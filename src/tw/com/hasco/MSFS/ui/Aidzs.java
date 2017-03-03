package tw.com.hasco.MSFS.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tw.com.hasco.MSFS.Debugger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Aidzs {

    List<Aidz> aidzs;
    double latMax = -200;
    double latMin = 200;
    double lngMax = -200;
    double lngMin = 200;
    public Aidzs(String name) {
        aidzs = new ArrayList<>();
        getFile(name);
    }

    private void getFile(String filename) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                classLoader.getResourceAsStream("file/" + filename)));
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.isEmpty() || line.charAt(0) == '#') {
                    continue;
                }
                Aidz aidz = new Aidz(line);
                aidzs.add(aidz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        aidzs.forEach((e) -> {
            latMax = (latMax >= e.latMax) ? latMax : e.latMax;
            latMin = (latMin <= e.latMin) ? latMin : e.latMin;
            lngMax = (lngMax >= e.lngMax) ? lngMax : e.lngMax;
            lngMin = (lngMin <= e.lngMin) ? lngMin : e.lngMin;            
        });
    }

    public void setXY(int width, int height, double latMin, double latMax, double lngMin, double lngMax) {
        aidzs.forEach((e) -> {
            e.setXY(width, height, latMin, latMax, lngMin, lngMax);
        });
    }

    public void draw(Graphics g) {
        g.setColor(java.awt.Color.blue);
        aidzs.get(0).draw(g);
        g.setColor(java.awt.Color.red);
        aidzs.get(1).draw(g);
        g.setColor(new Color(157, 65, 230));
        for (int i = 2; i < aidzs.size(); ++i) {
            aidzs.get(i).draw(g);
        }
    }

    public void dump() {
        aidzs.forEach((e) -> {
            e.dump();
        });
    }

    public static void main(String args[]) throws IOException {
        Aidzs e = new Aidzs("AidzV1_Taiwan.csv");
        e.dump();
    }

    void setXY(Double cx, Double cy, Double r, int sx0, int sy0, int sxdim, int sydim, double theta_x, double theta_y) {
        aidzs.forEach((e) -> {
            e.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
    }
}

class Aidz {

    String name1;
    String name2;
    double lat[], lng[];
    int x[], y[];
    Polygon poly;
    double latMax = -200;
    double latMin = 200;
    double lngMax = -200;
    double lngMin = 200;

    public static double[] convertDoubles(ArrayList<Double> doubles) {
        double[] ret = new double[doubles.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = doubles.get(i);
        }
        return ret;
    }

    public Aidz(String line) {
        String tokens[] = line.split(",");
        if (((tokens.length / 2) * 2) != tokens.length) {
            throw new RuntimeException("from AirPort constructor");
        }
        name1 = tokens[0];
        name2 = tokens[1];
        ArrayList<Double> lat1, lng1;
        lat1 = new ArrayList<>();
        lng1 = new ArrayList<>();
        lat = new double[5];
        lng = new double[5];
        int num = (tokens.length - 2) / 2;
        for (int i = 0; i < num; ++i) {
            lat1.add(Double.parseDouble(tokens[2 + i * 2]));
            lng1.add(Double.parseDouble(tokens[2 + i * 2 + 1]));
        }
        lat = convertDoubles(lat1);
        lng = convertDoubles(lng1);
        for(int i = 0; i < lat.length; ++i) {
            latMax = (latMax >= lat[i]) ? latMax : lat[i];
            latMin = (latMin <= lat[i]) ? latMin : lat[i];
            lngMax = (lngMax >= lng[i]) ? lngMax : lng[i];
            lngMin = (lngMin <= lng[i]) ? lngMin : lng[i];
        }
        x = new int[lat.length];
        y = new int[lng.length];
    }

    public void setXY(double cx, double cy, double r, int sx0, int sy0, int sxdim, int sydim, double theta_x, double theta_y) {
        // Debugger.log(width + "," + height + "," + lngMax + "," +lngMin + "," + latMax + "," + latMin);
        double sxxdim = sxdim * Math.cos(theta_x);
        double sxydim = -sxdim * Math.sin(theta_x);
        double syxdim = -sydim * Math.sin(theta_y);
        double syydim = -sydim * Math.cos(theta_y);

        double latMax = cy + r;
        double latMin = cy - r;
        double lngMax = cx + r;
        double lngMin = cx - r;
        for (int i = 0; i < lng.length; ++i) {
            // if (lng[i] > lngMax || lng[i] < lngMin || lat[i] > latMax || lat[i] < latMin) continue;
            x[i] = (int) ((lng[i] - cx) / r * sxxdim + (lat[i] - cy) / r * syxdim) + sx0;
            y[i] = (int) ((lng[i] - cx) / r * sxydim + (lat[i] - cy) / r * syydim) + sy0;

        }
        poly = new Polygon(x, y, x.length);
    }

    public void setXY(int width, int height, double latMin, double latMax, double lngMin, double lngMax) {
        // Debugger.log(width + "," + height + "," + lngMax + "," +lngMin + "," + latMax + "," + latMin);
        for (int i = 0; i < x.length; ++i) {
            x[i] = (int) (width * (lng[i] - lngMin) / (lngMax - lngMin));
            y[i] = (int) (height * (latMax - lat[i]) / (latMax - latMin));
            // Debugger.log(lng[i] + "," + lat[i]);
            // Debugger.log(x[i] + "," + y[i]);
        }
        poly = new Polygon(x, y, x.length);
    }

    public void draw(Graphics g) {
        g.drawPolygon(poly);

    }

    public void dump() {
        Debugger.log(name1 + "," + name2);
    }
}

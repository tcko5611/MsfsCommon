package tw.com.hasco.MSFS.ui;

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
public class AirPorts {

    List<AirPort> airPorts;
    double latMax = -200;
    double latMin = 200;
    double lngMax = -200;
    double lngMin = 200;

    public AirPorts(String name) {
        airPorts = new ArrayList<>();
        getFile(name);
    }

    private void getFile(String filename) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(
                classLoader.getResourceAsStream("file/" + filename)));
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.isEmpty() || line.charAt(0) == '#') {
                    continue;
                }
                AirPort airPort = new AirPort(line);
                airPorts.add(airPort);
            }
            //  scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        airPorts.forEach((e) -> {
            latMax = (latMax >= e.latMax) ? latMax : e.latMax;
            latMin = (latMin <= e.latMin) ? latMin : e.latMin;
            lngMax = (lngMax >= e.lngMax) ? lngMax : e.lngMax;
            lngMin = (lngMin <= e.lngMin) ? lngMin : e.lngMin;
        });
    }

    public void setXY(int width, int height, double latMin, double latMax, double lngMin, double lngMax) {
        airPorts.forEach((e) -> {
            e.setXY(width, height, latMin, latMax, lngMin, lngMax);
        });
    }

    public void draw(Graphics g) {
        g.setColor(java.awt.Color.blue);
        airPorts.forEach((e) -> {
            e.draw(g);
        });
    }

    public void dump() {
        airPorts.forEach((e) -> {
            e.dump();
        });
    }

    public static void main(String args[]) throws IOException {
        AirPorts e = new AirPorts("U5_Runway_NAmerica.csv");
        e.dump();
    }

    void setXY(Double cx, Double cy, Double r, int sx0, int sy0, int sxdim, int sydim, double theta_x, double theta_y) {
        airPorts.forEach((e) -> {
            e.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
    }
}

class AirPort {

    String id;
    String degree1;
    String degree2;
    String nation;
    String name;
    double lat[], lng[];
    int x[], y[];
    Polygon poly;
    double latMax = -200;
    double latMin = 200;
    double lngMax = -200;
    double lngMin = 200;

    public AirPort(String line) {
        String tokens[] = line.split(",");
        if (tokens.length != 15) {
            throw new RuntimeException("from AirPort constructor");
        }
        id = tokens[0];
        degree1 = tokens[1];
        degree2 = tokens[2];
        nation = tokens[3];
        name = tokens[4];
        lat = new double[5];
        lng = new double[5];
        for (int i = 0; i < 5; ++i) {
            lat[i] = Double.parseDouble(tokens[5 + i * 2]);
            lng[i] = Double.parseDouble(tokens[5 + i * 2 + 1]);
            latMax = (latMax >= lat[i]) ? latMax : lat[i];
            lngMax = (lngMax >= lng[i]) ? lngMax : lng[i];
            latMin = (latMin <= lat[i]) ? latMin : lat[i];
            lngMin = (lngMin >= lng[i]) ? lngMin : lng[i];
        }
        x = new int[5];
        y = new int[5];
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
            x[i] = (int) (sx0 + (lng[i] - cx) / r * sxxdim + (lat[i] - cy) / r * syxdim);
            y[i] = (int) (sy0 + (lng[i] - cx) / r * sxydim + (lat[i] - cy) / r * syydim);
            // Debugger.log(lng[i] + "," + lat[i]);
            // Debugger.log(x[i] + "," + y[i]);
        }
        poly = new Polygon(x, y, x.length);
    }

    public void setXY(int width, int height, double latMin, double latMax, double lngMin, double lngMax) {
        // Debugger.log(width + "," + height + "," + lngMax + "," +lngMin + "," + latMax + "," + latMin);
        for (int i = 0; i < 5; ++i) {
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
        Debugger.log(id + "," + degree1 + "," + degree2 + "," + nation + "," + name);
    }
}

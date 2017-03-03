/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import tw.com.hasco.MSFS.Debugger;

/**
 * Store taiwan map point for use
 *
 * @author T.C.KO
 */
public class LocalMap {

    ArrayList<Double> lats;
    ArrayList<Double> lngs;
    ArrayList<Integer> xs;
    ArrayList<Integer> ys;
    double latMax = -200;
    double lngMax = -200;
    double latMin = 200;
    double lngMin = 200;

    public static void main(String[] args) {
        LocalMap obj = new LocalMap("T5_Area_USA.csv");
        obj.getInfo();
    }

    public LocalMap(String filename) {
        lats = new ArrayList<>();
        lngs = new ArrayList<>();
        xs = new ArrayList<>();
        ys = new ArrayList<>();
        getFile(filename);
    }

    void getInfo() {
        Debugger.log("max lat: " + latMax + ", min lat: " + latMin);
        Debugger.log("max long: " + lngMax + ", min long: " + lngMin);
    }

    private void getFile(String filename) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        // File file = new File(classLoader.getResource("file/TaiwanLatLon.csv").getFile());
        BufferedReader br = new BufferedReader(new InputStreamReader(
                classLoader.getResourceAsStream("file/" + filename)));
        // File file = new File("file/TaiwanLatLon.csv");
        try {
            // first two line are mark
            br.readLine();
            br.readLine();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer stok = new StringTokenizer(line, ",");
                double lat = Double.parseDouble(stok.nextToken());
                double lng = Double.parseDouble(stok.nextToken());
                lats.add(lat);
                lngs.add(lng);
                latMax = (latMax >= lat) ? latMax : lat;
                latMin = (latMin <= lat) ? latMin : lat;
                lngMax = (lngMax >= lng) ? lngMax : lng;
                lngMin = (lngMin <= lng) ? lngMin : lng;
            }
            //  scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setXY(int width, int height, double latMin, double latMax, double lngMin, double lngMax) {
        // Debugger.log(width + "," + height + "," + lngMax + "," +lngMin + "," + latMax + "," + latMin);
        xs.clear();
        ys.clear();
        for (int i = 0; i < lngs.size(); ++i) {
            int x = (int) (width * (lngs.get(i) - lngMin) / (lngMax - lngMin));
            int y = (int) (height * (latMax - lats.get(i)) / (latMax - latMin));
            xs.add(x);
            ys.add(y);
            // Debugger.log(lng[i] + "," + lat[i]);
            // Debugger.log(x[i] + "," + y[i]);
        }
    }

    /**
     * function for genearte x, y for draw
     *
     * @param cx : longitude center
     * @param cy : latitude center
     * @param r : radius of center
     * @param sx0 : center x of draw area
     * @param sy0 : center y of draw area
     * @param sxdim : screen xdim
     * @param sydim : screen y dim
     * @param theta_x
     * @param theta_y
     */
    public void setXY(double cx, double cy, double r, int sx0, int sy0, int sxdim, int sydim, double theta_x, double theta_y) {
        // Debugger.log(width + "," + height + "," + lngMax + "," +lngMin + "," + latMax + "," + latMin);
        double sxxdim = sxdim * Math.cos(theta_x);
        double sxydim = -sxdim * Math.sin(theta_x);
        double syxdim = -sydim * Math.sin(theta_y);
        double syydim = -sydim * Math.cos(theta_y);
        xs.clear();
        ys.clear();
        double latMax = cy + r;
        double latMin = cy - r;
        double lngMax = cx + r;
        double lngMin = cx - r;
        for (int i = 0; i < lngs.size(); ++i) {
            double lng = lngs.get(i);
            double lat = lats.get(i);
            if (lng > lngMax || lng < lngMin || lat > latMax || lat < latMin) {
                continue;
            }
            int x = (int) (sx0 + (lng - cx) / r * sxxdim + (lat - cy) / r * syxdim);
            int y = (int) (sy0 + (lng - cx) / r * sxydim + (lat - cy) / r * syydim);
            xs.add(x);
            ys.add(y);
            // Debugger.log(lng[i] + "," + lat[i]);
            // Debugger.log(x[i] + "," + y[i]);
        }
    }

    public void draw(Graphics2D g) {
        if (xs.isEmpty()) {
            return;
        }
        g.setColor(java.awt.Color.black);
        int x1 = xs.get(0);
        int y1 = ys.get(0);
        for (int i = 1; i < xs.size(); ++i) {
            int x2 = xs.get(i);
            int y2 = ys.get(i);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }
}

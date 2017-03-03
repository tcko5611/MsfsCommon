/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.LicChecker;

/**
 *
 * @author DELL
 */
public class ThreeDPanel extends javax.swing.JPanel {

    DecimalFormat precisionTwo = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    // panel setting don't change it
    //final int sx0 = 194; // orinal x point  
    final int sx0 = 250; // orinal x point 
    // final int sy0 = 300; // origianl y point 
    final int sy0 = 250; // origianl y point 
    final int sxdim = 110; // x length for x axis
    final int sydim = 110; // y length for y axis
    long preTime = 0; // previous time for dynamic map
    boolean dynMapEnable = false;
    double theta_xy = Math.toRadians(45.0);
    double theta_y0 = theta_xy;
    double theta_y = theta_xy; // theta of 3d y axis of normal y axis
    double theta_x0 = 0;
    double theta_x = 0; // can be change for different point of view
    int lineDuration = 5000;
    // final int syydim = 40; // y length for y axis
    // final int syxdim = 40; // x length for y axis
    final int szdim = 200; // y length for z axis 
    final int NUM = 100;
    final int DIVX = 2;
    final int DIVY = 2;
    final int DIVZ = 1;
    // set max and min of xmax and xmin, shouldn't use these
    // double xmin = -12.56, xmax = 12.56, xdelta = (xmax - xmin) / NUM;
    // double ymin = -12.56, ymax = 12.56, ydelta = (ymax - ymin) / NUM;
    double zmin = 0.0, zmax = 60.0;

    ArrayList<ThreeDLoc> traceLocs; // Taiwan map
    ArrayList<ThreeDPoint> tracePts; // Taiwan map
    ArrayList<Long> times;
    AirPorts taiwanPorts;

    ThreeDLoc currLoc;
    ThreeDPoint currPt;
    Double cx, cy, r; // center latitude, logitude and half height
    double heading;
    double heading_xy;
    double theta;
    double maxAlt;
    BufferedImage plane;
    BufferedImage plane_blue;

    // maps
    ArrayList<LocalMap> maps;
    boolean twnMapEnable;
    boolean nAsiaMapEnable;
    boolean sAsiaMapEnable;
    boolean pacMapEnable;
    boolean usaMapEnable;
    // airports
    ArrayList<AirPorts> airports;
    boolean twnPortEnable;
    boolean nAsiaPortEnable;
    boolean sAsiaPortEnable;
    boolean pacPortEnable;
    boolean usaPortEnable;
    // airports
    ArrayList<Aidzs> aidzs;
    boolean twnAidzEnable;
    boolean nAsiaAidzEnable;
    boolean sAsiaAidzEnable;
    boolean pacAidzEnable;
    boolean usaAidzEnable;

    boolean taiwanPortEnable;
    boolean aidzsEnable;
    boolean pacificPortEnable;
    boolean asiaPortEnable;

    /**
     * Creates new form Wave
     */
    public ThreeDPanel() {
        initComponents();

        cy = 23.605691;
        cx = 121.024777;
        r = 1.80; // 1.677918
        // set lic
        setLic();
        // for maps
        maps = new ArrayList<>();
        airports = new ArrayList<>();
        aidzs = new ArrayList<>();
        addMaps();
        addPorts();
        addAidzs();
        maxAlt = 50.0;
        zmax = 100.0;

        // taiwanLocs = taiwanMap.getLocs();
        // taiwanPts = new ArrayList<Point>();
        traceLocs = new ArrayList<>();
        tracePts = new ArrayList<>();
        times = new ArrayList<>();

        // calculateTaiwanPts();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            plane = ImageIO.read(classLoader.getResourceAsStream("draw/plane.png"));
        } catch (IOException ex) {
            Logger.getLogger(TracePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            plane_blue = ImageIO.read(classLoader.getResourceAsStream("draw/plane_blue.png"));
        } catch (IOException ex) {
            Logger.getLogger(TracePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDynMap(boolean t) {
        dynMapEnable = t;
    }

    private void setLic() {
        twnMapEnable = LicChecker.getInstance().isT1_TWN();
        nAsiaMapEnable = LicChecker.getInstance().isT2_NASIA();
        sAsiaMapEnable = LicChecker.getInstance().isT3_SASIA();
        pacMapEnable = LicChecker.getInstance().isT4_PAC();
        usaMapEnable = LicChecker.getInstance().isT5_USA();

        twnPortEnable = LicChecker.getInstance().isU1_TWN();
        nAsiaPortEnable = LicChecker.getInstance().isU2_NASIA();
        sAsiaPortEnable = LicChecker.getInstance().isU3_SASIA();
        pacPortEnable = LicChecker.getInstance().isU4_PAC();
        usaPortEnable = LicChecker.getInstance().isU5_USA();

        twnAidzEnable = LicChecker.getInstance().isV1_TWN();
        nAsiaAidzEnable = LicChecker.getInstance().isV2_NASIA();
        sAsiaAidzEnable = LicChecker.getInstance().isV3_SASIA();
        pacAidzEnable = LicChecker.getInstance().isV4_PAC();
        usaAidzEnable = LicChecker.getInstance().isV5_USA();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void drawAxis(Graphics2D g2d) {

        double sxxdim = sxdim * Math.cos(theta_x);
        double sxydim = sxdim * Math.sin(theta_x);
        double syxdim = sydim * Math.sin(theta_y);
        double syydim = sydim * Math.cos(theta_y);
        int p11_x = (int) (sx0 - sxxdim + syxdim);
        int p11_y = (int) (sy0 + sxydim + syydim);
        int p12_x = (int) (sx0 + sxxdim + syxdim);
        int p12_y = (int) (sy0 - sxydim + syydim);
        int p21_x = (int) (sx0 - sxxdim - syxdim);
        int p21_y = (int) (sy0 + sxydim - syydim);
        // int p14_x = (int) (sx0 + sxxdim - syxdim);
        // int p14_y = (int) (sy0 - sxydim - syydim);

        int p13_x = (int) (sx0 - sxxdim + syxdim);
        int p13_y = (int) (sy0 + sxydim + syydim) - szdim;
        // int p22_x = (int) (sx0 + sxxdim + syxdim);
        // int p22_y = (int) (sy0 - sxydim + syydim) - szdim;
        // int p23_x = (int) (sx0 - sxxdim - syxdim);
        // int p23_y = (int) (sy0 + sxydim - syydim) - szdim;
        // int p24_x = (int) (sx0 + sxxdim - syxdim);
        // int p24_y = (int) (sy0 - sxydim - syydim) - szdim;
        g2d.setColor(Color.black);
        g2d.drawLine(p11_x, p11_y, p12_x, p12_y);
        // g2d.drawLine(p13_x, p13_y, p14_x, p14_y);
        g2d.drawLine(p11_x, p11_y, p21_x, p21_y);
        // g2d.drawLine(p12_x, p12_y, p14_x, p14_y);

        // g2d.drawLine(p21_x, p21_y, p22_x, p22_y);
        // g2d.drawLine(p23_x, p23_y, p24_x, p24_y);
        // g2d.drawLine(p21_x, p21_y, p23_x, p23_y);
        // g2d.drawLine(p22_x, p22_y, p24_x, p24_y);
        float[] dash1 = {10f, 0f, 10f};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        g2d.setStroke(bs1);
        g2d.drawLine(p11_x, p11_y, p13_x, p13_y);
        g2d.setStroke(new BasicStroke(1.0f));
        // g2d.drawLine(p12_x, p12_y, p22_x, p22_y);
        // g2d.drawLine(p13_x, p13_y, p23_x, p23_y);
        //g2d.drawLine(p14_x, p14_y, p24_x, p24_y);
        // draw x axis label
        for (int i = 0; i <= DIVX; ++i) {
            double xmin = cx - r;
            double xmax = cx + r;
            double x = xmin + i * (xmax - xmin) / DIVX - cx;
            double y = -r;
            int sx1 = (int) (sx0 + sxxdim * x / r - syxdim * y / r);
            int sy1 = (int) (sy0 - sxydim * x / r - syydim * y / r);
            g2d.drawLine(sx1, sy1, sx1, sy1 + 10);
            g2d.drawString(precisionTwo.format(x + cx), sx1 - 10, sy1 + 30);
        }
        // draw y axis
        for (int i = 0; i <= DIVY; ++i) {
            double ymin = cy - r;
            double ymax = cy + r;
            double x = -r;
            double y = ymin + i * (ymax - ymin) / DIVY - cy;
            int sx1 = (int) (sx0 + sxxdim * x / r - syxdim * y / r);
            int sy1 = (int) (sy0 - sxydim * x / r - syydim * y / r);
            g2d.drawLine(sx1, sy1, sx1, sy1 + 10);
            g2d.drawString(precisionTwo.format(y + cy), sx1 + 20, sy1 + 5);
        }
        // draw z axis
        for (int i = 0; i <= DIVZ; ++i) {
            double z = zmin + i * (zmax - zmin) / DIVZ;
            double x = -r;
            double y = -r;
            int iz = (int) ((z - zmin) / (zmax - zmin) * szdim);
            int sx1 = (int) (sx0 + sxxdim * x / r - syxdim * y / r);
            int sy1 = (int) (sy0 - sxydim * x / r - syydim * y / r) - iz;

            g2d.drawLine(sx1 - 10, sy1, sx1, sy1);
            g2d.drawString(precisionTwo.format(z), sx1 - 30, sy1 + 5);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        if (dynMapEnable) {
            checkDynMap();
        }
        // for axis
        drawAxis(g2d);
        /*
        g2d.drawRect(sx0 - sxdim + syxdim, sy0 - szdim - syydim, 2 * sxdim, szdim);
        g2d.drawRect(sx0 - sxdim - syxdim, sy0 - szdim + syydim, 2 * sxdim, szdim);
        g2d.drawLine(sx0 - sxdim - syxdim, sy0 + syydim, sx0 - sxdim + syxdim, sy0 - syydim);
        g2d.drawLine(sx0 + sxdim - syxdim, sy0 + syydim, sx0 + sxdim + syxdim, sy0 - syydim);
        g2d.drawLine(sx0 - sxdim - syxdim, sy0 - szdim + syydim, sx0 - sxdim + syxdim, sy0 - szdim - syydim);
        g2d.drawLine(sx0 + sxdim - syxdim, sy0 - szdim + syydim, sx0 + sxdim + syxdim, sy0 - szdim - syydim);
        // draw y axis
        for (int i = 0; i <= DIVX; ++i) {
            float[] dash1 = {2f, 0f, 2f};
            // BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
            // BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
            // g2d.setStroke(bs1);
            double xmin = cx - r;
            double xmax = cx + r;
            double x = xmin + i * (xmax - xmin) / DIVX;
            int ix = -sxdim + 2 * i * sxdim / DIVX;
            int sx1 = sx0 + ix - syxdim;
            int sy1 = sy0 + syydim;
            g2d.drawLine(sx1, sy1, sx1, sy1 + 10);
            // int sx2 = sx0 + ix + syxdim;
            // int sy2 = sy0 + szdim - syydim;
            // g2d.drawLine(sx1, sy1, sx2, sy2);
            g2d.drawString(precisionTwo.format(x), sx1 - 10, sy1 + 30);
            g2d.setStroke(new BasicStroke(1.0f));
        }
        // draw x axis
        for (int i = 0; i <= DIVY; ++i) {
            float[] dash1 = {2f, 0f, 2f};
            // BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
            // BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
            // g2d.setStroke(bs1);
            double ymin = cy - r;
            double ymax = cy + r;
            double y = ymin + i * (ymax - ymin) / DIVY;
            int iy = syydim - 2 * i * syydim / DIVY;
            int ix = -syxdim + 2 * i * syxdim / DIVY;
            int sx1 = sx0 + ix - sxdim;
            int sy1 = sy0 + iy;
            int sx2 = sx0 + ix + sxdim;
            int sy2 = sy0 + iy;
            // g2d.drawLine(sx1, sy1, sx2, sy2);
            g2d.drawLine(sx2, sy2, sx2 + 10, sy2);
            g2d.drawString(precisionTwo.format(y), sx2 + 20, sy2 + 5);
            // g2d.setStroke(new BasicStroke(1.0f));
            // int ix2 = ix + 80;
            // g.drawLine(ix, yend, ix2, yend2);
        }
        // draw z axis
        for (int i = 0; i <= DIVZ; ++i) {
            // float[] dash1 = {2f, 0f, 2f};
            // BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
            // BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
            // g2d.setStroke(bs1);
            double z = zmin + i * (zmax - zmin) / DIVZ;
            int iy = (int) (syydim - z * szdim / (zmax - zmin));
            int sx1 = sx0 - syxdim - sxdim;
            int sy1 = sy0 + iy;
            int sx2 = sx0 - syxdim + sxdim;
            int sy2 = sy0 + iy;
            // g2d.drawLine(sx1, sy1, sx2, sy2);
            g2d.drawLine(sx1 - 10, sy1, sx1, sy1);
            g2d.drawString(precisionTwo.format(z), sx1 - 30, sy2 + 5);
            // g2d.setStroke(new BasicStroke(1.0f));
            // int ix2 = ix + 80;
            // g.drawLine(ix, yend, ix2, yend2);
        }
         */
        g2d.setColor(Color.black);
        double xmin = cx - r, xmax = cx + r, ymin = cy - r, ymax = cy + r, xdelta = 2 * r / NUM, ydelta = 2 * r / NUM;
        maps.forEach((m) -> {
            m.draw(g2d);
        });
        aidzs.forEach((m) -> {
            m.draw(g2d);
        });
        airports.forEach((m) -> {
            m.draw(g2d);
        });

        g2d.setStroke(new BasicStroke(3.0f));
        drawTrace(g2d);
        if (currPt != null) {
            // AffineTransform tx = new AffineTransform().getRotateInstance(Math.toRadians(heading), 8, 8);
            /*
            AffineTransform tx = new AffineTransform();
            tx.translate(currPt.getX(), currPt.getY());
            tx.rotate(Math.toRadians(heading) - heading_xy);
            // tx.scale(0.5, 0.5);
            tx.translate(-8, -8);
            // tx.rotate(-1.0 * Math.toRadians(heading));
            // g2d.drawImage(plane, tx, null);
//.getRotateInstance(Math.toRadians(heading), 16, 16);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(plane, null), 0, 0, null);
             */
            // add threed [lane
            AffineTransform tx = new AffineTransform();
            tx.translate(currPt.getX(), currPt.getY() - currPt.getZ());
            tx.rotate(Math.toRadians(heading) - heading_xy);
            // tx.scale(0.5, 0.5);
            tx.translate(-8, -8);
            // tx.rotate(-1.0 * Math.toRadians(heading));
            // g2d.drawImage(plane, tx, null);
//.getRotateInstance(Math.toRadians(heading), 16, 16);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(plane_blue, null), 0, 0, null);
        }

        /*
        for (int iy = ybegin; iy >= xend; iy += (xend - xbegin) / DIV) {
            g.drawLine(iy, yend, iy, yend + 5);
            int ix2 = iy + 80;
            g.drawLine(iy, yend, ix2, yend2);
        }
         */
    }

    private ThreeDPoint transLocToPoint(ThreeDLoc loc) {
        double sxxdim = sxdim * Math.cos(theta_x);
        double sxydim = -sxdim * Math.sin(theta_x);
        double syxdim = -sydim * Math.sin(theta_y);
        double syydim = -sydim * Math.cos(theta_y);
        int sz = (int) (loc.getAlt() * szdim / (zmax - zmin));
        int sx = (int) ((loc.getLng() - cx) * sxxdim / r + (loc.getLat() - cy) * syxdim / r) + sx0;
        int sy = (int) ((loc.getLng() - cx) * sxydim / r + (loc.getLat() - cy) * syydim / r + sy0);
        return new ThreeDPoint(sx, sy, sz);
    }

    private void calculateTracePts() {
        tracePts.clear();
        traceLocs.forEach((l) -> {
            tracePts.add(transLocToPoint(l));
        });
    }

    public void update(FSBasic fsBasic) {
        try {
            double lat = fsBasic.latitude();
            double lng = fsBasic.longitude();
            double alt = fsBasic.altitude();
            int engineRpm = fsBasic.engineRPM();
            if ((lat == 0.0 && lng == 0.0) || (engineRpm == 0)) {
                return;
            }
            if (alt > maxAlt) {
                maxAlt = alt;
                zmax = 2.0 * alt;
            }
            currLoc = new ThreeDLoc(lat, lng, alt);
            currPt = transLocToPoint(currLoc);
            traceLocs.add(currLoc);
            tracePts.add(currPt);
            heading = fsBasic.heading();
            theta = fsBasic.pitch();
            Date d = sdf.parse(fsBasic.getDisplayTime());
            Long t = d.getTime();
            times.add(t);
            repaint();
        } catch (ParseException ex) {
            Logger.getLogger(ThreeDPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearData() {
        cy = 23.605691;
        cx = 121.024777;
        theta_x = 0;
        theta_xy = Math.toRadians(45);
        theta_y = theta_xy;
        r = 1.80; // 1.677918 
        currLoc = null;
        currPt = null;
        times.clear();
        traceLocs.clear();
        tracePts.clear();
        aidzs.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        airports.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        // calculateTaiwanPts();
        maps.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        repaint();
    }

    public void setLineDuration(int d) {
        lineDuration = d * 1000;
        // repaint();
    }

    void drawTrace(Graphics2D g2d) {
        if (tracePts.isEmpty()) {
            return;
        }
        ThreeDPoint p;
        long t0 = times.get(0);
        g2d.setColor(java.awt.Color.blue);
        g2d.setStroke(new BasicStroke(1.0f));
        for (int i = 1; i < times.size(); ++i) {
            if ((times.get(i) - lineDuration) >= t0) {
                p = tracePts.get(i);
                g2d.drawLine(p.getX(), p.getY(), p.getX(), p.getY() - p.getZ());
                t0 = times.get(i);
            }
        }
        g2d.setColor(java.awt.Color.green);
        g2d.setStroke(new BasicStroke(3.0f));
        p = tracePts.get(0);
        int x1 = p.getX();
        int y1 = p.getY();
        for (int i = 1; i < tracePts.size(); ++i) {
            p = tracePts.get(i);
            int x2 = p.getX();
            int y2 = p.getY();
            g2d.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }

        g2d.setColor(java.awt.Color.red);
        p = tracePts.get(0);
        x1 = p.getX();
        y1 = p.getY() - p.getZ();
        for (int i = 1; i < tracePts.size(); ++i) {
            p = tracePts.get(i);
            int x2 = p.getX();
            int y2 = p.getY() - p.getZ();
            g2d.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }

    }

    private void updateDrawPts() {
        // calculateTaiwanPts();
        maps.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        aidzs.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        airports.forEach((m) -> {
            m.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        });
        calculateTracePts();
    }

    private void updateDrawPtsAndRepaint() {
        updateDrawPts();
        repaint();
    }

    private void checkDynMap() {
        long curTime = System.currentTimeMillis();
        if ((curTime - preTime) > 1000) {
            preTime = curTime;
            updateDynMap();
        }

    }

    private void updateDynMap() {
        if (currLoc != null) {
            cx = currLoc.getLng();
            cy = currLoc.getLat();
        }
        updateDrawPts();
    }

    private void addMaps() {
        if (twnMapEnable) {            
            addMap("MapT1_Taiwan.csv");            
        }
        if (nAsiaMapEnable) {            
            addMap("MapT2_China.csv");
            addMap("MapT2_Japan.csv");
            addMap("MapT2_SouthKorea.csv");
            addMap("MapT2_NorthKorea.csv");            
        }
        if (sAsiaMapEnable) {            
            addMap("MapT3_Cambodia.csv");
            addMap("MapT3_Indonesia.csv");
            addMap("MapT3_Malaysia.csv");
            addMap("MapT3_Philippines.csv");
            addMap("MapT3_Singapore.csv");
            addMap("MapT3_Thailand.csv");
            addMap("MapT3_Vietnam.csv");            
        }
        if (pacMapEnable) {           
            addMap("MapT4_Guam.csv");
            addMap("MapT4_Palau.csv");            
        }
        if (usaMapEnable) {            
            addMap("T5_Area_Canada.csv");
            addMap("T5_Area_Mexico.csv");
            addMap("T5_Area_USA.csv");            
        }
    }

    private void addMap(String name) {
        LocalMap map = new LocalMap(name);
        map.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        maps.add(map);
    }

    private void addPorts() {
        if (twnPortEnable) {            
            addPort("AirportU1_Taiwan.csv");            
        }
        if (nAsiaPortEnable) {
            // addPort("AirportU2_China.csv");
            // addPort("AirportU2_Japan.csv");
            // addPort("AirportU2_SouthKorea.csv");
            // addPort("AirportU2_NorthKorea.csv");
        }
        if (sAsiaPortEnable) {
            // addPort("AirportU3_Cambodia.csv");
            // addPort("AirportU3_Indonesia.csv");
            // addPort("AirportU3_Malaysia.csv");
            // addPort("AirportU3_Philippines.csv");
            // addPort("AirportU3_Singapore.csv");
            // addPort("AirportU3_Thailand.csv");
            // addPort("AirportU3_Vietnam.csv");
        }
        if (pacPortEnable) {
            // addPort("AirportU4_Guam.csv");
            // addPort("AirportU4_Palau.csv");
        }
        if (usaPortEnable) {            
            addPort("AirportU5_NAmerica.csv");
            addPort("U5_Runway_NAmerica.csv");            
        }
    }

    private void addPort(String name) {
        AirPorts ports = new AirPorts(name);
        ports.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        airports.add(ports);
    }

    private void addAidzs() {
        if (twnAidzEnable) {
            addAidz("AidzV1_Taiwan.csv");
        }
        if (nAsiaAidzEnable) {
            // addAidz("AidzV2_China.csv");
            // addAidz("AidzV2_Japan.csv");
            // addAidz("AidzV2_SouthKorea.csv");
            // addAidz("AidzV2_NorthKorea.csv");
        }
        if (sAsiaAidzEnable) {
            // addAidz("AidzV3_Cambodia.csv");
            // addAidz("AidzV3_Indonesia.csv");
            // addAidz("AidzV3_Malaysia.csv");
            // addAidz("AidzV3_Philippines.csv");
            // addAidz("AidzV3_Singapore.csv");
            // addAidz("AidzV3_Thailand.csv");
            // addAidz("AidzV3_Vietnam.csv");
        }
        if (pacAidzEnable) {
            // addAidz("AidzV4_Guam.csv");
            // addAidz("AidzV4_Palau.csv");
        }
        if (usaAidzEnable) {

        }
    }

    private void addAidz(String name) {
        Aidzs aidz = new Aidzs(name);
        aidz.setXY(cx, cy, r, sx0, sy0, sxdim, sydim, theta_x, theta_y);
        aidzs.add(aidz);
    }

    /*
    public void setCenter(double lat, double lng) {
        cx = lng;
        cy = lat;
        updateDrawPtsAndRepaint();
    }
     */
    public void zoomin() {
        r = r / Math.sqrt(2.0);
        if (currLoc != null) {
            cx = currLoc.getLng();
            cy = currLoc.getLat();
        }
        updateDrawPtsAndRepaint();
    }

    public void setTheta(double degree) {
        heading_xy = Math.toRadians(degree) * 2.0;
        theta_x0 = Math.toRadians(degree);
        theta_y0 = Math.toRadians(degree + 45);
        theta_x = theta_x0 / Math.toRadians(45.0) * theta_xy;
        theta_y = Math.toRadians(90.0) + (theta_y0 - Math.toRadians(90)) / Math.toRadians(45.0) * theta_xy;
        updateDrawPtsAndRepaint();
    }

    public void setThetaXy(double degree) {
        theta_xy = Math.toRadians(degree);
        theta_x = theta_x0 / Math.toRadians(45.0) * theta_xy;
        theta_y = Math.toRadians(90.0) + (theta_y0 - Math.toRadians(90)) / Math.toRadians(45.0) * theta_xy;
        updateDrawPtsAndRepaint();
    }

    public void zoomout() {
        r = r * Math.sqrt(2.0);
        if (currLoc != null) {
            cx = currLoc.getLng();
            cy = currLoc.getLat();
        }
        r = ((cx + r) > 180) ? 180-cx: r;
        r= ((cx-r)<-180) ? cx+180 : r;
        r = ((cy + r) > 90) ? 90-cy: r;
        r= ((cy-r)<-90) ? cx+90 : r;
        updateDrawPtsAndRepaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        JPanel p = new ThreeDPanel();
        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setVisible(true);
    }
}

class ThreeDLoc {

    double lat; // latitude
    double lng; // logitude
    double alt; // altitude

    public ThreeDLoc(double y, double x, double z) {
        lat = y;
        lng = x;
        alt = z;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public double getAlt() {
        return alt;
    }
}

class ThreeDPoint {

    int x; // screen x, for xy plane 
    int y; // screen y, for xy plane
    int z; // y+z is for 3d 

    public ThreeDPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

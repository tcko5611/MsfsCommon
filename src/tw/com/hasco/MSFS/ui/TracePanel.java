/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.ToolTipManager;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.LicChecker;
import tw.com.hasco.MSFS.network.MsfsUdpServer;

/**
 *
 * @author DELL
 */
public class TracePanel extends javax.swing.JPanel {

    // ArrayList<Location> taiwanLocs; // Taiwan map
    // ArrayList<Point> taiwanPts; // Taiwan map
    Map<String, Plane> planes;
    ArrayList<Location> traceLocs; // Taiwan map
    ArrayList<Point> tracePts; // Taiwan map
    AirPorts taiwanPorts;
double mouseLat;
double mouseLng;
    int width; // paint region width
    int height; // paint region height
    Location currentLoc;
    Point currentPt;
    Double cx, cy, r; // center latitude, logitude and half height
    double heading;
    BufferedImage plane;
    BufferedImage bluePlane;
    // dynamic map
    long preTime = 0;
    boolean dynMapEnable = false;
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

    /**
     * Creates new form PlotTrace
     */
    public TracePanel() {
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
        // tiwanLocs = taiwanMap.getLocs();
        // taiwanPts = new ArrayList<Point>();
        traceLocs = new ArrayList<>();
        tracePts = new ArrayList<>();
        // for network planes
        planes = new HashMap<>();
        // calculateTaiwanPts();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            plane = ImageIO.read(classLoader.getResourceAsStream("draw/plane.png"));
            bluePlane = ImageIO.read(classLoader.getResourceAsStream("draw/plane_blue.png"));
        } catch (IOException ex) {
            Logger.getLogger(TracePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        map.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        maps.add(map);
    }

    private void addPorts() {
        if (twnPortEnable) {
            addPort("AirportU1_Taiwan.csv");
        }
        if (nAsiaPortEnable) {
            // addPort("AirPortU2_China.csv");
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
        ports.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        airports.add(ports);
    }

    private void addAidzs() {
        if (twnAidzEnable) {
            addAidz("AidzV1_Taiwan.csv");
        }
        if (nAsiaAidzEnable) {
            //addAidz("AidzV2_China.csv");
            //addAidz("AidzV2_Japan.csv");
            //addAidz("AidzV2_SouthKorea.csv");
            //addAidz("AidzV2_NorthKorea.csv");
        }
        if (sAsiaAidzEnable) {
            //addAidz("AidzV3_Cambodia.csv");
            //addAidz("AidzV3_Indonesia.csv");
            //addAidz("AidzV3_Malaysia.csv");
            //addAidz("AidzV3_Philippines.csv");
            //addAidz("AidzV3_Singapore.csv");
            //addAidz("AidzV3_Thailand.csv");
            //addAidz("AidzV3_Vietnam.csv");
        }
        if (pacAidzEnable) {
            //addAidz("AidzV4_Guam.csv");
            //addAidz("AidzV4_Palau.csv");
        }
        if (usaAidzEnable) {

        }
    }

    private void addAidz(String name) {
        Aidzs aidz = new Aidzs(name);
        aidz.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        aidzs.add(aidz);
    }

    /*
    public void setTaiwanPortEnable(boolean t) {
        taiwanPortEnable = t;
    }
    
    public void setAidzsEnable(boolean t) {
        aidzsEnable = t;
    }
     */
    private Point transLocToPoint(Location l) {
        double scale = 200 / r;
        double x = (l.getLongitude() - cx) * scale + 200;
        double y = (cy - l.getLatitude()) * scale + 200;
        return (new Point((int) x, (int) y));
    }

    /*
    private void calculateTaiwanPts() {
        taiwanPts.clear();
        for (Location l : taiwanLocs) {
            taiwanPts.add(transLocToPoint(l));
        }
    }
     */
    private void calculateTracePts() {
        tracePts.clear();
        traceLocs.forEach((l) -> {
            tracePts.add(transLocToPoint(l));
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 400));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         int x = evt.getX();
        int y = evt.getY();
        mouseLat = cy + (200 - y) * r / 200;
        mouseLng = cx + (x - 200) * r / 200;
        JComponent component = (JComponent)evt.getSource();
        component.setToolTipText(mouseLat + "," + mouseLng);
        ToolTipManager.sharedInstance().registerComponent(component);
        ToolTipManager.sharedInstance().setInitialDelay(0) ;        
        System.out.println(mouseLat + "," + mouseLng);//these co-ords are relative to the component
    }//GEN-LAST:event_formMousePressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        updateDrawPtsAndRepaint();
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
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
        maps.forEach((m) -> {
            m.draw(g2d);
        });
        aidzs.forEach((m) -> {
            m.draw(g2d);
        });
        airports.forEach((m) -> {
            m.draw(g2d);
        });

        g.setColor(java.awt.Color.black);
        width = getWidth();
        height = getHeight();
        //System.out.println(width);
        //System.out.println(height);
        // drawTrace(g2d, taiwanPts);
        g.setColor(java.awt.Color.green);
        g2d.setStroke(new BasicStroke(3.0f));
        drawTrace(g2d, tracePts);
        g.setColor(java.awt.Color.red);
        if (currentPt != null && currentPt.getX() > 0 && currentPt.getX() < width && currentPt.getY() > 0 && currentPt.getY() < height) {
            // AffineTransform tx = new AffineTransform().getRotateInstance(Math.toRadians(heading), 8, 8);
            AffineTransform tx = new AffineTransform();
            tx.translate(currentPt.getX(), currentPt.getY());
            tx.rotate(Math.toRadians(heading));
            // tx.scale(0.5, 0.5);
            tx.translate(-8, -8);
            // tx.rotate(-1.0 * Math.toRadians(heading));
            // g2d.drawImage(plane, tx, null);
//.getRotateInstance(Math.toRadians(heading), 16, 16);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(plane, null), 0, 0, null);
        }
        drawPlanes(g2d);
        // g.setColor(java.awt.Color.blue);
        // g2d.drawOval(currentPt.getX(), currentPt.getY(), 3, 3);
        // draw axis
        g.setColor(java.awt.Color.black);
        float[] dash1 = {2f, 0f, 2f};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        g2d.setStroke(bs1);
        // g2d.setStroke(new BasicStroke(1f));
        for (int i = 1; i < 10; i++) {
            int dx = width * i / 10;
            int dy = height * i / 10;
            double x = (cx - r) + (2 * r * dx) / width;
            double y = (cy + r) - (2 * r * dy) / height;
            g2d.drawLine(dx, 0, dx, height);
            g2d.drawLine(0, dy, width, dy);
            g2d.drawString(String.format("%.2f", x), dx, height - 5);
            g2d.drawString(String.format("%.2f", y), 0, dy);
        }
    }

    private void drawPlanes(Graphics2D g2d) {
        this.planes.values().forEach((p) -> {
            double head = p.heading;
            Location l = new Location(p.lat, p.lng);
            Point pp = this.transLocToPoint(l);
            if (pp.getX() > 0 && pp.getX() < width && pp.getY() > 0 && pp.getY() < height) {
                AffineTransform tx = new AffineTransform();
                tx.translate(pp.getX(), pp.getY());
                tx.rotate(Math.toRadians(head));
                tx.translate(-8, -8);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                g2d.drawImage(op.filter(bluePlane, null), 0, 0, null);
            }
        });
    }

    static void drawTrace(Graphics2D g2d, ArrayList<Point> pts) {
        if (pts.isEmpty()) {
            return;
        }
        Point p = pts.get(0);
        int x1 = p.getX();
        int y1 = p.getY();
        for (int i = 1; i < pts.size(); ++i) {
            p = pts.get(i);
            int x2 = p.getX();
            int y2 = p.getY();
            g2d.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }

    public void update(FSBasic fsBasic) {
        double lat = fsBasic.latitude();
        double lng = fsBasic.longitude();
        int engineRpm = fsBasic.engineRPM();
        if ((lat == 0.0 && lng == 0.0) || (engineRpm == 0)) {
            return;
        }
        currentLoc = new Location(lat, lng);
        currentPt = this.transLocToPoint(currentLoc);
        traceLocs.add(currentLoc);
        tracePts.add(currentPt);
        heading = fsBasic.heading();
        repaint();
    }

    public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame("Demo");
        TracePanel p = new TracePanel();
        p.setSize(400, 400);
        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
    }

    private void updateDrawPts() {
        // calculateTaiwanPts();
        maps.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        });
        airports.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        });
        aidzs.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
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
        if (currentLoc != null) {
            cx = currentLoc.getLongitude();
            cy = currentLoc.getLatitude();
        }
        updateDrawPts();
    }

    public void setCenter(double lat, double lng) {
        cx = lng;
        cy = lat;
        cx = (cx > 175) ? 175 : ((cx < -175) ? -175 : cx);
        cy = (cy > 85) ? 85 : ((cy < -85) ? -85 : cy);
        r = ((cx + r) > 180) ? 180 - cx : r;
        r = ((cx - r) < -180) ? cx + 180 : r;
        r = ((cy + r) > 90) ? 90 - cy : r;
        r = ((cy - r) < -90) ? cx + 90 : r;
        updateDrawPtsAndRepaint();
    }

    public void setDynMap(boolean t) {
        dynMapEnable = t;
    }

    public void zoomin() {
        r = r / Math.sqrt(2.0);
        if (currentLoc != null) {
            cx = currentLoc.getLongitude();
            cy = currentLoc.getLatitude();
        }
        updateDrawPtsAndRepaint();
    }

    public void zoomout() {
        r = r * Math.sqrt(2.0);
        if (currentLoc != null) {
            cx = currentLoc.getLongitude();
            cy = currentLoc.getLatitude();
        }
        r = ((cx + r) > 180) ? 180 - cx : r;
        r = ((cx - r) < -180) ? cx + 180 : r;
        r = ((cy + r) > 90) ? 90 - cy : r;
        r = ((cy - r) < -90) ? cx + 90 : r;
        updateDrawPtsAndRepaint();

    }

    public void clearData() {
        cy = 23.605691;
        cx = 121.024777;
        r = 1.80; // 1.677918 
        currentLoc = null;
        currentPt = null;
        traceLocs.clear();
        tracePts.clear();
        // calculateTaiwanPts();
        maps.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        });
        airports.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        });
        aidzs.forEach((m) -> {
            m.setXY(getWidth(), getHeight(), cy - r, cy + r, cx - r, cx + r);
        });
        repaint();
    }

    void update(MsfsUdpServer p) {
        long t= System.currentTimeMillis();
        String name = p.getName();
        double lat = p.getLat();
        double lng = p.getLng();
        double head = p.getHeading();
        Plane newplane = new Plane(t, name, lat, lng, head);
        planes.put(name, newplane);
    }
}

/**
 * point for draw trace
 *
 * @author DELL
 */
class Point {

    Integer x = 0;
    Integer y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Plane {
    long t;
    String name;
    double lat;
    double lng;
    double heading;

    Plane(long t, String name, double lat, double lng, double heading) {
        this.t = t;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.heading = heading;
    }
}

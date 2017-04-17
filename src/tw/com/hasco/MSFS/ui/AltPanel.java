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
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import tw.com.hasco.MSFS.locale.LocaleManager;

/**
 *
 * @author ktc
 */
public class AltPanel extends javax.swing.JPanel {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    ArrayList<Long> times;
    ArrayList<Double> altitudes;
    double maxAltitude;
    ArrayList<Double> groundAltitudes;
    final private Lock lock;

    /**
     * Creates new form PlotAltitudePanel
     */
    public AltPanel() {
        this.lock = new ReentrantLock();
        initComponents();
        times = new ArrayList<>();
        altitudes = new ArrayList<>();
        groundAltitudes = new ArrayList<>();
        maxAltitude = 0.0;
    }

    /**
     * Add data
     * @param time
     * @param altitude
     * @param groundAltitude
     * @throws java.text.ParseException
     */
    public void addData(String time, double altitude, double groundAltitude) throws ParseException {
        Date d = sdf.parse(time);
        Long t = d.getTime();
        if (!times.isEmpty()) {
            Long lastTime = times.get(times.size() - 1);
            if (t <= lastTime) {
                return;
            }
        }
        lock.lock();
        try {
            times.add(t);
            altitudes.add(altitude);
            if (altitude > maxAltitude) {
                maxAltitude = altitude;
            }
            groundAltitudes.add(groundAltitude);
        } finally {
            lock.unlock();
        }
        repaint();
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
            .addGap(0, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    private void drawAxis(Graphics2D g2d, String xlabel0, String xlabel1, String ylabel0, String ylabel1, int fontSize) {
        double width = getWidth();
        double height = getHeight();
        int x, y, x1, y1, x2, y2;
        x = (int) (0.4 * width);
        y = (int) (0.05 * height);
        g2d.drawString(LocaleManager.getInstance("Taiwan").getString("fig_plane_altitude"), x, y);
        g2d.drawString("Altitude Profile", x, y + fontSize);
        // draw y -axis
        x1 = (int) (0.1 * width);
        y1 = (int) (0.9 * height);
        x2 = x1;
        y2 = (int) (0.1 * height);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, x2-3, y2 +3);
        g2d.drawLine(x2, y2, x2+3, y2 +3);
        // draw x axis
        x1 = (int) (0.1 * width);
        y1 = (int) (0.9 * height);
        x2 = (int) (0.95 * width);
        y2 = y1;
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, x2-3, y2 -3);
        g2d.drawLine(x2, y2, x2-3, y2 +3);
        // draw 0 x -axis
        x1 = (int) (0.08 * width);
        y1 = (int) (0.8 * height);
        x2 = (int) (0.9 * width);
        y2 = y1;
        g2d.drawLine(x1, y1, x2, y2);
        // draw y label0
        y = (int) (0.8 * height);
        x = (int) (0.05 * width);
        g2d.drawString(ylabel0, x, y);
        // darw ylabel1
        x = (int) (0.04 * width);
        y = (int) (0.2 * height);
        g2d.drawString(ylabel1, x, y);
        // draw xlabel 0
        x = (int) (0.05 * width);
        y = (int) (0.95 * height);
        g2d.drawString(xlabel0, x, y);
        // draw x label 1
        x = (int) (0.85 * width);
        y = (int) (0.95 * height);
        g2d.drawString(xlabel1, x, y);
        // draw symbol
        x = (int) (0.04 * width);
        y = (int) (0.15 * height);
         g2d.drawString(LocaleManager.getInstance("Taiwan").getString("meter"), x, y);
         y=(int)  (0.1 * height);
         g2d.drawString(LocaleManager.getInstance("Taiwan").getString("altitude"), x, y);
    }
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
        double width = getWidth();
        double height = getHeight();
        int x, y, x1, y1, x2, y2;

        //Font currentFont = g.getFont();
        //Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        //g.setFont(newFont);

        if (times.isEmpty()) {
            return;
        }
        String startTime = sdf.format(new Date(times.get(0))), endTime = sdf.format(new Date(times.get(times.size() - 1)));
        Double axisAltitude = (maxAltitude == 0) ? 100 : Math.ceil(maxAltitude);
        String ylabel0 = "0", ylabel1 = String.format("%.1f", axisAltitude);
        drawAxis(g2d, startTime, endTime, ylabel0, ylabel1, g.getFont().getSize());
        double altitude, groundAtitude;
        double yScale = 0.6 * height / axisAltitude, xScale;
        if (times.size() == 1) {
            if (maxAltitude == 0) {
                g2d.drawLine((int) (0.1 * width), (int) (0.8 * height), (int) (0.9 * width), (int) (0.8 * height));
            } else {
                x1 = (int) (0.1 * width);
                x2 = (int) (0.9 * width);
                y1 = (int) (0.8 * height - altitudes.get(0) * yScale);
                y2 = y1;
                g2d.drawLine(x1, y1, x2, y2);
                y1 = (int) (0.8 * height - groundAltitudes.get(0) * yScale);
                y2 = y1;
                g2d.drawLine(x1, y1, x2, y2);
            }
        } else if (times.size() <= 500) {
            if (maxAltitude == 0) {
                g2d.drawLine((int) (0.1 * width), (int) (0.8 * height), (int) (0.9 * width), (int) (0.8 * height));
            } else {
                xScale = 0.8 * width / (times.get(times.size() - 1) - times.get(0));
                x1 = (int) (0.1 * width);
                y1 = (int) (0.8 * height - altitudes.get(0) * yScale);
                g2d.setColor(Color.RED);
                for (int i = 1; i < times.size(); ++i) {
                    x2 = (int) (0.1 * width + xScale * (times.get(i) - times.get(0)));
                    y2 = (int) (0.8 * height - altitudes.get(i) * yScale);
                    if ((altitudes.get(i) - groundAltitudes.get(i)) < 2) {
                        g2d.setColor(Color.YELLOW);
                        g2d.setStroke(new BasicStroke(3));
                    } else {
                        g2d.setColor(Color.RED);
                        g2d.setStroke(new BasicStroke(1));
                    }
                    g2d.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
                g2d.setStroke(new BasicStroke(1));
                x2 = x1;
                y2 = y1;
                x1 = (int) (0.9 * width);
                y1 = (int) (0.8 * height);
                g2d.setColor(Color.BLACK);
                g2d.drawLine(x1, y1, x2, y2);
                ArrayList<Integer> vecXs = new ArrayList<>();
                ArrayList<Integer> vecYs = new ArrayList<>();
                x = (int) (0.1 * width);
                y = (int) (0.8 * height);
                vecXs.add(x);
                vecYs.add(y);

                for (int i = 0; i < times.size(); ++i) {
                    x = (int) (0.1 * width + xScale * (times.get(i) - times.get(0)));
                    y = (int) (0.8 * height - groundAltitudes.get(i) * yScale);
                    vecXs.add(x);
                    vecYs.add(y);
                }
                x = (int) (0.9 * width);
                y = (int) (0.8 * height);
                vecXs.add(x);
                vecYs.add(y);
                int[] intXs = convertIntegers(vecXs);
                int[] intYs = convertIntegers(vecYs);
                Polygon poly = new Polygon(intXs, intYs, vecXs.size());
                g2d.setColor(new Color(0,153,51));
                g2d.fill(poly);
            }
        } else {
            if (maxAltitude == 0) {
                g2d.drawLine((int) (0.1 * width), (int) (0.8 * height), (int) (0.9 * width), (int) (0.8 * height));
            } else {
                int incr = (int) (times.size() / 500);
                xScale = 0.8 * width / (times.get(times.size() - 1) - times.get(0));
                x1 = (int) (0.1 * width);
                y1 = (int) (0.8 * height - altitudes.get(0) * yScale);
                g2d.setColor(Color.RED);
                for (int i = 1; i < times.size(); i += incr) {
                    x2 = (int) (0.1 * width + xScale * (times.get(i) - times.get(0)));
                    y2 = (int) (0.8 * height - altitudes.get(i) * yScale);
                    g2d.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
                x2 = x1;
                y2 = y1;
                x1 = (int) (0.9 * width);
                y1 = (int) (0.8 * height);
                g2d.setColor(Color.BLACK);
                g2d.drawLine(x1, y1, x2, y2);
                ArrayList<Integer> vecXs = new ArrayList<>();
                ArrayList<Integer> vecYs = new ArrayList<>();
                x = (int) (0.1 * width);
                y = (int) (0.8 * height);
                vecXs.add(x);
                vecYs.add(y);

                for (int i = 0; i < times.size(); ++i) {
                    x = (int) (0.1 * width + xScale * (times.get(i) - times.get(0)));
                    y = (int) (0.8 * height - groundAltitudes.get(i) * yScale);
                    vecXs.add(x);
                    vecYs.add(y);
                }
                x = (int) (0.9 * width);
                y = (int) (0.8 * height);
                vecXs.add(x);
                vecYs.add(y);
                int[] intXs = convertIntegers(vecXs);
                int[] intYs = convertIntegers(vecYs);
                Polygon poly = new Polygon(intXs, intYs, vecXs.size());
                g2d.setColor(new Color(0,153,51));
                g2d.fill(poly);
            }
        }

    }
    public void clearData() {
        altitudes.clear();
        groundAltitudes.clear();
        times.clear();
        maxAltitude = 0.0;
    }
}

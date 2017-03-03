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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tw.com.hasco.MSFS.FS.FSBasic;

/**
 *
 * @author DELL
 */
public class YawPanel extends javax.swing.JPanel {

    double beta;
    double heading;
    int rudderDeflection;
    int rudderControl;
    BufferedImage planeTop;
    BufferedImage pic;

    /**
     * Creates new form PlotFrontPanel
     */
    public YawPanel() {
        initComponents();
        try {
            beta = 15;
            heading = 15;
            rudderControl = 100;
            rudderDeflection = 30;
            ClassLoader classLoader = getClass().getClassLoader();
            planeTop = ImageIO.read(classLoader.getResourceAsStream("draw/top.png"));
            BufferedImage before = ImageIO.read(classLoader.getResourceAsStream("draw/pic3.png"));
            int w = before.getWidth();
            int h = before.getHeight();
            pic = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at = new AffineTransform();
            at.scale(0.583, 0.583);
            AffineTransformOp scaleOp = 
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            pic = scaleOp.filter(before, pic);
            //pic = ImageIO.read(classLoader.getResourceAsStream("draw/pic3.png"));
        } catch (IOException ex) {
            Logger.getLogger(YawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


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
        double planeWidth = planeTop.getWidth();
        double planeHeight = planeTop.getHeight();
        double x, y, x1, y1, x2, y2;
        // Font currentFont = g.getFont();
        // Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        // g.setFont(newFont);
        // title string
        x = 0.05 * width;
        y = 0.05 * height;
        g2d.drawString("方向操控姿態動畫 Yaw Control & Attitude Dynamic Graphic", (int) x, (int) y);
        // symbol table
        x = 0.05 * width;
        y = 0.81 * height;
        g2d.drawString("\u03B2:側滑角：" + (int)beta, (int) x, (int) y);
        g2d.drawString("\u03C8:方位角：" + (int) heading, (int) x , (int) y + g.getFont().getSize() + 10);
        g2d.drawString("\u03B4R:方向舵角：" + (int) rudderDeflection, (int) x, (int) y + 2 * g.getFont().getSize() + 20);
        // draw plane 
        double rcx = width / 2, rcy = height / 2 - planeHeight * 51 / 231; // rcx, rcy: rotation center
        double rot = Math.toRadians(beta);
        AffineTransform at = new AffineTransform();
        // 4. translate it to the center of the component
        at.translate(rcx, rcy);
        // 3. do the actual rotation
        at.rotate(-1.0 * rot);
        // 2. just a scale because this image is big
         at.scale(0.583, 0.583);
        // 1. translate the object so that you rotate it around the 
        //    center (easier :))
        at.translate(-planeWidth / 2, -planeHeight * 65 / 231);
        // at.translate(-planeWidth / 2, -planeHeight /2);
        // draw the image
        g2d.drawImage(planeTop, at, null);

        // 1. draw beta
        // 1.1 draw vx line
        g.setColor(java.awt.Color.green);
        y2 = rcy - 0.25 * width;
        g2d.drawLine((int) (rcx), (int) (rcy), (int) (rcx), (int) (y2));
        g2d.drawString("Vx", (int) rcx, (int) y2);
        // 1.2 draw x body line
        x1 = rcx - 0.25 * width * Math.sin(rot);
        y1 = rcy - 0.25 * width * Math.cos(rot);
        x2 = rcx + 0.35 * width * Math.sin(rot);
        y2 = rcy + 0.35 * width * Math.cos(rot);
        g.setColor(java.awt.Color.pink);
        g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2); // line
        g2d.drawString("Xbody", (int) x1, (int) y1);
        x = rcx - 0.2 * width;
        y = rcy - 0.2 * width;
        g2d.drawArc((int) x, (int) y, (int) (0.4 * width), (int) (0.4 * width), 90, (int) beta);
        double degree = beta/2;
        rot = Math.toRadians(degree);
        x = rcx -  0.2 * width * Math.sin(rot);
        y = rcy -  0.2 * width * Math.cos(rot);
        g2d.drawString("\u03B2:" + (int) beta, (int)x, (int)y);
        //1.3 draw north line
        double betaPsi = beta + heading;
        rot = Math.toRadians(betaPsi);
        x2 = rcx - 0.25 * width * Math.sin(rot);
        y2 = rcy - 0.25 * width * Math.cos(rot);
        g.setColor(java.awt.Color.BLUE);
        g2d.drawLine((int) rcx, (int) rcy, (int) x2, (int) y2);
        g2d.drawString("North", (int) x2, (int) y2);
        x = rcx - 0.2 * width;
        y = rcy - 0.2 * width;
        g2d.drawArc((int) x, (int) y, (int) (0.4 * width), (int) (0.4 * width), (int) (90 + beta), (int) heading);
        degree = beta + heading / 2;
        rot = Math.toRadians(degree);
        x = rcx -  0.2 * width * Math.sin(rot);
        y = rcy -  0.2 * width * Math.cos(rot);
        g2d.drawString("\u03C8:" + (int) heading, (int)x, (int)y);
        // draw rudderDeflection
        double deltaBeta = rudderDeflection + beta;
        rot = Math.toRadians(beta);
        double r = planeHeight * 123 / 231*0.583;
        x1 = rcx + r * Math.sin(rot);
        y1 = rcy + r * Math.cos(rot);
        rot = Math.toRadians(deltaBeta);
        x2 = x1 + 0.15 * width * Math.sin(rot);
        y2 = y1 + 0.15 * width * Math.cos(rot);
        g.setColor(java.awt.Color.blue);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g2d.setStroke(new BasicStroke(1));
        x = x1 - 0.12 * width;
        y = y1 - 0.12 * width;
        g2d.drawArc((int) x, (int) y, (int) (0.24 * width), (int) (0.24 * width), (int) (270 + beta), (int) rudderDeflection);
        degree =  beta + rudderDeflection/2;
        rot = Math.toRadians(degree);
        x = x1 + 0.13 * width * Math.sin(rot);
        y = y1 + 0.13 * width * Math.cos(rot);
        g2d.drawString("\u03B4R:"+ (int) rudderDeflection, (int) x, (int)y);
        // draw rudderControl
        g.setColor(java.awt.Color.black);
        x = width * 0.8 - pic.getWidth()* 0.9*0.583;
        y = height * 0.98;
        g2d.drawString("方向舵踏板操控%: " + (int) rudderControl, (int) x, (int) y);
        g.setColor(java.awt.Color.blue);
        x = x - 0.1 * pic.getWidth() *0.583;
        y = y - height * 0.09 - pic.getHeight() / 2 *0.583;
        g2d.drawImage(pic, (int) x, (int) y, null);
        rcx = x + pic.getWidth()*0.485 *0.583;
        rcy = y + pic.getHeight() *0.14 *0.583;
        degree = Math.toRadians(rudderControl * 0.25);
        x1 = rcx + pic.getHeight() * Math.cos(degree)*0.583;
        y1 = rcy - pic.getHeight() * Math.sin(degree) *0.583;
        x2 = rcx - pic.getHeight() * Math.cos(degree)*0.583;
        y2 = rcy + pic.getHeight() * Math.sin(degree)*0.583;
        // g2d.setStroke(new BasicStroke(3));
        g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g2d.drawLine((int) x1, (int) y1, (int) x1, (int) y1-10);
        g2d.fillRect((int) x1-10, (int) y1-30, 20, 20);
        g2d.drawLine((int) x2, (int) y2, (int) x2, (int) y2-10);
        g2d.fillRect((int) x2-10, (int) y2-30, 20, 20);
        // g2d.drawRect(WIDTH, WIDTH, WIDTH, HEIGHT);
       
    }

    public void update(FSBasic fsBasic) {
        beta = fsBasic.beta();
        heading = fsBasic.heading();
        rudderDeflection = fsBasic.rudderDeflection();
        rudderControl = fsBasic.rudderControl();
        repaint();
    }

    public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame("Demo");
        JPanel p = new YawPanel();
        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350, 400);
        f.setVisible(true);
    }

}
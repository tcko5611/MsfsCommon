package tw.com.hasco.MSFS.ui;

import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.Observer;
import tw.com.hasco.MSFS.locale.LocaleManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ktc
 */
public class AltFrame extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form PlotAltitudeFrame
     */
    public AltFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/draw/h.jpg")));
        this.setTitle(LocaleManager.getInstance("Taiwan").getString("fig_altitude"));
        // this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        altPanel = new tw.com.hasco.MSFS.ui.AltPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        altitudeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        flyAltitudeLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        groundAltitudeLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout altPanelLayout = new javax.swing.GroupLayout(altPanel);
        altPanel.setLayout(altPanelLayout);
        altPanelLayout.setHorizontalGroup(
            altPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        altPanelLayout.setVerticalGroup(
            altPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setText("時間");

        timeLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeLabel.setText("00:00:00");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("航高");

        altitudeLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        altitudeLabel.setForeground(new java.awt.Color(255, 0, 0));
        altitudeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        altitudeLabel.setText("0");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.blue);
        jLabel3.setText("離地");

        flyAltitudeLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        flyAltitudeLabel.setForeground(java.awt.Color.blue);
        flyAltitudeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        flyAltitudeLabel.setText("0");

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("地高");

        groundAltitudeLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        groundAltitudeLabel.setForeground(new java.awt.Color(0, 153, 51));
        groundAltitudeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        groundAltitudeLabel.setText("0");

        clearButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        clearButton.setText("清除資料");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(altitudeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flyAltitudeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groundAltitudeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(altitudeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(flyAltitudeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(groundAltitudeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addGap(0, 215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(altPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(altPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_clearButtonActionPerformed
    public void addData(String strTime, double altitude, double groundAltitude) {
        try {
            double flyAltitude = altitude - groundAltitude;
            this.timeLabel.setText(strTime);
            this.altitudeLabel.setText(String.format("%.1f", altitude));
            this.flyAltitudeLabel.setText(String.format("%.1f", flyAltitude));
            this.groundAltitudeLabel.setText(String.format("%.1f", groundAltitude));
            altPanel.addData(strTime, altitude, groundAltitude);
        } catch (ParseException ex) {
            Logger.getLogger(AltFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        AltFrame plotAltitudeFrame = new AltFrame();
        plotAltitudeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {            
                plotAltitudeFrame.setVisible(true);
        });
        Executor executor;
        executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // TODO add your handling code here:
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String strTime = "12:03:20";
                    Long ltime = sdf.parse(strTime).getTime();
                    Random rand = new Random();

                    for (int i = 0; i < 5000; ++i) {
                        System.out.println(i);
                        strTime = sdf.format(new Date(ltime + i * 1000));
                        double altitude = (2 + rand.nextDouble() * 0.2) * i;
                        // double altitude = 2*i;
                        double groundAltitude = i * (1 + rand.nextDouble() * 0.2);
                        plotAltitudeFrame.addData(strTime, altitude, groundAltitude);
                        sleep(1);
                    }
                } catch (ParseException | InterruptedException ex) {
                    Logger.getLogger(AltFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tw.com.hasco.MSFS.ui.AltPanel altPanel;
    private javax.swing.JLabel altitudeLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel flyAltitudeLabel;
    private javax.swing.JLabel groundAltitudeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(FSBasic fsBasic) {
        String strTime = fsBasic.getDisplayTime();
        double altitude = fsBasic.altitude();
        double groundAltitude = fsBasic.groudAltitude();
        double lat = fsBasic.latitude();
        double lng = fsBasic.longitude();
        int engineRpm = fsBasic.engineRPM();
        if ((lat == 0.0 && lng == 0.0) || (engineRpm == 0))return;
        this.addData(strTime, altitude, groundAltitude);
    }

    public void clearData() {
        this.timeLabel.setText("00:00:00");
        this.altitudeLabel.setText("0");
        this.flyAltitudeLabel.setText("0");
        this.groundAltitudeLabel.setText("0");
        this.altPanel.clearData();
    }
}

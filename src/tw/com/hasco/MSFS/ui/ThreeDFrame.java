/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.Observer;
import tw.com.hasco.MSFS.locale.LocaleManager;

/**
 *
 * @author DELL
 */
public class ThreeDFrame extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form ThreeDFrame
     */
    public ThreeDFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/draw/h.jpg")));
        this.setTitle(LocaleManager.getInstance("Taiwan").getString("figThreeD"));
        updateWidgetName();
    }
private void updateWidgetName() {
    LocaleManager l = LocaleManager.getInstance("Taiwan");
    this.dynMapCheckBox.setText(l.getString("dynMap"));
    this.bigButton.setText(l.getString("zoomIn"));
    this.smallButton.setText(l.getString("zoomOut"));
    this.clearButton.setText(l.getString("clearData"));
    this.periodLabel.setText(l.getString("period"));
    this.secLabel.setText(l.getString("sec"));
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        threeDPanel = new tw.com.hasco.MSFS.ui.ThreeDPanel();
        jPanel1 = new javax.swing.JPanel();
        dynMapCheckBox = new javax.swing.JCheckBox();
        bigButton = new javax.swing.JButton();
        smallButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        periodLabel = new javax.swing.JLabel();
        degreeTextField = new javax.swing.JTextField();
        secLabel = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        threeDPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout threeDPanelLayout = new javax.swing.GroupLayout(threeDPanel);
        threeDPanel.setLayout(threeDPanelLayout);
        threeDPanelLayout.setHorizontalGroup(
            threeDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        threeDPanelLayout.setVerticalGroup(
            threeDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        dynMapCheckBox.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dynMapCheckBox.setText("動態地圖");
        dynMapCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dynMapCheckBoxItemStateChanged(evt);
            }
        });

        bigButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        bigButton.setText("放大");
        bigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bigButtonActionPerformed(evt);
            }
        });

        smallButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        smallButton.setText("縮小");
        smallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        clearButton.setText("清除資料");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        periodLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        periodLabel.setText("間隔");

        degreeTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        degreeTextField.setText("5");
        degreeTextField.setToolTipText("");
        degreeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeTextFieldActionPerformed(evt);
            }
        });

        secLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        secLabel.setText("秒");

        jSlider1.setMaximum(45);
        jSlider1.setMinimum(15);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setValue(30);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jSlider2.setMaximum(45);
        jSlider2.setMinimum(-30);
        jSlider2.setValue(0);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dynMapCheckBox)
                    .addComponent(bigButton)
                    .addComponent(smallButton)
                    .addComponent(clearButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(periodLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(degreeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secLabel))
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dynMapCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bigButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(smallButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodLabel)
                    .addComponent(degreeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(threeDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(threeDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigButtonActionPerformed
        // TODO add your handling code here:
        this.threeDPanel.zoomin();
    }//GEN-LAST:event_bigButtonActionPerformed

    private void smallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallButtonActionPerformed
        // TODO add your handling code here:
        this.threeDPanel.zoomout();
    }//GEN-LAST:event_smallButtonActionPerformed

    private void degreeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeTextFieldActionPerformed
        // TODO add your handling code here:
        int d = Integer.parseInt(degreeTextField.getText());
        threeDPanel.setLineDuration(d);
    }//GEN-LAST:event_degreeTextFieldActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            int degree = (int) source.getValue();
            this.threeDPanel.setThetaXy(degree);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
                JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            int degree = (int) source.getValue();
            this.threeDPanel.setTheta(degree);
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void dynMapCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dynMapCheckBoxItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
            threeDPanel.setDynMap(true);
            //do something...
        } else {//checkbox has been deselected
            //do something...
            threeDPanel.setDynMap(false);
        }
    }//GEN-LAST:event_dynMapCheckBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(ThreeDFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreeDFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreeDFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreeDFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        LocaleManager l = LocaleManager.getInstance("China");
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override            
            public void run() {
                new ThreeDFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bigButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField degreeTextField;
    private javax.swing.JCheckBox dynMapCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JLabel secLabel;
    private javax.swing.JButton smallButton;
    private tw.com.hasco.MSFS.ui.ThreeDPanel threeDPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(FSBasic fsBasic) {
        threeDPanel.update(fsBasic);
    }
    
    public void clearData() {
        threeDPanel.clearData();
    }
}

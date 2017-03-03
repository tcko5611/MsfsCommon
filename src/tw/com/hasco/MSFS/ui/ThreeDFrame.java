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
        this.setTitle("Map 3D航跡圖");
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
        bigButton = new javax.swing.JButton();
        smallButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        degreeTextField = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        clearButton = new javax.swing.JButton();
        jSlider2 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        dynMapCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout threeDPanelLayout = new javax.swing.GroupLayout(threeDPanel);
        threeDPanel.setLayout(threeDPanelLayout);
        threeDPanelLayout.setHorizontalGroup(
            threeDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        threeDPanelLayout.setVerticalGroup(
            threeDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        jLabel4.setText("間隔");

        degreeTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        degreeTextField.setText("5");
        degreeTextField.setToolTipText("");
        degreeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeTextFieldActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(45);
        jSlider1.setMinimum(15);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setValue(30);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        clearButton.setText("清除資料");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        jLabel5.setText("秒");

        dynMapCheckBox.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dynMapCheckBox.setText("動態地圖");
        dynMapCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dynMapCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(threeDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bigButton)
                    .addComponent(smallButton)
                    .addComponent(clearButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(degreeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynMapCheckBox))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dynMapCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bigButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(smallButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(degreeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(106, 106, 106)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(threeDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
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
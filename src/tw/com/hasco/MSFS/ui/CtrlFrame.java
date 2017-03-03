/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.Observer;

/**
 *
 * @author ktc
 */
public class CtrlFrame extends javax.swing.JFrame implements Observer {



    /**
     * Creates new form AircraftFrame
     * @throws java.io.IOException
     */
    public CtrlFrame() throws IOException {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/draw/h.jpg")));
        this.setTitle("飛行員操控與飛機狀態");
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

        recordButtonGroup = new javax.swing.ButtonGroup();
        dataPanel2 = new tw.com.hasco.MSFS.ui.CtrlPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(CtrlFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CtrlFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CtrlFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CtrlFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        CtrlFrame dataFrame = new CtrlFrame();
        java.awt.EventQueue.invokeLater(() -> {            
                dataFrame.setVisible(true);            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tw.com.hasco.MSFS.ui.CtrlPanel dataPanel2;
    private javax.swing.ButtonGroup recordButtonGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(FSBasic fsBasic) {
        dataPanel2.update(fsBasic);
    }
}
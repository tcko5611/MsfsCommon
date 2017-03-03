package tw.com.hasco.MSFS.ui;

import java.awt.Toolkit;
import javax.swing.JFrame;
import tw.com.hasco.MSFS.LicChecker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class LicFrame extends javax.swing.JFrame {
    /**
     * Creates new form MainFrame
     */
    

    public LicFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/draw/h.jpg")));
        checkLic();
        setTitle("User Info");     
    }
private void checkLic() {
    // set front end textfied
    this.userTextField.setText(LicChecker.getInstance().getUser());
    this.purchaseDateTextField.setText(LicChecker.getInstance().getPurchaseDate());
    this.expirDateTextField.setText(LicChecker.getInstance().getExpireDate());
    this.macTextField.setText(LicChecker.getInstance().getMacNum());
    // graphic
    if (LicChecker.getInstance().isG1_LLA()) {
        this.LLA.setSelected(true);
    }
    if (LicChecker.getInstance().isG2_CTRL()) {
        this.Ctrl.setSelected(true);
    }
    if (LicChecker.getInstance().isG3_PITCH()) {
        this.pitch.setSelected(true);
    }
    if (LicChecker.getInstance().isG4_ROLL()) {
        this.roll.setSelected(true);
    }
    if (LicChecker.getInstance().isG5_YAW()) {
        this.yaw.setSelected(true);
    }
    if (LicChecker.getInstance().isG6_PLANE()) {
        this.plane.setSelected(true);
    }
    if (LicChecker.getInstance().isG7_ALT()) {
        this.alt.setSelected(true);
    }
    if (LicChecker.getInstance().isG8_THREED()) {
        this.threed.setSelected(true);
    }
    if (LicChecker.getInstance().isG9_PLOT6()) {
        this.plot6.setSelected(true);
    }
    // simulator
     if (LicChecker.getInstance().isS1_FSX()) {
        this.fsx.setSelected(true);
        this.fs2002.setSelected(true);
        this.fs2004.setSelected(true);
    }
    if (LicChecker.getInstance().isS2_XPLANE()) {
        this.xplane.setSelected(true);
    }
    if (LicChecker.getInstance().isS3_MODEL()) {
        this.model.setSelected(true);
    }
    if (LicChecker.getInstance().isS4_DOF3()) {
        this.dof3.setSelected(true);
    }
    if (LicChecker.getInstance().isS5_DOF6()) {
        this.dof6.setSelected(true);
    }
    // record
     if (LicChecker.getInstance().isR1_REFLY()) {
        this.refly.setSelected(true);
    }
    if (LicChecker.getInstance().isR2_RECORD()) {
        this.record.setSelected(true);
    }
    if (LicChecker.getInstance().isR3_PLAY()) {
        this.play.setSelected(true);
    }
    // map
     if (LicChecker.getInstance().isM1_SELFPORT()) {
        this.selfPort.setSelected(true);
    }
    if (LicChecker.getInstance().isM2_SELF2DMAP()) {
        this.self2DMap.setSelected(true);
    }
    if (LicChecker.getInstance().isM3_SELF3DBUIL()) {
        this.sel3DBuil.setSelected(true);
    }
    if (LicChecker.getInstance().isM4_COORMAP()) {
        this.coorMap.setSelected(true);
    }
    if (LicChecker.getInstance().isM5_MARK()) {
        this.mark.setSelected(true);
    }
    // Aviation
     if (LicChecker.getInstance().isA1_PHYMATH()) {
        this.phyMath.setSelected(true);
    }
    if (LicChecker.getInstance().isA2_AIRDYN()) {
        this.airDyn.setSelected(true);
    }
    if (LicChecker.getInstance().isA3_FLYTRAIN()) {
        this.flyTrain.setSelected(true);
    }
    if (LicChecker.getInstance().isA4_FLYQUAL()) {
        this.flyQual.setSelected(true);
    }
    if (LicChecker.getInstance().isA5_FLYCHK()) {
        this.flyChk.setSelected(true);
    }
    // defence
     if (LicChecker.getInstance().isD1_ENESHIP()) {
        this.eneShip.setSelected(true);
    }
    if (LicChecker.getInstance().isD2_AIRPIC()) {
        this.airPic.setSelected(true);
    }
    // Area data
     if (LicChecker.getInstance().isT1_TWN()) {
        this.tTwn.setSelected(true);
    }
    if (LicChecker.getInstance().isT2_NASIA()) {
        this.tNAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isT3_SASIA()) {
        this.tSAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isT4_PAC()) {
        this.tPac.setSelected(true);
    }
    if (LicChecker.getInstance().isT5_USA()) {
        this.tUsa.setSelected(true);
    }
    // airport data
     if (LicChecker.getInstance().isU1_TWN()) {
        this.uTwn.setSelected(true);
    }
    if (LicChecker.getInstance().isU2_NASIA()) {
        this.uNAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isU3_SASIA()) {
        this.uSAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isU4_PAC()) {
        this.uPac.setSelected(true);
    }
    if (LicChecker.getInstance().isU5_USA()) {
        this.uUsa.setSelected(true);
    }
    // Aidz data
    if (LicChecker.getInstance().isV1_TWN()) {
        this.vTwn.setSelected(true);
    }
    if (LicChecker.getInstance().isV2_NASIA()) {
        this.vNAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isV3_SASIA()) {
        this.vSAsia.setSelected(true);
    }
    if (LicChecker.getInstance().isV4_PAC()) {
        this.vPac.setSelected(true);
    }
    if (LicChecker.getInstance().isV5_USA()) {
        this.vUsa.setSelected(true);
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

        jPanel1 = new javax.swing.JPanel();
        userTextField = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        purchaseDateLabel = new javax.swing.JLabel();
        purchaseDateTextField = new javax.swing.JTextField();
        expirDateTextField = new javax.swing.JTextField();
        expireDateLabel = new javax.swing.JLabel();
        macLabel = new javax.swing.JLabel();
        macTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        LLA = new javax.swing.JCheckBox();
        Ctrl = new javax.swing.JCheckBox();
        pitch = new javax.swing.JCheckBox();
        roll = new javax.swing.JCheckBox();
        yaw = new javax.swing.JCheckBox();
        plane = new javax.swing.JCheckBox();
        alt = new javax.swing.JCheckBox();
        threed = new javax.swing.JCheckBox();
        plot6 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        refly = new javax.swing.JCheckBox();
        record = new javax.swing.JCheckBox();
        play = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        selfPort = new javax.swing.JCheckBox();
        self2DMap = new javax.swing.JCheckBox();
        sel3DBuil = new javax.swing.JCheckBox();
        coorMap = new javax.swing.JCheckBox();
        mark = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        fsx = new javax.swing.JCheckBox();
        fs2004 = new javax.swing.JCheckBox();
        fs2002 = new javax.swing.JCheckBox();
        xplane = new javax.swing.JCheckBox();
        model = new javax.swing.JCheckBox();
        dof3 = new javax.swing.JCheckBox();
        dof6 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        phyMath = new javax.swing.JCheckBox();
        airDyn = new javax.swing.JCheckBox();
        flyTrain = new javax.swing.JCheckBox();
        flyQual = new javax.swing.JCheckBox();
        flyChk = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        eneShip = new javax.swing.JCheckBox();
        airPic = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        tSAsia = new javax.swing.JCheckBox();
        tPac = new javax.swing.JCheckBox();
        tNAsia = new javax.swing.JCheckBox();
        tUsa = new javax.swing.JCheckBox();
        tTwn = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        uSAsia = new javax.swing.JCheckBox();
        uPac = new javax.swing.JCheckBox();
        uNAsia = new javax.swing.JCheckBox();
        uUsa = new javax.swing.JCheckBox();
        uTwn = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        vSAsia = new javax.swing.JCheckBox();
        vPac = new javax.swing.JCheckBox();
        vNAsia = new javax.swing.JCheckBox();
        vUsa = new javax.swing.JCheckBox();
        vTwn = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTextField.setEditable(false);
        userTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        userTextField.setText("John Lee");

        userLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        userLabel.setText("使用者名字");

        purchaseDateLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        purchaseDateLabel.setText("購買日期");

        purchaseDateTextField.setEditable(false);
        purchaseDateTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        purchaseDateTextField.setText("2017/03/01");

        expirDateTextField.setEditable(false);
        expirDateTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        expirDateTextField.setText("2017/07/30");

        expireDateLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        expireDateLabel.setText("截止日期");

        macLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        macLabel.setText("mac address");

        macTextField.setEditable(false);
        macTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        macTextField.setText("64-27-37-39-1B-51");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(macLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(macTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(expireDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(expirDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(purchaseDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseDateLabel)
                    .addComponent(purchaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expireDateLabel)
                    .addComponent(expirDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(macTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(macLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Graphic", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N
        jPanel3.setToolTipText("Graphic");
        jPanel3.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        jPanel3.setName("Graphic"); // NOI18N

        LLA.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        LLA.setText("G1-飛航資訊LLA");
        LLA.setToolTipText("");
        LLA.setEnabled(false);

        Ctrl.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        Ctrl.setText("G2-飛行操控Ctrl");
        Ctrl.setEnabled(false);

        pitch.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        pitch.setText("G3-俯仰圖 Pitch");
        pitch.setEnabled(false);

        roll.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        roll.setText("G4-滾轉圖 Roll");
        roll.setEnabled(false);

        yaw.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        yaw.setText("G5-方向圖 Yaw");
        yaw.setEnabled(false);

        plane.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        plane.setText("G6-平面圖2D");
        plane.setEnabled(false);

        alt.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        alt.setText("G7-高度圖 Alt");
        alt.setEnabled(false);

        threed.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        threed.setText("G8-立體圖3D");
        threed.setEnabled(false);

        plot6.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        plot6.setText("G9-數值圖 Plot6");
        plot6.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yaw)
                    .addComponent(plane)
                    .addComponent(alt)
                    .addComponent(threed)
                    .addComponent(LLA)
                    .addComponent(Ctrl)
                    .addComponent(pitch)
                    .addComponent(roll))
                .addGap(114, 114, 114))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plot6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LLA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ctrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pitch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yaw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(threed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plot6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Record", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        refly.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        refly.setText("R1-重飛 Refly");
        refly.setEnabled(false);

        record.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        record.setText("R2-記錄 Record");
        record.setEnabled(false);

        play.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        play.setText("R3-播放 Play");
        play.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(record)
                    .addComponent(refly)
                    .addComponent(play)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(refly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(record)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(play)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Map", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        selfPort.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        selfPort.setText("M1-自建跑道");
        selfPort.setEnabled(false);

        self2DMap.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        self2DMap.setText("M2-自建2D地圖");
        self2DMap.setEnabled(false);

        sel3DBuil.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        sel3DBuil.setText("M3-自建3D建物");
        sel3DBuil.setEnabled(false);

        coorMap.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        coorMap.setText("M4-座標化地圖");
        coorMap.setEnabled(false);

        mark.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        mark.setText("M5-標示");
        mark.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selfPort)
                    .addComponent(sel3DBuil)
                    .addComponent(self2DMap)
                    .addComponent(coorMap)
                    .addComponent(mark)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selfPort)
                .addGap(0, 0, 0)
                .addComponent(self2DMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sel3DBuil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coorMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mark)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simulator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        fsx.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        fsx.setText("S1-FSX");
        fsx.setEnabled(false);

        fs2004.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        fs2004.setText("S1-FS2004");
        fs2004.setEnabled(false);

        fs2002.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        fs2002.setText("S1-FS2002");
        fs2002.setEnabled(false);

        xplane.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        xplane.setText("S2-XPlane");
        xplane.setEnabled(false);

        model.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        model.setText("S3-To Model");
        model.setEnabled(false);

        dof3.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dof3.setText("S4-To 3DOF");
        dof3.setEnabled(false);

        dof6.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dof6.setText("S5-To 6DOF");
        dof6.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fsx)
            .addComponent(xplane)
            .addComponent(fs2004)
            .addComponent(dof6)
            .addComponent(dof3)
            .addComponent(model)
            .addComponent(fs2002)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fsx, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fs2004, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fs2002, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xplane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(model)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dof3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dof6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aviation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        phyMath.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        phyMath.setText("A1-航空物理數學");
        phyMath.setEnabled(false);

        airDyn.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        airDyn.setText("A2-飛機空氣動力");
        airDyn.setEnabled(false);

        flyTrain.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        flyTrain.setText("A3-飛行訓練科目");
        flyTrain.setEnabled(false);

        flyQual.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        flyQual.setText("A4-飛航品保查核");
        flyQual.setEnabled(false);

        flyChk.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        flyChk.setText("A5-飛安事故調查");
        flyChk.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(flyChk)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airDyn)
                            .addComponent(phyMath)
                            .addComponent(flyTrain)
                            .addComponent(flyQual))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phyMath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airDyn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flyTrain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flyQual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flyChk, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Defence", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        eneShip.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        eneShip.setText("D1-反艦攔截");
        eneShip.setEnabled(false);

        airPic.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        airPic.setText("D2-空中偵照");
        airPic.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eneShip)
                    .addComponent(airPic))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eneShip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airPic)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Area Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        tSAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        tSAsia.setText("T3-東南亞");
        tSAsia.setEnabled(false);

        tPac.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        tPac.setText("T4-太平洋");
        tPac.setEnabled(false);

        tNAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        tNAsia.setText("T2-東北亞");
        tNAsia.setEnabled(false);

        tUsa.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        tUsa.setText("T5-北美");
        tUsa.setEnabled(false);

        tTwn.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        tTwn.setText("T1-台灣");
        tTwn.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tUsa)
                    .addComponent(tNAsia)
                    .addComponent(tTwn)
                    .addComponent(tSAsia)
                    .addComponent(tPac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tTwn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tNAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tUsa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Airport Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        uSAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        uSAsia.setText("U3-東南亞");
        uSAsia.setEnabled(false);

        uPac.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        uPac.setText("U4-太平洋");
        uPac.setEnabled(false);

        uNAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        uNAsia.setText("U2-東北亞");
        uNAsia.setEnabled(false);

        uUsa.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        uUsa.setText("U5-北美");
        uUsa.setEnabled(false);

        uTwn.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        uTwn.setText("U1-台灣");
        uTwn.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uUsa)
                    .addComponent(uNAsia)
                    .addComponent(uTwn)
                    .addComponent(uSAsia)
                    .addComponent(uPac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uTwn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uNAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uSAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uUsa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AIDZ FIR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("新細明體", 0, 14))); // NOI18N

        vSAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        vSAsia.setText("V3-東南亞");
        vSAsia.setEnabled(false);

        vPac.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        vPac.setText("V4-太平洋");
        vPac.setEnabled(false);

        vNAsia.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        vNAsia.setText("V2-東北亞");
        vNAsia.setEnabled(false);

        vUsa.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        vUsa.setText("V5-北美");
        vUsa.setEnabled(false);

        vTwn.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        vTwn.setText("V1-台灣");
        vTwn.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vUsa)
                    .addComponent(vNAsia)
                    .addComponent(vTwn)
                    .addComponent(vSAsia)
                    .addComponent(vPac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vTwn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vNAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vSAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vUsa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LicFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LicFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LicFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LicFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {            
                new LicFrame().setVisible(true);            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Ctrl;
    private javax.swing.JCheckBox LLA;
    private javax.swing.JCheckBox airDyn;
    private javax.swing.JCheckBox airPic;
    private javax.swing.JCheckBox alt;
    private javax.swing.JCheckBox coorMap;
    private javax.swing.JCheckBox dof3;
    private javax.swing.JCheckBox dof6;
    private javax.swing.JCheckBox eneShip;
    private javax.swing.JTextField expirDateTextField;
    private javax.swing.JLabel expireDateLabel;
    private javax.swing.JCheckBox flyChk;
    private javax.swing.JCheckBox flyQual;
    private javax.swing.JCheckBox flyTrain;
    private javax.swing.JCheckBox fs2002;
    private javax.swing.JCheckBox fs2004;
    private javax.swing.JCheckBox fsx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel macLabel;
    private javax.swing.JTextField macTextField;
    private javax.swing.JCheckBox mark;
    private javax.swing.JCheckBox model;
    private javax.swing.JCheckBox phyMath;
    private javax.swing.JCheckBox pitch;
    private javax.swing.JCheckBox plane;
    private javax.swing.JCheckBox play;
    private javax.swing.JCheckBox plot6;
    private javax.swing.JLabel purchaseDateLabel;
    private javax.swing.JTextField purchaseDateTextField;
    private javax.swing.JCheckBox record;
    private javax.swing.JCheckBox refly;
    private javax.swing.JCheckBox roll;
    private javax.swing.JCheckBox sel3DBuil;
    private javax.swing.JCheckBox self2DMap;
    private javax.swing.JCheckBox selfPort;
    private javax.swing.JCheckBox tNAsia;
    private javax.swing.JCheckBox tPac;
    private javax.swing.JCheckBox tSAsia;
    private javax.swing.JCheckBox tTwn;
    private javax.swing.JCheckBox tUsa;
    private javax.swing.JCheckBox threed;
    private javax.swing.JCheckBox uNAsia;
    private javax.swing.JCheckBox uPac;
    private javax.swing.JCheckBox uSAsia;
    private javax.swing.JCheckBox uTwn;
    private javax.swing.JCheckBox uUsa;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    private javax.swing.JCheckBox vNAsia;
    private javax.swing.JCheckBox vPac;
    private javax.swing.JCheckBox vSAsia;
    private javax.swing.JCheckBox vTwn;
    private javax.swing.JCheckBox vUsa;
    private javax.swing.JCheckBox xplane;
    private javax.swing.JCheckBox yaw;
    // End of variables declaration//GEN-END:variables
}

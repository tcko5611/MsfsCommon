/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import jssc.SerialPortException;
import tw.com.hasco.MSFS.Debugger;
import tw.com.hasco.MSFS.LicChecker;
import tw.com.hasco.MSFS.MacAddress;
import tw.com.hasco.MSFS.locale.LocaleManager;
import tw.com.hasco.MSFS.model.DataGetter;
import tw.com.hasco.MSFS.model.PlaneType;
import tw.com.hasco.MSFS.network.MsfsUdpClient;
import tw.com.hasco.MSFS.network.MsfsUdpServer;

/**
 *
 * @author ktc
 */
public class OldGFlightFrame extends javax.swing.JFrame {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    LicFrame licFrame;
    LlaFrame llaFrame;
    CtrlFrame data2Frame;
    PitchFrame plotThetaFrame;
    AltFrame plotAltitudeFrame;
    RollFrame plotFrontFrame;
    YawFrame plotTopFrame;
    TraceFrame plotTraceFrame;
    ThreeDFrame threeDFrame;
    Plot6Frame data1Frame;
    DataGetter dataGetter;
    // add for network
    ClientFrame clientFrame;
    ServerFrame serverFrame;
    MsfsUdpClient udpClient;
    MsfsUdpServer udpServer;
    
    double recordPeriod = 5; // record time period

    boolean recordable = false;
    boolean reflyAble = false;
    // for license check
    // end of license file
    boolean taiwanPortEnable = false;
    boolean newPortEnable = false;
    boolean aidzsEnable = false;
    boolean pacificPortEnable = false;
    boolean asiaPortEnable = false;
    boolean enermyShipEnable = false;
    boolean airPictureEnable = false;

    /**
     * Creates new form AircraftFrame
     *
     * @throws java.io.IOException
     */
    public OldGFlightFrame() throws IOException {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/draw/h.jpg")));
        setTitle("鴻祺航太飛航分析動畫 g-Flight 1.2");
        // setResizable(false);
        // check lic
        disableAll();
        checkLic();

        userTextField.setText(LicChecker.getInstance().getLicInfo());

        licFrame = new LicFrame();
        llaFrame = new LlaFrame();
        data2Frame = new CtrlFrame();
        plotThetaFrame = new PitchFrame();
        plotFrontFrame = new RollFrame();
        plotTopFrame = new YawFrame();
        plotTraceFrame = new TraceFrame();
        threeDFrame = new ThreeDFrame();
        data1Frame = new Plot6Frame();
        // for network
        clientFrame = new ClientFrame();
        serverFrame = new ServerFrame();

        plotAltitudeFrame = new AltFrame();
        
    }

    private void disableAll() {
        this.playMenuItem.setEnabled(false);
        this.fsxMenuItem.setEnabled(false);
        this.fs2002MenuItem.setEnabled(false);
        this.fs2004MenuItem.setEnabled(false);
        this.xplaneMenuItem.setEnabled(false);
        this.data1MenuItem.setEnabled(false);
        this.data2MenuItem.setEnabled(false);
        this.pitchMenuItem.setEnabled(false);
        this.rollMenuItem.setEnabled(false);
        this.yawMenuItem.setEnabled(false);
        this.altMenuItem.setEnabled(false);
        this.planeMenuItem.setEnabled(false);
        this.threeDMenuItem.setEnabled(false);
        this.recordMenuItem.setEnabled(false);
        this.startRecordButton.setEnabled(false);
        this.stopRecordButton.setEnabled(false);
        this.reflyButton.setEnabled(false);
        this.clearButton.setEnabled(false);

        taiwanPortEnable = false;
        newPortEnable = false;
        aidzsEnable = false;
        pacificPortEnable = false;
        asiaPortEnable = false;
        enermyShipEnable = false;
        airPictureEnable = false;
    }

    private void checkLic() {

        // graphic
        if (LicChecker.getInstance().isG1_LLA()) {
            data1MenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG2_CTRL()) {
            data2MenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG3_PITCH()) {
            pitchMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG4_ROLL()) {
            rollMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG5_YAW()) {
            yawMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG6_PLANE()) {
            planeMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG7_ALT()) {
            altMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isG8_THREED()) {
            threeDMenuItem.setEnabled(true);
        }
        // Simulator

        if (LicChecker.getInstance().isS1_FSX()) {
            fs2002MenuItem.setEnabled(true);
            fs2004MenuItem.setEnabled(true);
            fsxMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isS2_XPLANE()) {
            xplaneMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isS3_MODEL()) {
            // to be determined
        }
        if (LicChecker.getInstance().isS4_DOF3()) {
            // to be determined
        }
        if (LicChecker.getInstance().isS5_DOF6()) {
            // to be determined
        }
        // TODO add your handling code here:

        if (LicChecker.getInstance().isR1_REFLY()) {
            reflyAble = true;
        }
        if (LicChecker.getInstance().isR2_RECORD()) {
            recordable = true;
            recordMenuItem.setEnabled(true);
        }
        if (LicChecker.getInstance().isR3_PLAY()) {
            playMenuItem.setEnabled(true);
        }

        // for map 
        if (LicChecker.getInstance().isM1_SELFPORT()) {

        }
        if (LicChecker.getInstance().isM2_SELF2DMAP()) {

        }
        if (LicChecker.getInstance().isM3_SELF3DBUIL()) {

        }
        if (LicChecker.getInstance().isM4_COORMAP()) {

        }
        if (LicChecker.getInstance().isM5_MARK()) {

        }

        // aviation
        if (LicChecker.getInstance().isA1_PHYMATH()) {
        }
        if (LicChecker.getInstance().isA2_AIRDYN()) {

        }
        if (LicChecker.getInstance().isA3_FLYTRAIN()) {

        }
        if (LicChecker.getInstance().isA4_FLYQUAL()) {

        }
        if (LicChecker.getInstance().isA5_FLYCHK()) {

        }
        // defence

        if (LicChecker.getInstance().isD1_ENESHIP()) {

        }
        if (LicChecker.getInstance().isD2_AIRPIC()) {

        }
        // Area Data

        if (LicChecker.getInstance().isT1_TWN()) {

        }
        if (LicChecker.getInstance().isT2_NASIA()) {

        }
        if (LicChecker.getInstance().isT3_SASIA()) {

        }
        if (LicChecker.getInstance().isT4_PAC()) {

        }
        if (LicChecker.getInstance().isT5_USA()) {

        }

        // Airport Data
        if (LicChecker.getInstance().isU1_TWN()) {

        }
        if (LicChecker.getInstance().isU2_NASIA()) {

        }
        if (LicChecker.getInstance().isU3_SASIA()) {

        }
        if (LicChecker.getInstance().isU4_PAC()) {

        }
        if (LicChecker.getInstance().isU5_USA()) {

        }

        // AIDZ FIR
        if (LicChecker.getInstance().isV1_TWN()) {

        }
        if (LicChecker.getInstance().isV2_NASIA()) {

        }
        if (LicChecker.getInstance().isV3_SASIA()) {

        }
        if (LicChecker.getInstance().isV4_PAC()) {

        }
        if (LicChecker.getInstance().isV5_USA()) {

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

        jPanel6 = new javax.swing.JPanel();
        startRecordButton = new javax.swing.JButton();
        stopRecordButton = new javax.swing.JButton();
        dataFreqLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        secondLabel = new javax.swing.JLabel();
        dataFreqComboBox = new javax.swing.JComboBox<>();
        clearButton = new javax.swing.JButton();
        reflyButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        fileLabel = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        graphicMenu = new javax.swing.JMenu();
        data1MenuItem = new javax.swing.JMenuItem();
        data2MenuItem = new javax.swing.JMenuItem();
        pitchMenuItem = new javax.swing.JMenuItem();
        rollMenuItem = new javax.swing.JMenuItem();
        yawMenuItem = new javax.swing.JMenuItem();
        planeMenuItem = new javax.swing.JMenuItem();
        altMenuItem = new javax.swing.JMenuItem();
        threeDMenuItem = new javax.swing.JMenuItem();
        dataMenuItem = new javax.swing.JMenuItem();
        simulatorMeu = new javax.swing.JMenu();
        fsxMenuItem = new javax.swing.JMenuItem();
        fs2004MenuItem = new javax.swing.JMenuItem();
        fs2002MenuItem = new javax.swing.JMenuItem();
        xplaneMenuItem = new javax.swing.JMenuItem();
        toModelMenuItem = new javax.swing.JMenuItem();
        to3DofMenuItem = new javax.swing.JMenuItem();
        to6DofMenuItem = new javax.swing.JMenuItem();
        recordMenu = new javax.swing.JMenu();
        recordMenuItem = new javax.swing.JMenuItem();
        playMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        clearMenuItem = new javax.swing.JMenuItem();
        mapMenu = new javax.swing.JMenu();
        selfAirportMenuItem = new javax.swing.JMenuItem();
        self2DMapMenuItem = new javax.swing.JMenuItem();
        self3DBuildingMenuItem = new javax.swing.JMenuItem();
        coorMapMenuItem = new javax.swing.JMenuItem();
        markMenuItem = new javax.swing.JMenuItem();
        aviationMenu = new javax.swing.JMenu();
        phyMathMenuItem = new javax.swing.JMenuItem();
        airDynMenuItem = new javax.swing.JMenuItem();
        trainMenuItem = new javax.swing.JMenuItem();
        quilityMenuItem = new javax.swing.JMenuItem();
        safeCheckMenuItem = new javax.swing.JMenuItem();
        defenseMenu = new javax.swing.JMenu();
        antiShipMenuItem = new javax.swing.JMenuItem();
        airPicMenuItem = new javax.swing.JMenuItem();
        licenseMenu = new javax.swing.JMenu();
        idMenuItem = new javax.swing.JMenuItem();
        macMenuItem = new javax.swing.JMenuItem();
        buyMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startRecordButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        startRecordButton.setText("開始");
        startRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRecordButtonActionPerformed(evt);
            }
        });

        stopRecordButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        stopRecordButton.setText("停止");
        stopRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopRecordButtonActionPerformed(evt);
            }
        });

        dataFreqLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        dataFreqLabel.setText("資料頻率");
        dataFreqLabel.setToolTipText("");

        dataLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dataLabel.setText("資料紀錄");

        secondLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        secondLabel.setText("秒");

        dataFreqComboBox.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        dataFreqComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.1", "0.5", "1", "5" }));
        dataFreqComboBox.setSelectedIndex(3);

        clearButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        clearButton.setText("清除");

        reflyButton.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        reflyButton.setText("重飛");
        reflyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startRecordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopRecordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reflyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFreqLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFreqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondLabel)
                .addGap(8, 8, 8))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(startRecordButton)
                    .addComponent(stopRecordButton)
                    .addComponent(clearButton)
                    .addComponent(dataFreqLabel)
                    .addComponent(dataFreqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondLabel)
                    .addComponent(reflyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        userLabel.setText("授權用戶");

        userTextField.setEditable(false);
        userTextField.setBackground(new java.awt.Color(255, 255, 255));
        userTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N

        fileLabel.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N
        fileLabel.setText("檔案位置");

        fileTextField.setEditable(false);
        fileTextField.setFont(new java.awt.Font("新細明體", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fileLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel)
                        .addGap(18, 18, 18)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileLabel)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        graphicMenu.setText("Graphic");
        graphicMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        data1MenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        data1MenuItem.setText("飛航資訊LLA");
        data1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data1MenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(data1MenuItem);

        data2MenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        data2MenuItem.setText("飛行操控Ctrl");
        data2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data2MenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(data2MenuItem);

        pitchMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        pitchMenuItem.setText("俯仰圖Pitch");
        pitchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pitchMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(pitchMenuItem);

        rollMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        rollMenuItem.setText("滾轉圖Roll");
        rollMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(rollMenuItem);

        yawMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        yawMenuItem.setText("方向圖Yaw");
        yawMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yawMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(yawMenuItem);

        planeMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        planeMenuItem.setText("平面圖2D");
        planeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(planeMenuItem);

        altMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        altMenuItem.setText("高度圖Alt");
        altMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(altMenuItem);

        threeDMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        threeDMenuItem.setText("立體圖3D");
        threeDMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeDMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(threeDMenuItem);

        dataMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        dataMenuItem.setText("Data 資料圖");
        dataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(dataMenuItem);

        jMenuBar1.add(graphicMenu);

        simulatorMeu.setText("Simulator");
        simulatorMeu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        fsxMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        fsxMenuItem.setText("FSX");
        fsxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fsxMenuItemActionPerformed(evt);
            }
        });
        simulatorMeu.add(fsxMenuItem);

        fs2004MenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        fs2004MenuItem.setText("FS2004");
        fs2004MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs2004MenuItemActionPerformed(evt);
            }
        });
        simulatorMeu.add(fs2004MenuItem);

        fs2002MenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        fs2002MenuItem.setText("FS2002");
        fs2002MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs2002MenuItemActionPerformed(evt);
            }
        });
        simulatorMeu.add(fs2002MenuItem);

        xplaneMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        xplaneMenuItem.setText("XPlane");
        xplaneMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xplaneMenuItemActionPerformed(evt);
            }
        });
        simulatorMeu.add(xplaneMenuItem);

        toModelMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        toModelMenuItem.setText("To Model");
        toModelMenuItem.setEnabled(false);
        simulatorMeu.add(toModelMenuItem);

        to3DofMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        to3DofMenuItem.setText("To 3-DOF");
        to3DofMenuItem.setEnabled(false);
        simulatorMeu.add(to3DofMenuItem);

        to6DofMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        to6DofMenuItem.setText("To 6-DOF");
        to6DofMenuItem.setEnabled(false);
        simulatorMeu.add(to6DofMenuItem);

        jMenuBar1.add(simulatorMeu);

        recordMenu.setText("Record");
        recordMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        recordMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        recordMenuItem.setText("紀錄REC");
        recordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordMenuItemActionPerformed(evt);
            }
        });
        recordMenu.add(recordMenuItem);

        playMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        playMenuItem.setText("播放Play");
        playMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playMenuItemActionPerformed(evt);
            }
        });
        recordMenu.add(playMenuItem);
        recordMenu.add(jSeparator1);

        clearMenuItem.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        clearMenuItem.setText("清除位置Clr");
        clearMenuItem.setToolTipText("");
        clearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMenuItemActionPerformed(evt);
            }
        });
        recordMenu.add(clearMenuItem);

        jMenuBar1.add(recordMenu);

        mapMenu.setText("Map");
        mapMenu.setEnabled(false);
        mapMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        selfAirportMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        selfAirportMenuItem.setText("自建跑道");
        mapMenu.add(selfAirportMenuItem);

        self2DMapMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        self2DMapMenuItem.setText("自建2D地圖");
        mapMenu.add(self2DMapMenuItem);

        self3DBuildingMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        self3DBuildingMenuItem.setText("自建3D建物");
        mapMenu.add(self3DBuildingMenuItem);

        coorMapMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        coorMapMenuItem.setText("座標化地圖");
        mapMenu.add(coorMapMenuItem);

        markMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        markMenuItem.setText("標示");
        mapMenu.add(markMenuItem);

        jMenuBar1.add(mapMenu);

        aviationMenu.setText("Aviation");
        aviationMenu.setEnabled(false);
        aviationMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        phyMathMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        phyMathMenuItem.setText("航空物理數學");
        aviationMenu.add(phyMathMenuItem);

        airDynMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        airDynMenuItem.setText("飛機空氣動力");
        aviationMenu.add(airDynMenuItem);

        trainMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        trainMenuItem.setText("飛行訓練科目");
        aviationMenu.add(trainMenuItem);

        quilityMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        quilityMenuItem.setText("飛航品保查核");
        aviationMenu.add(quilityMenuItem);

        safeCheckMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        safeCheckMenuItem.setText("飛安事故調查");
        aviationMenu.add(safeCheckMenuItem);

        jMenuBar1.add(aviationMenu);

        defenseMenu.setText("Defense");
        defenseMenu.setEnabled(false);
        defenseMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        antiShipMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        antiShipMenuItem.setText("反艦攔截");
        defenseMenu.add(antiShipMenuItem);

        airPicMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        airPicMenuItem.setText("空中偵照");
        defenseMenu.add(airPicMenuItem);

        jMenuBar1.add(defenseMenu);

        licenseMenu.setText("License");
        licenseMenu.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        idMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        idMenuItem.setText("User Info");
        idMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idMenuItemActionPerformed(evt);
            }
        });
        licenseMenu.add(idMenuItem);

        macMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        macMenuItem.setText("Host ID");
        macMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macMenuItemActionPerformed(evt);
            }
        });
        licenseMenu.add(macMenuItem);

        buyMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        buyMenuItem.setText("購買 g-Fight");
        buyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyMenuItemActionPerformed(evt);
            }
        });
        licenseMenu.add(buyMenuItem);

        aboutMenuItem.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        aboutMenuItem.setText("關於 g-Fight");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        licenseMenu.add(aboutMenuItem);

        jMenuBar1.add(licenseMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRecordButtonActionPerformed
        // TODO add your handling code here:
        String fN = this.fileTextField.getText();
        int select = this.dataFreqComboBox.getSelectedIndex();
        switch (select) {
            case 0:
                recordPeriod = 0.1;
                break;
            case 1:
                recordPeriod = 0.5;
                break;
            case 2:
                recordPeriod = 1;
                break;
            case 3:
                recordPeriod = 5;
                break;
            default:
                recordPeriod = 5;
        }
        if (fN.equals("")) {
            recordPeriod = 0.1;
            fN = "C:/temp/temp_hasco.csv";
            if (!reflyAble) {
                return;
            }
        }
        this.dataGetter.startRecord(fN, recordPeriod);
        stopRecordButton.setEnabled(true);
        this.clearButton.setEnabled(false);
        startRecordButton.setEnabled(false);
        this.recordMenuItem.setEnabled(false);
        this.reflyButton.setEnabled(false);
    }//GEN-LAST:event_startRecordButtonActionPerformed

    private void stopRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopRecordButtonActionPerformed
        // TODO add your handling code here:
        dataGetter.stopRecord();
        stopRecordButton.setEnabled(false);
        startRecordButton.setEnabled(true);
        this.clearButton.setEnabled(true);
        if (this.recordable) {
            this.recordMenuItem.setEnabled(true);
        }
        if (this.fileTextField.getText().equals("") && reflyAble) {
            this.reflyButton.setEnabled(true);
        }
    }//GEN-LAST:event_stopRecordButtonActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        Debugger.log("about");
        JOptionPane.showMessageDialog(null, LocaleManager.getInstance().getString("credit"), "關於", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void macMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macMenuItemActionPerformed
        // TODO add your handling code here:
        String mac = MacAddress.getIpMacAddress();
        JOptionPane.showMessageDialog(null, mac, "Host ID", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_macMenuItemActionPerformed

    private void buyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyMenuItemActionPerformed
        // TODO add your handling code here:
        Debugger.log("about");
        JOptionPane.showMessageDialog(null, LocaleManager.getInstance().getString("licenseFileError"), "購買", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buyMenuItemActionPerformed

    private void idMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idMenuItemActionPerformed
        // TODO add your handling code here:
        this.licFrame.setVisible(true);
        Debugger.log("about");
        // JOptionPane.showMessageDialog(null, user, "使用者 ID", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_idMenuItemActionPerformed

    private void planeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeMenuItemActionPerformed
        // TODO add your handling code here:
        plotTraceFrame.setVisible(true);
    }//GEN-LAST:event_planeMenuItemActionPerformed

    private void data2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data2MenuItemActionPerformed
        // TODO add your handling code here:
        data2Frame.setVisible(true);
    }//GEN-LAST:event_data2MenuItemActionPerformed

    private void pitchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pitchMenuItemActionPerformed
        // TODO add your handling code here:
        this.plotThetaFrame.setVisible(true);
    }//GEN-LAST:event_pitchMenuItemActionPerformed

    private void rollMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollMenuItemActionPerformed
        // TODO add your handling code here:
        this.plotFrontFrame.setVisible(true);
    }//GEN-LAST:event_rollMenuItemActionPerformed

    private void yawMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yawMenuItemActionPerformed
        // TODO add your handling code here:
        this.plotTopFrame.setVisible(true);
    }//GEN-LAST:event_yawMenuItemActionPerformed

    private void altMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altMenuItemActionPerformed
        // TODO add your handling code here:
        this.plotAltitudeFrame.setVisible(true);
    }//GEN-LAST:event_altMenuItemActionPerformed

    private void recordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser c = new JFileChooser();
        c.setCurrentDirectory(new File("C:"));
        FileFilter filter = new FileNameExtensionFilter("csv file", new String[]{"csv"});
        c.setFileFilter(filter);
        int rVal = c.showOpenDialog(OldGFlightFrame.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            String str = c.getSelectedFile().getName();
            int i = str.lastIndexOf(".csv");
            String fileName;
            if (i == -1) {
                fileName = c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName() + ".csv";
            } else {
                fileName = c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName();
            }
            fileTextField.setText(fileName);
        }
    }//GEN-LAST:event_recordMenuItemActionPerformed

    private void fsxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsxMenuItemActionPerformed
        // TODO add your handling code here:
        fsActionPerformed(evt);
    }//GEN-LAST:event_fsxMenuItemActionPerformed

    private void fs2004MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs2004MenuItemActionPerformed
        // TODO add your handling code here:
        fsActionPerformed(evt);
    }//GEN-LAST:event_fs2004MenuItemActionPerformed

    private void fs2002MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs2002MenuItemActionPerformed
        // TODO add your handling code here:
        fsActionPerformed(evt);
    }//GEN-LAST:event_fs2002MenuItemActionPerformed

    private void playMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playMenuItemActionPerformed
        // TODO add your handling code here:
        this.stopDataGetter();

        JFileChooser c = new JFileChooser();
        c.setCurrentDirectory(new File("C:"));
        FileFilter filter = new FileNameExtensionFilter("csv file", new String[]{"csv"});
        c.setFileFilter(filter);
        int rVal = c.showOpenDialog(OldGFlightFrame.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            try {
                String fileName = c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName();
                this.fileTextField.setText(fileName);
                dataGetter = new DataGetter(fileName, PlaneType.AIRCRAFT);
                this.setDataGetter();
                startRecordButton.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(OldGFlightFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_playMenuItemActionPerformed

    private void xplaneMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xplaneMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            stopDataGetter();
            dataGetter = new DataGetter(PlaneType.AIRCRAFT, "xplane");
            this.setDataGetter();
        } catch (IOException ex) {
            Logger.getLogger(OldGFlightFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xplaneMenuItemActionPerformed

    private void clearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMenuItemActionPerformed
        // TODO add your handling code here:
        this.fileTextField.setText("");
    }//GEN-LAST:event_clearMenuItemActionPerformed

    private void reflyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflyButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.stopDataGetter();

        try {
            String fileName = "C:/temp/temp_hasco.csv";
            // this.fileTextField.setText(fileName);
            dataGetter = new DataGetter(fileName, PlaneType.AIRCRAFT);
            this.setDataGetter();
            startRecordButton.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(OldGFlightFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        reflyButton.setEnabled(true);
    }//GEN-LAST:event_reflyButtonActionPerformed

    private void threeDMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeDMenuItemActionPerformed
        // TODO add your handling code here:
        threeDFrame.setVisible(true);
    }//GEN-LAST:event_threeDMenuItemActionPerformed

    private void data1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data1MenuItemActionPerformed
        // TODO add your handling code here:
        llaFrame.setVisible(true);
    }//GEN-LAST:event_data1MenuItemActionPerformed

    private void dataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataMenuItemActionPerformed
        // TODO add your handling code here:
        data1Frame.setVisible(true);
    }//GEN-LAST:event_dataMenuItemActionPerformed
    public void fsActionPerformed(ActionEvent e) {
        stopDataGetter();
        try {
            dataGetter = new DataGetter(PlaneType.AIRCRAFT, "fs");
            this.setDataGetter();
        } catch (IOException ex) {
            Logger.getLogger(OldGFlightFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void stopDataGetter() {
        if (dataGetter != null) {
            dataGetter.stopRun();
            plotAltitudeFrame.clearData();
            plotTraceFrame.clearData();
            threeDFrame.clearData();
            data1Frame.clearData();
            udpClient = null;
            if (udpServer != null) {
                udpServer.stop(true);
                udpServer = null;
            }
            
        }
        reflyButton.setEnabled(false);
        dataGetter = null;
    }

    private void setDataGetter() {
        // dataGetter.addObserver(DataFrame.this);
        dataGetter.addObserver(llaFrame);
        dataGetter.addObserver(data2Frame);
        dataGetter.addObserver(plotThetaFrame);
        dataGetter.addObserver(plotFrontFrame);
        dataGetter.addObserver(plotTopFrame);
        dataGetter.addObserver(plotTraceFrame);
        dataGetter.addObserver(threeDFrame);
        dataGetter.addObserver(data1Frame);
        dataGetter.addObserver(plotAltitudeFrame);
        if (udpClient != null) dataGetter.addObserver(udpClient);
        if (udpServer != null) {
            // need to add observer for udpServer
        }
        
        if (recordable) {
            this.recordMenuItem.setEnabled(true);
            startRecordButton.setEnabled(true);
            stopRecordButton.setEnabled(false);
            clearButton.setEnabled(false);
        }
        
        executor.execute(dataGetter);
        
    }

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
            java.util.logging.Logger.getLogger(OldGFlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OldGFlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OldGFlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OldGFlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        OldGFlightFrame dataFrame = new OldGFlightFrame();
        java.awt.EventQueue.invokeLater(() -> {
            dataFrame.setVisible(true);
        });
        // ExecutorService executor = Executors.newCachedThreadPool();
        // executor.submit(dataGetter);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem airDynMenuItem;
    private javax.swing.JMenuItem airPicMenuItem;
    private javax.swing.JMenuItem altMenuItem;
    private javax.swing.JMenuItem antiShipMenuItem;
    private javax.swing.JMenu aviationMenu;
    private javax.swing.JMenuItem buyMenuItem;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenuItem clearMenuItem;
    private javax.swing.JMenuItem coorMapMenuItem;
    private javax.swing.JMenuItem data1MenuItem;
    private javax.swing.JMenuItem data2MenuItem;
    private javax.swing.JComboBox<String> dataFreqComboBox;
    private javax.swing.JLabel dataFreqLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JMenuItem dataMenuItem;
    private javax.swing.JMenu defenseMenu;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JMenuItem fs2002MenuItem;
    private javax.swing.JMenuItem fs2004MenuItem;
    private javax.swing.JMenuItem fsxMenuItem;
    private javax.swing.JMenu graphicMenu;
    private javax.swing.JMenuItem idMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu licenseMenu;
    private javax.swing.JMenuItem macMenuItem;
    private javax.swing.JMenu mapMenu;
    private javax.swing.JMenuItem markMenuItem;
    private javax.swing.JMenuItem phyMathMenuItem;
    private javax.swing.JMenuItem pitchMenuItem;
    private javax.swing.JMenuItem planeMenuItem;
    private javax.swing.JMenuItem playMenuItem;
    private javax.swing.JMenuItem quilityMenuItem;
    private javax.swing.JMenu recordMenu;
    private javax.swing.JMenuItem recordMenuItem;
    private javax.swing.JButton reflyButton;
    private javax.swing.JMenuItem rollMenuItem;
    private javax.swing.JMenuItem safeCheckMenuItem;
    private javax.swing.JLabel secondLabel;
    private javax.swing.JMenuItem self2DMapMenuItem;
    private javax.swing.JMenuItem self3DBuildingMenuItem;
    private javax.swing.JMenuItem selfAirportMenuItem;
    private javax.swing.JMenu simulatorMeu;
    private javax.swing.JButton startRecordButton;
    private javax.swing.JButton stopRecordButton;
    private javax.swing.JMenuItem threeDMenuItem;
    private javax.swing.JMenuItem to3DofMenuItem;
    private javax.swing.JMenuItem to6DofMenuItem;
    private javax.swing.JMenuItem toModelMenuItem;
    private javax.swing.JMenuItem trainMenuItem;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    private javax.swing.JMenuItem xplaneMenuItem;
    private javax.swing.JMenuItem yawMenuItem;
    // End of variables declaration//GEN-END:variables

}

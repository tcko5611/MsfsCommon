/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import tw.com.hasco.MSFS.locale.LocaleManager;

/**
 * license check class, decerypt the license file and get license results
 *
 * @author DELL
 */
public class LicChecker {

    static private LicChecker instance = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    // for license check
    // graphic
    int lic_g;
    static final int G1_LLA = 1;
    static final int G2_CTRL = 2;
    static final int G3_PITCH = 4;
    static final int G4_ROLL = 8;
    static final int G5_YAW = 16;
    static final int G6_PLANE = 32;
    static final int G7_ALT = 64;
    static final int G8_THREED = 128;
    static final int G9_PLOT6 = 256;

    // simulator
    int lic_s;
    static final int S1_FSX = 1;
    static final int S2_XPLANE = 2;
    static final int S3_MODEL = 4;
    static final int S4_DOF3 = 8;
    static final int S5_DOF6 = 16;

    // record
    int lic_r;
    static final int R1_REFLY = 1;
    static final int R2_RECORD = 2;
    static final int R3_PLAY = 4;
    // map
    int lic_m;
    static final int M1_SELFPORT = 1;
    static final int M2_SELF2DMAP = 2;
    static final int M3_SELF3DBUIL = 4;
    static final int M4_COORMAP = 8;
    static final int M5_MARK = 16;
    // aviation
    int lic_a;
    static final int A1_PHYMATH = 1;
    static final int A2_AIRDYN = 2;
    static final int A3_FLYTRAIN = 4;
    static final int A4_FLYQUAL = 8;
    static final int A5_FLYCHK = 16;
    // defence
    int lic_d;
    static final int D1_ENESHIP = 1;
    static final int D2_AIRPIC = 2;
    // area data
    int lic_t;
    static final int T1_TWN = 1;
    static final int T2_NASIA = 2;
    static final int T3_SASIA = 4;
    static final int T4_PAC = 8;
    static final int T5_USA = 16;
    // airport data
    int lic_u;
    static final int U1_TWN = 1;
    static final int U2_NASIA = 2;
    static final int U3_SASIA = 4;
    static final int U4_PAC = 8;
    static final int U5_USA = 16;
    // AIDZ FIR
    int lic_v;
    static final int V1_TWN = 1;
    static final int V2_NASIA = 2;
    static final int V3_SASIA = 4;
    static final int V4_PAC = 8;
    static final int V5_USA = 16;

    // language
    int lic_lang;
    static final int L1_TW = 1;
    static final int L2_CN = 2;

    // end of license file
    // informations
    String licStr;
    String user;
    String purchaseDate;
    String expireDate;
    String macNum;

    /**
     * sigleton class for set constructor for private
     */
    private LicChecker() {
        lic_g = 0;
        lic_s = 0;
        lic_r = 0;
        lic_m = 0;
        lic_a = 0;
        lic_d = 0;
        lic_t = 0;
        lic_u = 0;
        lic_v = 0;
        lic_lang = 0;
        checkLic();
    }

    /**
     * sigleton instance function, parse the license file
     *
     * @return the sigleton
     */
    public static LicChecker getInstance() {
        if (instance == null) {
            instance = new LicChecker();
        }
        return instance;
    }

    /**
     * get user name
     *
     * @return user name
     */
    public String getUser() {
        return user;
    }

    /**
     * get purchase date
     *
     * @return purcahse date
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * get expire date
     *
     * @return expire date
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * get mac num
     *
     * @return mac num
     */
    public String getMacNum() {
        return macNum;
    }

    /**
     * parse the license file and encrypt it, get all information
     */
    private void checkLic() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("license.txt"));
            String str = in.readLine();
            if (str == null) {
                return;
            }
            str = Decryptor.decrypt(str);
            String[] strs = str.split(":");
            if (strs.length != 15) {
                JOptionPane.showMessageDialog(null, LocaleManager.getInstance("Taiwan").getString("licenseFileError"),
                        "license file error", JOptionPane.INFORMATION_MESSAGE);
            }
            if (strs[2].substring(0, 4).equals("9999")) {
                licStr = strs[0] + " " + strs[1] + " Licensed ";
            } else {
                licStr = strs[0] + " " + strs[1] + " Licensed to " + strs[2];
            }
            user = strs[0];
            purchaseDate = strs[1];
            expireDate = strs[2];
            macNum = strs[3];

            Date currentDate = new Date();
            Date lastDate = this.dateFormat.parse(strs[14]);
            if (lastDate.after(currentDate)) {
                Debugger.log("Date is not correct in your machine");
                JOptionPane.showMessageDialog(null, "Date is not correct in your machine", "License", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date expireDate1 = dateFormat.parse(strs[2]);
            if (currentDate.after(expireDate1)) {
                Debugger.log("License expired");
                JOptionPane.showMessageDialog(null, "License Expired", "License", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String macAddress = strs[3];
            Debugger.log(macAddress);
            if (MacAddress.checkMacAddressInMachine(macAddress)) {
                lic_g = Integer.parseInt(strs[4]);
                lic_s = Integer.parseInt(strs[5]);
                lic_r = Integer.parseInt(strs[6]);
                lic_m = Integer.parseInt(strs[7]);
                lic_a = Integer.parseInt(strs[8]);
                lic_d = Integer.parseInt(strs[9]);
                lic_t = Integer.parseInt(strs[10]);
                lic_u = Integer.parseInt(strs[11]);
                lic_v = Integer.parseInt(strs[12]);
                lic_lang = Integer.parseInt(strs[13]);
                Debugger.log(lic_g);

                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("license.txt")));
                str = strs[0] + ":" + strs[1] + ":" + strs[2] + ":" + strs[3]
                        + ":" + strs[4] + ":" + strs[5] + ":" + strs[6] + ":"
                        + strs[7] + ":" + strs[8] + ":" + strs[9] + ":"
                        + strs[10] + ":" + strs[11] + ":" + strs[12] + ":" + strs[13] + ":"
                        + dateFormat.format(currentDate);
                out.println(Decryptor.encrypt(str));
                Debugger.log("out:" + str);
                out.close();
            } else {
                Debugger.log("license file error");
                JOptionPane.showMessageDialog(null, "License File Error", "License", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException | IOException | NumberFormatException | ParseException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, LocaleManager.getInstance("Taiwan").getString("licenseFileError"), "license file error", JOptionPane.INFORMATION_MESSAGE);
        } finally {
        }
    }

    /**
     * get LLA enable status
     *
     * @return LLA
     */
    public boolean isG1_LLA() {
        return ((lic_g & G1_LLA) != 0);
    }

    /**
     * get CTRL enable status
     *
     * @return CTRL
     */
    public boolean isG2_CTRL() {
        return ((lic_g & G2_CTRL) != 0);
    }

    /**
     * get PITCH enable status
     *
     * @return PITCH
     */
    public boolean isG3_PITCH() {
        return ((lic_g & G3_PITCH) != 0);
    }

    /**
     * get ROLL enable status
     *
     * @return ROLL
     */
    public boolean isG4_ROLL() {
        return ((lic_g & G4_ROLL) != 0);
    }

    /**
     * get YAW enable status
     *
     * @return YAW
     */
    public boolean isG5_YAW() {
        return ((lic_g & G5_YAW) != 0);
    }

    /**
     * get PLANE enable status
     *
     * @return PLANE
     */
    public boolean isG6_PLANE() {
        return ((lic_g & G6_PLANE) != 0);
    }

    /**
     * get ALT enable status
     *
     * @return ALT
     */
    public boolean isG7_ALT() {
        return ((lic_g & G7_ALT) != 0);
    }

    /**
     * get THREED enable status
     *
     * @return THREED
     */
    public boolean isG8_THREED() {
        return ((lic_g & G8_THREED) != 0);
    }

    /**
     * get PLOT6 enable status
     *
     * @return PLOT6
     */
    public boolean isG9_PLOT6() {
        return ((lic_g & G9_PLOT6) != 0);
    }
    // Simulator

    /**
     * get FSX enable status
     *
     * @return FSX
     */
    public boolean isS1_FSX() {
        return ((lic_s & S1_FSX) != 0);
    }

    /**
     * get XPLANE enable status
     *
     * @return XPLANE
     */
    public boolean isS2_XPLANE() {
        return ((lic_s & S2_XPLANE) != 0);
    }

    /**
     * get MODEL enable status
     *
     * @return MODEL
     */
    public boolean isS3_MODEL() {
        return ((lic_s & S3_MODEL) != 0);
    }

    /**
     * get DOF3 enable status
     *
     * @return DOF3
     */
    public boolean isS4_DOF3() {
        return ((lic_s & S4_DOF3) != 0);
    }

    /**
     * get DOF6 enable status
     *
     * @return DOF6
     */
    public boolean isS5_DOF6() {
        return ((lic_s & S5_DOF6) != 0);
    }

    /**
     * get REFLY enable status
     *
     * @return REFLY
     */
    public boolean isR1_REFLY() {
        return ((lic_r & R1_REFLY) != 0);
    }

    /**
     * get RECORD enable status
     *
     * @return RECORD
     */
    public boolean isR2_RECORD() {
        return ((lic_r & R2_RECORD) != 0);
    }

    /**
     * get PLAY enable status
     *
     * @return PLAY
     */
    public boolean isR3_PLAY() {
        return ((lic_r & R3_PLAY) != 0);
    }

    /**
     * get SELFPORT enable status
     *
     * @return SELFPORT
     */
    public boolean isM1_SELFPORT() {
        return ((lic_m & M1_SELFPORT) != 0);
    }

    /**
     * get SELF2DMAP enable status
     *
     * @return SELF2DMAP
     */
    public boolean isM2_SELF2DMAP() {
        return ((lic_m & M2_SELF2DMAP) != 0);
    }

    /**
     * get SELF3DBUIL enable status
     *
     * @return SELF3DBUIL
     */
    public boolean isM3_SELF3DBUIL() {
        return ((lic_m & M3_SELF3DBUIL) != 0);
    }

    /**
     * get COORMAP enable status
     *
     * @return COORMAP
     */
    public boolean isM4_COORMAP() {
        return ((lic_m & M4_COORMAP) != 0);
    }

    /**
     * get MARK enable status
     *
     * @return MARK
     */
    public boolean isM5_MARK() {
        return ((lic_m & M5_MARK) != 0);
    }

    /**
     * get PHYMATH enable status
     *
     * @return PHYMATH
     */
    public boolean isA1_PHYMATH() {
        return ((lic_a & A1_PHYMATH) != 0);
    }

    /**
     * get AIRDYN enable status
     *
     * @return AIRDYN
     */
    public boolean isA2_AIRDYN() {
        return ((lic_a & A2_AIRDYN) != 0);
    }

    /**
     * get FLYTRAIN enable status
     *
     * @return FLYTRAIN
     */
    public boolean isA3_FLYTRAIN() {
        return ((lic_a & A3_FLYTRAIN) != 0);
    }

    /**
     * get FLYQUAL enable status
     *
     * @return FLYQUAL
     */
    public boolean isA4_FLYQUAL() {
        return ((lic_a & A4_FLYQUAL) != 0);
    }

    /**
     * get FLYCHK enable status
     *
     * @return FLYCHK
     */
    public boolean isA5_FLYCHK() {
        return ((lic_a & A5_FLYCHK) != 0);
    }

    /**
     * get ENESHIP enable status
     *
     * @return ENESHIP
     */
    public boolean isD1_ENESHIP() {
        return ((lic_d & D1_ENESHIP) != 0);
    }

    /**
     * get AIRPIC enable status
     *
     * @return AIRPIC
     */
    public boolean isD2_AIRPIC() {
        return ((lic_d & D2_AIRPIC) != 0);
    }

    /**
     * get TWN enable status
     *
     * @return TWN
     */
    public boolean isT1_TWN() {
        return ((lic_t & T1_TWN) != 0);
    }

    /**
     * get NASIA enable status
     *
     * @return NASIA
     */
    public boolean isT2_NASIA() {
        return ((lic_t & T2_NASIA) != 0);
    }

    /**
     * get SASIA enable status
     *
     * @return SASIA
     */
    public boolean isT3_SASIA() {
        return ((lic_t & T3_SASIA) != 0);
    }

    /**
     * get PAC enable status
     *
     * @return PAC
     */
    public boolean isT4_PAC() {
        return ((lic_t & T4_PAC) != 0);
    }

    /**
     * get USA enable status
     *
     * @return USA
     */
    public boolean isT5_USA() {
        return ((lic_t & T5_USA) != 0);
    }

    // Airport Data
    public boolean isU1_TWN() {
        return ((lic_u & U1_TWN) != 0);
    }

    public boolean isU2_NASIA() {
        return ((lic_u & U2_NASIA) != 0);
    }

    public boolean isU3_SASIA() {
        return ((lic_u & U3_SASIA) != 0);
    }

    public boolean isU4_PAC() {
        return ((lic_u & U4_PAC) != 0);
    }

    public boolean isU5_USA() {
        return ((lic_u & U5_USA) != 0);
    }

    // AIDZ FIR
    public boolean isV1_TWN() {
        return ((lic_v & V1_TWN) != 0);
    }

    public boolean isV2_NASIA() {
        return ((lic_v & V2_NASIA) != 0);
    }

    public boolean isV3_SASIA() {
        return ((lic_v & V3_SASIA) != 0);
    }

    public boolean isV4_PAC() {
        return ((lic_v & V4_PAC) != 0);
    }

    public boolean isV5_USA() {
        return ((lic_v & V5_USA) != 0);
    }

    public int getLang() {
        return lic_lang;
    }

    public int getLangTw() {
        return L1_TW;
    }

    public int getLangCn() {
        return L2_CN;
    }

    public String getLicInfo() {
        return licStr;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.FS;
import java.io.IOException;
import fsuipc.FSUIPC;
import tw.com.hasco.MSFS.model.PlaneType;

/**
 * FS simulator
 * @author DELL
 */
public class FSFs extends FSBasic {

    /**
     * constructor
     * @param planeType : plane or helicopter
     */
    public FSFs(PlaneType planeType) {
        super(planeType);
        FSUIPC.init();
    }
    @Override
    public void setStop(boolean b) {
        stop = b;
        if (stop) {
          FSUIPC.close();
        }
    }
    @Override
    public void update() throws IOException {
        FSUIPC.refreshMSFSData();
        this.setYear();
        this.setDay();
        this.setHour();
        this.setMin();
        this.setSec();
        this.setType();
        this.setPitch();
        this.setBank();
        this.setHeading();
        this.setAoa();
        this.setBeta();
        this.setMagneticHeading();
        this.setThrottleLevel();
        this.setMixtureLevel();
        this.setPropLevel();
        this.setPropRPM();
        this.setEngineRPM();
        this.setTorque();
        this.setHelicopterEngineRPM();
        this.setManifold();
        this.setNavigateFrequency();
        this.setNavigateID();
        this.setNavigateName();
        this.setLocalizerDev();
        this.setGlideslopeDev();
        this.setDme();
        this.setLatitude();
        this.setLongitude();
        this.setAltitude();
        this.setGroudAltitude();
        this.setIndicatedAirSpeed();
        this.setTrueAirSpeed();;
        this.setGroundSpeed();
        this.setVerticalSpeed();
        this.setWindSpeed();
        this.setwindDirection();
        this.setMachSpeed();
        this.setGForce();
        this.setElevatorControl();
        this.setElevatorDeflection();
        this.setElevatorTrimControl();
        this.setAileronControl();
        this.setAileronDeflection();
        this.setAileronTrimControl();
        this.setAileronTrimDeflection();
        this.setRudderControl();
        this.setRudderDeflection();
        this.setRudderTrimControl();
        this.setGearControl();
        this.setGearPosition();
        this.setFlapsControl();
        this.setFlapsDeflection();
        flyAltitude = altitude - groundAltitude;
    }

    // Inner function for get value from FSUIPC
    private void setType() {
        String result = FSUIPC.getString(0x3D00, 256);
        type = result.substring(0, result.indexOf('\0'));
    }

    private void setPitch() {
        pitch = FSUIPC.getInt(0x0578);
        pitch = pitch * -360.0 / (65536.0 * 65536.0);
        //return getDouble(0x2F70);
    }

    /**
     * 取得滾轉角（Bank）。 Note: 可使用 0x2F78。
     *
     * @return 傳回滾轉角。
     */
    private void setBank() {
        bank = FSUIPC.getInt(0x057C);
        bank = bank * -360.0 / (65536.0 * 65536.0);
        //return getDouble(0x2F78);
    }

    /**
     * 取得方位角（Heading）。
     *
     * @return 傳回方位角。
     */
    private void setHeading() {
        heading = FSUIPC.getInt(0x0580);
        heading = heading * 360.0 / (65536.0 * 65536.0);
        if (heading < 0) {
            heading += 360;
        }

    }

    /**
     * 取得攻角（Angle of Attack）。
     *
     * @return 傳回攻角。
     */
    private void setAoa() {
        aoa = FSUIPC.getDouble(0x2ED0);
        if (aoa == Double.NaN) {
            aoa = 0.0;
        }
        aoa = aoa * 57.29583;
    }

    /**
     * 取得測滑角（Incidence Beta）。
     *
     * @return 傳回測滑角。
     */
    private void setBeta() {
        beta = FSUIPC.getDouble(0x2ED8);
        beta = beta * 57.29583;
    }

    /**
     * 取得磁方角（Magnetic Heading）。
     *
     * @return 傳回磁方角。
     */
    private void setMagneticHeading() {
        double heading1 = FSUIPC.getInt(0x0580);
        double heading2 = FSUIPC.getShort(0x02A0);
        magneticHeading = (heading1 * 360.0 / (65536.0 * 65536.0)) - (heading2 * 360.0 / 65536.0);
        if (magneticHeading < 0) {
            magneticHeading += 360;
        }
    }

    /**
     * 取得升降舵桿位（Elevator Control）。
     *
     * @return 回傳升降舵桿位。
     */
    private void setElevatorControl() {
        this.elevatorControl = (int) (FSUIPC.getShort(0x0BB2) / 16384.0 * 100.0);
    }

    /**
     * 取得升降舵位置（Elevator Deflection）。
     *
     * @return 回傳升降舵位置。
     */
    private void setElevatorDeflection() {
        this.elevatorDeflection = (int) (FSUIPC.getDouble(0x2E98) * 57.29583);
    }

    /**
     * 取得升降舵配平（Elevator Trim Control）。
     *
     * @return 回傳升降舵配平。
     */
    private void setElevatorTrimControl() {
        this.elevatorTrimControl = FSUIPC.getDouble(0x2EA0) * 57.29583;
    }

    /**
     * 取得副翼桿位（Aileron Control）。
     *
     */
    public void setAileronControl() {
        this.aileronControl = (int) (FSUIPC.getShort(0x0BB6) / 16383.0 * 100);
    }

    /**
     * 取得副翼位置（Aileron Deflection）。
     *
     * @return 回傳副翼位置。
     */
    private void setAileronDeflection() {
        this.aileronDeflection = (int) (FSUIPC.getDouble(0x2EA8) * 57.29583);
    }

    /**
     * 取得副翼配平桿位（Aileron Trim Control）。
     *
     * @return 回傳副翼配平桿位。
     */
    private void setAileronTrimControl() {
        this.aileronTrimControl = FSUIPC.getDouble(0x2EB0) * 57.29583;
    }

    /**
     * 取得方向舵桿位（Rudder Control）。
     *
     * @return 回傳方向舵桿位。
     */
    private void setRudderControl() {
        this.rudderControl = (int) (FSUIPC.getShort(0x0BBA) / 16383.0 * 100.0);
    }

    /**
     * 取得方向舵位置（Rudder Deflection）。
     *
     * @return 回傳方向舵位置。
     */
    private void setRudderDeflection() {
        this.rudderDeflection = (int) (FSUIPC.getDouble(0x2EB8) * 57.29583);
    }

    /**
     * 取得方向舵配平位置（Rudder Trim Control）。
     *
     * @return 回傳方向舵配平。
     */
    private void setRudderTrimControl() {
        this.rudderTrimControl = FSUIPC.getDouble(0x2EC0) * 57.29583;
    }

    /**
     * 取得副翼配平位置（Aileron Trim Deflection）。
     *
     * @return 回傳副翼配平桿位。
     */
    private void setAileronTrimDeflection() {
        this.aileronTrimDeflection = (int) (FSUIPC.getDouble(0x2EB0) / 57.29583);
    }

    /**
     * 取得起落架桿位（Gear Control）。
     *
     * @return 傳回起落架桿位。
     */
    private void setGearControl() {
        int val = FSUIPC.getInt(0x0BE8);
        this.gearControl = (val == 0) ? "up" : "down";
    }

    /**
     * 取得起落架位置（Gear position）。
     *
     * @return 傳回起落架位置。
     */
    private void setGearPosition() {
        int val = FSUIPC.getInt(0x0BF0);
        this.gearPosition = (val == 0) ? "up" : "down";
    }

    /**
     * 取得襟翼桿位（Flaps Control）。
     *
     * @return 傳回襟翼桿位。
     */
    private void setFlapsControl() {
        this.flapsControl = (int) (FSUIPC.getInt(0x0BDC) / 16383.0 * 100.0);
    }

    /**
     * 取得襟翼位置（Flaps Deflection）。
     *
     * @return 傳回襟翼位置。
     */
    private void setFlapsDeflection() {
        this.flapsDeflection = (int) (FSUIPC.getInt(0x0BE4) / 16383.0 * 30);
    }

    /**
     * 取得目前的年份。
     *
     * @return 傳回目前的年份。
     */
    private void setYear() {
        year = (int) FSUIPC.getShort(0x0240);
    }

    private void setDay() {
        //TODO 使用Calendar 轉換。
        day = (int) FSUIPC.getShort(0x023E);
    }

    /**
     * 取得目前的時間（小時）。
     *
     * @return 傳回目前的時間（小時）。
     */
    private void setHour() {
        hour = (int) FSUIPC.getByte(0x0238);
    }

    /**
     * 取得目前的時間（分）。
     *
     * @return 傳回目前的時間（分）。
     */
    private void setMin() {
        min = (int) FSUIPC.getByte(0x0239);
    }

    /**
     * 取得目前的時間（秒）。
     *
     * @return 傳回目前的時間（秒）。
     */
    private void setSec() {
        sec = (int) FSUIPC.getByte(0x023A);
    }

    private void setThrottleLevel() {
        this.throttleLevel = (int) (FSUIPC.getShort(0x088C) / 16384.0 * 100.0);
    }

    /**
     * 取得混合比桿位（Mixture Level）。
     *
     * @return 傳回混合比桿位。
     */
    private void setMixtureLevel() {
        this.mixtureLevel = (int) (FSUIPC.getShort(0x0890) / 16384.0 * 100.0);
    }

    /**
     * 取得螺旋槳桿位（Prop Level）。
     *
     * @return 傳回螺旋槳桿位。
     */
    private void setPropLevel() {
        this.propLevel = (int) (FSUIPC.getShort(0x088E) / 16384.0 * 100.0);
    }

    /**
     * 取得引擎轉數（Propeller RPM）。
     *
     * @return 傳回引擎轉數。
     */
    private void setEngineRPM() {
        this.engineRPM = (int) (FSUIPC.getShort(0x0898) / 16384.0 * 100.0);
    }

    /**
     * 取得螺旋槳轉數。
     *
     * @return 傳回螺旋槳轉數。
     */
    private void setPropRPM() {
        this.propRPM = (int) FSUIPC.getDouble(0x2400);
    }

    /**
     * 取得扭力輸出（Torque）。
     *
     * @return 傳回扭力輸出。
     */
    private void setTorque() {
        this.torque = (int) (FSUIPC.getInt(0x08F4) / 16384.0 * 100.0);
    }

    //直升機
    private void setHelicopterEngineRPM() {
        this.helicopterEngineRPM = (int) (FSUIPC.getShort(0x0896) / 16384.0 * 100.0);
    }

    //進氣壓力
    private void setManifold() {
        this.manifold = (double) FSUIPC.getShort(0x08C0) / 1024;
    }

    private void setNavigateFrequency() {
        byte[] bcd = new byte[2];
        bcd[0] = FSUIPC.getByte(0x0350);
        bcd[1] = FSUIPC.getByte(0x0351);

        int len;
        int i;

        int[] aints = new int[4];
        char[] achars = new char[4];

        for (i = 0; i < 4; i += 2) {
            aints[i] = bcd[i / 2] & 0xf;
            aints[i + 1] = (bcd[i / 2] & 0xf0) >> 4;
        }

        len = 4;
        for (i = 0; i < 4; i++) {
            achars[i] = (char) (aints[len - i - 1] + (int) '0');
        }
        String str = new String(achars);
        str = str.substring(0, 2) + "." + str.substring(2, 4);
        str = removeNonLetterCharacters(str);
        this.navigateFrequency = "1" + str;
    }

    /**
     * 取得 NAV1 ID。
     *
     * @return 傳回 NAV1 ID。
     */
    private void setNavigateID() {
        String result = FSUIPC.getString(0x3000, 6);
        this.navigateID = removeNonLetterCharacters(result);
    }

    /**
     * 取得 NAV1 名稱。
     *
     * @return 傳回 NAV1 名稱。
     */
    private void setNavigateName() {
        String result = FSUIPC.getString(0x3006, 25);
        this.navigateName = removeNonLetterCharacters(result);
    }

    /**
     * 取得 NAV1-Localizer Needle。
     *
     * @return 傳回 NAV1-Localizer Needle。
     */
    private void setLocalizerDev() {
        this.localizerDev = FSUIPC.getByte(0x0C48);
    }

    /**
     * 取得 NAV1-Glideslope Needle。
     *
     * @return 傳回 NAV1-Glideslope Needle。
     */
    private void setGlideslopeDev() {
        this.glideslopeDev = FSUIPC.getByte(0x0C49);
    }

    /**
     * 取得 DME Distance。
     *
     * @return 傳回 DME Distance。
     */
    private void setDme() {
        this.dme = FSUIPC.getString(0x0C29, 5);
    }

    private String removeNonLetterCharacters(String str) {
        char[] charArray = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (char ch : charArray) {
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    /**
     * 取得緯度（Latitude）。 根據說明文件所述，必須使用 64 bit 的整數變數來儲存從 FSUIPC 得到的值，因此 程式中是使用
     * getLong ，之後再將其轉型為 double。
     *
     * @return 傳回飛機的緯度。
     */
    private void setLatitude() {
        double lat = (double) FSUIPC.getLong(0x0560);
        this.latitude = lat * 90.0 / (10001750.0 * 65536.0 * 65536.0);
    }

    /**
     * 取得經度（Longitude）。 根據說明文件所述，必須使用 64 bit 的整數變數來儲存從 FSUIPC 得到的值，因此 程式中是使用
     * FSUIPC.getLong ，之後再將其轉型為 double。
     *
     * @return 傳回飛機的緯度。
     */
    private void setLongitude() {
        double lon = (double) FSUIPC.getLong(0x0568);
        this.longitude = lon * 360.0 / (65536.0 * 65536.0 * 65536.0 * 65536.0);
    }

    /**
     * 取得飛行高度（Altitude）。 此版本只有取得分行高度資訊中小數點以上的資訊，而忽略小數點以下的資訊。
     *
     * @return 傳回飛機的飛行高度。
     */
    private void setAltitude() {
        this.altitude = FSUIPC.getInt(0x0574) + Math.abs(FSUIPC.getInt(0x0570) / 65536.0 / 65536.0);
    }

    /**
     * 取得地面標高（Ground Altitude）。
     *
     * @return 傳回地面標高。
     */
    private void setGroudAltitude() {
        this.groundAltitude = (double) FSUIPC.getInt(0x0020) / 256;
    }

    /**
     * 取得儀表空速（Indicated Air Speed）。
     *
     * @return 傳回儀表空速 (浬/時)。
     */
    private void setIndicatedAirSpeed() {
        double IAS = (double) FSUIPC.getInt(0x02BC);
        this.indicatedAirSpeed = IAS / 128.0;
    }

    /**
     * 取得真實空速（True Air Speed）。
     *
     * @return 傳回真實空速 (浬/時)。
     */
    private void setTrueAirSpeed() {
        double TAS = (double) FSUIPC.getInt(0x02B8);
        this.trueAirSpeed = TAS / 128.0;
    }

    /**
     * 取得對地速度（Ground Speed）。
     *
     * @return 傳回對地速度 (浬/時)。
     */
    private void setGroundSpeed() {
        double GS = (double) FSUIPC.getInt(0x02B4);
        this.groundSpeed = GS / 65536.0 * 60.0 * 60.0 / 1.852 / 1000.0;
    }

    /**
     * 取得垂直速度（Vertical Speed）。
     *
     * @return 傳回垂直速度 (呎/分)。
     */
    private void setVerticalSpeed() {
        double VS = (double) FSUIPC.getInt(0x02C8);
        this.verticalSpeed = VS * 60.0 * 3.28084 / 256.0;
    }

    /**
     * 取得風速（Wind Speed）。
     *
     * @return 傳回風速 (浬/時)。
     */
    private void setWindSpeed() {
        this.windSpeed = (double) FSUIPC.getShort(0x0E90);
    }

    /**
     * 取得風向（Wind Direction）。
     *
     * @return 傳回風向。
     */
    private void setwindDirection() {
        short direction1 = FSUIPC.getShort(0x0E92);
        short direction2 = FSUIPC.getShort(0x02A0);
        double result = (direction1 * 360.0 / 65536.0) - (direction2 * 360.0 / 65536.0);
        if (result < 0) {
            result += 360;
        }
        this.windDirection = result;
    }

    /**
     * 取得馬赫數（Mach Speed）。
     *
     * @return 傳回馬赫數。
     */
    private void setMachSpeed() {
        double mach = FSUIPC.getShort(0x11C6);
        this.machSpeed = mach / 20480.0;
    }

    /**
     * 取得 G 值（G Force）。
     *
     * @return 傳回 G 值。
     */
    private void setGForce() {
        double force = FSUIPC.getShort(0x11BA);
        this.gForce = force / 625.0;
    }   
}

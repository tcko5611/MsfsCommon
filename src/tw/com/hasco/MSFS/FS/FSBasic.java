/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.FS;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import tw.com.hasco.MSFS.model.MSFSDataEnum;
import tw.com.hasco.MSFS.model.PlaneType;
import tw.com.hasco.MSFS.model.StringBufferWithSeparator;

/**
 *
 * @author DELL
 */
enum Simulator {FS, XPLANE}
public abstract class FSBasic {

    List<MSFSDataEnum> planeDataLt;
    BufferedReader bufferedReader;
    String navigateFrequency;
    String navigateID;
    String navigateName;
    double localizerDev;
    double glideslopeDev;
    String dme;
    String strTime;
    double flyAltitude;
    double aoa;
    double beta;
    int engineRPM;
    PlaneType planeType;
    int recordPeriod;
    Simulator simulator;
    public FSBasic(PlaneType planeType) {
        this.planeType = planeType;
        switch (planeType) {
            case AIRCRAFT:
                planeDataLt = PlaneType.getAircraftDataLt();
                break;
            case HELICOPTER:
                planeDataLt = PlaneType.getHelicopterDataLt();
                break;
        }
        simulator = Simulator.FS;
        recordPeriod = 100;
        stop = false;
    }

    int year, day, hour, min, sec;
    String type;
    double pitch;
    double bank;
    double heading;
    double magneticHeading;
    int throttleLevel;
    int mixtureLevel;
    int propLevel;
    int propRPM;
    int torque;
    int helicopterEngineRPM;
    double manifold;
    double latitude;
    double longitude;
    double altitude;
    double groundAltitude;
    double indicatedAirSpeed;
    double trueAirSpeed;
    double groundSpeed;
    double verticalSpeed;
    double windSpeed;
    double windDirection;
    double machSpeed;
    double gForce;
    int elevatorControl;
    int elevatorDeflection;
    double elevatorTrimControl;
    int aileronControl;
    int aileronDeflection;
    double aileronTrimControl;
    int rudderControl;
    int rudderDeflection;
    double rudderTrimControl;
    int aileronTrimDeflection;
    String gearControl;
    String gearPosition;
    int flapsControl;
    int flapsDeflection;
    boolean stop;

    public abstract void update() throws IOException, FSFileException;

    /**
     * stop the FS
     * @param b
     */
    public void setStop(boolean b) {
        stop = b;
    }

    /**
     * get recordPeriod
     * @return 
     */
    public int getRecordPeriod() {
        return recordPeriod;
    }

    /**
     * get time
     *
     * @return 
     */
    public int year() {
        return year;
    }

    public int day() {
        return day;
    }

    public int hour() {
        return hour;
    }

    public int min() {
        return min;
    }

    public int sec() {
        return sec;
    }

    public String getDisplayTime() {
        strTime = Integer.toString(hour) + ":" + Integer.toString(min)
                + ":" + Integer.toString(sec);
        return strTime;
    }
    /**
    * get simulator
     * @return 
    */
    public String getSimulator() {
        if (simulator == Simulator.XPLANE) return "xplane";
        return "fs";
    }
    
    /**
     * get type
     *
     * @return aicraft type
     */
    public String type() {
        return type;
    }

    public String getType() {
        return type;
    }

    /**
     * get pitch
     *
     * @return pitch
     */
    public double pitch() {
        return pitch;
    }

    public String getPitch() {
        return String.format("%.1f 度", pitch);
    }

    /**
     * 取得滾轉角（Bank）。 Note: 可使用 0x2F78。
     *
     * @return 傳回滾轉角。
     */
    public double bank() {
        return bank;
    }

    public String getBank() {
        return String.format("%.1f 度", bank);
    }

    /**
     * 取得方位角（Heading）。
     *
     * @return 傳回方位角。
     */
    public double heading() {
        return heading;
    }

    public String getHeading() {
        return String.format("%.1f 度", heading);
    }

    /**
     * 取得攻角（Angle of Attack）。
     *
     * @return 傳回攻角。
     */
    public double aoa() {
        return aoa;
    }

    public String getAoa() {
        return String.format("%.1f 度", aoa);
    }

    /**
     * 取得測滑角（Incidence Beta）。
     *
     * @return 傳回測滑角。
     */
    public double beta() {
        return beta;
    }

    public String getBeta() {
        return String.format("%.1f 度", beta);
    }

    /**
     * 取得磁方角（Magnetic Heading）。
     *
     * @return 傳回磁方角。
     */
    public double magneticHeading() {
        return magneticHeading;
    }

    public String getMagneticHeading() {
        return String.format("%.1f 度", magneticHeading);
    }

    /**
     * 取得節流閥桿位（Throttle Level）。
     *
     * @return 傳回節流閥桿位。
     */
    public int throttleLevel() {
        return throttleLevel;
    }

    public String getThrottleLevel() {
        return String.format("%d%%", throttleLevel);
    }

    /**
     * 取得混合比桿位（Mixture Level）。
     *
     * @return 傳回混合比桿位。
     */
    public int mixtureLevel() {
        return mixtureLevel;
    }

    public String getMixtureLevel() {
        return String.format("%d%%", mixtureLevel);
    }

    /**
     * 取得螺旋槳桿位（Prop Level）。
     *
     * @return 傳回螺旋槳桿位。
     */
    public int propLevel() {
        return propLevel;
    }

    public String getPropLevel() {
        if (simulator == Simulator.XPLANE) return String.format("%d RPM", propLevel);
        return String.format("%d%%", propLevel);
    }

    /**
     * 取得引擎轉數（Propeller RPM）。
     *
     * @return 傳回引擎轉數。
     */
    public int engineRPM() {
        return engineRPM;
    }

    public String getEngineRPM() {
        if (simulator == Simulator.XPLANE) return String.format("%d rpm", engineRPM);
        return String.format("%d%%", engineRPM);
    }

    /**
     * 取得螺旋槳轉數。
     *
     * @return 傳回螺旋槳轉數。
     */
    public int propRPM() {
        return propRPM;
    }

    public String getPropRPM() {
        return String.format("%d", propRPM);
    }

    /**
     * 取得扭力輸出（Torque）。
     *
     * @return 傳回扭力輸出。
     */
    public int torque() {
        return torque;
    }

    public String getTorque() {
        if (simulator == Simulator.XPLANE) return String.format("%d NM", torque);
        return String.format("%d%%", torque);
    }

    //直升機
    public int helicopterEngineRPM() {
        return helicopterEngineRPM;
    }

    public String getHelicopterEngineRPM() {
        return String.format("%d", helicopterEngineRPM);
    }

    //進氣壓力
    public double manifold() {
        return manifold;
    }

    public String getManifold() {
        return String.format("%.2f", manifold);
    }

    /**
     * 取得 NAV1 頻率。
     *
     * @return 傳回 NAV1 頻率。
     */
    public String navigateFrequency() {
        return navigateFrequency;
    }

    public String getNavigateFrequency() {
        return navigateFrequency;
    }

    /**
     * 取得 NAV1 ID。
     *
     * @return 傳回 NAV1 ID。
     */
    public String navigateID() {
        return navigateID;
    }

    public String getNavigateID() {
        return navigateID;
    }

    /**
     * 取得 NAV1 名稱。
     *
     * @return 傳回 NAV1 名稱。
     */
    public String navigateName() {
        return navigateName;
    }

    public String getNavigateName() {
        return navigateName;
    }

    /**
     * 取得 NAV1-Localizer Needle。
     *
     * @return 傳回 NAV1-Localizer Needle。
     */
    public double localizerDev() {
        return localizerDev;
    }

    public String getLocalizerDev() {
        return String.format("%.1f", localizerDev);
    }

    /**
     * 取得 NAV1-Glideslope Needle。
     *
     * @return 傳回 NAV1-Glideslope Needle。
     */
    public double glideslopeDev() {
        return glideslopeDev;
    }

    public String getGlideslopeDev() {
        return String.format("%.1f", glideslopeDev);
    }

    /**
     * 取得 DME Distance。
     *
     * @return 傳回 DME Distance。
     */
    public String dme() {
        return dme;
    }

    public String getDme() {
        return dme;
    }

    /**
     * 取得緯度（Latitude）。 根據說明文件所述，必須使用 64 bit 的整數變數來儲存從 FSUIPC 得到的值，因此 程式中是使用
     * getLong ，之後再將其轉型為 double。
     *
     * @return 傳回飛機的緯度。
     */
    public double latitude() {
        return latitude;
    }

    public String getLatitudeInDegree() {
        return String.format("%.5f", latitude);
        //return repository.getDisplayString(MSFSDataEnum.LATITUDE);
    }

    public String getLatitudeInDMS() {
        return transformToDMS(latitude);
    }

    /**
     * 取得經度（Longitude）。 根據說明文件所述，必須使用 64 bit 的整數變數來儲存從 FSUIPC 得到的值，因此 程式中是使用
     * getLong ，之後再將其轉型為 double。
     *
     * @return 傳回飛機的緯度。
     */
    public double longitude() {
        return longitude;
    }

    public String getLongitudeInDegree() {
        return String.format("%.5f", longitude);
        //return repository.getDisplayString(MSFSDataEnum.LONGITUDE);
    }

    public String getLongitudeInDMS() {
        //Double longitude = (Double) repository.getRawData(MSFSDataEnum.LONGITUDE);
        return transformToDMS(longitude);
    }

    private String transformToDMS(double latitude) {
        double lat1 = Math.abs(latitude);
        int degree = (int) Math.floor(lat1);
        int minute = (int) Math.floor((lat1 - degree) * 60);
        double second = ((lat1 - degree) * 60 - minute) * 60;
        String str = (latitude >= 0) ? String.format("%d:%d:%4.1f", degree, minute, second) : String.format("-%d:%d:%4.1f", degree, minute, second);
        return str;
    }

    /**
     * 取得飛行高度（Altitude）。 此版本只有取得分行高度資訊中小數點以上的資訊，而忽略小數點以下的資訊。
     *
     * @return 傳回飛機的飛行高度。
     */
    public double altitude() {
        return altitude;
    }

    public String getAltitudeInMeter() {
        return String.format("%10.1f 公尺", altitude);
    }

    public String getAltitudeInFeet() {
        // Double altitudeInMeter = (Double) repository.getRawData(MSFSDataEnum.ALTITUDE);
        // Double altitudeInFeet = altitudeInMeter * 3.28084;
        return String.format("%.1f 呎`", altitude * 3.28084);
    }

    /**
     * 取得地面標高（Ground Altitude）。
     *
     * @return 傳回地面標高。
     */
    public double groudAltitude() {
        return groundAltitude;
    }

    public double flyAltitude() {
        return flyAltitude;
    }

    public String getGroundAltitude() {
        return String.format("%.1f 公尺", groundAltitude);
    }

    public String getFlyAltitude() {
        return String.format("%.1f 公尺", altitude - groundAltitude);
    }

    /**
     * 取得儀表空速（Indicated Air Speed）。
     *
     * @return 傳回儀表空速 (浬/時)。
     */
    public double indicatedAirSpeed() {
        return indicatedAirSpeed;
    }

    public String getIndicatedAirSpeed() {
        return String.format("%10.1f 節", indicatedAirSpeed);
    }

    /**
     * 取得真實空速（True Air Speed）。
     *
     * @return 傳回真實空速 (浬/時)。
     */
    public double trueAirSpeed() {
        return trueAirSpeed;
    }

    public String getTrueAirSpeed() {
        return String.format("%10.1f 節", trueAirSpeed);
    }

    /**
     * 取得對地速度（Ground Speed）。
     *
     * @return 傳回對地速度 (浬/時)。
     */
    public double groundSpeed() {
        return groundSpeed;
    }

    public String getGroundSpeedInKnot() {
        return String.format("%.2f 節", groundSpeed);
    }

    public String getGroundSpeedInMeter() {
        return String.format("%.0f 公尺/秒", groundSpeed / 3.6 * 1.852);
    }

    /**
     * 取得垂直速度（Vertical Speed）。
     *
     * @return 傳回垂直速度 (呎/分)。
     */
    public double verticalSpeed() {
        return verticalSpeed;
    }

    public String getVerticalSpeedInMeter() {
        return String.format("%.2f 公尺/秒", verticalSpeed / 60.0 / 3.28084);
    }

    public String getVerticalSpeedInFeet() {
        return String.format("%.2f 呎/分", verticalSpeed);
    }

    /**
     * 取得風速（Wind Speed）。
     *
     * @return 傳回風速 (浬/時)。
     */
    public double windSpeed() {
        return windSpeed;
    }

    /**
     * 取得風向（Wind Direction）。
     *
     * @return 傳回風向。
     */
    public double windDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return String.format("%.0f", windSpeed);
    }

    public String getWindDirection() {
        return String.format("%.0f", windDirection);
    }

    /**
     * 取得馬赫數（Mach Speed）。
     *
     * @return 傳回馬赫數。
     */
    public double machSpeed() {
        return machSpeed;
    }

    public String getMachSpeed() {
        return String.format("%.2f", machSpeed);
    }

    /**
     * 取得 G 值（G Force）。
     *
     * @return 傳回 G 值。
     */
    public double gForce() {
        return gForce;
    }

    public String getGForce() {
        return String.format("%.1f", gForce);
    }

    /**
     * 取得升降舵桿位（Elevator Control）。
     *
     * @return 回傳升降舵桿位。
     */
    public int elevatorControl() {
        return elevatorControl;
    }

    public String getElevatorControl() {
        return String.format("%d%%", elevatorControl);
    }

    /**
     * 取得升降舵位置（Elevator Deflection）。
     *
     * @return 回傳升降舵位置。
     */
    public int elevatorDeflection() {
        return elevatorDeflection;
    }

    public String getElevatorDeflection() {
        return String.format("%d度", elevatorDeflection);
    }

    /**
     * 取得升降舵配平（Elevator Trim Control）。
     *
     * @return 回傳升降舵配平。
     */
    public double elevatorTrimControl() {
        return elevatorTrimControl;
    }

    public String getElevatorTrimControl() {
        if (simulator == Simulator.XPLANE) return String.format("%.1f%%", elevatorTrimControl);
        return String.format("%.1f度", elevatorTrimControl);
    }

    /**
     * 取得副翼桿位（Aileron Control）。
     *
     * @return 回傳副翼桿位。
     */
    public int aileronControl() {
        return aileronControl;
    }

    public String getAileronControl() {
        return String.format("%d%%", aileronControl);
    }

    /**
     * 取得副翼位置（Aileron Deflection）。
     *
     * @return 回傳副翼位置。
     */
    public int aileronDeflection() {
        return aileronDeflection;
    }

    public String getAileronDeflection() {
        return String.format("%d度", aileronDeflection);
    }

    /**
     * 取得副翼配平桿位（Aileron Trim Control）。
     *
     * @return 回傳副翼配平桿位。
     */
    public double aileronTrimControl() {
        return aileronTrimControl;
    }

    public String getAileronTrimControl() {
        if (simulator == Simulator.XPLANE) return String.format("%.1f%%", aileronTrimControl);
        return String.format("%.1f度", aileronTrimControl);
    }

    /**
     * 取得方向舵桿位（Rudder Control）。
     *
     * @return 回傳方向舵桿位。
     */
    public int rudderControl() {
        return rudderControl;
    }

    public String getRudderControl() {
        return String.format("%d%%", rudderControl);
    }

    /**
     * 取得方向舵位置（Rudder Deflection）。
     *
     * @return 回傳方向舵位置。
     */
    public int rudderDeflection() {
        return rudderDeflection;
    }

    public String getRudderDeflection() {
        return String.format("%d度", rudderDeflection);
    }

    /**
     * 取得方向舵配平位置（Rudder Trim Control）。
     *
     * @return 回傳方向舵配平。
     */
    public double rudderTrimControl() {
        return rudderTrimControl;
    }

    public String getRudderTrimControl() {
        if (simulator == Simulator.XPLANE) return String.format("%.1f%%", rudderTrimControl);
        return String.format("%.1f度", rudderTrimControl);
    }

    /**
     * 取得副翼配平位置（Aileron Trim Deflection）。
     *
     * @return 回傳副翼配平桿位。
     */
    public int aileronTrimDeflection() {
        return aileronTrimDeflection;
    }

    /**
     * 取得起落架桿位（Gear Control）。
     *
     * @return 傳回起落架桿位。
     */
    public String gearControl() {
        return gearControl;
    }

    public String getGearControl() {
        return gearControl;
    }

    /**
     * 取得起落架位置（Gear position）。
     *
     * @return 傳回起落架位置。
     */
    public String gearPosition() {
        return gearPosition;
    }

    public String getGearPosition() {
        return gearPosition;
    }

    /**
     * 取得襟翼桿位（Flaps Control）。
     *
     * @return 傳回襟翼桿位。
     */
    public int flapsControl() {
        return flapsControl;
    }

    public String getFlapsControl() {
        return String.format("%d%%", flapsControl);
    }

    /**
     * 取得襟翼位置（Flaps Deflection）。
     *
     * @return 傳回襟翼位置。
     */
    public int flapsDeflection() {
        return flapsDeflection;
    }

    public String getFlapsDeflection() {
        return String.format("%d度", flapsDeflection);
    }

    /**
     * This function is use to output the first line record file
     *
     * @return string of the first line output
     */
    public String getFirstLine() {
        StringBufferWithSeparator buffer = new StringBufferWithSeparator(", ");
        for (MSFSDataEnum t : this.planeDataLt) {
            buffer.append(t.getDes1());
        }
        buffer = buffer.removeLastSeparator();
        return buffer.toString();
    }

    /**
     * This function is used to generate second line of record file
     *
     * @return string of second line
     */
    public String getSecondLine() {
        StringBufferWithSeparator buffer = new StringBufferWithSeparator(", ");
        for (MSFSDataEnum t : this.planeDataLt) {
            if (simulator == Simulator.XPLANE) {
                buffer.append(t.getDes4());
            }
            else {
                buffer.append(t.getDes2());
            }
        }
        buffer = buffer.removeLastSeparator();
        return buffer.toString();
    }

    /**
     * This function is used to generate record data
     *
     * @return string of the record file
     */
    public String getNewLine() {
        StringBufferWithSeparator buffer = new StringBufferWithSeparator(", ");
        for (MSFSDataEnum t : this.planeDataLt) {
            buffer.append(getRawData(t));
        }
        buffer = buffer.removeLastSeparator();
        return buffer.toString();
    }

    private Object getRawData(MSFSDataEnum type) {
        switch (type) {
            case LATITUDE:
                return this.latitude;
            case LONGITUDE:
                return this.longitude;
            case ALTITUDE:
                return this.altitude;
            case GROUND_ALTITUDE:
                return this.groundAltitude;
            case FLY_ALTITUDE:
                return this.flyAltitude;
            case HEADING:
                return this.heading;
            case PITCH:
                return this.pitch;
            case BANK:
                return this.bank;
            case MAGNETIC_HEADING:
                return this.magneticHeading;
            case AOA:
                return this.aoa;
            case BETA:
                return this.beta;
            case INDICATED_AIR_SPEED:
                return this.indicatedAirSpeed;
            case TRUE_AIR_SPEED:
                return this.trueAirSpeed;
            case MACH_SPEED:
                return this.machSpeed;
            case VERTICAL_SPEED:
                return this.verticalSpeed;
            case GFORCE:
                return this.gForce;
            case GROUND_SPEED:
                return this.groundSpeed;
            case WIND_DIRECTION:
                return this.windDirection;
            case WIND_SPEED:
                return this.windSpeed;
            case THROTTLE_LEVEL:
                return this.throttleLevel;
            case PROP_LEVEL:
                return this.propLevel;
            case MIXTURE_LEVEL:
                return this.mixtureLevel;
            case ENGINE_RPM:
                return this.engineRPM;
            case PROP_RPM:
                return this.propRPM;
            case TORQUE:
                return this.torque;
            case ELEVATOR_CONTROL:
                return this.elevatorControl;
            case ELEVATOR_DEFLECTION:
                return this.elevatorDeflection;
            case AILERON_CONTROL:
                return this.aileronControl;
            case AILERON_DEFLECTION:
                return this.aileronDeflection;
            case RUDDER_CONTROL:
                return this.rudderControl;
            case RUDDER_DEFLECTION:
                return this.rudderDeflection;
            case FLAPS_CONTROL:
                return this.flapsControl;
            case FLAPS_DEFLECTION:
                return this.flapsDeflection;
            case GEAR_CONTROL:
                return this.gearControl;
            case GEAR_POSITION:
                return this.gearPosition;
            case ELEVATOR_TRIM_CONTROL:
                return this.elevatorTrimControl;
            case RUDDER_TRIM_CONTROL:
                return this.rudderTrimControl;
            case AILERON_TRIM_CONTROL:
                return this.aileronTrimControl;
            case NAVIGATE_FREQUENCY:
                return this.navigateFrequency;
            case NAVIGATE_ID:
                return this.navigateID;
            case NAVIGATE_NAME:
                return this.navigateName;
            case LOCALIZER_DEV:
                return this.localizerDev;
            case GLIDESLOPE_DEV:
                return this.glideslopeDev;
            case DME:
                return this.dme;
            case TIME:
                return this.strTime;
            case HELICOPTER_ENGINE_RPM:
                return this.helicopterEngineRPM;
            case MANIFOLD:
                return this.manifold;
            default:
                throw new RuntimeException("data size error");
        }
    }
}

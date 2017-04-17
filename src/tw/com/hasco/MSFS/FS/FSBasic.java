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


enum Simulator {
    FS, XPLANE
}
/**
 * basic class for Flight simulator
 * @author DELL
 */
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
    int recordPeriod; /** use in FsFile for send out data period */
    Simulator simulator;

    /**
     * constructor for FSBasic
     *
     * @param planeType for aircraft or helicopter they will write different
     * sequence of data
     */
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

    /**
     * update fs for new data
     *
     * @throws IOException open file fail
     * @throws FSFileException indicate the FsFile is to end of file
     */
    public abstract void update() throws IOException, FSFileException;

    /**
     * stop the FS
     *
     * @param b
     */
    public void setStop(boolean b) {
        stop = b;
    }

    /**
     * get recordPeriod
     *
     * @return record period use for FsFile
     */
    public int getRecordPeriod() {
        return recordPeriod;
    }

    /**
     * get time
     *
     * @return time
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
     *
     * @return simulator name
     */
    public String getSimulator() {
        if (simulator == Simulator.XPLANE) {
            return "xplane";
        }
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
     * @return pitch in degree
     */
    public double pitch() {
        return pitch;
    }

    public String getPitch() {
        return String.format("%.1f 度", pitch);
    }

    /**
     * get bank
     *
     * @return bank(roll) in degree
     */
    public double bank() {
        return bank;
    }

    public String getBank() {
        return String.format("%.1f 度", bank);
    }

    /**
     * get yaw
     *
     * @return heading in degree
     */
    public double heading() {
        return heading;
    }

    public String getHeading() {
        return String.format("%.1f 度", heading);
    }

    /**
     * get aoa
     *
     * @return aoa in degree
     */
    public double aoa() {
        return aoa;
    }

    public String getAoa() {
        return String.format("%.1f 度", aoa);
    }

    /**
     * get beta
     *
     * @return beta in degree
     */
    public double beta() {
        return beta;
    }

    public String getBeta() {
        return String.format("%.1f 度", beta);
    }

    /**
     * get Magnetic Heading
     *
     * @return magnetic heading in degree
     */
    public double magneticHeading() {
        return magneticHeading;
    }

    public String getMagneticHeading() {
        return String.format("%.1f 度", magneticHeading);
    }

    /**
     * Throttle Level
     *
     * @return throttle level in %
     */
    public int throttleLevel() {
        return throttleLevel;
    }

    public String getThrottleLevel() {
        return String.format("%d%%", throttleLevel);
    }

    /**
     * Mixture Level
     *
     * @return mixture level in %
     */
    public int mixtureLevel() {
        return mixtureLevel;
    }

    public String getMixtureLevel() {
        return String.format("%d%%", mixtureLevel);
    }

    /**
     * Prop Leve
     *
     * @return Prop Leve RPM
     */
    public int propLevel() {
        return propLevel;
    }

    public String getPropLevel() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%d RPM", propLevel);
        }
        return String.format("%d%%", propLevel);
    }

    /**
     * Propeller RPM
     *
     * @return Propeller RPM
     */
    public int engineRPM() {
        return engineRPM;
    }

    public String getEngineRPM() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%d rpm", engineRPM);
        }
        return String.format("%d%%", engineRPM);
    }

    /**
     * prop rmp
     *
     * @return prop rpm
     */
    public int propRPM() {
        return propRPM;
    }

    public String getPropRPM() {
        return String.format("%d", propRPM);
    }

    /**
     * Torque
     *
     * @return torque nm
     */
    public int torque() {
        return torque;
    }

    public String getTorque() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%d NM", torque);
        }
        return String.format("%d%%", torque);
    }

    /**
     * helicopter RPM
     * @return helicopter RPM
     */
    public int helicopterEngineRPM() {
        return helicopterEngineRPM;
    }

    public String getHelicopterEngineRPM() {
        return String.format("%d", helicopterEngineRPM);
    }

    /**
     * mainfold
     * @return mainfold
     */
    public double manifold() {
        return manifold;
    }

    public String getManifold() {
        return String.format("%.2f", manifold);
    }

    /**
     * NAV1 frequency
     *
     * @return NAV1 frequency
     */
    public String navigateFrequency() {
        return navigateFrequency;
    }

    public String getNavigateFrequency() {
        return navigateFrequency;
    }

    /**
     * NAV1 ID。
     *
     * @return NAV1 ID
     */
    public String navigateID() {
        return navigateID;
    }

    public String getNavigateID() {
        return navigateID;
    }

    /**
     * NAV1 name。
     *
     * @return NAV1 name
     */
    public String navigateName() {
        return navigateName;
    }

    public String getNavigateName() {
        return navigateName;
    }

    /**
     * NAV1-Localizer Needle。
     *
     * @return NAV1-Localizer Needle
     */
    public double localizerDev() {
        return localizerDev;
    }

    public String getLocalizerDev() {
        return String.format("%.1f", localizerDev);
    }

    /**
     * NAV1-Glideslope Needle。
     *
     * @return NAV1-Glideslope Needle
     */
    public double glideslopeDev() {
        return glideslopeDev;
    }

    public String getGlideslopeDev() {
        return String.format("%.1f", glideslopeDev);
    }

    /**
     * DME Distance
     *
     * @return DME Distance
     */
    public String dme() {
        return dme;
    }

    public String getDme() {
        return dme;
    }

    /**
     * Latitude
     *
     * @return latitue
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
     * Longitude
     *
     * @return longitude
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
     * Altitude
     *
     * @return altitude m
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
     * Ground Altitude
     *
     * @return ground altitude m
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
     * Indicated Air Speed
     *
     * @return  Indicated Air Speed knot
     */
    public double indicatedAirSpeed() {
        return indicatedAirSpeed;
    }

    public String getIndicatedAirSpeed() {
        return String.format("%10.1f 節", indicatedAirSpeed);
    }

    /**
     * True Air Speed
     *
     * @return True Air Speed knot
     */
    public double trueAirSpeed() {
        return trueAirSpeed;
    }

    public String getTrueAirSpeed() {
        return String.format("%10.1f 節", trueAirSpeed);
    }

    /**
     * Ground Speed
     *
     * @return Ground Speed knot
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
     * Vertical Speed
     *
     * @return Vertical Speed feet/min
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
     * Wind Speed
     *
     * @return Wind Speed mile/hour
     */
    public double windSpeed() {
        return windSpeed;
    }

    /**
     * Wind Direction
     *
     * @return Wind Direction
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
     * Mach Speed
     *
     * @return Mach Speed
     */
    public double machSpeed() {
        return machSpeed;
    }

    public String getMachSpeed() {
        return String.format("%.2f", machSpeed);
    }

    /**
     * G Force
     *
     * @return G Force
     */
    public double gForce() {
        return gForce;
    }

    public String getGForce() {
        return String.format("%.1f", gForce);
    }

    /**
     * Elevator Control
     *
     * @return Elevator Control %
     */
    public int elevatorControl() {
        return elevatorControl;
    }

    public String getElevatorControl() {
        return String.format("%d%%", elevatorControl);
    }

    /**
     * Elevator Deflection
     *
     * @return Elevator Deflection %
     */
    public int elevatorDeflection() {
        return elevatorDeflection;
    }

    public String getElevatorDeflection() {
        return String.format("%d度", elevatorDeflection);
    }

    /**
     * Elevator Trim Control
     *
     * @return Elevator Trim Control %
     */
    public double elevatorTrimControl() {
        return elevatorTrimControl;
    }

    public String getElevatorTrimControl() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%.1f%%", elevatorTrimControl);
        }
        return String.format("%.1f度", elevatorTrimControl);
    }

    /**
     * Aileron Control
     *
     * @return Aileron Control %
     */
    public int aileronControl() {
        return aileronControl;
    }

    public String getAileronControl() {
        return String.format("%d%%", aileronControl);
    }

    /**
     * Aileron Deflection
     *
     * @return Aileron Deflection degree
     */
    public int aileronDeflection() {
        return aileronDeflection;
    }

    public String getAileronDeflection() {
        return String.format("%d度", aileronDeflection);
    }

    /**
     * Aileron Trim Control
     *
     * @return Aileron Trim Control degree
     */
    public double aileronTrimControl() {
        return aileronTrimControl;
    }

    public String getAileronTrimControl() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%.1f%%", aileronTrimControl);
        }
        return String.format("%.1f度", aileronTrimControl);
    }

    /**
     * Rudder Control
     *
     * @return Rudder Control %
     */
    public int rudderControl() {
        return rudderControl;
    }

    public String getRudderControl() {
        return String.format("%d%%", rudderControl);
    }

    /**
     * Rudder Deflection
     *
     * @return Rudder Deflection degree
     */
    public int rudderDeflection() {
        return rudderDeflection;
    }

    public String getRudderDeflection() {
        return String.format("%d度", rudderDeflection);
    }

    /**
     * Rudder Trim Control
     *
     * @return Rudder Trim Control %
     */
    public double rudderTrimControl() {
        return rudderTrimControl;
    }

    public String getRudderTrimControl() {
        if (simulator == Simulator.XPLANE) {
            return String.format("%.1f%%", rudderTrimControl);
        }
        return String.format("%.1f度", rudderTrimControl);
    }

    /**
     * Aileron Trim Deflection
     *
     * @return Aileron Trim Deflection
     */
    public int aileronTrimDeflection() {
        return aileronTrimDeflection;
    }

    /**
     * Gear Control
     *
     * @return Gear Control
     */
    public String gearControl() {
        return gearControl;
    }

    public String getGearControl() {
        return gearControl;
    }

    /**
     * Gear position
     *
     * @return Gear position
     */
    public String gearPosition() {
        return gearPosition;
    }

    public String getGearPosition() {
        return gearPosition;
    }

    /**
     * Flaps Control
     *
     * @return Flaps Control %
     */
    public int flapsControl() {
        return flapsControl;
    }

    public String getFlapsControl() {
        return String.format("%d%%", flapsControl);
    }

    /**
     * Flaps Deflection
     *
     * @return Flaps Deflection degree
     */
    public int flapsDeflection() {
        return flapsDeflection;
    }

    public String getFlapsDeflection() {
        return String.format("%d度", flapsDeflection);
    }

    /**
     * This function is use to output the first line record file, the name of variable
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
            } else {
                buffer.append(t.getDes2());
            }
        }
        buffer = buffer.removeLastSeparator();
        return buffer.toString();
    }

    /**
     * This function is used to generate new line for record data
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

    /**
     * get data of type for record data
     *
     * @param type comes from planeDataLt for plane type
     * @return return the data of type value
     */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.FS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import tw.com.hasco.MSFS.model.MSFSDataEnum;
import tw.com.hasco.MSFS.model.PlaneType;

/**
 * FS for read from file
 * @author DELL
 */
public class FSFile extends FSBasic{
/**
 * constructor for read record file
 * @param fileName file name
 * @param planeType xplane or fs
 * @throws FileNotFoundException if no file
 * @throws IOException if file has problem
 */
    public FSFile(String fileName, PlaneType planeType) throws FileNotFoundException, IOException {
        super(planeType);
        this.bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] fields = line.split(",");
        if (fields.length <= 3)  {
            type = fields[0];
            recordPeriod = Integer.parseInt(fields[1]);
            if (fields.length == 3 && fields[2].equals("xplane")) simulator = Simulator.XPLANE;
            bufferedReader.readLine();
        }
        bufferedReader.readLine();
    }
    
    @Override
    /**
     * called by user to update the data
     */
    public void update() throws IOException, FSFileException {
        if (bufferedReader == null) throw new FSFileException("File over");
        String  line = this.bufferedReader.readLine();
        if (line == null) {
            bufferedReader.close();
            bufferedReader = null;
            throw new FSFileException("File over");
        }
        scanLineForData(line);
    }
/**
 * set data
 * @param line data line to set data
 */
    private void scanLineForData(String line) {
        line = line.replaceAll("\\s+", "");
        String[] fields = line.split(",");
        if (fields.length != this.planeDataLt.size()) {
            throw new RuntimeException("data size error");
        }
        Iterator<MSFSDataEnum> it = planeDataLt.iterator();
        int i = 0;
        while (it.hasNext()) {
            MSFSDataEnum t = it.next();
            String val;
            val = fields[i++];
            setDataVal(t, val);
        }
    }
/**
 * set data from data line
 * @param type the enum type
 * @param val the val
 */
    private void setDataVal(MSFSDataEnum type, String val) {
        switch (type) {
            case LATITUDE:
                this.latitude = Double.parseDouble(val);
                break;
            case LONGITUDE:
                this.longitude = Double.parseDouble(val);
                break;
            case ALTITUDE:
                this.altitude = Double.parseDouble(val);
                break;
            case GROUND_ALTITUDE:
                this.groundAltitude = Double.parseDouble(val);
                break;
            case FLY_ALTITUDE:
                this.flyAltitude = Double.parseDouble(val);
                break;
            case HEADING:
                this.heading = Double.parseDouble(val);
                break;
            case PITCH:
                this.pitch = Double.parseDouble(val);
                break;
            case BANK:
                this.bank = Double.parseDouble(val);
                break;
            case MAGNETIC_HEADING:
                this.magneticHeading = Double.parseDouble(val);
                break;
            case AOA:
                this.aoa = Double.parseDouble(val);
                if (Double.isNaN(this.aoa)) {
                    this.aoa = 0.0;
                }
                break;
            case BETA:
                this.beta = Double.parseDouble(val);
                break;
            case INDICATED_AIR_SPEED:
                this.indicatedAirSpeed = Double.parseDouble(val);
                break;
            case TRUE_AIR_SPEED:
                this.trueAirSpeed = Double.parseDouble(val);
                break;
            case MACH_SPEED:
                this.machSpeed = Double.parseDouble(val);
                break;
            case VERTICAL_SPEED:
                this.verticalSpeed = Double.parseDouble(val);
                break;
            case GFORCE:
                this.gForce = Double.parseDouble(val);
                break;
            case GROUND_SPEED:
                this.groundSpeed = Double.parseDouble(val);
                break;
            case WIND_DIRECTION:
                this.windDirection = Double.parseDouble(val);
                break;
            case WIND_SPEED:
                this.windSpeed = Double.parseDouble(val);
                break;
            case THROTTLE_LEVEL:
                this.throttleLevel = Integer.parseInt(val);
                break;
            case PROP_LEVEL:
                this.propLevel = Integer.parseInt(val);
                break;
            case MIXTURE_LEVEL:
                this.mixtureLevel = Integer.parseInt(val);
                break;
            case ENGINE_RPM:
                this.engineRPM = Integer.parseInt(val);
                break;
            case PROP_RPM:
                this.propRPM = Integer.parseInt(val);
                break;
            case TORQUE:
                this.torque = Integer.parseInt(val);
                break;
            case ELEVATOR_CONTROL:
                this.elevatorControl = Integer.parseInt(val);
                break;
            case ELEVATOR_DEFLECTION:
                this.elevatorDeflection = Integer.parseInt(val);
                break;
            case AILERON_CONTROL:
                this.aileronControl = Integer.parseInt(val);
                break;
            case AILERON_DEFLECTION:
                this.aileronDeflection = Integer.parseInt(val);
                break;
            case RUDDER_CONTROL:
                this.rudderControl = Integer.parseInt(val);
                break;
            case RUDDER_DEFLECTION:
                this.rudderDeflection = Integer.parseInt(val);
                break;
            case FLAPS_CONTROL:
                this.flapsControl = Integer.parseInt(val);
                break;
            case FLAPS_DEFLECTION:
                this.flapsDeflection = Integer.parseInt(val);
                break;
            case GEAR_CONTROL:
                this.gearControl = val;
                break;
            case GEAR_POSITION:
                this.gearPosition = val;
                break;
            case ELEVATOR_TRIM_CONTROL:
                this.elevatorTrimControl = Double.parseDouble(val);
                break;
            case RUDDER_TRIM_CONTROL:
                this.rudderTrimControl = Double.parseDouble(val);
                break;
            case AILERON_TRIM_CONTROL:
                this.aileronTrimControl = Double.parseDouble(val);
                break;
            case NAVIGATE_FREQUENCY:
                this.navigateFrequency = val;
                break;
            case NAVIGATE_ID:
                this.navigateID = val;
                break;
            case NAVIGATE_NAME:
                this.navigateName = val;
                break;
            case LOCALIZER_DEV:
                this.localizerDev = Double.parseDouble(val);
                break;
            case GLIDESLOPE_DEV:
                this.glideslopeDev = Double.parseDouble(val);
                break;
            case DME:
                this.dme = val;
                break;
            case TIME:
                this.strTime = val;
                String[] split = val.split(":");
                hour = Integer.valueOf(split[0]);
                min = Integer.valueOf(split[1]);
                sec = Integer.valueOf(split[2]);
                break;
            case HELICOPTER_ENGINE_RPM:
                this.helicopterEngineRPM = Integer.parseInt(val);
                break;
            case MANIFOLD:
                this.manifold = Double.parseDouble(val);
                break;
            default:
                throw new RuntimeException("data size error");
        }
    }
}



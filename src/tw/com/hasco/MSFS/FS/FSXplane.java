/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.FS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.com.hasco.MSFS.Debugger;
import tw.com.hasco.MSFS.model.MSFSDataEnum;
import tw.com.hasco.MSFS.model.PlaneType;
import static tw.com.hasco.MSFS.model.PlaneType.AIRCRAFT;

/**
 *
 * @author DELL
 */
public class FSXplane extends FSBasic {

    static final int PORT = 54946;
    /* port for receive data*/
    List<MSFSDataEnum> dataLt;
    /* data list from data.txt */
    UdpServer udp;

    /* udp server, get data from xplane */

    /**
     * constructor
     *
     * @param planeType plane or helicopter
     * @throws SocketException udp server error
     */
    public FSXplane(PlaneType planeType) throws SocketException {
        super(planeType);
        simulator = Simulator.XPLANE;
        stop = false;
        buildDataLt();
        udp = new UdpServer(PORT);
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(udp);
    }

    @Override
    public void setStop(boolean b) {
        stop = b;
        udp.close();
    }

    /**
     * build udp data sequence from data.txt
     */
    final void buildDataLt() {
        try {
            dataLt = new LinkedList<>();
            BufferedReader br;
            ClassLoader classLoader = FSXplane.class.getClassLoader();
            br = new BufferedReader(new InputStreamReader(
                    classLoader.getResourceAsStream("file/data.txt")));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.isEmpty() || line.charAt(0) != 's') {
                    continue;
                }
                String[] strs = line.split("\\s+");
                if (strs.length != 3) {
                    continue;
                }
                dataLt.add(PlaneType.getEnumFromString(strs[2]));
            }
        } catch (IOException ex) {
            Logger.getLogger(FSXplane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() throws IOException {
        // flyAltitude = altitude - groundAltitude;
        groundAltitude = altitude - flyAltitude;
        machSpeed = this.trueAirSpeed / (343.0 * 3.6) * 1.852;
    }

    /**
     * for data sequence to set data
     *
     * @param type data name
     * @param val data val
     */
    private void setDataVal(MSFSDataEnum type, float val) {
        switch (type) {
            case TIME:
                val = val / 3600;
                hour = (int) (val);
                val = (val - hour) * 60;
                min = (int) (val);
                val = (val - min) * 60;
                sec = (int) (val);
                break;
            case LATITUDE:
                this.latitude = val;
                break;
            case LONGITUDE:
                this.longitude = val;
                break;
            case ALTITUDE:
                this.altitude = val;
                break;
            case GROUND_ALTITUDE:
                this.groundAltitude = val;
                break;
            case FLY_ALTITUDE:
                this.flyAltitude = val;
                break;
            case HEADING:
                this.heading = val;
                break;
            case PITCH:
                this.pitch = val;
                break;
            case BANK:
                this.bank = val;
                break;
            case MAGNETIC_HEADING:
                this.magneticHeading = val;
                break;
            case AOA:
                this.aoa = val;
                break;
            case BETA:
                this.beta = -val;
                break;
            case INDICATED_AIR_SPEED:
                this.indicatedAirSpeed = val;
                break;
            case TRUE_AIR_SPEED:
                this.trueAirSpeed = val * 1.944;
                break;
            case MACH_SPEED:
                this.machSpeed = val;
                break;
            case VERTICAL_SPEED:
                this.verticalSpeed = val;
                break;
            case GFORCE:
                this.gForce = val;
                break;
            case GROUND_SPEED:
                this.groundSpeed = val * 1.944;
                break;
            case WIND_DIRECTION:
                this.windDirection = val;
                break;
            case WIND_SPEED:
                this.windSpeed = val;
                break;
            case THROTTLE_LEVEL:
                this.throttleLevel = (int) (val * 100);
                break;
            case PROP_LEVEL:
                this.propLevel = (int) (val * 30.0 / 3.14159);
                break;
            case MIXTURE_LEVEL:
                this.mixtureLevel = (int) (val * 100);
                break;
            case ENGINE_RPM:
                this.engineRPM = (int) val;
                break;
            case PROP_RPM:
                this.propRPM = (int) val;
                break;
            case TORQUE:
                this.torque = (int) val;
                break;
            case ELEVATOR_CONTROL:
                this.elevatorControl = (int) (val * 100);
                break;
            case ELEVATOR_DEFLECTION:
                this.elevatorDeflection = (int) (-1 * val);
                break;
            case AILERON_CONTROL:
                this.aileronControl = (int) (val * 100);
                break;
            case AILERON_DEFLECTION:
                this.aileronDeflection = (int) val;
                break;
            case RUDDER_CONTROL:
                this.rudderControl = (int) (val * 100);
                break;
            case RUDDER_DEFLECTION:
                this.rudderDeflection = (int) val;
                break;
            case FLAPS_CONTROL:
                this.flapsControl = (int) (val * 100);
                break;
            case FLAPS_DEFLECTION:
                this.flapsDeflection = (int) val;
                break;
            case GEAR_CONTROL:

                this.gearControl = (val == 0.0) ? "up" : "down";
                break;
            case GEAR_POSITION:
                this.gearPosition = (val == 0.0) ? "up" : "down";
                break;
            case ELEVATOR_TRIM_CONTROL:
                this.elevatorTrimControl = (val * 100);
                break;
            case RUDDER_TRIM_CONTROL:
                this.rudderTrimControl = (val * 100);
                break;
            case AILERON_TRIM_CONTROL:
                this.aileronTrimControl = (val * 100);
                break;
            /*
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
                this.localizerDev = val;
                break;
            case GLIDESLOPE_DEV:
                this.glideslopeDev = val;
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
             */
            case HOUR:
                hour = (int) val;
                break;
            case MIN:
                min = (int) val;
                break;
            case SEC:
                sec = (int) val;
                break;
            case HELICOPTER_ENGINE_RPM:
                this.helicopterEngineRPM = (int) val;
                break;
            case MANIFOLD:
                this.manifold = val;
                break;
            default:
                throw new RuntimeException("data size error");
        }
    }

    /**
     * class of udpserver
     */
    public class UdpServer implements Runnable {

        int port;    // 連接埠
        final int SIZE = 8192;                    // 設定最大的訊息大小為 8192.
        byte buffer[] = new byte[SIZE];            // 設定訊息暫存區
        DatagramSocket socket;
        DatagramPacket packet;
        byte[] data;

        /**
         * constructor
         *
         * @param pPort receive port
         * @throws SocketException udp exception
         */
        public UdpServer(int pPort) throws SocketException {
            port = pPort;                            // 設定連接埠。
            socket = new DatagramSocket(port);         // 設定接收的 UDP Socket.
            packet = new DatagramPacket(buffer, buffer.length);
            data = new byte[4];
        }

        /**
         * when stop close the socket
         */
        public void close() {
            socket.close();
        }

        @Override
        public void run() {
            while (!stop) {
                try {
                    socket.receive(packet);                                    // 接收封包。
                } catch (IOException ex) {
                    Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                Debugger.log("msg:" + packet.getLength());
                String str = "";
                if (dataLt.size() != (int) (packet.getLength() / 4)) {
                    continue;
                }
                ListIterator<MSFSDataEnum> it = dataLt.listIterator();

                for (int i = 0; i < dataLt.size(); ++i) {
                    MSFSDataEnum type = it.next();
                    for (int j = 0; j < 4; ++j) {
                        data[j] = buffer[4 * i + 3 - j];
                    }
                    Float d = ByteBuffer.wrap(data).getFloat();
                    setDataVal(type, d);
                    str += d + " ";
                }
                Debugger.log(str);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        FSXplane fs = new FSXplane(AIRCRAFT);
    }
}

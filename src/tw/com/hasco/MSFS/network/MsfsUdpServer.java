/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.com.hasco.MSFS.Debugger;

/**
 *
 * @author DELL
 */
public class MsfsUdpServer implements Runnable {

    int port = 54947;    // server port
    final int SIZE = 8192;                    // max receive size 8192.
    byte buffer[] = new byte[SIZE];            // buffer to receive message
    DatagramSocket socket; // server socket
    DatagramPacket packet; // packet for transmit packet
    List<MsfsUdpObserver> observers; // observer to look at this file 
    String name; // reveive packet name ip:port
    double lat; // received latitude
    double lng; // received lobitude
    double heading; // received heading
    boolean stop = false; // stop to stop receive data

    /**
     * This function use to get Ip name
     *
     * @return the ip address of this machine
     */
    public static String getIpName() {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            String str = "";
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    str = i.getHostAddress();
                    // System.out.println(str);
                    String strs[] = str.split("\\.");
                    //System.out.println(strs.length);
                    if ((strs.length == 4) && !(strs[0].equals("127"))) {
                        return str;
                    }
                }
            }
            return str;
        } catch (SocketException ex) {
            Logger.getLogger(MsfsUdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * construtor need ip to indicate which port is used
     *
     * @param pPort : server port
     * @throws SocketException exception for called object to determined what to
     * do
     */
    public MsfsUdpServer(int pPort) throws SocketException {
        port = pPort;
        socket = new DatagramSocket(port);         // udp server socket, need to specified port
        packet = new DatagramPacket(buffer, buffer.length); // new packet
        observers = new ArrayList<>();
    }

    /**
     * add Oberver
     *
     * @param p oberver
     */
    public void addObserver(MsfsUdpObserver p) {
        if (!observers.contains(p)) {
            observers.add(p);
        }
    }

    /**
     * remove obsever
     *
     * @param p observer
     */
    public void removeObserver(MsfsUdpObserver p) {
        observers.remove(p);
    }

    /**
     * notify the observers for this object
     */
    private void notifyObserver() {
        observers.forEach((o) -> {
            o.update(this);
        });
    }

    /**
     * stop running or not
     *
     * @param t
     */
    public void stop(boolean t) {
        stop = t;
    }

    /**
     * get the name of udp from address
     *
     * @return name of from udp client
     */
    public String getName() {
        return name;
    }

    /**
     * get received latitude
     *
     * @return
     */
    public double getLat() {
        return lat;
    }

    /**
     * get received latitude
     *
     * @return
     */
    public double getLng() {
        return lng;
    }

    /**
     * get received latitude
     *
     * @return
     */
    public double getHeading() {
        return heading;
    }

    /**
     * start to receive data and notified observers
     */
    @Override
    public void run() {
        while (!stop) {
            try {
                socket.receive(packet);                                    // receive packet
                String msg = new String(buffer, 0, packet.getLength());    // transform data into packet              

                String strs[] = msg.split(",");
                name = strs[0];
                lat = Double.parseDouble(strs[1]);
                lng = Double.parseDouble(strs[2]);
                heading = Double.parseDouble(strs[3]);
                // Debugger.log("From" + name + ", lat =" + lat + ", lng=" + lng + ", heading =" + heading);
                notifyObserver();
            } catch (IOException ex) {
                Logger.getLogger(MsfsUdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) throws SocketException {
        MsfsUdpServer server = new MsfsUdpServer(54947);
        server.run();
    }
}

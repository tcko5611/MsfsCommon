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
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.Observer;

/**
 *
 * @author DELL
 */
public class MsfsUdpClient implements Observer {

    int port;            // port : server 
    InetAddress server; // InetAddress is IP, server's IP
    DatagramSocket socket; // udp socket to transmit data
    int localPort; // local port 
    String localIp; // local IP

    /**
     * udp client constructor
     *
     * @param pServer server name
     * @param pPort server port
     * @throws UnknownHostException can't not resolve server name
     * @throws SocketException build udp socket exception
     */
    public MsfsUdpClient(String pServer, int pPort) throws UnknownHostException, SocketException {
        port = pPort;                             // server port
        server = InetAddress.getByName(pServer); // transform server address to server IP。
        socket = new DatagramSocket();    // build UDP Socket。
        localIp = MsfsUdpServer.getIpName(); // get local ip address
        localPort = socket.getLocalPort(); // get local port
    }

    /**
     * get data and send data by udp, if fail just ignore it
     * @param fsBasic to get the data from this object
     */
    @Override
    public void update(FSBasic fsBasic) {
        try {
            String msg = localIp + ":" + localPort + "," + fsBasic.getLatitudeInDegree() + ","
                    + fsBasic.getLongitudeInDegree() + "," + String.format("%.1f", fsBasic.heading());
            byte buffer[] = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, server, port);
            socket.send(packet);                             // send data
        } catch (IOException ex) {
            Logger.getLogger(MsfsUdpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

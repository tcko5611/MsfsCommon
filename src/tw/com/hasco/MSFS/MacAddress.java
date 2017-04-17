/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * mac number utility
 * @author DELL
 */
public class MacAddress {
/**
 * gep mac ip
 * @return mac ip string
 */
    static public String getIpMacAddress() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * get mac number
     * @return mac number 
     * @throws SocketException 
     */
    public static String getMacAddress() throws SocketException {
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        while (en.hasMoreElements()) {
            NetworkInterface iface = en.nextElement();
            byte[] bytes = iface.getHardwareAddress();
            if (bytes == null || bytes[0] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X%s", bytes[i], (i < bytes.length - 1) ? "-" : ""));
            }
            return sb.toString();
        }
        return "";
    }

    public static boolean checkMacAddressInMachine(String mac) throws SocketException {
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        while (en.hasMoreElements()) {
            NetworkInterface iface = en.nextElement();
            byte[] bytes = iface.getHardwareAddress();
            if (bytes == null || bytes[0] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X%s", bytes[i], (i < bytes.length - 1) ? "-" : ""));
            }
            String str = sb.toString();
            if (str.equals(mac)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws SocketException {
        // System.out.println(MacAddress.getMacAddress());
        System.out.println("list of mac");
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        int num = 0;
        while (en.hasMoreElements()) {
            ++num;
            NetworkInterface iface = en.nextElement();
            // System.out.println("iface:" + iface);
            byte[] mac = iface.getHardwareAddress();
            if (mac == null || mac[0] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
        }
        System.out.println("num:" + num);
    }
}

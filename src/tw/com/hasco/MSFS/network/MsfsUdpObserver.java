/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.network;

/**
 * observer interface of MSfsUdpServer
 * @author DELL
 */
public interface MsfsUdpObserver {
    /**
     * the update function in Observer pattern, need to be implemented in observer 
     * @param p  object to be observe
     */
    public void update(MsfsUdpServer p);
}

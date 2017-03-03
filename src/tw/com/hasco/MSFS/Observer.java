/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;
import tw.com.hasco.MSFS.FS.FSBasic;
// import tw.com.hasco.MSFS.model.DisplayDataMediator;
/**
 *
 * @author ktc
 */
public interface Observer {
    void update(FSBasic fsBasic);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;

/**
 * Debuggin class, in release set isEnabled false 
 * @author T.C.KO
 */
public class Debugger{
    static boolean DEBUG_BUILD = false;
    public static boolean isDebugBuild() {
        return DEBUG_BUILD;
    }
    public static boolean isEnabled(){
        return true;
    }

    public static void log(Object o){
        if (isEnabled()) {
          System.out.println(o.toString());
        }
    }

    public static void err(Object o) {
        if (isEnabled()) {
          System.err.println(o.toString());
        }      
    }
}

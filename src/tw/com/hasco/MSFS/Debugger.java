/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;

/**
 * Debuggin class, in release set isEnabled false
 *
 * @author T.C.KO
 */
public class Debugger {

    /**
     * when don't want Debugger information, set return to false
     *
     * @return true or false for output message
     */
    private static boolean isEnabled() {
        return true;
    }

    /**
     * log output information
     *
     * @param o : output message
     */
    public static void log(Object o) {
        if (isEnabled()) {
            System.out.println(o.toString());
        }
    }

    /**
     * err output information
     *
     * @param o : err message
     */
    public static void err(Object o) {
        if (isEnabled()) {
            System.err.println(o.toString());
        }
    }
}

/*
 * Created on 2005/9/16
 */
package fsuipc;

import java.util.MissingResourceException;

/**
 * Wrapper class for fsuipc_java.dll
 *
 * @author tcko
 */
public class fsuipc_wrapper {

    public static final int SIM_ANY = 0;
    public static final int SIM_FS98 = 1;
    public static final int SIM_FS2K = 2;
    public static final int SIM_CFS2 = 3;
    public static final int SIM_CFS1 = 4;
    public static final int SIM_FS2K2 = 6;
/**
 * getthe library of fsuipc
 */
    public static synchronized void loadLibrary() {
        try {
            System.loadLibrary("fsuipc_java");
        } catch (UnsatisfiedLinkError error) {
            throw new MissingResourceException("fsuipc_java.lib can not be found.", "Library", "fsuipc_java");
        }
    }

    /**
     * 使用 JNI 呼叫 FSUIPC 所提供的 FSUIPC_Open 函式。
     *
     * @param flightSim Version of flightsim to try and connect to.
     * @return 0 if connection failed
     */
    public static synchronized native int Open(int flightSim);

    /**
     * 使用 JNI 呼叫 FSUIPC 所提供的 FSUIPC_Close 函式。
     *
     */
    public static synchronized native void Close();

    /**
     * 使用 JNI 呼叫 FSUIPC 所提供的 FSUIPC_Read 函式。
     *
     * @param offset
     * @param count
     * @param data
     */
    public static synchronized native void ReadData(int offset, int count, byte[] data);

    /**
     * 使用 JNI 呼叫 FSUIPC 所提供的 FSUIPC_Write 函式。
     *
     * @param offset
     * @param count
     * @param data
     */
    public static synchronized native void WriteData(int offset, int count, byte[] data);

    /**
     * 使用 JNI 呼叫 FSUIPC 所提供的 FSUIPC_Process 函式。
     * don't use now
     *
     */
    public static synchronized native void Process();
}

package fsuipc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.swing.JOptionPane;
import tw.com.hasco.MSFS.Debugger;
import tw.com.hasco.MSFS.locale.LocaleManager;

/**
 * The class is used for FS API
 *
 * @author tcko
 * @version 1.0
 * @since 2014-03-31
 */
public class FSUIPC {

    private static byte[] data = new byte[20000];

    /**
     * function for initialized for FS
     */
    public static void init() {
        fsuipc_wrapper.loadLibrary();
        int ret = fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY);
        System.out.println("ret =" + ret);
        if (ret == 0) {
            // TODO add your handling code here:
            Debugger.log("Flight simulator not found");
            JOptionPane.showMessageDialog(null, LocaleManager.getInstance("Taiwan").getString("fsNotFound"), "錯誤", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("fsNotFound");
        }
    }

    /**
     * close for FS.
     */
    public static void close() {
        fsuipc_wrapper.Close();
    }

    /**
     * get data from FS
     */
    public static void refreshMSFSData() {
        fsuipc_wrapper.ReadData(0, 20000, data);
    }

    /**
     * Get byte results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the byte value
     */
    public static byte getByte(int offset) {
        return data[offset];
    }

    /**
     * Get short results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the short value
     */
    public static short getShort(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(2);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 2);
        return buf.getShort(0);
    }

    /**
     * Get int results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the int value
     */
    public static int getInt(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 4);
        return buf.getInt(0);
    }

    /**
     * Get long results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the long value
     */
    public static long getLong(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 8);
        return buf.getLong(0);
    }

    /**
     * Get float results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the float value
     */
    public static float getFloat(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 4);
        return buf.getFloat(0);
    }

    /**
     * Get double results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the double value
     */
    public static double getDouble(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 8);
        return buf.getDouble(0);
    }

    /**
     * Get string results for FS data
     *
     * @param offset the offset position from data, need to reference doc
     * @return the string value
     */
    public static String getString(int offset, int length) {
        byte[] str = new byte[length];
        System.arraycopy(data, offset, str, 0, length);
        return new String(str);
    }

}

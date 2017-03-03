package fsuipc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.swing.JOptionPane;
import tw.com.hasco.MSFS.Debugger;
import tw.com.hasco.MSFS.locale.LocaleManager;

public class FSUIPC {

    protected static byte[] data = new byte[20000];

    public FSUIPC() {
        fsuipc_wrapper.loadLibrary();
    }

    public static void init() {
        fsuipc_wrapper.loadLibrary();
        int ret = fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY);
        System.out.println("ret =" + ret);
        if (ret == 0) {
                    // TODO add your handling code here:
            Debugger.log("Flight simulator not found");
            JOptionPane.showMessageDialog(null, LocaleManager.getInstance().getString("fsNotFound"), "錯誤", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("fsNotFound");
        }
    }
    public static void close() {
        fsuipc_wrapper.Close();
    }
    public static void refreshMSFSData() {
        fsuipc_wrapper.ReadData(0, 20000, data);
    }

    public static byte getByte(int offset) {
        return data[offset];
    }

    public static short getShort(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(2);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 2);
        return buf.getShort(0);
    }

    public static int getInt(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 4);
        return buf.getInt(0);
    }

    public static long getLong(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 8);
        return buf.getLong(0);
    }

    public static float getFloat(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 4);
        return buf.getFloat(0);
    }

    public static double getDouble(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(data, offset, 8);
        return buf.getDouble(0);
    }

    public static String getString(int offset, int length) {
        byte[] str = new byte[length];
        System.arraycopy(data, offset, str, 0, length);
        return new String(str);
    }

}

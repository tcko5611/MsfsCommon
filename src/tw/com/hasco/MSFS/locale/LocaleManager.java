package tw.com.hasco.MSFS.locale;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

/**
 * sigleton class for manage locale
 *
 * @author T.C.KO
 */
public class LocaleManager {

    private ResourceBundle resouceBundle;
    private Locale currentLocale;
    static private LocaleManager instance = null;

    /**
     * construtor
     *
     * @param str locale like taiwan china...
     */
    private LocaleManager(String str) {
        initialLocale(str);
    }

    /**
     *
     * @param str locale like taiwan china...
     */
    private void initialLocale(String str) {
        if (str.equals("Taiwan")) {
            currentLocale = Locale.TAIWAN;
        } else if (str.equals("China")) {
            currentLocale = Locale.CHINA;
        }
        try {
            resouceBundle = ResourceBundle.getBundle("tw.com.hasco.MSFS.language", currentLocale);
        } catch (MissingResourceException e) {
            //if (currentLocale.equals(Locale.TAIWAN)) {
            // if (currentLocale.equals(Locale.CHINA)) {
            // JOptionPane.showMessageDialog(null, "無法讀取語言檔案。", "Error", JOptionPane.ERROR_MESSAGE);
            // } else {
            JOptionPane.showMessageDialog(null, "Can not find localization files.", "Error", JOptionPane.ERROR_MESSAGE);
            //}

            System.exit(-1);
        }
    }

    /**
     * get singleton instance
     *
     * @param str locale like taiwan china...
     * @return singleton instance
     */
    public static LocaleManager getInstance(String str) {
        if (instance == null) {
            instance = new LocaleManager(str);
        }

        return instance;
    }

    /**
     * get key value
     *
     * @param key
     * @return value
     */
    public String getString(String key) {
        return resouceBundle.getString(key);
    }

    /**
     * get keys
     *
     * @return key list
     */
    public Enumeration<String> getKeys() {
        return resouceBundle.getKeys();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LocaleManager loc = new LocaleManager("Taiwan");
        LocaleManager loc2 = new LocaleManager("China");
        // get the keys
        Enumeration<String> enumeration = loc.getKeys();

        // print all the keys
        while (enumeration.hasMoreElements()) {
            String str = enumeration.nextElement();
            System.out.println("" + str + "," + loc.getString(str) + "," + loc2.getString(str));
        }

    }
}

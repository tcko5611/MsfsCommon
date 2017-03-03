package tw.com.hasco.MSFS.locale;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class LocaleManager {

    private ResourceBundle resouceBundle;
    private Locale currentLocale;
    static private LocaleManager instance = null;

    private LocaleManager() {
        initialLocale();
    }

    private void initialLocale() {
        currentLocale = Locale.TAIWAN;
        try {
            resouceBundle = ResourceBundle.getBundle("tw.com.hasco.MSFS.language", currentLocale);
        } catch (MissingResourceException e) {
            if (currentLocale.equals(Locale.TAIWAN)) {
                JOptionPane.showMessageDialog(null, "無法讀取語言檔案。", "錯誤", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Can not find localization files.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            System.exit(-1);
        }
    }

    public static LocaleManager getInstance() {
        if (instance == null) {
            instance = new LocaleManager();
        }

        return instance;
    }

    public String getString(String key) {
        return resouceBundle.getString(key);
    }
}

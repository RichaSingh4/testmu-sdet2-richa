package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

//    static {
//        try {
//            prop = new Properties();
//
//            InputStream input = ConfigReader.class
//                    .getClassLoader()
//                    .getResourceAsStream("config.properties");
//
//            if (input == null) {
//                throw new RuntimeException("config.properties NOT found in resources");
//            }
//
//            prop.load(input);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load config file", e);
//        }
//    }
static {
    try {
        FileInputStream fis = new FileInputStream(
                "src/test/resources/config/config.properties");

        prop = new Properties();
        prop.load(fis);

    } catch (IOException e) {
        throw new RuntimeException("Failed to load config.properties");
    }
}


    public static String get(String key) {
        return prop.getProperty(key);
    }


    public static String getApiUrl() {
        return prop.getProperty("apiBaseUrl");
    }

    public static String getUiUrl() {
        return prop.getProperty("uiBaseUrl");
    }

    public static int getInt(String key) {
        return Integer.parseInt(prop.getProperty(key));
    }
}
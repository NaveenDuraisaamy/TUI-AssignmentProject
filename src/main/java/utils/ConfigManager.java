package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties prop;

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}

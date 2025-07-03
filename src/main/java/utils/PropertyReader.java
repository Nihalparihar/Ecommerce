package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop;

    static {
        try {
            // Define the path to your config.properties file
            File configFilePath = new File("src/test/resources/config.properties");
            FileInputStream fis = new FileInputStream(configFilePath);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}

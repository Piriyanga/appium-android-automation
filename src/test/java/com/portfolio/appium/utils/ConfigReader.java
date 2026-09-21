package com.portfolio.appium.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties file was not found in src/test/resources");
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties file", e);
        }
    }

    private ConfigReader() {
        // Utility class
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);

        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException("Missing configuration value for key: " + key);
        }

        return value;
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
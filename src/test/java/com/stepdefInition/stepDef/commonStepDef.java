package com.stepdefInition.stepDef;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class commonStepDef {

        private static Properties properties = new Properties();

        static {
            try (InputStream inputStream = commonStepDef.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (inputStream == null) {
                    throw new IOException("Property file 'config.properties' not found in the classpath");
                }
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
}

package methods;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = configReader.class.getClassLoader().getResourceAsStream("config.properties")) {
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

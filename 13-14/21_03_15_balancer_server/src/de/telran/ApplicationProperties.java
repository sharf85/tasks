package de.telran;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    Properties properties;

    ApplicationProperties(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(filePath));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

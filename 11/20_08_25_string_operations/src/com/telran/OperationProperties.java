package com.telran;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class OperationProperties {

    private static final String OPERATIONS_KEY = "operations";
    Properties properties;
    String filePath;

    OperationProperties(String filePath) {
        properties = new Properties();
        this.filePath = filePath;
    }

    public void load() throws IOException {
        properties.load(new FileReader(filePath));
    }

    public List<String> getOperationPaths() {
        String stringPaths = properties.getProperty(OPERATIONS_KEY);
        String[] arrayPaths = stringPaths.split(",");
        return Arrays.asList(arrayPaths);
    }
}

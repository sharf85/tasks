package com.telran.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesService {

    private String propsPath;
    private Properties props;

    public PropertiesService(String propsPath) throws IOException {
        this.propsPath = propsPath;
        props = new Properties();
        props.load(new FileReader("config/config.props"));
    }

    public String getOperationPackage() {
        return props.getProperty("operations_package");
    }

    public List<String> getOperationNames() {
        String operations = props.getProperty("operations");
        return Arrays.asList(operations.split(","));
    }

    public List<String> getOperationPaths() {
        String packageName = getOperationPackage();
        List<String> names = getOperationNames();

        List<String> res = new ArrayList<>();
        for (String name : names) {
            res.add(packageName + "." + name);
        }

        return res;
    }
}

package de.telran;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("program.props"));

        String name = properties.getProperty("name");

        System.out.println(name);
    }
}

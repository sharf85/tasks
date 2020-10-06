package com.telran;

import java.io.IOException;
import java.util.List;

public class Main {

    static final String ZONES_FILENAME = "zones.txt";

    public static void main(String[] args) throws IOException {
        FileOperations fo = new FileOperations();

        List<String> zones = fo.readFileToList(ZONES_FILENAME);

        DomainChecker domainChecker = new DomainChecker(zones);

        ConsoleListener consoleListener = new ConsoleListener(domainChecker);
        new Thread(consoleListener).start();
    }
}

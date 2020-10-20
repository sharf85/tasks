package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleListener implements Runnable {

    DomainChecker domainChecker;

    public ConsoleListener(DomainChecker domainChecker) {
        this.domainChecker = domainChecker;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                System.out.println("Please wait!");
                List<String> freeDomains = domainChecker.getFreeDomains(line);
                freeDomains.forEach(System.out::println);
                if (freeDomains.size() == 0)
                    System.out.println("No domains found!");
                else
                    System.out.println("Completed!");
//                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

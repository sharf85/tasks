package de.telran.domain_searcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// automatically creates one object
@Component
public class ConsoleListener implements ApplicationRunner {

    DomainChecker domainChecker;

    public ConsoleListener(/*automatically injects the object of DomainChecker*/@Autowired DomainChecker domainChecker) {
        this.domainChecker = domainChecker;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
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

package de.telran.hello_world;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class HelloWorld implements ApplicationRunner {

    String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello " + name);
    }
}

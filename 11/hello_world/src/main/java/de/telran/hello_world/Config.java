package de.telran.hello_world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${de.telran.name1}")
    String name1;

    @Value("${de.telran.name2}")
    String name2;

    @Bean
    public HelloWorld helloWorld1() {
        return new HelloWorld(name1);
    }

    @Bean
    public HelloWorld helloWorld2() {
        return new HelloWorld(name2);
    }
}

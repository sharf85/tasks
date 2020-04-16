package com.telran.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

//    @Bean
//    public ObjectMapper jacksonObjectMapper() {
//        return new ObjectMapper();
//                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//    }
}

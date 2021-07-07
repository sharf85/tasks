package de.telran.autoservice.config;

import de.telran.autoservice.entity.Auto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class AutoConfig {

    @Bean
    @Qualifier("simple")
    @Order(2)
    public Auto mazda() {
        return new Auto("Mazda", "red");
    }

    @Bean
    @Qualifier("simple")
    @Order(1)
    public Auto opel() {
        return new Auto("Opel", "grey");
    }

    @Bean
    public Auto bentley() {
        return new Auto("Bentley", "silver");
    }

}

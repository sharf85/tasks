package de.telran.autos.config;

import de.telran.autos.OrderFlow;
import de.telran.autos.entity.Auto;
import de.telran.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class Config {

    // this bean will be placed into the Application Context and its name is 'opel'
    @Bean
    @Qualifier("simpleAutos")
    @Order(2)
    public Auto opel() {
        return new Auto(1, "Opel", "grey", LocalDate.of(2015, 1, 1), 50000);
    }

    @Bean
    @Order(1)
    @Qualifier("simpleAutos")
    public Auto mazda() {
        return new Auto(2, "Mazda", "red", LocalDate.of(2018, 1, 15), 25000);
    }

    @Bean
    public Auto bentley() {
        return new Auto(3, "Bentley", "pink", LocalDate.of(2000, 6, 15), 5000);
    }

    @Bean
    public OrderFlow orderFlow(@Qualifier("simpleAutos") List<Auto> simpleAutos, Auto bentley, AutoService autoService) {
        return new OrderFlow(simpleAutos, bentley, autoService);
    }

}

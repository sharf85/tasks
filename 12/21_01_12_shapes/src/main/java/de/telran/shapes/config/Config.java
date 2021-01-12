package de.telran.shapes.config;

import de.telran.shapes.entity.Line;
import de.telran.shapes.entity.Picture;
import de.telran.shapes.entity.Rectangle;
import de.telran.shapes.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public Line line1() {
        return new Line('*', 40);
    }

    @Bean
    @Order(2)
    @Qualifier("shapes")
    public Line line2() {
        return new Line('%', 35);
    }

    @Bean
    @Order(1)
    @Qualifier("shapes")
    public Rectangle rectangle1() {
        return new Rectangle('+', 20, 30);
    }

    @Bean
    public Picture picture(@Qualifier("shapes") List<Shape> shapes) {
        return new Picture('0', shapes);
    }
}

package de.telran.shapes.config;

import de.telran.shapes.model.Line;
import de.telran.shapes.model.Picture;
import de.telran.shapes.model.Rectangle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
public class Config {

    @Bean
    @Qualifier("simpleShapes")
    @Order(2)
    public Rectangle rectangle() {
        return new Rectangle(20, 5, '#');
    }

    @Bean
    @Qualifier("simpleShapes")
    @Order(1)
    public Line line1() {
        return new Line(10, '*');
    }

    @Bean
    public Picture picture(Line line1, Rectangle rectangle) {
        return new Picture(Arrays.asList(line1, rectangle, line1));
    }

}

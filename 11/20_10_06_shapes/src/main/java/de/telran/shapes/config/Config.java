package de.telran.shapes.config;

import de.telran.shapes.model.Line;
import de.telran.shapes.model.Picture;
import de.telran.shapes.model.Rectangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config {

    @Bean
    public Line line1() {
        return new Line(10, '*');
    }

    @Bean
    public Rectangle rectangle() {
        return new Rectangle(20, 5, '#');
    }

    @Bean
    public Picture picture(Line line1, Rectangle rectangle) {
        return new Picture(Arrays.asList(line1, rectangle, line1));
    }

}

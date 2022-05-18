package com.example.shapes_spring.config;

import com.example.shapes_spring.model.Line;
import com.example.shapes_spring.model.Picture;
import com.example.shapes_spring.model.Rectangle;
import com.example.shapes_spring.model.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class Config {

    @Bean
    @Qualifier("picture1")
    @Order(1)
    public Line line1() {
        return new Line('*', 15);
    }

    @Bean
    @Qualifier("picture1")
    @Order(3)
    public Line line2() {
        return new Line('&', 8);
    }

    @Bean
    @Qualifier("picture2")
    @Order(1)
    public Line line3() {
        return new Line('^', 12);
    }

    @Bean
    @Order(2)
    @Qualifier("picture1")
    public Rectangle rectangle1() {
        return new Rectangle('+', 7, 3);
    }

    @Bean
    @Qualifier("picture2")
    @Order(2)
    public Rectangle rectangle2() {
        return new Rectangle('=', 3, 7);
    }

    @Bean
    public Picture picture1(@Qualifier("picture1") List<Shape> shapes) {
        return new Picture('!', shapes);
    }

    @Bean
    public Picture picture2(@Qualifier("picture2") List<Shape> shapes) {
        return new Picture('?', shapes);
    }


}

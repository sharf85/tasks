package de.telran.shapes.config;

import de.telran.shapes.entity.Line;
import de.telran.shapes.entity.Picture;
import de.telran.shapes.entity.Rectangle;
import de.telran.shapes.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ShapesConfiguration {

    @Bean
    @Qualifier("q_picture2")
    public Line line1() {
        return new Line('x', 20);
    }

    @Bean
    @Qualifier("q_picture")
    @Order(1)
    public Line line2() {
        return new Line('-', 32);
    }

    @Qualifier("q_picture")
    @Order(3)
    @Bean
    public Line line3() {
        return new Line('+', 17);
    }

    @Qualifier("q_picture")
    @Order(2)
    @Bean
    public Rectangle rectangle1() {
        return new Rectangle('=', 20, 30);
    }

    @Bean
    @Qualifier("q_picture2")
    public Rectangle rectangle2() {
        return new Rectangle('*', 30, 20);
    }

    @Bean
    public Picture picture(@Qualifier("q_picture") Shape[] shapes) {
        return new Picture('s', shapes);
    }

    @Bean
    public Picture picture2(@Qualifier("q_picture2") Shape[] shapes) {
        return new Picture('s', shapes);
    }

}

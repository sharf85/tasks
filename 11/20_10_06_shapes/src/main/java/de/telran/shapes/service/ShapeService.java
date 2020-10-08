package de.telran.shapes.service;

import de.telran.shapes.model.Shape;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeService {

    public void drawShapes(List<Shape> shapes) {
        System.out.println("--------------------");
        shapes.forEach(Shape::draw);
        System.out.println("--------------------");
    }
}

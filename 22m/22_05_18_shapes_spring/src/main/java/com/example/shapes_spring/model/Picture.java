package com.example.shapes_spring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Picture extends Shape {

    private final List<Shape> shapes;
    private final int maxWidth;

    public Picture(char symbol, List<Shape> shapes) {
        super(symbol);
        this.shapes = new ArrayList<>(shapes);
        maxWidth = shapes.stream()
                .mapToInt(Shape::getMaxWidth)
                .max()
                .orElse(0);
    }

    @Override
    public int getMaxWidth() {
        return maxWidth;
    }

    @Override
    public void draw() {
        drawBorder();
        shapes.forEach(Shape::draw);
        drawBorder();
    }

    private void drawBorder() {
        for (int i = 0; i < maxWidth; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}

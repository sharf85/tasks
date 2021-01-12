package de.telran.shapes.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Picture extends Shape {

    private static final int BORDER_LENGTH = 20;
    private final List<Shape> shapes;
    private final Line border;

    public Picture(char symbol, Collection<Shape> shapes) {
        super(symbol);

        this.shapes = new ArrayList<>(shapes);
        border = new Line(symbol, BORDER_LENGTH);
    }

    @Override
    public void draw() {
        border.draw();

        for (Shape shape : shapes) {
            shape.draw();
        }

        border.draw();
    }
}

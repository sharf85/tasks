package de.telran.shapes.model;

import java.util.Collections;
import java.util.List;

public class Picture implements Shape {

    private List<Shape> shapes;

    public Picture(List<Shape> shapes) {
        this.shapes = Collections.unmodifiableList(shapes);
    }

    /**
     * iterates over all the shapes and draws it
     */
    @Override
    public void draw() {

    }

    public List<Shape> getShapes() {
        return shapes;
    }
}

package com.telran.shape;

public class Picture extends Shape {

    Shape[] shapes;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
        System.out.println();
    }
}

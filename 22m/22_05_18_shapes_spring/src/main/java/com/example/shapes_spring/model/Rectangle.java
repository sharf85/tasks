package com.example.shapes_spring.model;

public class Rectangle extends Shape {

    private final int width;
    private final int height;
    private final Line line;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
        this.line = new Line(symbol, width);
    }

    @Override
    public int getMaxWidth() {
        return line.getMaxWidth();
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            line.draw();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

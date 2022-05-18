package com.example.shapes_spring.model;

public class Line extends Shape {
    private final int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public int getMaxWidth() {
        return 2 * length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
            System.out.print(" ");
        }

        System.out.println();
    }
}

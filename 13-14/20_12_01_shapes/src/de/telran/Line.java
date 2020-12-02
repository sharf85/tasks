package de.telran;

public class Line extends Shape {

    private int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {

    }

    public int getLength() {
        return length;
    }
}

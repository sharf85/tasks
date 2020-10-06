package de.telran.shapes.model;

public class Line implements Shape {
    private int length;
    private char symbol;

    public Line(int length, char symbol) {
        this.length = length;
        this.symbol = symbol;
    }

    @Override
    public void draw() {

    }

    public int getLength() {
        return length;
    }

    public char getSymbol() {
        return symbol;
    }
}

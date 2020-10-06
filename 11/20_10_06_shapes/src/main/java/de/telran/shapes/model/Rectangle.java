package de.telran.shapes.model;

public class Rectangle implements Shape {
    private int width;
    private int height;
    private char symbol;

    public Rectangle(int width, int height, char symbol) {
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    @Override
    public void draw() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getSymbol() {
        return symbol;
    }
}

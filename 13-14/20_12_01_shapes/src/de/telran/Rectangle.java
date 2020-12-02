package de.telran;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
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
}

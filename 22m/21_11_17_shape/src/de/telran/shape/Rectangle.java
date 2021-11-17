package de.telran.shape;

public class Rectangle extends Shape {

    final int width;
    final int height;
    final Line line;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
        line = new Line(symbol, width);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            line.draw();
        }
    }
}

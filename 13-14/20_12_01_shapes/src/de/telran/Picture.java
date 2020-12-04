package de.telran;

public class Picture extends Shape {

    private static final int BORDER_LENGTH = 30;

    private final Shape[] shapes;

    private final Line borderLine;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
        borderLine = new Line(symbol, BORDER_LENGTH);
    }

    @Override
    public void draw() {
        borderLine.draw();
        for (Shape shape : shapes) {
            shape.draw();
        }
        borderLine.draw();
    }
}

package de.telran.shapes.entity;

public class Rectangle extends Shape {

    private final int width;
    private final int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                buffer.append(symbol).append(" ");
            }
            buffer.append(System.lineSeparator());
        }

        System.out.print(buffer);
    }
}

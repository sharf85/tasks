package de.telran.shapes.entity;

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
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(symbol).append(" ");
            }
            builder.append(System.lineSeparator());
        }

        System.out.print(builder);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

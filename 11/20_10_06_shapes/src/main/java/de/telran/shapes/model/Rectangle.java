package de.telran.shapes.model;

public class Rectangle implements Shape {
    private int width;
    private int height;
    private char symbol;

    private String rectangleString;

    public Rectangle(int width, int height, char symbol) {
        this.width = width;
        this.height = height;
        this.symbol = symbol;

        rectangleString = initStringRectangle(width, height);
    }

    private String initStringRectangle(int width, int height) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(symbol).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public void draw() {
        System.out.print(rectangleString);
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

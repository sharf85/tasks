package de.telran;

public class Line extends Shape {

    private int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(symbol).append(" ");
        }

        System.out.println(builder);
    }

    public int getLength() {
        return length;
    }
}

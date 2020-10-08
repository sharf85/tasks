package de.telran.shapes.model;

import java.util.Arrays;

public class Line implements Shape {
    private int length;
    private char symbol;
    private String line;

    public Line(int length, char symbol) {
        this.length = length;
        this.symbol = symbol;

        char[] charsLine = new char[length];
        Arrays.fill(charsLine, symbol);
        line = new String(charsLine);
    }

    @Override
    public void draw() {
        System.out.println(line);
    }

    public int getLength() {
        return length;
    }

    public char getSymbol() {
        return symbol;
    }
}

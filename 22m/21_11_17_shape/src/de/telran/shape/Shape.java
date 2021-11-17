package de.telran.shape;

public abstract class Shape {

    final char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void draw();
}

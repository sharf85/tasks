package com.example.shapes_spring.model;

public abstract class Shape {

    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract int getMaxWidth();

    public abstract void draw();
}

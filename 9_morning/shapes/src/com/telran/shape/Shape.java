package com.telran.shape;

public abstract class Shape {

    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();
}

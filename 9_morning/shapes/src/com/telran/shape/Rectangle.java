package com.telran.shape;

public class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i > 0 && i < height - 1 && j > 0 && j < width - 1) {
                    System.out.print("  ");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }
}

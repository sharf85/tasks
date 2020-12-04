package de.telran;

public class Main {

    public static void main(String[] args) {

        Shape line1 = new Line('-', 15);
        Shape rectangle1 = new Rectangle('*', 10, 5);

        Shape[] shapes = {line1, rectangle1};

        Shape picture1 = new Picture('=', shapes);

        Shape picture2 = new Picture('+', new Shape[]{line1, picture1});

        picture2.draw();
    }
}

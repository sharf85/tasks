package de.telran;

public class Main {

    public static void main(String[] args) {

        Line line1 = new Line('-', 15);
        Rectangle rectangle1 = new Rectangle('*', 20, 20);

        Shape[] shapes = {line1, rectangle1};

        Picture picture1 = new Picture('=', shapes);
    }
}

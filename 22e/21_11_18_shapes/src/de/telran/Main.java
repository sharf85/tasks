package de.telran;

import de.telran.shape.Line;
import de.telran.shape.Picture;
import de.telran.shape.Rectangle;
import de.telran.shape.Shape;

public class Main {

    public static void main(String[] args) {
        Shape line1 = new Line('+', 5);
        Shape line2 = new Line('-', 10);
        Shape rectangle = new Rectangle('*', 5, 3);
        Shape picture1 = new Picture('1', new Shape[]{line1, rectangle});
        Shape picture2 = new Picture('2', new Shape[]{line2, picture1});

        picture2.draw();
    }
}

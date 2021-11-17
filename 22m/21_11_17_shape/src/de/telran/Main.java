package de.telran;

import de.telran.shape.Line;
import de.telran.shape.Picture;
import de.telran.shape.Rectangle;
import de.telran.shape.Shape;

public class Main {

    public static void main(String[] args) {

        Shape line1 = new Line('x', 5);
        Shape line2 = new Line('+', 25);
        Shape rectangle = new Rectangle('-', 3, 3);

        Shape picture1 = new Picture('1', new Shape[]{line1, rectangle});

        Shape[] picture2Shapes = new Shape[]{line2, picture1};
        Shape picture2 = new Picture('2', picture2Shapes);
//        picture2.draw();

        picture2Shapes[1] = line1;
        picture2.draw();
    }
}

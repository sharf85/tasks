package com.telran;

import com.telran.shape.Line;
import com.telran.shape.Picture;
import com.telran.shape.Rectangle;
import com.telran.shape.Shape;

public class Application {

    public static void main(String[] args) {

        Shape line1 = new Line('a', 15);
        Shape line2 = new Line('o', 20);
        Shape rectangle = new Rectangle('+', 10, 4);

        Shape picture1 = new Picture('-', new Shape[]{line1, rectangle});

        Shape picture2 = new Picture('0', new Shape[]{line2, picture1});

        picture2.draw();
    }
}

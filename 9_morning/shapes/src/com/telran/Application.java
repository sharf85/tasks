package com.telran;

import com.telran.shape.Line;
import com.telran.shape.Picture;
import com.telran.shape.Rectangle;
import com.telran.shape.Shape;

public class Application {

    public static void main(String[] args) {

        Shape line = new Line('#', 10);
        Shape rectangle1 = new Rectangle('*', 10, 20);
        Shape rectangle2 = new Rectangle('1', 1, 1);
        Shape picture1 = new Picture('@', new Shape[]{line, rectangle1});
        Shape line1 = new Line('5', 20);

        Shape picture2 = new Picture('o', new Shape[]{picture1, line1, rectangle2});

        picture2.draw();
    }
}

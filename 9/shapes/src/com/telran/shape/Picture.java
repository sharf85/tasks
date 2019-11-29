package com.telran.shape;

public class Picture extends Shape {

    private Shape[] shapes;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    public void draw() {
        for (int i = 0; i < 50; i++) {
            System.out.print(getSymbol());
        }

        System.out.println();

        for (Shape shape : shapes) {
            shape.draw();
        }
        System.out.println();

//        for (int i = 0; i < shapes.length; i++) {
//            shapes[i].draw();
//        }
    }
}

package de.telran.shape;

public class Picture extends Shape {

    private static final int BORDER_WIDTH = 30;

    Shape[] shapes;
    Line border;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
        border = new Line(symbol, BORDER_WIDTH);
    }

    @Override
    public void draw() {
        border.draw();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
        border.draw();
    }
}

package de.telran.shape;

public class Picture extends Shape {

    private final static int BORDER_LENGTH = 30;

    private final Shape[] shapes;
    final Line line;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);

//        this.shapes = shapes;
        this.shapes = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            this.shapes[i] = shapes[i];
        }

        line = new Line(symbol, BORDER_LENGTH);
    }

    @Override
    public void draw() {
        line.draw();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
        line.draw();
    }
}

package de.telran.book;

public class Bestseller extends LiteratureBook {

    private final double coef;

    public Bestseller(int id, String title, String author, int price, double coef) {
        super(id, title, author, price);
        this.coef = coef;
    }

    @Override
    public int computePrice() {
        return (int) (super.computePrice() * coef);
    }

    public double getCoef() {
        return coef;
    }
}

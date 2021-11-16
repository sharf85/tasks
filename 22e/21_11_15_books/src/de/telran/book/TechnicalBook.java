package de.telran.book;

public class TechnicalBook extends Book {

    private final String scientificField;

    public TechnicalBook(int id, String title, String author, int price, String scientificField) {
        super(id, title, author, price);
        this.scientificField = scientificField;
    }

    public String getScientificField() {
        return scientificField;
    }

    @Override
    public int computePrice() {
        return getPrice();
    }
}

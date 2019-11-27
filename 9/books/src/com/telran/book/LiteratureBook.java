package com.telran.book;

public class LiteratureBook extends Book {
    public LiteratureBook(int id, String title, String author, int price) {
        super(id, title, author, price);
    }

    @Override
    public int computePrice() {
        return getPrice() + 10;
    }

}

package de.telran.book;

// Абстрактный класс - это класс, который не подразумевает создания собственных представителей (объектов данного класса).
public abstract class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int price;

    public Book(int id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    // must be implemented in every non-abstract subclass
    public abstract int computePrice();
}

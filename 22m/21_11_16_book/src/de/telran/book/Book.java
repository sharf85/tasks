package de.telran.book;

// Абстрактный класс - это такой класс, который не подразумевает создания собственных представителей (создание объектов этого класса)
// абстрактный метод в абстрактном классе - это метод, не имеющий тела, который необходимо переопределить в каждом дочернем
// НЕАБСТРАКТНОМ классе
public abstract class Book {
    private final int id;
    private final String title;
    private final String author;
    private int price;

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

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract int computePrice();
}

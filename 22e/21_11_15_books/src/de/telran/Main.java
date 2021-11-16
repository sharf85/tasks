package de.telran;

import de.telran.book.Bestseller;
import de.telran.book.Book;
import de.telran.book.LiteratureBook;
import de.telran.book.TechnicalBook;

public class Main {

    public static void main(String[] args) {

        Book mathBook = new TechnicalBook(1, "Algebra", "Ivan Ivanov", 50, "Mathematics");
        LiteratureBook litBook = new LiteratureBook(2, "The littele prince", "Sent Exupery", 30);
        Book harry = new Bestseller(3, "Harry Potter I", "J.K. Rowling", 30, 3);

        Book[] books = {mathBook, litBook, harry};

        for (int i = 0; i < books.length; i++) {
            String description = describeBook(books[i]);
            System.out.println(description);
        }

        System.out.println(describeBook(litBook));
    }

    // Полиморфизм - это возможность применять один и тот же метод у объектов различных классов, связанных общим родителем (супер классом).
    static String describeBook(Book book) {
        return "The book was written by " + book.getAuthor() + ". It's called " + book.getTitle() + ". The book costs " + book.computePrice();
    }
}

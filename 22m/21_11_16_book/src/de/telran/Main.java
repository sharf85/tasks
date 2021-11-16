package de.telran;

import de.telran.book.Bestseller;
import de.telran.book.Book;
import de.telran.book.LiteratureBook;
import de.telran.book.TechnicalBook;

public class Main {

    public static void main(String[] args) {

        Book litBook = new LiteratureBook(1, "The little prince", "Sent Exupery", 50);
        Bestseller harry = new Bestseller(2, "Harry Potter", "J. K. Rowling", 30, 5);
        Book mathBook = new TechnicalBook(3, "Algebra and Numeric Theory", "Unknown", 20, "Mathematics");

        Book[] books = {litBook, harry, mathBook};

        for (int i = 0; i < books.length; i++) {
            System.out.println(describeBook(books[i]));
        }

        String description = describeBook(harry);
    }

    //  Полиморфизм - это возможность применять один и тот же метод у объектов различных типов (классов), связанных
    // связанных общим родителем (этот метод существует в родительском классе)
    private static String describeBook(Book book) {
        return "The book is called " + book.getTitle() + ". It was written by " + book.getAuthor() + ". The price is " + book.computePrice();
    }
}

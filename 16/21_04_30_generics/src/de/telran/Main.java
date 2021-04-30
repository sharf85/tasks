package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product<Integer> opel = new Product<>(1, "Opel", 500);
        Product<String> macbook = new Product<>("apple_id1", "macbook", 600);

        String macbookId = macbook.getId();
        int opelId = opel.getId();

        System.out.println(macbookId);
        System.out.println(opelId);

// old approach before generics
        List strings = new ArrayList();

        strings.add("str1");
        strings.add("str2");
        strings.add("str3");
        strings.add("str4");

        String lastStr = (String) strings.get(3);

        strings.add(5);

        lastStr = (String) strings.get(4);// causes exception

    }
}

class Product<T> {
    T id;
    String name;
    double price;

    public Product(T id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

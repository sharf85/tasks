package de.telran;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        OurArrayList<String> strings = new OurArrayList<>();

        // down casting
//        ArrayList anotherStrings = (ArrayList) strings;


        strings.addLast("Vasya");
        strings.addLast("Petya");
        strings.addLast("Alisa");

        // non static nested class
        // every instance of ForwardIterator is dependant on an instance of OurArrayList,
        // which is 'strings' in our case
        Iterator<String> iterator = strings.forwardIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // static nested class
        iterator = strings.backwardIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        String res = "";

        for (int i = 0; i < strings.size(); i++) {
            res += strings.get(i);
        }

        // Iterable - перебираемое (что-то, что можно перебрать)
        for (String str : strings) {
            System.out.println(str);
        }
        // equivalent to:
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            System.out.println(str);
        }

        List<Product> products = Arrays.asList(
                new Product(100),
                new Product(50),
                new Product(70)
        );

        //
        Comparator<Product> priceComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.price - o2.price;
            }
        };

        products.sort(priceComparator);

    }
}

class Product {
    int price;
    long timestamp;

    public Product(int price) {
        this.price = price;
        this.timestamp = System.currentTimeMillis();
    }

    public double getPrice() {
        return price;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

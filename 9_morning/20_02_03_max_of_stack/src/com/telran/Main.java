package com.telran;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        MaxStack<Auto> autos = new MaxStack<>(new DateComparator());
//        MaxStack<Auto> autos = new MaxStack<>();

        Auto citroen = new Auto("Citroen", "C4", 2010);
        Auto opel = new Auto("Opel", "Astra", 2012);
        Auto nissan = new Auto("Nissan", "X-Trail", 2018);

        autos.addLast(citroen);
        autos.addLast(opel);
        autos.addLast(nissan);

        System.out.println(autos.getMax());

    }
}

class Auto implements Comparable<Auto> {
    String brand;
    String model;
    int date;

    public Auto(String brand, String model, int date) {
        this.brand = brand;
        this.model = model;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Auto other) {
        if (brand.compareTo(other.brand) < 0)
            return -1;
        else if (brand.compareTo(other.brand) > 0)
            return 1;

        if (model.compareTo(other.model) < 0)
            return -1;
        else if (model.compareTo(other.model) > 0)
            return 1;

        return date - other.date;
    }
}

class BrandLexicographicalComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

class DateComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
//        return o1.date - o2.date;
        return Integer.compare(o1.date, o2.date);
    }
}

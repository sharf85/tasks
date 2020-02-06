package com.telran;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        MaxStack<Auto> autoStack = new MaxStack<>();
//        MaxStack<Auto> autoStack = new MaxStack<>(new BrandAutoComparator());

        Auto citroen = new Auto("Citroen", "C4", 2010);
        Auto opel = new Auto("Opel", "Astra", 2012);
        Auto opelZafira = new Auto("Opel", "Zafira", 2012);
        Auto nissan = new Auto("Nissan", "X-Trail", 2018);

        autoStack.addLast(citroen);
        autoStack.addLast(opelZafira);
        autoStack.addLast(opel);
        autoStack.addLast(nissan);

        System.out.println(autoStack.max());
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
        int res = brand.compareTo(other.brand);
        if (res != 0)
            return res;

        res = model.compareTo(other.model);
        if (res != 0)
            return res;

        return date - other.date;
    }
}

class BrandAutoComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

class DateAutoComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.date - o2.date;
    }
}

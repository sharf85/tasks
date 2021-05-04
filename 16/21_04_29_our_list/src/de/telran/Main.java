package de.telran;

public class Main {
    public static void main(String... args) {
        OurList<String> list = new OurArrayList<>();

        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        list.add("hello");

        System.out.println(list.contains(new String("hello")));

        for (String line : list) {
            System.out.println(line);
        }
    }
}

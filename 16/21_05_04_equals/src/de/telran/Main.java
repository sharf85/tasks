package de.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Auto opel = new Auto("Opel", "grey");

        List<Auto> autos = fillList();

        System.out.println(autos.contains(opel));
    }

    public static List<Auto> fillList() {
        List<Auto> res = new ArrayList<>();
        res.add(new Auto("Opel", "grey"));
        res.add(new Auto("Mazda", "red"));
        return res;
    }
}

class Auto {
    String make;
    String color;

    public Auto(String make, String color) {
        this.make = make;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        // the implementation does not consider edge cases such as null fields etc.
        if (!(o instanceof Auto))
            return false;

        Auto other = (Auto) o;
        return this.make.equals(other.make) && this.color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, color);
    }
}

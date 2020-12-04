package de.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<Auto> autos = createAutos();

        Auto opel = new Auto("Opel", "grey");
        autos.remove(opel);

        for (Auto auto : autos) {
            System.out.println(auto.color + " " + auto.brand);
        }
    }

    private static List<Auto> createAutos() {
        List<Auto> result = new ArrayList<>();
        Auto opel = new Auto("Opel", "grey");
        Auto mazda = new Auto("Mazda", "red");
        result.add(opel);
        result.add(mazda);
        return result;
    }
}

class Auto {
    String brand;
    String color;

    public Auto(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Auto))
//            return false;
//
//        Auto otherAuto = (Auto) obj;
//        return this.brand.equals(otherAuto.brand)
//                && this.color.equals(otherAuto.color);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return Objects.equals(brand, auto.brand) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }
}

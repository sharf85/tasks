package de.telran;

import java.util.Arrays;
import java.util.List;

public class ListContainsExample {
    public static void main(String[] args) {
        List<Auto> autos = composeAutos();
        Auto bentleyInMain = new Auto("Bentley", 2010, "Silver");

        System.out.println(autos.remove(bentleyInMain));
    }

    static List<Auto> composeAutos() {
        Auto opel = new Auto("Opel", 2012, "Grey");
        Auto mazda = new Auto("Mazda", 2015, "Red");
        Auto bentley = new Auto("Bentley", 2010, "Silver");

        return Arrays.asList(opel, mazda, bentley);
    }
}

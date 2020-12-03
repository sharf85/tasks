package de.telran;

public class Main {

    public static void main(String[] args) {

        Auto opel = new Auto("Opel", "grey");
        switchAuto(opel);
        System.out.println(opel.brand);//Opel
        System.out.println(opel.color);//Green
    }

    private static Auto switchAuto(Auto auto) {
        auto.color = "Green";

        auto = new Auto("Mazda", "red");
        auto.color = "purple";
        return auto;
    }
}

class Auto {
    String brand;
    String color;

    public Auto(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
}

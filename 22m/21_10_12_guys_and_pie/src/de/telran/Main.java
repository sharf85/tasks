package de.telran;

public class Main {

    public static void main(String[] args) {
        double mashaAtePie = 0.5;
        double petyaAtePie = mashaAtePie / 2;
        double vasyaAtePie = (mashaAtePie + petyaAtePie) * 4;
        double totalAtePie = mashaAtePie + petyaAtePie + vasyaAtePie;
        System.out.println("The guys ate " + totalAtePie + " pie in total");
    }
}

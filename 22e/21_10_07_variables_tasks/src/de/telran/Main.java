package de.telran;

public class Main {

    public static void main(String[] args) {
        // Masha ate 2.5 apples, Petya ate 3.5 apples. How many apples did they eat together?
        double mashaAppleAteNumber = 2.5;
        double petyaAppleAteNumber = 3.5;
        double totalAppleAteNumber = mashaAppleAteNumber + petyaAppleAteNumber;
        System.out.println("They ate " + totalAppleAteNumber + " in total");

        // Masha ate 1/2 of a pie, Petya ate twice less than Masha, Vasya ate 4 times more than Masha and Petya ate together.
        // How much did they eat all together?

        double mashaPieAteAmount = 1d / 2;
        double petyaPieAteAmount = mashaPieAteAmount / 2;
        double vasyaPieAteAmount = (mashaPieAteAmount + petyaPieAteAmount) * 4;

        double pieAteInTotal = mashaPieAteAmount + petyaPieAteAmount + vasyaPieAteAmount;
        System.out.println("They ate " + pieAteInTotal + " pie in total");
    }
}

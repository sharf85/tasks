package de.telran;

public class Main {

    public static void main(String[] args) {
        printVasyaAction(2, 25);
        printVasyaAction(6, 20);
        printVasyaAction(6, 25);
        printVasyaAction(7, 20);
        printVasyaAction(7, -7);
    }

    static void printVasyaAction(int dayOfWeek, int temperature) {
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Uncle Vasya works");
                break;
            case 6:
                if (temperature >= 23 && temperature <= 29) {
                    System.out.println("Uncle Vasya fishes");
                } else {
                    System.out.println("Mr Vasya does nothing");
                }
                break;
            case 7:
                if (temperature <= -5) {
                    System.out.println("Uncle Vasya goes to the neighbours sauna");
                } else {
                    System.out.println("Mr Vasya does nothing");
                }
                break;
        }
    }
}

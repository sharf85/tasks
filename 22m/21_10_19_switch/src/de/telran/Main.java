package de.telran;

public class Main {

    public static void main(String[] args) {

        int dayOfWeek = 5;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("No such a day in a week");
                break;
        }


        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Working day");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }
}

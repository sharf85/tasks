package de.telran;

public class Main {

    public static void main(String[] args) {
        printDayOfWeek(3);//
    }

    static void printDayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
//                System.out.println("The day of week is Monday");
//                break;
            case 2:
//                System.out.println("The day of week is Tuesday");
//                break;
            case 3:
//                System.out.println("The day of week is Wednesday");
//                break;
            case 4:
//                System.out.println("The day of week is Thursday");
//                break;
            case 5:
//                System.out.println("The day of week is Friday");
                System.out.println("Today is a working day");
                break;
            case 6:
                System.out.println("The day of week is Saturday");
                break;
            case 7:
                System.out.println("The day of week is Sunday");
                break;
            default:
                System.out.println("No such a day of week");
                break;
        }
    }
}

package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    // Дядя Вася пойдет на рыбалку в субботу, если температура ваздуха будет от 23 до 29 включительно.
    // На буднях он ходит на работу. А в воскресенье он пойдет к соседу в баню, если температура воздуха будет не выше -5.
    // Написать функцию, которая принимает номер дня недели (1 - 7) и температуру, и распечатывает в консоль поведение дяди Васи.
    static void printVasyaAction(int dayOfWeek, int temperature) {
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Uncle Vasya goes working");
                break;
            case 6:
                if (temperature >= 23 && temperature <= 29) {
                    System.out.println("Uncle Vasya goes fishing");
                } else {
                    System.out.println("Uncle Vasya does not go fishing on Saturday");
                }
                break;
            case 7:
                if (temperature <= -5) {
                    System.out.println("Uncle Vasya goes to the neighbour's sauna");
                } else {
                    System.out.println("Uncle Vasya does not go to the neighbour's sauna on Sunday");
                }
                break;
            default:
                System.out.println("No such a day of week");
                break;
        }
    }
}

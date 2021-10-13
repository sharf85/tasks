package de.telran;

public class Main {

    public static void main(String[] args) {
    }

    /**
     * Дядя Вася пойдет на рыбалку в субботу, если температура ваздуха будет от 23 до 29 включительно.
     * На буднях он ходит на работу. А в воскресенье он пойдет к соседу в баню, если температура воздуха будет не выше -5.
     * Написать функцию, которая принимает номер дня недели (1 - 7) и температуру, и распечатывает в консоль поведение дяди Васи.
     *
     * @param dayOfWeek   is always between 1 and 7
     * @param temperature
     */
    static void printVasyaAction(int dayOfWeek, int temperature) {
        if (dayOfWeek <= 5) {
            System.out.println("Uncle Vasya goes working");
        } else if (dayOfWeek == 6) {
            if (temperature >= 23 && temperature <= 29)
                System.out.println("Uncle Vasya goes fishing");
        } else if (dayOfWeek == 7) {
            if (temperature <= -5)
                System.out.println("Uncle Vasya goes to his neighbour to have sauna");
        }
    }
}

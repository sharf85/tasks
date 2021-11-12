package de.telran;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 10;
        array[1] = 5;
        array[2] = 20;


        AdvancedIntArray advancedIntArray = new AdvancedIntArray(3);
        advancedIntArray.set(0, 10);
        advancedIntArray.set(1, 5);
        advancedIntArray.set(2, 20);

        advancedIntArray.println();

        advancedIntArray.append(99);
        advancedIntArray.println();

        advancedIntArray.delete(2);//{10, 5, 99}
        advancedIntArray.println();
    }
}

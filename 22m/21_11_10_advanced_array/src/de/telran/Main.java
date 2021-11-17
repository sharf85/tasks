package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int[] array = {10, 8, 23};

        int elt = array[1];//8
        array[2] = 239;
        int length = array.length;

        AdvancedIntArray advancedIntArray = new AdvancedIntArray(3);
        advancedIntArray.set(0, 10);
        advancedIntArray.set(1, 8);
        advancedIntArray.set(2, 23);

        int elt2 = advancedIntArray.get(1);
        advancedIntArray.set(2, 239);
        int length2 = advancedIntArray.size();

        advancedIntArray.append(500);//{10, 8, 239, 500}
        System.out.println(advancedIntArray.get(3));//500

        advancedIntArray.delete(1);//{10, 239, 500}
        advancedIntArray.insert(2, 20);//{10, 239, 20, 500}
        advancedIntArray.println();

        System.out.println(advancedIntArray.contains(239));//true
    }
}

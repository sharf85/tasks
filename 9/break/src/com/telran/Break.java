package com.telran;

public class Break {

    public static void main(String[] args) {
        System.out.println(getClosestNumber(1));
    }

    /**
     * The function returns the closest number, which is larger than start and
     * divided by 11, 13, 17
     *
     * @param start
     * @return int
     */
    static int getClosestNumber(int start) {
        int res = start;
        while (true) {
            if (res % 11 == 0 && res % 13 == 0 && res % 17 == 0) {
                break;
            }
            res++;
        }
        return res;
    }
}

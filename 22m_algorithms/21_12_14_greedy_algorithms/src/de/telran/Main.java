package de.telran;

public class Main {

    /**
     * @param l            the length of the way
     * @param fuelStations the points for refueling (km from the start)
     * @param maxDistance  the distance which is reachable by one refueling
     * @return number of stops for refueling
     */
    //(950, {200, 375, 550, 750})
    // TODO implement
    public int getFuelingNumber(int l, int maxDistance, int[] fuelStations) {

    }

    /**
     * The method must return the min possible number of segment of the length l, so that all the numbers are covered
     * by these segments
     *
     * @param numbers an array of sorted numbers
     * @param l       the length of the segments
     * @return
     */
    public int getSegmentNumber(int[] numbers, int l) {
        int leftSegmentEnd = numbers[0];
        int i = 0;
        while (i < numbers.length) {
            //написать цикл, который обходит все точки, начиная с i-той, которые залезают в отрезок длины l с началом в leftSegmentEnd
        }
    }

    /**
     * Compose the money from the coins 1, 5, 10 cent, so that the number of coins is min possible
     *
     * @param money the amount of money to compose
     * @return the min possible number of coins, which compose the (amount of) money
     */

    // 23 -> 10 + 10 + 1 + 1 + 1
    public int exchangeMoney(int money) {

    }
}

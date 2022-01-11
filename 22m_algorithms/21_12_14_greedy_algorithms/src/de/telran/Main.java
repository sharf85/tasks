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

        int[] points = new int[fuelStations.length + 2];

        points[0] = 0;
        points[points.length - 1] = l;

        System.arraycopy(fuelStations, 0, points, 1, fuelStations.length);

        int res = 0;
        int startingPosition = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i] > startingPosition + maxDistance) {
                res++;
                startingPosition = points[i - 1];
            }
        }
        return res;
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
        int res = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > leftSegmentEnd + l) {
                res++;
                leftSegmentEnd = numbers[i];
            }
        }
        return res;
    }

    /**
     * Compose the money from the coins 1, 5, 10 cent, so that the number of coins is min possible
     *
     * @param money the amount of money to compose
     * @return the min possible number of coins, which compose the (amount of) money
     */

    // 23 -> 10 + 10 + 1 + 1 + 1
    public int exchangeMoney(int money) {
        int res = money / 10;//the number of coins of the value 10
        int rest = money % 10;//the money to split with 5 and 1 value coins

        res += rest / 5;
        rest = rest % 5;

        res += rest;
        return res;
    }
}

package com.telran;

public class Task {

    public int solve(int number) {
        int numberSum = countDigitsSum(number);

        int res = number;
        while (countDigitsSum(++res) != numberSum) ;

        return res;
    }

    private int countDigitsSum(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }


}

package com.telran;

public class Casino {

    /**
     * the method finds the least number of steps needed to reach
     * N dollars from 1 dollar, if by one step Vasya can either
     * add 1 dollar or double his current balance
     *
     * @param N > 0, the balance to reach
     * @param M >=0, max number of doubling the balance
     * @return min possible number of steps
     */
    public int getNumberOptimalSteps(int N, int M) {
        if (N == 1)
            return 0;

        if (N % 2 == 0 && M > 0)
            return 1 + getNumberOptimalSteps(N / 2, M - 1);
        return 1 + getNumberOptimalSteps(N - 1, M);
    }
}

package com.telran;

import java.util.Arrays;

public class Task {
    public int solve(int A[], int B[]) {
        long sumA = Arrays.stream(A).mapToLong(num -> num).sum();
        long sumB = Arrays.stream(B).mapToLong(num -> num).sum();

        if (sumA != sumB || sumA % 2 != 0)
            return 0;

        int range = A.length - 1;

        long sumLeftA = 0;
        long sumLeftB = 0;

        int res = 0;
        for (int i = 0; i < range; i++) {
            sumLeftA += A[i];
            sumLeftB += B[i];

            if (sumLeftA == sumLeftB && sumLeftA == sumA - sumLeftA)
                res++;
        }
        return res;
    }
}

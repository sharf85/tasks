package com.telran;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(0));//0
        System.out.println(fib(1));//1
        System.out.println(fib(2));//1
        System.out.println(fib(3));//2
        System.out.println(fib(4));//3
        System.out.println(fib(5));//5

        System.out.println(fib(20));


        System.out.println(fibViaArray(0));//0
        System.out.println(fibViaArray(1));//1
        System.out.println(fibViaArray(2));//1
        System.out.println(fibViaArray(3));//2
        System.out.println(fibViaArray(4));//3
        System.out.println(fibViaArray(5));//5

        System.out.println(fibViaArray(20));

        int[][] array = new int[][]{{1, 0, 9, 10, 15}, {1, 4, 5}};
    }

    static long fib(int n) {
        int current = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int newFib = current + next;
            current = next;
            next = newFib;
        }
        return current;
    }

    static long fibViaArray(int n) {
        long[] cache = new long[n + 1];

        if (n < 2)
            return n;

        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }
}

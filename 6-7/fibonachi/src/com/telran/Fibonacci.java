package com.telran;

public class Fibonacci {
    public int reminder(int n, int m) {

        int current = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int newFib = (current + next) % m;
            current = next;
            next = newFib;
        }
        return current;
    }
}

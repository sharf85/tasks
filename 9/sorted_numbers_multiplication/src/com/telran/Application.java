package com.telran;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // write your code here
    }

    // O(n*log(n)), n - length of nums
    public static boolean isMultiplication(List<Integer> nums, int N) {
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (N % num == 0) {
                int mul = N / num;
                if (Collections.binarySearch(nums, mul) >= 0)
                    return true;
            }
        }
        return false;
    }

    // O(n*n), n - length of nums
    public static boolean isMultiplication2(List<Integer> nums, int N) {
        for (int i = 0; i < nums.size(); i++) {
            int mul1 = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                int mul2 = nums.get(j);
                if (mul1 * mul2 == N)
                    return true;
            }
        }
        return false;
    }

    public static boolean isMultiplication3(List<Integer> nums, int N) {
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        for (int num : nums) {
//            if (N % num == 0)
//                q.add(num);
//        }


        ArrayDeque<Integer> q = new ArrayDeque<>(nums);

        while (q.size() > 1) {
            if (q.getFirst() * q.getLast() > N)
                q.removeLast();
            else if (q.getFirst() * q.getLast() < N)
                q.removeFirst();
            else
                return true;
        }
        return false;
    }
}

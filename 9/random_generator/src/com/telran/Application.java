package com.telran;

import com.telran.random.MaxRule;
import com.telran.random.RandomGenerator;
import com.telran.random.RandomRule;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        RandomRule rule = new MaxRule(Integer.MAX_VALUE);
        RandomGenerator toMaxGenerator = new RandomGenerator(rule);

        int[] randoms = toMaxGenerator.nextN(10);
        System.out.println(Arrays.toString(randoms));
    }
}

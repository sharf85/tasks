package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        int[] javaArray = new int[]{1, 3, -8};

        Array ourArray = new Array(javaArray);

        System.out.println(ourArray.get(0));//1
        System.out.println(ourArray.get(1));//3
        System.out.println(ourArray.get(2));//-8

        System.out.println(ourArray.size());//3

        System.out.println(ourArray.toString());
    }
}

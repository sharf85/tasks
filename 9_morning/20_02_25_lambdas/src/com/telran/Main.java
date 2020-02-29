package com.telran;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> identity2 = new IdentityFunction<>();

        System.out.println(multiplyByTwo.apply(5));
        System.out.println(identity2.apply(6));
    }
}

class IdentityFunction<T> implements Function<T, T> {

    @Override
    public T apply(T t) {
        return t;
    }
}

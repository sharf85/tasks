package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(10);
        list.add("hello");

        List<String> stringList = new ArrayList<>();
        stringList.add("hello");

        List<Integer> anotherList = new ArrayList(list);
        Integer first = anotherList.get(0);
        Integer second = anotherList.get(1);

        List someList = new ArrayList();
        int someValue = (int) someList.get(0);

    }
}

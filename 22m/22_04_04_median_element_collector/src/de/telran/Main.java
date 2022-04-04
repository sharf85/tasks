package de.telran;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // Необходимо реализовать коллектор, который будет выдавать медианный элемент стрима Integers
    // {5, 0, 15} -> {0, 5, 15} -> 5
    // {5, 0, 15, -10, -17} -> {-17, -10, 0, 5, 15} -> 0
    // {5, 0, 15, -10, -17, 239} -> {-17, -10, 0, 5, 15, 239} -> 2.5
    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.of(-17, -10, 0, 5, 15, 239);
        Collector<Integer, List<Integer>, Double> medianElementCollector = new MedianElementCollector();
        double median = intStream.collect(medianElementCollector);
        System.out.println(median);
    }
}

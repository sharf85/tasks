package de.telran;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Стримы это инструмент для обработки последовательности данных в более функциональном стиле.
        // Стрим не является коллекцией, он работает с элементами из источника.
        // Stream<T>, IntStream, LongStream, DoubleStream
        // 1. Создание стримов.
        // - collection.stream()
        // - Stream<Double> stream = Arrays.stream(new Double[]{23d, 100d});
        // - IntStream stream = str.chars();
        // - LongStream stream = LongStream.of(100, 234, 5)
        //   Stream<Long> longStream = Stream.of(100L, 34L, 5L);
        // - Stream<Integer> stream = Stream.concat(stream1, stream2);
        // - Stream.generate(supplier), Stream.generate(Math::random)
        // - IntStream intStream = IntStream.iterate(1, x -> 3 * x - 10);
        // - IntStream.range(0, 10) - стрим с источником, состоящим из int чисел от 0 до 9 включительно
        // - IntStream.rangeClosed(0, 10) - стрим с источником, состоящим из int чисел от 0 до 10 включительно

        LongStream stream = LongStream.of(100, 234, 5);
        Stream<Long> longStream = Stream.of(100L, 34L, 5L);

        // 2. Виды операций (методов) стрима.
        // - Intermediate (промежуточные)
        // - Terminal (терминальные)

        // a) Промедуточные операции - операции, которые возвращают новый стрим, добавляя к последовательности
        // его операций еще одну, не запуская вычисления.
        // - filter(predicate) - отбрасывает те данные, predicate.test() от которых даст false
        // - map(function) - возвращает новый стрим, получаенный из старого путем применения function.apply() к
        // его элементам
        // - limit(N) - возвращает новый стрим, состоящий из первых N элементов из старого стрима
        // - skip(N) - возвращает новый стрим, состоящий из элементов из старого стрима, следющих после первых
        // N элементов
        // - distinct() - возвращает новый стрим без повторяющихся элементов из первого стрима
        // - sorted() - возвращает стрим с отсортированными элементами старого стрима. Если элементы Comparable,
        // можно испоьзовать без Comparator.
        // flatMap(Function<T, Stream<E>>)

        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1, 5, 8),
                Arrays.asList(-5, 7),
                Arrays.asList(10, 50, -8)
        );

        Function<List<Integer>, Stream<Integer>> unwrap = (list) -> list.stream();
        System.out.println(listStream.flatMap(unwrap).collect(Collectors.toList()));

        // b) Терминальные операции - операции, которые запускают последовательность промежуточных операций и возвращают результат
        // - collect(collector)
        // - toArray() - превращает стрим в массив
        // - max()/min() - находит максимум/минимум (для общего стрима нужен компаратор)
        // - count() - возвращает количество элементов в стриме
        // - forEach(consumer) - проходит по всем элементам из стрима и применяет к каждому consumer.accept(t)
        stream.forEach(System.out::println);
        // - reduce() комбинирует элементы из стрима
//        System.out.println(longStream.reduce((Long x, Long y) -> x + y));
        System.out.println(longStream.reduce(10L, (Long x, Long y) -> x + y));
        // anyMatch(predicate), allMatch(predicate), noneMatch(predicate) - возвращает да или нет
        // Пример:
        // Есть коллекция строк. Хотим составить строку, состоящую из всех слов короче 5 букв, в uppercase, каждое слово
        // встречается один раз.

        List<String> words = Arrays.asList("Hello", "word", "and", "Vasya", "in", "the", "word");

        String res = words.stream()
                .filter(word -> word.length() < 5)
                .map(String::toUpperCase)
                .distinct()
                .reduce("", (accumulated, currentElement) -> accumulated + currentElement);
        System.out.println(res);
    }
}

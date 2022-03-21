package de.telran;

import java.util.function.*;

public class Main {

    static String GREETINGS = "Hello";

    public static void main(String[] args) {
        // Method reference (ссылка на метод) - это реализация функционального интерфейса,
        // используя функциональность существующего метода

        Function<Double, Double> sqrt = Math::sqrt;

        Function<Double, Double> sqrt2 = sqrt::apply;

        Supplier<String> generator = String::new;

        Function<String, String> identity = String::new;

        // closure (замукание) - возможность использовать переменные из контекста (области видимости)
        // в лямбда выражении

        // локальная переменная должна быть либо final, либо технически final
        final String greetings = "Hello ";

        Function<String, String> hello = (String name) -> greetings + name;

        // функциональные интерфейсы, встроенные в библиотеку Java:
        // семейство Functions - интерфейсы с методом apply, который что-то принимает и что-то возвращает
        // семейство Operators - интерфейсы, которые что-то принимают и что-то возвращают, при этом тип
        // всех аргументов и возвращаемой ссылки одинаковый
        // семейство Predicates - принимают что-угодно, возвращают boolean (мотод, который реализуется, называется
        // test)
        // семейство Suppliers - ничего не принимают, возвращают что-то (метод называется get())
        // семейство Consumers - что-то принимают, ничего не возвращают (метод называется accept(...))

        // printer - принимает строку и распечатывает в консоль
        Consumer<String> printer = System.out::println;
        printer.accept("Hello 22 group");
        IntPredicate isEven = x -> x % 2 == 0;

        // 1. IntSupplier                              4. Math::sin
        // 2. Consumer<String>                         1. () -> 3
        // 3. BiPredicate<Integer, Integer>            5. (x) -> String.valueOf(x)
        // 4. DoubleUnaryOperator                      2. System.out::println
        // 5. Function<Double, String>                 3. (x, x) -> x % 5 == 0

        // Композиция функций.
        // f(x) = x^2 + 3x + 5. f(1) = 1 + 3 + 5 = 9
        // g(x) = 3x - 7. f(2) = 6 - 7 = -1
        // h(x) = f(g(x)). h(x) = f(3x - 7) = (3x - 7)^2 + 3(3x - 7) + 5 = 9x^2 - 42x + 49 + 9x - 21 + 5 = 9x^2 - 33x + 33
        // h(3) = 81 - 99 + 33 = 15

        Function<Double, Double> f = x -> x * x + 3 * x + 5;
        Function<Double, Double> g = x -> 3 * x - 7;
        Function<Double, Double> h = f.compose(g);
        Function<Double, Double> anotherH = g.andThen(f);
        System.out.println(h.apply(3.0));//15
        System.out.println(anotherH.apply(3.0));//15

        Function<String, Double> f1 = Double::valueOf;//f.apply("125") -> 125.0
        Function<Integer, String> g1 = String::valueOf;// g.apply(239) -> "239"
        Function<Integer, Double> h1 = f1.compose(g1);// h.apply(38) ~ f.apply(g.apply(38)) -> 38.0

        System.out.println(38);

        // метод g.andThen(f) = f.compose(g)

        // Предикаты. Есть три default метода: and, or, negate

        IntPredicate isOdd = x -> x % 2 != 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;

        IntPredicate isOddAndDividedBy3 = isOdd.and(dividedBy3);
        IntPredicate isEvenOrDividedBy3 = isOdd.negate().or(dividedBy3);

    }
}

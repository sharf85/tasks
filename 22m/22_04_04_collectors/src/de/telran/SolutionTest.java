package de.telran;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_sumSqrt() {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4);
        assertEquals(30, solution.countSumSquared(s1));
    }

    @Test
    public void test_multiplySqrt() {
        Stream<Integer> s2 = Stream.of(1, 2, 3, 4);
        assertEquals(576, solution.multiplySquared(s2));
    }

    @Test
    public void test_palindromes() {
        List<String> strings = Arrays.asList("mam", "mama", "pep", "sos", "papa");
        Map<Boolean, List<String>> res = new HashMap<>();
        res.put(false, Arrays.asList("mama", "papa"));
        res.put(true, Arrays.asList("mam", "pep", "sos"));
        assertEquals(res, solution.groupStringsByPalindrome(strings));
    }

    @Test
    public void test_countPalindrome() {
        List<String> strings = Arrays.asList("mam", "mama", "pep", "sos", "papa");
        Map<Boolean, Long> res = new HashMap<>();
        res.put(false, 2L);
        res.put(true, 3L);
        assertEquals(res, solution.groupAndCountStringsByPalindrome(strings));
    }

    @Test
    public void test_totalTransactionByAccount() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", 100, "12"),
                new Transaction("2", 10, "12"),
                new Transaction("3", 15, "25"),
                new Transaction("4", 20, "36"),
                new Transaction("5", 40, "25"),
                new Transaction("6", 15, "12"),
                new Transaction("7", 5, "36")
        );
        Map<String, Long> res = new HashMap<>();
        res.put("12", 125L);
        res.put("25", 55L);
        res.put("36", 25L);
        assertEquals(res, solution.sumTransactionsByAccount(transactions));
    }

    @Test
    public void test_countVisitsByUrl() {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 15", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de"),
                new LogEntry("MacBook Air 13", "www.bahn.de"),
                new LogEntry("MacBook Air 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de")
        );
        Map<String, Long> res = new HashMap<>();
        res.put("www.tel-ran.de", 5L);
        res.put("www.bahn.de", 3L);
        res.put("www.sparkasse.de", 2L);
        assertEquals(res, solution.countClicksByUrl(logs));
    }

    @Test
    public void test_getSetOfVisitsByLogin() {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 15", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de"),
                new LogEntry("MacBook Air 13", "www.bahn.de"),
                new LogEntry("MacBook Air 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.bahn.de"),
                new LogEntry("MacBook Pro 15", "www.sparkasse.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de")
        );

        Set<String> mbPro13 = new HashSet<>();
        mbPro13.add("www.tel-ran.de");
        mbPro13.add("www.sparkasse.de");
        mbPro13.add("www.bahn.de");

        Set<String> mbPro15 = new HashSet<>();
        mbPro15.add("www.tel-ran.de");
        mbPro15.add("www.sparkasse.de");

        Set<String> mbAir13 = new HashSet<>();
        mbAir13.add("www.bahn.de");
        mbAir13.add("www.tel-ran.de");

        Set<String> lenovo = new HashSet<>();
        lenovo.add("www.tel-ran.de");
        lenovo.add("www.bahn.de");

        Map<String, Set<String>> res = new HashMap<>();
        res.put("MacBook Pro 13", mbPro13);
        res.put("MacBook Pro 15", mbPro15);
        res.put("MacBook Air 13", mbAir13);
        res.put("Lenovo PC", lenovo);
        assertEquals(res, solution.getSetVisitedUrlsByAccount(logs));
    }

    @Test
    public void testSunOfSquares_1number() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{2});
        assertEquals(4, solution.countSumSquared(numbers));
    }

    @Test
    public void testSunOfSquares_severalNumbers() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4});
        assertEquals(30, solution.countSumSquared(numbers));
    }

    @Test
    public void testMultiplicationOfSquares_1number() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{2});
        assertEquals(4, solution.multiplySquared(numbers));
    }

    @Test
    public void testMultiplicationOfSquares_severalNumbers() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4});
        assertEquals(576, solution.multiplySquared(numbers));
    }

    @Test
    public void testContainsPalindrome_TrueAndFalse() {
        List<String> strings = Arrays.asList("anna", "abc", "banan", "a", "madam");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(true, Arrays.asList("anna", "a", "madam"));
        map.put(false, Arrays.asList("abc", "banan"));
        assertEquals(map, solution.groupStringsByPalindrome(strings));
    }

    @Test
    public void testContainsPalindrome_noTrue() {
        List<String> strings = Arrays.asList("abc", "banan");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(false, Arrays.asList("abc", "banan"));
        assertEquals(map, solution.groupStringsByPalindrome(strings));
    }

    @Test
    public void testContainsPalindrome_noFalse() {
        List<String> strings = Arrays.asList("anna", "a", "madam");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(true, Arrays.asList("anna", "a", "madam"));
        assertEquals(map, solution.groupStringsByPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome() {
        List<String> strings = Arrays.asList("anna", "abc", "banan", "a", "madam");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(true, 3L);
        map.put(false, 2L);
        assertEquals(map, solution.groupAndCountStringsByPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome_0True() {
        List<String> strings = Arrays.asList("abc", "banan");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(false, 2L);
        assertEquals(map, solution.groupAndCountStringsByPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome_0False() {
        List<String> strings = Arrays.asList("anna", "a", "madam");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(true, 3L);
//        map.put(false, 0L);
        assertEquals(map, solution.groupAndCountStringsByPalindrome(strings));
    }

    @Test
    public void testSumOfTransactionsByAccount() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", 5000, "2"),
                new Transaction("2", 1000, "3"),
                new Transaction("3", 200, "1"),
                new Transaction("4", 15000, "3"),
                new Transaction("5", 800, "3"),
                new Transaction("6", 25000, "1")
        );
        Map<String, Long> map = new HashMap<>();
        map.put("1", 25200L);
        map.put("2", 5000L);
        map.put("3", 16800L);
        assertEquals(map, solution.sumTransactionsByAccount(transactions));
    }

    @Test
    public void testCountNumberOfVisits() {
        List<LogEntry> entries = Arrays.asList(
                new LogEntry("vasya@gmail.com", "http://www.courses/java"),
                new LogEntry("petya@gmail.com", "http://www.courses/php"),
                new LogEntry("masha@gmail.com", "http://www.courses/javascript"),
                new LogEntry("olga@gmail.com", "http://www.courses/java"),
                new LogEntry("masha@gmail.com", "http://www.courses/java"),
                new LogEntry("vasya@gmail.com", "http://www.courses/php"),
                new LogEntry("alex@gmail.com", "http://www.courses/mysql"),
                new LogEntry("vasya@gmail.com", "http://www.courses/java"),
                new LogEntry("alex@gmail.com", "http://www.courses/mysql"),
                new LogEntry("masha@gmail.com", "http://www.courses/javascript")
        );
        Map<String, Long> map = new HashMap<>();
        map.put("http://www.courses/java", 4L);
        map.put("http://www.courses/php", 2L);
        map.put("http://www.courses/javascript", 2L);
        map.put("http://www.courses/mysql", 2L);
        assertEquals(map, solution.countClicksByUrl(entries));
    }

    @Test
    public void getUniqueUsersByUrlCollectors_Test() {
        LogEntry l1 = new LogEntry("Anton", "githab.com");
        LogEntry l2 = new LogEntry("Anton", "tut.by");
        LogEntry l3= new LogEntry("Anton", "news.com");
        LogEntry l4 = new LogEntry("Petr", "githab.com");
        LogEntry l5= new LogEntry("Olga", "news.com");
        LogEntry l6 = new LogEntry("Ivan", "tut.by");
        List<LogEntry> l = Arrays.asList(l1,l2,l3,l4, l5, l6);

        Map<String,Set<String>> expected = new HashMap<>();
        expected.put("Anton", Set.of("githab.com", "tut.by","news.com"));
        expected.put("Olga", Collections.singleton("news.com"));
        expected.put("Petr", Collections.singleton("githab.com"));
        expected.put("Ivan", Collections.singleton("tut.by"));
        assertEquals(expected, solution.getSetVisitedUrlsByAccount(l));
    }

    @Test
    public void getNumberVisitedUrlsByAccount_Test() {
        LogEntry l1 = new LogEntry("Anton", "githab.com");
        LogEntry l2 = new LogEntry("Anton", "tut.by");
        LogEntry l3= new LogEntry("Anton", "news.com");
        LogEntry l4 = new LogEntry("Petr", "githab.com");
        LogEntry l5= new LogEntry("Olga", "news.com");
        LogEntry l6 = new LogEntry("Ivan", "tut.by");
        List<LogEntry> l = Arrays.asList(l1,l2,l3,l4, l5, l6);

        Map<String,Integer> expected = new HashMap<>();
        expected.put("Anton", 3);
        expected.put("Olga", 1);
        expected.put("Petr", 1);
        expected.put("Ivan", 1);
        assertEquals(expected, solution.getNumberVisitedUrlsByAccount(l));
    }
}

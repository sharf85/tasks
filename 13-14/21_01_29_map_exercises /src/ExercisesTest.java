import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {
    Exercises exercises = new Exercises();
    List<Integer> input = new ArrayList<>();
    List<String> stringInput = new ArrayList<>();

    @Test
    public void test_getUniqueNumbers_repeated() {
        Collections.addAll(input, 3, 6, 10, 3, 6, 15);
        HashSet<Integer> exp = new HashSet<>();
        Collections.addAll(exp, 3, 6, 10, 15);
        assertEquals(exp, exercises.retainUnique(input));
    }

    @Test
    public void test_getUniqueNumbers_repeatedAll() {
        Collections.addAll(input, 3, 3, 3, 3, 3);
        HashSet<Integer> exp = new HashSet<>();
        Collections.addAll(exp, 3);
        assertEquals(exp, exercises.retainUnique(input));
    }

    @Test
    public void test_getUniqueNumbers_noRepeated() {
        Collections.addAll(input, 3, -4, 100, 2, 1);
        HashSet<Integer> exp = new HashSet<>();
        Collections.addAll(exp, 3, -4, 100, 2, 1);
        assertEquals(exp, exercises.retainUnique(input));
    }

    @Test
    public void test_createDictionary() {
        Collections.addAll(stringInput, "бекон", "арбуз", "бобер", "бидон", "алмаз", "банан", "боб");
        List<List<String>> output = exercises.splitWordsByLetter(stringInput);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан", "бекон", "бидон", "боб", "бобер"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary1() {
        Collections.addAll(stringInput, "вагон", "арбуз", "винил", "галоп", "алмаз", "банан", "глина", "ёж", "кот", "ёлка");
        List<List<String>> output = exercises.splitWordsByLetter(stringInput);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан"));
        exp.add(Arrays.asList("вагон", "винил"));
        exp.add(Arrays.asList("галоп",  "глина"));
        exp.add(Arrays.asList("кот"));
        exp.add(Arrays.asList("ёж", "ёлка"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary2() {
        Collections.addAll(stringInput, "cat", "dog", "frog", "cookie", "dragon", "fibonacci");
        List<List<String>> output = exercises.splitWordsByLetter(stringInput);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("cat", "cookie"));
        exp.add(Arrays.asList("dog", "dragon"));
        exp.add(Arrays.asList("fibonacci", "frog"));
        assertEquals(exp, output);
    }
}

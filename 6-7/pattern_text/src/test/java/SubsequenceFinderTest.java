import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SubsequenceFinderTest {

    SubsequenceFinder finder;

    public static String text = "Hello world, guys!";

    @Before
    public void init() {
        finder = new SubsequenceFinder();
    }

    @Test
    public void testIsSubsequence_emptyPattern_true() {
        assertTrue(finder.isSubsequence(text, ""));
    }

    @Test
    public void testIsSubsequence_3lettersOnAfterAnother_true() {
        assertTrue(finder.isSubsequence(text, "llo"));
    }

    @Test
    public void testIsSubsequence_3letters_false() {
        assertFalse(finder.isSubsequence(text, "oll"));
    }

    @Test
    public void testIsSubsequence_5randomLetters_true() {

        for (int i = 0; i < 100; i++) {
            String pattern = getRandomSubsequence(text, 5);
            assertTrue(finder.isSubsequence(text, pattern));
        }
    }

    private String getRandomSubsequence(String text, int length) {

        Set<Integer> indexesSet = new TreeSet<>();

        Random random = new Random();

        while (indexesSet.size() < length) {
            indexesSet.add(random.nextInt(text.length()));
        }

        return indexesSet.stream()
                .map(text::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}

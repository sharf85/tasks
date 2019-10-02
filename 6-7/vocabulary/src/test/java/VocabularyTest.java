import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class VocabularyTest {

    Vocabulary vocabulary;

    @Before
    public void init() {
        vocabulary = new Vocabulary();
    }

    @Test
    public void testRevealAllCompositeWords_oneWord() {
        Set vocabularySet = new HashSet<>(Arrays.asList("the", "therefore", "walking", "i", "go", "refore"));
        assertEquals(
                new HashSet<>(Arrays.asList("therefore")),
                vocabulary.revealAllCompositeWords(vocabularySet));
    }

    @Test
    public void testRevealAllCompositeWords_noWords() {
        Set vocabularySet = new HashSet<>(Arrays.asList("the", "therefore", "walking", "i", "go"));
        assertEquals(
                new HashSet<>(),
                vocabulary.revealAllCompositeWords(vocabularySet));
    }

    @Test
    public void testRevealAllCompositeWords_twoWords() {
        Set vocabularySet = new HashSet<>(Arrays.asList("the", "therefore", "walking", "i", "go", "refore", "goi"));
        assertEquals(
                new HashSet<>(Arrays.asList("goi", "therefore")),
                vocabulary.revealAllCompositeWords(vocabularySet));
    }
}

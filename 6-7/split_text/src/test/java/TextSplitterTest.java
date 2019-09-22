import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TextSplitterTest {

    private TextSplitter textSplitter;

    @Before
    public void init() {
        Set<String> vocab = new HashSet(Arrays.asList("the", "therefore", "walking", "i", "go"));
        textSplitter = new TextSplitter(vocab);
    }

    @Test
    public void testSplitText_singleSimpleWord_success() throws NotSplitException {

        List<String> testing = Arrays.asList("walking");
        assertEquals(testing, textSplitter.splitText("walking"));
    }

    @Test
    public void testSplitText_singleComplexWord_success() throws NotSplitException {

        List<String> testing = Arrays.asList("therefore");
        assertEquals(testing, textSplitter.splitText("therefore"));
    }

    @Test
    public void testSplitText_simplePhrase_success() throws NotSplitException {

        List<String> testing = Arrays.asList("go", "walking");
        assertEquals(testing, textSplitter.splitText("gowalking"));
    }

    @Test
    public void testSplitText_complexPhrase_success() throws NotSplitException {

        List<String> testing = Arrays.asList("therefore", "i", "go", "walking");

        List<String> result = textSplitter.splitText("thereforeigowalking");
        assertEquals(testing, result);
    }

    @Test
    public void testSplitText_moreComplexPhrase_success() throws NotSplitException {

        List<String> testing = Arrays.asList("the", "therefore", "i", "go", "walking");

        List<String> result = textSplitter.splitText("thethereforeigowalking");
        assertEquals(testing, result);
    }

    @Test(expected = NotSplitException.class)
    public void testSplitText_moreComplexPhrase_fail() throws NotSplitException {

//        List<String> testing = Arrays.asList("the", "therefore", "i", "go", "walking");

        List<String> result = textSplitter.splitText("thethereformeigowalking");
//        assertEquals(testing, result);
    }
}

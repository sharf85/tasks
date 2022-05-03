import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CutServiceTest {
    CutService cutService = new CutService();
    List<Cut> cuts = new ArrayList<>();

    @Test
    void testGetPointsNumber() {
        cuts.add(new Cut(1, 5));
        cuts.add(new Cut(3, 8));
        cuts.add(new Cut(6, 7));

        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    void testGetPointsNumber_() {
        cuts.add(new Cut(0, 1));
        // cuts.add(new Cut(0, 1));
        cuts.add(new Cut(1, 2));

        assertEquals(1, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    void testGetPointsNumber_1() {
        cuts.add(new Cut(0, 5));
        cuts.add(new Cut(1, 2));
        cuts.add(new Cut(3, 4));

        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    void testGetPointsNumber_2() {
        cuts.add(new Cut(0, 5));
        cuts.add(new Cut(3, 7));
        cuts.add(new Cut(6, 8));

        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    void testGetPointsNumber_3() {
        cuts.add(new Cut(5, 8));
        cuts.add(new Cut(4, 7));
        cuts.add(new Cut(1, 5));
        cuts.add(new Cut(2, 3));

        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    void testGetPointsNumber_4() {
        cuts.add(new Cut(2, 4));
        cuts.add(new Cut(1, 6));
        cuts.add(new Cut(7, 8));
        cuts.add(new Cut(3, 9));
        cuts.add(new Cut(5, 10));

        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    public void test_minPointsCoveredByCuts1(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(11, 19),
                new Cut(21, 24));
        assertEquals(3, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    public void test_minPointsCoveredByCuts2(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(15, 19),
                new Cut(21, 24));
        assertEquals(3, cutService.getMinPointsCoveringCuts(cuts));
    }

    @Test
    public void test_minPointsCoveredByCuts3(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(11, 19),
                new Cut(17, 24));
        assertEquals(2, cutService.getMinPointsCoveringCuts(cuts));
    }
}

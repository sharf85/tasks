package de.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CutServiceTest {

    CutService cutService = new CutService();

    @Test
    public void testCuts() {
        List<Cut> cuts = Arrays.asList(
                new Cut(1, 2),
                new Cut(2, 5),
                new Cut(2, 8),
                new Cut(4, 9),
                new Cut(9, 12)
        );
        assertEquals(3, cutService.countMaxIntersectedCuts(cuts));
    }

    @Test
    void testGetMaxCovered() {
        Cut cut1 = new Cut(1, 3);
        Cut cut2 = new Cut(2, 5);
        Cut cut3 = new Cut(5, 7);
        Cut cut4 = new Cut(6, 8);
        List<Cut> cuts = new ArrayList<>();
        cuts.add(cut1);
        cuts.add(cut2);
        cuts.add(cut3);
        cuts.add(cut4);

        int result = 2;

        assertEquals(result, cutService.countMaxIntersectedCuts(cuts));
    }

    @Test
    void testGetMaxCovered_3() {
        Cut cut1 = new Cut(1, 3);
        Cut cut2 = new Cut(2, 5);
        Cut cut3 = new Cut(5, 7);
        Cut cut4 = new Cut(5, 8);
        List<Cut> cuts = new ArrayList<>();
        cuts.add(cut1);
        cuts.add(cut2);
        cuts.add(cut3);
        cuts.add(cut4);

        int result = 3;

        assertEquals(result, cutService.countMaxIntersectedCuts(cuts));
    }
}

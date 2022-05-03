import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointServiceTest {

    PointService pointService = new PointService();
    List<Integer> numbers = new ArrayList<>();
    List<Cut> cuts = new ArrayList<>();

    @Test
    void testGetCoveringCutsNumberByPoint_1() {
        numbers.add(25);
        numbers.add(40);
        numbers.add(45);
        numbers.add(80);
        numbers.add(83);
        cuts.add(new Cut(26, 46));
        cuts.add(new Cut(38, 40));
        cuts.add(new Cut(80, 84));

        Map<Integer, Integer> res = pointService.getCoveringCutsNumberByPoint(numbers, cuts);

        assertEquals(5, res.size());
        assertEquals(0, res.get(25));
        assertEquals(2, res.get(40));
    }

    @Test
    void testGetCoveringCutsNumberByPoint_2() {
        numbers.add(26);
        numbers.add(27);
        cuts.add(new Cut(26, 27));
        cuts.add(new Cut(27, 40));
        cuts.add(new Cut(27, 84));

        Map<Integer, Integer> res = pointService.getCoveringCutsNumberByPoint(numbers, cuts);

        assertEquals(2, res.size());
        assertEquals(1, res.get(26));
        assertEquals(3, res.get(27));
    }

    @Test
    public void test_getCoveringCutsNumberByPoint(){
        List<Integer> numbers = Arrays.asList(1, 2, 5, 6, 3, 7, 9);
        List<Cut> cuts = Arrays.asList(
                new Cut(2, 4),
                new Cut(2, 6),
                new Cut(1, 1),
                new Cut(1, 12),
                new Cut(5, 7),
                new Cut(8, 9));
        Map<Integer, Integer> res = new HashMap<>();
        res.put(1,2);
        res.put(2,3);
        res.put(3,3);
        res.put(5,3);
        res.put(6,3);
        res.put(7,2);
        res.put(9,2);
        assertEquals(res, pointService.getCoveringCutsNumberByPoint(numbers,cuts));
    }

    @Test
    public void test_collectPoints_emptyPointsEmptyCuts_empty_0() {
        List<Integer> points = Collections.emptyList();
        List<Cut> cuts = Collections.emptyList();
        Map<Integer, Integer> expected = new HashMap<>();
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void test_collectPoints_emptyPointsEmptyCuts_1() {
        List<Integer> points = Collections.singletonList(1);
        List<Cut> cuts = Collections.singletonList(new Cut(0, 2));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1,1);
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void getCoveringCutsNumberByPoint_test_1() {
        List<Integer> points = Collections.singletonList(1);
        List<Cut> cuts = Collections.singletonList(new Cut(2, 4));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1,0);
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void getCoveringCutsNumberByPoint_test_2() {
        List<Integer> points = Collections.singletonList(3);
        List<Cut> cuts  = Arrays.asList(new Cut(2, 4), new Cut(0, 4),
                new Cut(1, 3));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3,3);
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void getCoveringCutsNumberByPoint_test_3() {
        List<Integer> points = Arrays.asList(3, 5, 7);
        List<Cut> cuts  = Collections.singletonList(new Cut(1, 9));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3,1);
        expected.put(5,1);
        expected.put(7,1);
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void getCoveringCutsNumberByPoint_test_4() {
        List<Integer> points = Arrays.asList(3, 5, 7);
        List<Cut> cuts = Collections.singletonList(new Cut(1, 4));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3,1);
        expected.put(5,0);
        expected.put(7,0);

        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }

    @Test
    public void getCoveringCutsNumberByPoint_test_5() {
        List<Integer> points = Arrays.asList(1, 2, 3, 4, 5);
        List<Cut> cuts  = Arrays.asList(
                new Cut(0, 2),
                new Cut(4, 5)
        );

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1,1);
        expected.put(2,1);
        expected.put(3,0);
        expected.put(4,1);
        expected.put(5,1);
        assertEquals(expected, pointService.getCoveringCutsNumberByPoint(points, cuts));
    }
}

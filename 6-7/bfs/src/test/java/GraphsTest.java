import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class GraphsTest {

    private Graphs graphs;

    @Before
    public void init() {
        graphs = new Graphs();
    }

    private List<List<Integer>> initGraph(Integer[][] source) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            res.add(Arrays.asList(source[i]));
        }

        return res;
    }

    @Test
    public void testBfs_GraphFromZero() {
        List<List<Integer>> graph = initGraph(new Integer[][]
                {
                        {3},
                        {2, 3},
                        {1, 3},
                        {1, 4, 0, 2},
                        {3}
                });


        int[] result = graphs.breadthFirstSearch(graph, 0);
        int[] expected = {0, 2, 2, 1, 2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testBfs_TreeFromZero() {
        List<List<Integer>> graph = initGraph(new Integer[][]
                {
                        {3},
                        {2, 3},
                        {1},
                        {1, 4, 0},
                        {3}
                });


        int[] result = graphs.breadthFirstSearch(graph, 0);
        int[] expected = {0, 2, 3, 1, 2};

        assertArrayEquals(expected, result);
    }

}

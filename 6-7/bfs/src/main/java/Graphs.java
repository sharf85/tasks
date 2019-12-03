import java.util.ArrayDeque;
import java.util.List;

public class Graphs {

    public int[] breadthFirstSearch(List<List<Integer>> graph, int sourceVertex) {
        boolean[] visited = new boolean[graph.size()];
        int[] result = new int[graph.size()];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(sourceVertex);
        visited[sourceVertex] = true;

        while (queue.size() > 0) {
            int currentVertex = queue.removeFirst();

            for (int childVertex : graph.get(currentVertex)) {
                if (!visited[childVertex]) {
                    queue.addLast(childVertex);
                    visited[childVertex] = true;
                    result[childVertex] = 1 + result[currentVertex];
                }
            }
        }

        return result;
    }
}

import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> destination) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        Map<Vertex<V>, Vertex<V>> predecessor = new HashMap<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            if (current.equals(destination)) {
                List<Vertex<V>> path = new ArrayList<>();
                for (Vertex<V> at = destination; at != null; at = predecessor.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);
                return path;
            }

            for (Vertex<V> neighbor : graph.getAdjVertices(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    predecessor.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }
}

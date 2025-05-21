import java.util.*;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<Vertex<V>, Map<Vertex<V>, Double>> adjacencyMap;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = new Vertex<>(sourceData);
        Vertex<V> dest = new Vertex<>(destData);
        addVertex(source);
        addVertex(dest);
        adjacencyMap.get(source).put(dest, weight);
        if (!directed) {
            adjacencyMap.get(dest).put(source, weight);
        }
    }

    public Map<Vertex<V>, Map<Vertex<V>, Double>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public Set<Vertex<V>> getVertices() {
        return adjacencyMap.keySet();
    }

    public Map<Vertex<V>, Double> getAdjVertices(Vertex<V> vertex) {
        return adjacencyMap.getOrDefault(vertex, new HashMap<>());
    }
}

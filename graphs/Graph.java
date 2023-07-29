package graphs;

import java.util.*;

class Vertex {
    int id;
    List<Edge> edges;

    public Vertex(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }
}

class Edge {
    Vertex source;
    Vertex destination;
    int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class Graph {
    private Map<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(int id) {
        if (!vertices.containsKey(id)) {
            vertices.put(id, new Vertex(id));
        }
    }

    public void addEdge(int sourceId, int destId, int weight) {
        if (!vertices.containsKey(sourceId) || !vertices.containsKey(destId)) {
            throw new IllegalArgumentException("Vertex does not exist.");
        }

        Vertex source = vertices.get(sourceId);
        Vertex destination = vertices.get(destId);
        Edge edge = new Edge(source, destination, weight);
        source.addEdge(edge);
    }

    public Vertex getVertex(int id) {
        return vertices.get(id);
    }

    public List<Vertex> getAllVertices() {
        return new ArrayList<>(vertices.values());
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 15);

        List<Vertex> vertices = graph.getAllVertices();
        for (Vertex vertex : vertices) {
            List<Edge> edges = vertex.getEdges();
            System.out.print("Vertex " + vertex.id + ": ");
            for (Edge edge : edges) {
                System.out.print("(" + edge.source.id + "->" + edge.destination.id + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
    
}

package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacenyList {
    private int[][] adjacencyList;
    private int numVertices;

    public AdjacenyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source][destination] = 1;
        adjacencyList[destination][source] = 1; // For undirected graph, add reverse edge
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyList[vertex][i] == 1) {
                adjacentVertices.add(i);
            }
        }
        return adjacentVertices;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            List<Integer> adjacentVertices = getAdjacentVertices(i);
            System.out.print("Vertex " + i + " -> ");
            for (int v : adjacentVertices) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        AdjacenyList graph = new GraphArray(numVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}

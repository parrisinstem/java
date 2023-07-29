package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix{
    private int[][] adjacencyMatrix;
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight; // For undirected graph, add reverse edge
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] != 0) {
                adjacentVertices.add(i);
            }
        }
        return adjacentVertices;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print(j + "(" + adjacencyMatrix[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        AdjacencyMatrix graph = new AdjacencyMatrix(numVertices);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 1);

        graph.printGraph();
    }
}

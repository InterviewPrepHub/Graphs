package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Graph;

import java.util.ListIterator;

public class DetectCycleInGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        DetectCycleInGraph d = new DetectCycleInGraph();

        if(isCyclic(graph)) {
            System.out.println("Graph is cyclic");
        } else {
            System.out.println("Graph is not cyclic");
        }

    }

    private static boolean isCyclic(Graph g) {

        int n = g.V;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isCyclicUtil(g, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(Graph g, boolean[] visited, int src, int parent) {

        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();

            if (!visited[nbr]) {
                if(isCyclicUtil(g, visited, nbr, src)) {
                    return true;
                }
            } else if(nbr!=parent) {
                return true;
            }
        }
        return false;
    }


}

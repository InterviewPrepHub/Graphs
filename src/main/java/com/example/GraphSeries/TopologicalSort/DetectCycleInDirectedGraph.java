package com.example.GraphSeries.TopologicalSort;

import com.example.GraphSeries.Graph;

import java.util.ListIterator;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        DetectCycleInDirectedGraph d = new DetectCycleInDirectedGraph();
        if(d.isCyclic(graph)) {
            System.out.println("Cycle is detected");
        } else {
            System.out.println("Cycle is not detected");
        }
    }

    private boolean isCyclic(Graph g) {

        int n = g.V;

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isCyclicUtil(g, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(Graph g, int src, boolean[] visited, boolean[] recStack) {

        //if the current vertex (src) is in recStack, cycle detected
        if (recStack[src]) {
            return true;
        }

        //if the current vertex (src) is visited but not in recStack, cycle not detected
        if (visited[src]) {
            return false;
        }

        visited[src] = true;
        recStack[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if(isCyclicUtil(g, nbr, visited, recStack)) {
                return true;
            }
        }

        recStack[src] = false;

        return false;
    }
}


















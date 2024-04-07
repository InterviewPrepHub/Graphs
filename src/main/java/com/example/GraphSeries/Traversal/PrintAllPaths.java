package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Edge;
import com.example.GraphSeries.WeightedGraph;

import java.util.ListIterator;

public class PrintAllPaths {

    public static void main(String[] args) {

        int n = 7;
        WeightedGraph w = new WeightedGraph(n);
        w.addEdge(0,1,10);
        w.addEdge(0,3,10);
        w.addEdge(1,2,10);
        w.addEdge(2,3,10);
        w.addEdge(3,4,10);
        w.addEdge(4,5,10);
        w.addEdge(5,6,10);
        w.addEdge(4,6,10);

        PrintAllPaths p = new PrintAllPaths();
        boolean[] visited = new boolean[w.V];
        p.findPaths(w, 0,6, visited, "", 0);

    }

    private void findPaths(WeightedGraph w, int src, int dest, boolean[] visited, String psf, int wsf) {

        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        ListIterator<Edge> it = w.adj[src].listIterator();

        while (it.hasNext()) {
            Edge edge = it.next();
            if (!visited[edge.nbr]) {
                findPaths(w, edge.nbr, dest, visited, psf+edge.nbr, wsf+edge.wt);
            }
        }

        visited[src] = false;

    }
}

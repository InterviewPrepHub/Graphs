package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Edge;
import com.example.GraphSeries.WeightedGraph;

import java.util.ListIterator;

public class HasPath {

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

        HasPath p = new HasPath();
        boolean[] visited = new boolean[w.V];
        boolean res = p.checkHasPath(w, 0,6, visited);
        System.out.println(res);
    }

    private boolean checkHasPath(WeightedGraph w, int src, int dest, boolean[] visited) {

        if(src == dest) {
            return true;
        }

        visited[src] = true;
        ListIterator<Edge> it = w.adj[src].listIterator();

        while (it.hasNext()) {
            Edge edge = it.next();
            boolean hasNbrPath = checkHasPath(w, edge.nbr, dest, visited);
            if (hasNbrPath) {
                return true;
            }
        }

        return false;
    }
}

package com.example.GraphSeries;

import java.util.LinkedList;

public class WeightedGraph {

    public int V;
    public LinkedList<Edge> adj[];

    public WeightedGraph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int nbr, int wt) {
        adj[src].add(new Edge(src, nbr, wt));
    }
}

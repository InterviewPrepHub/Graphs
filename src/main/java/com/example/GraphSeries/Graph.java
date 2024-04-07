package com.example.GraphSeries;

import java.util.LinkedList;

public class Graph {

    public int V;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }
}

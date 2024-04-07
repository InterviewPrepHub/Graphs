package com.example.GraphSeries.ConnectedComponent;

import com.example.GraphSeries.Edge;
import com.example.GraphSeries.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IsGraphConnected {

    public static void main(String[] args) {
        int n = 7;
        WeightedGraph w = new WeightedGraph(n);
        w.addEdge(0,1,10);
        w.addEdge(2,3,10);
        w.addEdge(4,5,10);
        w.addEdge(5,6,10);
        w.addEdge(4,6,10);

        List<List> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            List<Integer> comp = null;
            if (visited[i] == false) {
                comp = new ArrayList<>();
                comp.add(i);
                generateList(w, i, visited, comp);
                comps.add(comp);
            }

        }
        System.out.println(comps);
        if (comps.size()>1) {
            System.out.println("graph not connected");
        } else {
            System.out.println("graph is connected");
        }
    }

    private static void generateList(WeightedGraph w, int src, boolean[] visited, List<Integer> comp) {
        visited[src] = true;

        ListIterator<Edge> it = w.adj[src].listIterator();

        while (it.hasNext()) {
            Edge edge = it.next();
            if (visited[edge.nbr] == false) {
                comp.add(edge.nbr);
                generateList(w, edge.nbr, visited, comp);
            }
        }
    }
}

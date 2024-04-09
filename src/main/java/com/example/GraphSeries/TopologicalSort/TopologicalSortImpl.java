package com.example.GraphSeries.TopologicalSort;

import com.example.GraphSeries.Graph;

import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSortImpl {

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,6);


        //in topological sort with vertices u,v, u must appear before v
        topoSort(g);
    }

    private static void topoSort(Graph g) {

        int n = g.V;
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsUtil(g, i, visited, st);
            }
        }

        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void dfsUtil(Graph g, int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while(it.hasNext()) {
            int nbr = it.next();
            if (!visited[nbr]) {
                dfsUtil(g, nbr, visited, st);
            }
        }

        st.add(src);
    }
}
















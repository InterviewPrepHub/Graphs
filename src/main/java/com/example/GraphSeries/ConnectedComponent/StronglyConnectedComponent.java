package com.example.GraphSeries.ConnectedComponent;

import com.example.GraphSeries.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class StronglyConnectedComponent {

    public static void main(String[] args) {

        int n = 5;
        Graph g = new Graph(n);

        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };

        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        StronglyConnectedComponent scc = new StronglyConnectedComponent();
        int res = scc.kosaraju(g);
        System.out.println(res);
    }

    public int kosaraju(Graph g) {
        int V = g.V;
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(g, i, visited, st);
            }
        }

        //create reverse adj - so create a new LinkedList<Integer>[] adj;

        LinkedList<Integer>[] adjT = new LinkedList[V];
        for (int i=0; i < V; i++) {
            adjT[i] = new LinkedList<>();
        }

        for (int i=0; i < V; i++) {
            visited[i] = false;

            ListIterator<Integer> it = g.adj[i].listIterator();
            while (it.hasNext()) {
                Integer nbr = it.next();
                adjT[nbr].add(i);
            }
        }

        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (!visited[node]) {
                scc++;
                reverseDFS(node, visited, adjT);
            }
        }
        return scc;
    }

    private void reverseDFS(int node, boolean[] visited, LinkedList<Integer>[] adjT) {
        visited[node] = true;

        ListIterator<Integer> it = adjT[node].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if (!visited[nbr]) {
                reverseDFS(nbr, visited, adjT);
            }
        }

    }

    private void dfs(Graph g, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if (!visited[nbr]) {
                dfs(g, nbr, visited, st);
            }
        }

        st.push(src);
    }

}

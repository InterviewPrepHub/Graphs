package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Graph;

import java.util.LinkedList;
import java.util.ListIterator;

/*
Time Complexity:

Best time & Worst time = O(V+E) --> V = no of vertices , E - no of edges

Space Complexity: O(V)
 */
public class DFS {

    public void dfs(Graph graph, int v) {
        boolean[] visited = new boolean[graph.V];

        dfsUtil(graph, v, visited);
    }

    private void dfsUtil(Graph graph, int v, boolean[] visited) {

        visited[v] = true;

        System.out.println(v);

        ListIterator<Integer> it = graph.adj[v].listIterator();

        while(it.hasNext()) {
            Integer n = it.next();
            if (!visited[n]) {
                dfsUtil(graph, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Graph g = new Graph(n);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        DFS d = new DFS();

        d.dfs(g, 2);
    }

    
}

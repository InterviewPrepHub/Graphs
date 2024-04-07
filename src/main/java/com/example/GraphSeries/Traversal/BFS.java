package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        int v = 5;

        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        BFS b = new BFS();
        b.bfs(g,0, v);
    }

    private void bfs(Graph g, int startNode, int v) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];

        visited[startNode] = true;
        q.add(startNode);

        while (!q.isEmpty()) {
            Integer currNode = q.poll();
            System.out.print(currNode+" ");

            ListIterator<Integer> it = g.adj[currNode].listIterator();
            while (it.hasNext()) {
                Integer n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }
}

package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LongestPathBetweenTwoVertices {

    int maxDist = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);

        LongestPathBetweenTwoVertices l = new LongestPathBetweenTwoVertices();
        int src = 0;
        int dest = 4;
        
        int res = l.longestPath(g, src, dest);
        System.out.println(res);
    }

    private int longestPath(Graph g, int src, int dest) {

        int n = g.V;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();

        longestPathUtil(g, src, dest, visited, 0, list);
        return maxDist;
    }

    private void longestPathUtil(Graph g, int src, int dest, boolean[] visited, int distance, List<Integer> path) {

        visited[src] = true;
        path.add(src);

        if(src == dest) {
            maxDist = Math.max(maxDist, distance);
        }

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if (!visited[nbr]) {
                longestPathUtil(g, nbr, dest, visited, distance+1, path);
            }
        }

        visited[src] = false;
        path.removeLast();

    }
}

















package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Graph;

import java.util.Arrays;
import java.util.ListIterator;

public class FindMotherVertex {

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        
        FindMotherVertex f = new FindMotherVertex();
        int mother = f.findMother(g);
        System.out.println(mother);
    }

    public int findMother(Graph g) {
        int n = g.V;
        boolean[] visited = new boolean[n];
        int lastVisited = 0;

        // Perform DFS from all vertices to find the last visited vertex
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsUtil(g, i, visited);
                lastVisited = i;
            }
        }

        // Reset visited array for next DFS
        Arrays.fill(visited, false);

        // Perform DFS from the last visited vertex to check if it covers all vertices
        dfsUtil(g, lastVisited, visited);

        // If any vertex is not visited, then no mother vertex exists
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        return lastVisited;
    }

    private void dfsUtil(Graph g, int src, boolean[] visited) {
        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if (!visited[nbr]) {
                dfsUtil(g, nbr, visited);
            }
        }
    }

}

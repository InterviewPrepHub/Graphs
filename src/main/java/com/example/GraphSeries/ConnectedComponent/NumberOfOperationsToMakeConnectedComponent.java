package com.example.GraphSeries.ConnectedComponent;

import com.example.GraphSeries.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NumberOfOperationsToMakeConnectedComponent {

    public static void main(String[] args) {

//        int n = 4;
//        int[][] connections = {{0,1},{0,2},{1,2}};

        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};

        NumberOfOperationsToMakeConnectedComponent ncc = new NumberOfOperationsToMakeConnectedComponent();

        int res = ncc.makeConnected(n, connections);

        System.out.println("connected components : "+res);

    }

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1) {
            return -1;  //not enough cables to connect all components
        }
        Graph graph = new Graph(n);

        for(int[] connection : connections) {
            graph.addEdge(connection[0], connection[1]);
        }

        List<List<Integer>> connectedConnections = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++) {
            List<Integer> connection = null;
            if(visited[i] == false) {
                connection = new ArrayList<>();
                connection.add(i);
                generateConnectionList(graph, i, visited, connection);
                connectedConnections.add(connection);
            }
        }

        return connectedConnections.size()-1;

    }

    public void generateConnectionList(Graph g, int src, boolean[] visited, List<Integer> connection) {
        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while(it.hasNext()) {
            Integer i = it.next();
            if(visited[i] == false) {
                connection.add(i);
                generateConnectionList(g, i, visited, connection);
            }
        }
    }
}

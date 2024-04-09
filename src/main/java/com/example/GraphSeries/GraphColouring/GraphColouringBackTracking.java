package com.example.GraphSeries.GraphColouring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphColouringBackTracking {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
        int numOfColors = 3; // Number of colors available

        // Color the graph using backtracking
        Map<Integer, Integer> colorAssignment = colorGraph(graph, numOfColors);

    }

    private static Map<Integer, Integer> colorGraph(int[][] graph, int numOfColors) {
        int V = graph.length;
        int[] colourAssignment = new int[V]; //store assignment colour for each vertex

        Arrays.fill(colourAssignment, 0);

        //try colouring the graph starting from vertex 0
        if(colourUtil(0, graph, numOfColors, colourAssignment)) {
            Map<Integer, Integer> result = new HashMap<>();
            for (int i = 0; i < V; i++) {
                result.put(i, colourAssignment[i]);
            }
            return result;
        } else {
            return null;
        }

    }

    //recursive function to assigne colour to vertex using backtracking
    private static boolean colourUtil(int v, int[][] graph, int numOfColors, int[] colourAssignment) {

        //try assigning colour to current vertex
        for (int c = 1; c <= numOfColors; c++) {
            //check if its safe to colour the vertex
            if(isSafe(v, c, graph, colourAssignment)) {
                colourAssignment[v] = c;

                // go to the neighbouring vertex
                if(colourUtil(v+1, graph, numOfColors, colourAssignment)) {
                    return true;
                }

                colourAssignment[v] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int v, int colour, int[][] graph, int[] colourAssignment) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && colour == colourAssignment[i]) {
                return false;
            }
        }
        return true;
    }
}

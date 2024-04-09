package com.example.GraphSeries.GraphColouring;

import java.util.*;

/*
Graph coloring is a fundamental concept in graph theory where you assign colors to the vertices of a graph
in such a way that no two adjacent vertices share the same color. This problem arises in various practical
scenarios, such as scheduling, register allocation, and map coloring.
 */
public class GraphColouringGreedy {

    public static void main(String[] args) {
        // Example graph represented as adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(0, 1, 3));
        graph.put(3, Arrays.asList(1, 2));

        int numOfColors = 3; // Number of colors available

        // Color the graph
        Map<Integer, Integer> colorAssignment = colorGraph(graph, numOfColors);

        for (Map.Entry<Integer, Integer> entry : colorAssignment.entrySet()) {
            System.out.println("vertex : "+entry.getKey()+" colour assigned : "+entry.getValue());
        }

    }

    private static Map<Integer, Integer> colorGraph(Map<Integer, List<Integer>> graph, int numOfColors) {

        Map<Integer, Integer> colourAssignment = new HashMap<>();

        //iterate over each vertex in graph
        for (int vertex : graph.keySet()) {
            Set<Integer> usedColour = new HashSet<>();  //colour used by adjacent colour

            //iterate over adjacent vertex and check their assigned colours
            for (int neighbour : graph.get(vertex)) {
                if (colourAssignment.containsKey(neighbour)) {
                    usedColour.add(colourAssignment.get(neighbour));    // Add neighbor's color to used colors set
                }
            }

            //assign the lowest colour to the current vertex
            int colour = 1;
            while(usedColour.contains(colour)) {
                colour++;   //increment colour until you find the available colour
            }
            colourAssignment.put(vertex, colour);   //assign colour to vertex
        }

        return colourAssignment;
    }
}

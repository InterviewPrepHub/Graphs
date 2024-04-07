package com.example.GraphSeries.ConnectedComponent;

import com.example.GraphSeries.Edge;
import com.example.GraphSeries.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
You are give n students. Each student will have an id from 0 to n-1. There are k number of clubs.
You have to finding how many ways can we select a pair of students such that both students from different clubs.

 */
public class PerfectFriends {

    public static void main(String[] args) {

        int n = 7;
        WeightedGraph w = new WeightedGraph(n);
        w.addEdge(0,1,10);
        w.addEdge(2,3,10);
        w.addEdge(4,5,10);
        w.addEdge(5,6,10);
        w.addEdge(4,6,10);

        PerfectFriends p = new PerfectFriends();
        p.getPerfectFriends(0, w, n);

    }

    int count = 0;

    private void getPerfectFriends(int src, WeightedGraph w, int n) {
        List<List<Integer>> comps = getConnectedComponents(src, w, n);
        System.out.println(comps);
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i+1; j < comps.size(); j++) {
                count += comps.get(i).size() * comps.get(j).size();
            }

        }

        System.out.println("total pairs created of friends from different components : "+count);
    }

    private List<List<Integer>> getConnectedComponents(int src, WeightedGraph w, int n) {

        List<List<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        List<Integer> comp = null;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                comp = new ArrayList<>();
                comp.add(i);
                generateList(i, w, comp, visited);
                comps.add(comp);
            }
        }
        return comps;
    }

    private void generateList(int src, WeightedGraph w, List<Integer> comp, boolean[] visited) {

        visited[src] = true;

        ListIterator<Edge> list = w.adj[src].listIterator();

        while (list.hasNext()) {
            Edge edge = list.next();
            if (visited[edge.nbr] == false) {
                comp.add(edge.nbr);
                generateList(edge.nbr, w, comp, visited);

            }
        }

    }
}

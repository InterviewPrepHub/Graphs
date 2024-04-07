package com.example.GraphSeries.Traversal;

import com.example.GraphSeries.Edge;
import com.example.GraphSeries.Pair;
import com.example.GraphSeries.WeightedGraph;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TraversalProblems {

    int min_wt_so_far = Integer.MAX_VALUE;
    int max_wt_so_far = Integer.MIN_VALUE;
    int ceil_path_wt = Integer.MAX_VALUE;
    int floor_path_wt = Integer.MIN_VALUE;
    String min_path;
    String max_path;
    String ceil_path;
    String floor_path;
    int k = 3;

    public static void main(String[] args) {
        int n = 7;
        WeightedGraph w = new WeightedGraph(n);
        w.addEdge(0,1,10);
        w.addEdge(1,2,10);
        w.addEdge(2,3,10);
        w.addEdge(0,3,40);
        w.addEdge(3,4,2);
        w.addEdge(4,5,3);
        w.addEdge(5,6,3);
        w.addEdge(4,6,8);

        TraversalProblems p = new TraversalProblems();
        boolean[] visited = new boolean[w.V];
        p.smallestPath(w,visited, 0, 6, "", 0);
//        p.ceilPath(40); //with given weight of 40 , just get the path with next biggest wt
//        p.kthLargestPath(3);



    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    private void smallestPath(WeightedGraph w, boolean[] visited, int src, int dest, String psf, int wsf) {

        if (src == dest) {

            if(wsf < min_wt_so_far) {
                min_wt_so_far = wsf;
                min_path = psf;
            }

            if(wsf > max_wt_so_far) {
                max_wt_so_far = wsf;
                max_path = psf;
            }

            if(wsf > 40 && wsf < ceil_path_wt) {
                ceil_path_wt = wsf;
                ceil_path = psf;
            }

            if(wsf < 40 && wsf > floor_path_wt) {
                floor_path_wt = wsf;
                floor_path = psf;
            }

            if(pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if(wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            return;
        }
        visited[src] = true;

        Iterator<Edge> it = w.adj[src].iterator();

        while (it.hasNext()) {
            Edge edge = it.next();
            smallestPath(w, visited, edge.nbr, dest, psf+edge.nbr, wsf+ edge.wt);
        }

        visited[src] = false;

    }
}

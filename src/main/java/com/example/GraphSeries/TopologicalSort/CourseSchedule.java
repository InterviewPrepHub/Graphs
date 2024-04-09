package com.example.GraphSeries.TopologicalSort;

import com.example.GraphSeries.Graph;

import java.util.ListIterator;
import java.util.Stack;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

//        int numCourses = 2;
//        int[][] prerequisites = {{1,0}, {0,1}};

        Graph g = new Graph(numCourses);
        CourseSchedule c = new CourseSchedule();
        c.canFinish(g, numCourses, prerequisites);
    }

    public void canFinish(Graph g, int numCourses, int[][] prerequisites) {

        int n = g.V;

        for (int[] pre: prerequisites) {
            g.addEdge(pre[0], pre[1]);
        }

        boolean[] visited = new boolean[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsUtil(g, i, visited, st);
            }
        }

        int size = st.size();
        int[] arr = new int[size];
        while (!st.empty()) {
            arr[size-1] = st.pop();
            size--;
        }

        for (int a : arr) {
            System.out.print(a+" ");
        }
    }

    private void dfsUtil(Graph g, int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;

        ListIterator<Integer> it = g.adj[src].listIterator();

        while (it.hasNext()) {
            Integer nbr = it.next();
            if(!visited[nbr]) {
                dfsUtil(g, nbr, visited, st);
            }
        }

        st.add(src);
    }
}

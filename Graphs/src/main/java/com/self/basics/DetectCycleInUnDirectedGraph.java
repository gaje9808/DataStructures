package com.self.basics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUnDirectedGraph {

//------------------------------ ******* USING DFS******--------------------------------
//
//    public static boolean isCyclicdfs(Graph g) {
//        int v = g.vertices;
//        boolean[] visited = new boolean[v];
//
//        Arrays.fill(visited,false);
//        for (int i=0;i<v;i++)
//            if (!visited[i]) {
//                if (isCyclicUtildfs(i,visited,g, -1))
//                    return true;
//            }
//        return false;
//    }
//
//    public static boolean isCyclicUtildfs(int i, boolean[] visited, Graph g, int parent) {
//        visited[i] = true;
//
//        Iterator<Integer> it = g.adj[i].listIterator();
//        while (it.hasNext()) {
//            int n = it.next();
//            if (!visited[n]) {
//                if(isCyclicUtildfs(n,visited,g,i))
//                    return true;
//            }
//            else if (i!= parent) return true;
//        }
//        return false;
//    }
//--------------------********************--------------------------------------------------

//--------------------**********USING BFS*******--------------------------------------------

    public static boolean isCyclicbfs(Graph g) {
        int v = g.vertices;
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        for (int i=0;i<v;i++)
            if (!visited[i] && isCyclicbfsUtil(i, visited, g))
                return true;
        return false;
    }

    public static boolean isCyclicbfsUtil(int i, boolean[] visited, Graph g) {
        int v = g.vertices;
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);

        int[] parent = new int[v];
        Arrays.fill(parent, -1);

        while (!q.isEmpty()) {
            i  = q.poll();
            Iterator<Integer> it = g.adj[i].listIterator();
            while (it.hasNext()){
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                    parent[n] = i;
                }
                else if(parent[n] != i)
                    return true;
            }
        }
        return false;
    }
//-----------------------******************---------------------------------------------

    // driver method similar to the one on geeks for geeks
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
//        if (isCyclicdfs(g1))
        if (isCyclicbfs(g1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
//        if (isCyclicdfs(g2))
        if (isCyclicbfs(g2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}

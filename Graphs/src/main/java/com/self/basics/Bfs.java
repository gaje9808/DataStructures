package com.self.basics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// for bfs traversal on graphs
public class Bfs {
    public static void bfs (Graph g){
        int v = g.vertices;
        boolean[] visited = new boolean[v];
        for (int i=0;i<v;i++)
            if (!visited[i])
                bfsUtil(i,visited,g);
    }

    public static void bfsUtil(int i, boolean[] visited, Graph g) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] =true;
        q.add(i);

        while (!q.isEmpty()) {
            i = q.poll();
            System.out.println(i);

            Iterator<Integer> it = g.adj[i].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }

    }

    // driver class for creating a graph
    public static void main(String[] args){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        bfs(g);
    }
}

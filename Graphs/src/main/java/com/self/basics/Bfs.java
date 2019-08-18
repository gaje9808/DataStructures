package com.self.basics;

import java.util.Iterator;
import java.util.LinkedList;

public class Bfs {
    public static void bfs (Graph g, int i){
        int v = g.vertices;
        LinkedList<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            i = q.poll();
            System.out.println(i);

            Iterator<Integer> it = g.adj[i].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        bfs(g,2);
    }
}

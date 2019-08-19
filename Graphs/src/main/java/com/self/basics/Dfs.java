package com.self.basics;

import java.util.Arrays;
import java.util.Iterator;

// basics class which covers dept first search of a graph
public class Dfs {
    public static void dfs(Graph g){
        int v = g.vertices;
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);

        for (int i=0;i<v;i++) {
            if (!visited[i]) {
                dfsUtil(i,g, visited);
            }
        }
    }

    public static void dfsUtil(int i, Graph g, boolean[] visited){
        visited[i] =  true;
        System.out.println(i);

        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                dfsUtil(n,g,visited);
        }
    }

    // driver method for creating a graph
    public static void main(String[] args){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        dfs(g);
    }
}

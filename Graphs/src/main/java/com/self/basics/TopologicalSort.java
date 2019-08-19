package com.self.basics;

import java.util.Iterator;
import java.util.Stack;

// only should be done using dfs as here we are trying to reach the lower most connected vertex from a given vertex
public class TopologicalSort {
    public static void dfs(Graph g){
        int v = g.vertices;
        boolean[] visited = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for (int i=0;i<v;i++) {
            if (!visited[i]) {
                dfsUtil(i,visited,g,s);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void dfsUtil(int i, boolean[] visited, Graph g, Stack s) {
        visited[i] = true;

        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                dfsUtil(n,visited,g,s);
            }
        }
        s.push(i);
    }

    // driver class for creating a graph
    public static void main(String[] args){
        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        dfs(g);
    }

}

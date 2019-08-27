package com.self.algoAndPuzzles;

import com.self.basics.Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class SCC_KosaRajusAlgo {
    public static void sCC(Graph g) {
        int v = g.vertices;
        Stack s = new Stack();
        boolean[] visited = new boolean[v];

        Arrays.fill(visited,false);

        for (int i=0;i<v;i++) {
            if (!visited[i]) {
                topologicalSortUtil(i,visited,g,s);
            }
        }

        Graph gt = transpose(g);

        Arrays.fill(visited,false);

        while (!s.isEmpty()) {
            int n = (int)s.pop();
            if (!visited[n]) {
                DFSUtil(n,visited,gt);
                System.out.println();
            }
        }
    }

    public static void topologicalSortUtil(int i, boolean[] visited, Graph g, Stack s){
        visited[i] = true;
        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()){
            int n = it.next();
            if (!visited[n]) {
                topologicalSortUtil(n,visited,g,s);
            }
        }

        s.push(i);
    }

    public static Graph transpose(Graph g) {
        int v = g.vertices;
        Graph gt = new Graph(v);
        for (int i=0;i<v;i++) {
            Iterator<Integer> it = g.adj[i].listIterator();
            while (it.hasNext()){
                int n = it.next();
                gt.addEdge(n,i);
            }
        }
        return gt;
    }

    public static void DFSUtil(int i, boolean[] visited, Graph g) {
        visited[i] = true;
        System.out.print(i + " ");

        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFSUtil(n,visited,g);
            }
        }
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        sCC(g);
    }
}

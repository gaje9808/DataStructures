package com.self.basics;

import java.util.LinkedList;

// A normal undirected Graph with v vertices and addEdge method
public class Graph {
    int vertices;
    LinkedList<Integer> adj[];

    Graph(int v){
        vertices = v;
        adj = new LinkedList[v];

        for (int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
//        adj[b].add(a);
    }
}

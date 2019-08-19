package com.self.basics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInUnDirectedGraph {
//using DFS we can solve this easily as we want to establish a parent child relationship between two vertices
//which can't be done very easily with bfs.
// To asset that there's a cycle we have to come back to the original point of starting after certain number of
// traversals. In dfs we always have know the recent parent of a vertex and hence finding a cycle becomes really easy.
    public static boolean isCyclicdfs(Graph g) {
        int v = g.vertices;
        boolean[] visited = new boolean[v];

        Arrays.fill(visited,false);
        for (int i=0;i<v;i++)
            if (!visited[i]) {
                if (isCyclicUtildfs(i,visited,g, -1))
                    return true;
            }
        return false;
    }

    public static boolean isCyclicUtildfs(int i, boolean[] visited, Graph g, int parent) {
        visited[i] = true;

        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                if(isCyclicUtildfs(n,visited,g,i))
                    return true;
            }
            else if (i!= parent) return true;
        }
        return false;
    }

    // driver method similar to the one on geeks for geeks
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (isCyclicdfs(g1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (isCyclicdfs(g2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}

package com.self.basics;

import java.util.Arrays;
import java.util.Iterator;

public class DetectCycleInDirectedGraph {
    public static boolean isCyclicdfs(Graph g) {
        int v = g.vertices;
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        Arrays.fill(visited,false);
        Arrays.fill(recStack, false);

        for (int i=0;i<v;i++) {
                if (!visited[i] && isCyclicUtildfs(i,visited,recStack,g))
                    return true;
        }
        return false;
    }

    public static boolean isCyclicUtildfs(int i, boolean[] visited, boolean[] recStack, Graph g) {
        if (recStack[i]) return true;

        visited[i] = true;
        recStack[i] = true;

        Iterator<Integer> it = g.adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
                if (isCyclicUtildfs(n,visited,recStack,g))
                    return true;
        }

        recStack[i] = false;
        return false;
    }

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

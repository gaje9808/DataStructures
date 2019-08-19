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
                if (isCyclicUtildfs(i,visited,recStack,g))
                    return true;
        }
        return false;
    }

    public static boolean isCyclicUtildfs(int i, boolean[] visited, boolean[] recStack, Graph g) {
        if (recStack[i]) return true;
        if (visited[i]) return false;

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
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(isCyclicdfs(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}

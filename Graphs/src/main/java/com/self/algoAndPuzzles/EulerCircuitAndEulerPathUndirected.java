package com.self.algoAndPuzzles;

import com.self.basics.Graph;

import java.util.Arrays;
import java.util.Iterator;

public class EulerCircuitAndEulerPathUndirected {
    public static int eulerian(Graph g){
        int v = g.vertices;
        if (isConnected(g)  == false)
            return 0;
        int odd = 0;
        for (int i=0;i<v;i++) {
            if (g.adj[i].size() %2 !=0)
                odd++;
        }
        if (odd > 2) return 0;
        return (odd == 2) ? 1:2;
    }

    public static boolean isConnected(Graph g) {
        int v = g.vertices;
        boolean[] visited = new boolean[v];
        Arrays.fill(visited,false);

        int i;
        for (i=0;i<v;i++) {
            if (g.adj[i].size() !=0)
                break;
        }

        if (i == v) return true;

        DFSUtil(i,visited,g);

        for (i=0;i<v;i++)
            if (!visited[i] && g.adj[i].size() >0)
                return false;

        return true;

    }

    public static void DFSUtil(int i, boolean[] visited, Graph g) {
        visited[i] = true;

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
        // Let us create and test graphs shown in above figures
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        int res = eulerian(g1);
        test(res);

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        res = eulerian(g2);
        test(res);


        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        res = eulerian(g3);
        test(res);

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        Graph g4 = new Graph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        res = eulerian(g4);
        test(res);

        // Let us create a graph with all veritces
        // with zero degree
        Graph g5 = new Graph(3);
        res = eulerian(g5);
        test(res);
    }

    public static void test(int res)
    {
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }
}

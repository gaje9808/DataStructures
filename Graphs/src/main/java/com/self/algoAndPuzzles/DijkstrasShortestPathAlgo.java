package com.self.algoAndPuzzles;

import com.self.basics.Graph;

import java.util.ArrayList;
import java.util.Arrays;

// Find shortest path from source to all vertices in the graph
public class DijkstrasShortestPathAlgo {
    public static int minDist(int dist[],boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i=0;i<dist.length;i++) {
            if (!visited[i] && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void dijkstra(int[][] g, int src) {
        int v = g.length;
        int dist[] = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);

        dist[src] = 0;

        for (int i=0;i<v-1;i++){
            int u=minDist(dist,visited);
            visited[u] = true;

            for (int j=0;j<v;j++) {
                if (!visited[j] && (dist[u] != Integer.MAX_VALUE) && (g[u][j] != 0) && (dist[j]>dist[u]+g[u][j])){
                    dist[j] = g[u][j] + dist[u];
                }
            }
        }

        for (int i=0;i<v;i++){
            System.out.print(dist[i] + " " );
        }
    }

    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph,0);
    }



}

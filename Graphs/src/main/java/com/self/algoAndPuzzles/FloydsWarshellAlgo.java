package com.self.algoAndPuzzles;


// Algorith to find min distance between all pair of vertices
public class FloydsWarshellAlgo {
    public static void floydWarshell (int a[][]){
        int n = a.length;
        int[][] dist  = new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                dist[i][j] = a[i][j];
            }
        }
        print(dist);

        for (int k =0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        System.out.println();
        print(dist);
    }

    public static void print(int[][] a) {
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { {0,   5,  Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, 0,   3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        // Print the solution
        floydWarshell(graph);
    }
}

package com.self.grid;

/* The problem here is that yoou are a Binary rectangular matrix and you have to find the
shortest path in the maze from source to a given destination.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze_LeesAlgo {
    public static void main(String[] args) {
        // input maze
        int[][] mat =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                };

        // Find shortest path from source (0, 0) to destination (7, 5)
        findShortPathbfs(mat, 0, 0, 7, 5);
//        findShortPathdfs(mat, 0, 0, 7, 5);

    }

    public static class Node{
        int x, y,dist;
        Node(int a,int b, int d) {
            x = a;
            y = b;
            dist = d;
        }
    }

    public static boolean isSafe(int x, int y, int[][] M, boolean[][] visited){
        int m = M.length;
        int n = M[0].length;
        return (x>=0 && x<m && y>=0 && y<n && M[x][y] ==1 && !visited[x][y]);
    }

//---------------------******USING BFS***********----------------------------------------
    public static void findShortPathbfs(int[][] M, int i, int j, int x, int y){
        int m = M.length;
        int n = M[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Node> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Node(i,j,0));

        int[] row = new int[]{-1,0,0,1};
        int[] col = new int[]{0,-1,1,0};
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node s = q.poll();
            i = s.x;
            j = s.y;
            int dist = s.dist;
            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            for (int k=0;k<4;k++){
                if (isSafe(i+row[k],j+col[k],M,visited)){
                    visited[i+row[k]][j+col[k]] = true;
                    q.add(new Node(i+row[k],j+col[k],dist+1));
                }
            }
        }

        if (minDist != Integer.MAX_VALUE) System.out.println(minDist);
        else System.out.println("Can't find");
    }
//------------------------------********************************------------------------------


// To do
//---------------------------*********USING DFS**********************-------------------------
//
//   public static void findShortPathdfs(int[][] M, int i, int j, int x, int y) {
//        int m = M.length;
//        int n = M[0].length;
//        int dist = 0;
//        boolean[][] visited = new boolean[m][n];
//
//        int mindist = findShortPathdfsUtil(M,i,j,x,y,visited,0,Integer.MAX_VALUE);
//       System.out.println(mindist);
//   }
//
//   public static int findShortPathdfsUtil(int[][] M, int i, int j, int x, int y, boolean[][] visited, int dist, int minDist) {
//        visited[i][j] = true;
//        if (i==x && j==y) {
//            return dist;
//        }
//        int[] row = new int[]{-1,0,0,1};
//        int[] col = new int[]{0,-1,1,0};
//
//        for (int k=0;k<4;k++){
//            if (isSafe(i+row[k],j+col[k],M,visited) && dist !=Integer.MAX_VALUE){
//                dist = findShortPathdfsUtil(M,i+row[k],j+col[k],x,y,visited,dist+1,minDist);
//                minDist = Math.min(minDist,dist);
//            }
//        }
//        return minDist;
//   }


}



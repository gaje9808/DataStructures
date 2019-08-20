package com.self.grid;

import com.self.basics.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };

        countIslands(M);

    }

    public static boolean isSafe(int[][] M, int i, int j, boolean[][] visited) {
        return (i>=0 && i< M.length && j>=0 && j<M[0].length && !visited[i][j] && M[i][j] == 1);
    }
//--------------------************USING DFS******************----------------------------------------------
//    public static void countIslands(int[][] M) {
//        int m = M.length;
//        int n = M[0].length;
//        int count=0;
//        boolean[][] visited = new boolean[m][n];
//
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++) {
//                if (!visited[i][j] && M[i][j] == 1) {
//                    dfs(M,i,j,visited);
//                    ++count;
//                }
//            }
//        }
//        System.out.println("total islands = "+count);
//    }
//
//    public static void dfs(int[][] M, int i, int j, boolean[][] visited) {
//        visited[i][j] = true;
//        int[] row = new int[]{-1,-1,-1,0,0,1,1,1};
//        int[] col = new int[]{-1,0,1,-1,1,-1,0,1};
//
//        for (int k=0;k<8;k++) {
//            if (isSafe(M,i+row[k], j+col[k], visited)) {
//                dfs(M,i+row[k],j+col[k], visited);
//            }
//        }
//    }
//-----------------------------******************************--------------------------------------

//------------------------*********USING BFS*********************----------------------------------

    public static class Node {
        int x,y;
        Node(int i, int j) {
            x=i;
            y=j;
        }
    }
    public static void countIslands(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int count =0;

        boolean[][] visited = new boolean[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if (!visited[i][j] && M[i][j] == 1) {
                    countIslandsUtil(M,i,j,visited);
                    count++;
                }
        System.out.println("total islands = "+count);

    }

    public static void countIslandsUtil(int[][] M, int i,int j, boolean[][] visited){
        Queue<Node> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Node(i,j));

        int[] row = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] col = new int[]{-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {
            Node s = q.poll();
            i = s.x;
            j = s.y;

            for (int k=0;k<8;k++) {
                if(isSafe(M,i+row[k],j+col[k],visited)){
                    visited[i+row[k]][j+col[k]] = true;
                    q.add(new Node(i+row[k],j+col[k]));

                }
            }
        }
    }
//--------------------------****************************------------------------------------------

}

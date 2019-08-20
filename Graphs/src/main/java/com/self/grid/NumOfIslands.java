//package com.self.grid;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class NumOfIslands {
//    public static void main(String[] args) {
//        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
//                                  { 0, 1, 0, 0, 1 },
//                                  { 1, 0, 0, 1, 1 },
//                                  { 0, 0, 0, 0, 0 },
//                                  { 1, 0, 1, 0, 1 } };
//
//        countIslands(M);
//
//    }

    // USING DFS----------------------------------------------
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
//
//    public static boolean isSafe(int[][] M, int i, int j, boolean[][] visited) {
//        return (i>=0 && i< M.length && j>=0 && j<M[0].length && !visited[i][j] && M[i][j] == 1);
//    }

//    // usings BFS--------------------------------------------------
//
//    public static class Node {
//        int x, y;
//        Node (int i, int j) {
//            x = i;
//            y = j;
//        }
//    }
//    public static void countIslands(int[][] M) {
//        int m = M.length;
//        int n = M[0].length;
//        boolean[][] visited = new boolean[m][n];
//        Queue<Node> q = new LinkedList<>();
//        visited[0][0] = true;
//        q.add(new Node(0,0));
//
//        while (!q.isEmpty()) {
//            Node s = q.poll();
//
//        }
//
//
//    }
//
//}

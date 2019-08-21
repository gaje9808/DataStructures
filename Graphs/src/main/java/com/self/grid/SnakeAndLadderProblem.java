package com.self.grid;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderProblem {
    public static void main(String[] args)
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

    public static class Node{
        int x, dist;
        Node(int i, int d) {
            x = i;
            dist = d;
        }
    }

    public static int getMinDiceThrows(int[] moves,int N){
        boolean[] visited = new boolean[N];
        Queue<Node> q = new LinkedList<>();

        visited[0] = true;
        Node s = new Node(0,1);
        q.add(s);

        while( !q.isEmpty()) {
            s = q.poll();
            int i = s.x;
            int dist = s.dist;

            for (int k=i+1;k<=i+6 && k<N;k++){
                if (!visited[k]) {
                    if (moves[k] != -1) i = moves[k];
                    visited[k] = true;
                    q.add(new Node(i,dist+1));
                }
            }
        }
        return s.dist;
    }
}

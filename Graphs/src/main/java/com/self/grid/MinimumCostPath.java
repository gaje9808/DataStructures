package com.self.grid;

public class MinimumCostPath {
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(minCost(cost,2,2));
    }

    public static int minCost(int[][] cost, int x, int y){
        int m = cost.length-1;
        int n = cost[0].length-1;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = cost[0][0];

        for (int i=1;i<=m;i++){
            dp[i][0] = dp[i-1][0] + cost[i][0];
        }

        for (int j=1;j<=n;j++){
            dp[0][j] = dp[0][j-1]+ cost[0][j];
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + cost[i][j];
            }
        }
        return dp[m][n];
    }
}

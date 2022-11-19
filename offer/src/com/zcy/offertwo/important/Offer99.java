package com.zcy.offertwo.important;

public class Offer99 {
//    //dfs超时
//    int m;
//    int n;
//    int res;
//    public int minPathSum(int[][] grid) {
//        m = grid.length;
//        n = grid[0].length;
//        res = Integer.MAX_VALUE;
//        dfs(grid,0,0,0);
//        return res;
//    }
//    public void dfs(int[][] grid,int i,int j,int sum){
//        if(i == m - 1 && j == n - 1){
//            res = Math.min(res,sum+grid[i][j]);
//            return;
//        }
//        if(i < m - 1)dfs(grid,i+1,j,sum+grid[i][j]);
//        if(j < n - 1)dfs(grid,i,j+1,sum+grid[i][j]);
//    }
    public static void main(String[] args){
       minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}});
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];  //i,j位置出发的最小值
        dp[m - 1][n - 1] = grid[m -1][n - 1];
        for(int i = n - 2;i >= 0;i--) dp[m - 1][i] = dp[m - 1][i + 1]+grid[m - 1][i];
        for(int i = m - 2;i >= 0;i--) dp[i][n -1] = dp[i+1][n - 1]+grid[i][n -1];
        for(int i = m - 2;i >= 0;i--){
            for(int j = n - 2;j>=0;j--){
                dp[i][j] = Math.min(dp[i+ 1][j],dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}

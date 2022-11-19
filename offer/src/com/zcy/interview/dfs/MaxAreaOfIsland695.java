package com.zcy.interview.dfs;
import java.util.*;

public class MaxAreaOfIsland695 {
    static int cnt;
    static int res;
    public static void main(String[] args) {
        cnt = 0;
        res = 0;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(maxAreaOfIsland(grid));

    }


    public static int maxAreaOfIsland(int[][] grid) {
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    res = Math.max(res,cnt);
                    cnt = 0;
                }
            }
        }
        return res;
    }
    public static void dfs(int[][] grid,int i,int j){
        if(grid[i][j] == 0) return;
        cnt++;
        grid[i][j] = 0;
        if(i+1 < grid.length)dfs(grid,i+1,j);
        if(i-1 >= 0)dfs(grid,i-1,j);
        if(j+1 < grid[0].length)dfs(grid,i,j+1);
        if(j-1 >= 0)dfs(grid,i,j-1);
    }
}

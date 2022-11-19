package com.zcy.DFS;

import java.util.Scanner;

public class NumEnclaves1020 {
   //自写击败百分5,2000ms
    boolean[][] vis;
    public int numEnclaves(int[][] grid) {

        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                vis = new boolean[grid.length][grid[0].length];
                if(grid[i][j] == 1&&!dfs(grid,i,j)) res++;
            }
        }
        return res;
    }
    public boolean dfs(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        if(i == 0 || i == m - 1||j == 0|| j == n - 1){
            return true;
        }
        if(grid[i+1][j] == 1&&!vis[i+1][j]){
            if(dfs(grid,i+1,j)) return true;
        }
        if(grid[i-1][j] == 1&&!vis[i-1][j]){
            if(dfs(grid,i-1,j)) return true;
        }
        if(grid[i][j+1] == 1&&!vis[i][j+1]){
            if(dfs(grid,i,j + 1)) return true;
        }
        if(grid[i][j - 1] == 1&&!vis[i][j - 1]){
            if(dfs(grid,i,j - 1)) return true;
        }
        return false;
    }
    //官方击败45
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

}

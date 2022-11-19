package com.zcy.DFS;

public class MaxAreaOfIsland695 {
    //简单dfs
    int cnt;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    cnt = 0;
                    dfs(grid,i,j);
                    res = Math.max(res,cnt);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid,int i,int j){
        if(j < 0||j > grid[0].length - 1||i < 0||i>grid.length - 1||grid[i][j] == 0){
            return;
        }
        if(grid[i][j] == 1){
            cnt +=1;
            grid[i][j] = 0;
        }
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}

package com.zcy.DFS;

public class HasValidPath1391 {
    //煞笔题，自写
    boolean[][] vis;
    public boolean hasValidPath(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        return dfs(grid,0,0);
    }
    public boolean dfs(int[][] grid,int i,int j){
        if(i == grid.length - 1&&j == grid[0].length - 1){
            return true;
        }

        vis[i][j] = true;
        if(grid[i][j] == 1){
            boolean flag1 = false;
            boolean flag2 = false;
            if(j+1<grid[0].length&&!vis[i][j+1]&&(grid[i][j+1] == 1||grid[i][j+1] == 3 ||grid[i][j+1] == 5)){
                flag1 = dfs(grid,i,j+1);
            }
            if(j-1>=0&&!vis[i][j-1]&&(grid[i][j-1] == 1||grid[i][j-1] == 4 ||grid[i][j-1] == 6)){
                flag2 = dfs(grid,i,j-1);
            }
            return flag1||flag2;
        }
        if(grid[i][j] == 2){
            boolean flag1 = false;
            boolean flag2 = false;
            if(i+1<grid.length&&!vis[i+1][j]&&(grid[i+1][j] == 2||grid[i+1][j] == 5 ||grid[i+1][j] == 6)){
                flag1 = dfs(grid,i+1,j);
            }
            if(i-1>=0&&!vis[i - 1][j]&&(grid[i-1][j] == 2||grid[i - 1][j] == 4 ||grid[i - 1][j] == 3)){
                flag2 = dfs(grid,i - 1,j);
            }
            return flag1||flag2;
        }
        if(grid[i][j] == 3){
            boolean flag1 = false;
            boolean flag2 = false;
            if(i+1<grid.length&&!vis[i+1][j]&&(grid[i+1][j] == 2 ||grid[i+1][j] == 5||grid[i+1][j] == 6)){
                flag1 = dfs(grid,i+1,j);
            }
            if(j-1>=0&&!vis[i][j-1]&&(grid[i][j-1] == 1 ||grid[i][j-1] == 4||grid[i][j-1] == 6)){
                flag2 = dfs(grid,i,j-1);
            }
            return flag1||flag2;
        }
        if(grid[i][j] == 4){
            boolean flag1 = false;
            boolean flag2 = false;
            if(i+1<grid.length&&!vis[i+1][j]&&(grid[i+1][j] == 2 ||grid[i+1][j] == 5||grid[i+1][j] == 6)){
                flag1 = dfs(grid,i+1,j);
            }
            if(j+1<grid[0].length&&!vis[i][j+1]&&(grid[i][j+1] == 1 ||grid[i][j+1] == 3||grid[i][j+1] == 5)){
                flag2 = dfs(grid,i,j+1);
            }
            return flag1||flag2;
        }
        if(grid[i][j] == 5){
            boolean flag1 = false;
            boolean flag2 = false;
            if(i -1>=0&&!vis[i - 1][j]&&(grid[i-1][j] == 2 ||grid[i-1][j] == 3||grid[i-1][j] == 4)){
                flag1 = dfs(grid,i-1,j);
            }
            if(j-1>=0&&!vis[i][j-1]&&(grid[i][j-1] == 1 ||grid[i][j-1] == 4||grid[i][j-1] == 6)){
                flag2 = dfs(grid,i,j-1);
            }
            return flag1||flag2;
        }
        if(grid[i][j] == 6){
            boolean flag1 = false;
            boolean flag2 = false;
            if(i -1>=0&&!vis[i-1][j]&&(grid[i-1][j] == 2 ||grid[i-1][j] == 3||grid[i-1][j] == 4)){
                flag1 = dfs(grid,i-1,j);
            }
            if(j+1<grid[0].length&&!vis[i][j+1]&&(grid[i][j+1] == 1 ||grid[i][j+1] == 3||grid[i][j+1] == 5)){
                flag2 = dfs(grid,i,j+1);
            }
            return flag1||flag2;
        }
        return false;
    }
}

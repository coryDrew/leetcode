package com.zcy.DFS;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic417 {
    //自写，600ms击败5，一坨屎，太长了
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] res = new int[heights.length][heights[0].length];//0表示既流不到Pac也流不到Atl，1表示能流到其中一个，2表示两个都能流到
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < heights.length;i++){
            for(int j = 0;j < heights[0].length;j++){
                boolean[][] vis1 = new boolean[heights.length][heights[0].length];
                if(bfsForPac(heights,i,j,vis1)){
                    res[i][j]++;
                }
                boolean[][] vis2 = new boolean[heights.length][heights[0].length];
                if(bfsForAtl(heights,i,j,vis2)){
                    res[i][j]++;
                }
                if(res[i][j] == 2){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    private boolean bfsForPac(int[][] heights,int i,int j,boolean[][] vis){
        vis[i][j] = true;
        if(i == 0 || j == 0){
            return true;
        }
        if(!vis[i - 1][j]&&heights[i][j] >= heights[i - 1][j] && bfsForPac(heights,i - 1,j,vis)){
            return true;
        }
        if(i+1 < heights.length&&!vis[i + 1][j]&&heights[i][j] >= heights[i + 1][j] && bfsForPac(heights,i + 1,j,vis)){
            return true;
        }
        if(j+1 < heights[0].length&&!vis[i][j + 1]&&heights[i][j] >= heights[i][j + 1] && bfsForPac(heights,i,j+1,vis)){
            return true;
        }
        if(!vis[i][j - 1]&&heights[i][j] >= heights[i][j - 1] && bfsForPac(heights,i,j - 1,vis)){
            return true;
        }
        return false;
    }
    private boolean bfsForAtl(int[][] heights,int i,int j,boolean[][] vis){
        vis[i][j] = true;
        if(i == heights.length - 1 || j == heights[0].length - 1){
            return true;
        }
        if(i-1>=0&&!vis[i - 1][j]&& heights[i][j] >= heights[i - 1][j] && bfsForAtl(heights,i - 1,j,vis)){
            return true;
        }
        if(!vis[i + 1][j]&&heights[i][j] >= heights[i + 1][j] && bfsForAtl(heights,i + 1,j,vis)){
            return true;
        }
        if(!vis[i][j + 1]&&heights[i][j] >= heights[i][j + 1] && bfsForAtl(heights,i,j+1,vis)){
            return true;
        }
        if(j - 1>=0&&!vis[i][j - 1]&&heights[i][j] >= heights[i][j - 1] && bfsForAtl(heights,i,j - 1,vis)){
            return true;
        }
        return false;
    }
    //官方dfs，4ms
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic666(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }
}

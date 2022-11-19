package com.zcy.array;

public class CountServers1267 {

    public static void main(String[] args) {
        ThreadLocal
        int[][] grid = new int[][]{{1,0},{0,1}};
        countServers(grid);
    }
    public static int countServers(int[][] grid) {
        int[] cntRow = new int[grid.length];
        int[] cntCol = new int[grid[0].length];
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                cntRow[i] += grid[i][j];
                cntCol[j] += grid[i][j];
            }
        }
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1&&(cntRow[i]>1 ||cntCol[j] > 1))
                    res++;

            }
        }
        return res;
    }
}

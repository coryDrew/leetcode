package com.zcy.offertwo;

public class Offer013 {
    //一维前缀和，速度太慢
    int[][] matrix;
    int[][] left;
    public Offer013(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        left = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                left[i][j] = j>0?left[i][j - 1]+matrix[i][j]:matrix[i][0];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1;i <= row2;i++){
            res+=left[i][col2] - left[i][col1]+matrix[i][col1];
        }
        return res;
    }
    //********************************************************
    int[][] sums;

    public Offer013(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //sums[1][1]代表第一行第一列，这里指的就是第一个元素
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        //最大的减两块，再把减重复的给加上
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

}

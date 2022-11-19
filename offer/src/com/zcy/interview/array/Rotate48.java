package com.zcy.interview.array;

public class Rotate48 {
    public void rotate(int[][] matrix) {
        //先根据水平轴翻转，再跟据主对角线对称
        int m = matrix.length,n = matrix[0].length;
        for(int i = 0;i < m/2;i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[m - i - 1];
            matrix[m - i - 1] = tmp;
        }
        for(int i = 0;i < m;i++){
            for(int j = i + 1;j < n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }
}

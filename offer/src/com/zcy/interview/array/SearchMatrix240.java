package com.zcy.interview.array;

public class SearchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0,j = n - 1;
        while(i < m && j>= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                i++;
                continue;
            }
            if(matrix[i][j] > target){
                j--;

            }
        }
        return false;
    }
}

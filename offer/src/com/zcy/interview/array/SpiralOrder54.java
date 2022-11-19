package com.zcy.interview.array;

public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //while(true)
        //四个变量
        //四个退出条件
        if(matrix.length == 0)return new ArrayList<>();
        int m = matrix.length,n = matrix[0].length;
        int top = 0,bottom = m - 1,left = 0,right = n - 1;
        List<Integer> res = new ArrayList<>();
        while(true){
            for(int i = left;i <= right;i++){
                res.add(matrix[top][i]);
            }
            if(++top > bottom)break;
            for(int i = top;i <= bottom;i++){
                res.add(matrix[i][right]);
            }
            if(--right < left)break;
            for(int i = right;i >= left;i--){
                res.add(matrix[bottom][i]);
            }
            if(--bottom < top)break;
            for(int i = bottom;i >= top;i--){
                res.add(matrix[i][left]);
            }
            if(++left > right)break;
        }
        return res;
    }
}

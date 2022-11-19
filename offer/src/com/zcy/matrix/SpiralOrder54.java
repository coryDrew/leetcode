package com.zcy.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    //周赛没写出来，再不会就可以重开了
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int top = 0,bottom = matrix.length - 1,left = 0,right = matrix[0].length - 1;
        while(true){
            for(int i = left;i <= right;i++){
                list.add(matrix[top][i]);
            }
            if(++top>bottom){
                break;
            }
            for(int i = top;i <= bottom;i++){
                list.add(matrix[i][right]);
            }
            if(--right<left){
                break;
            }
            for(int i = right;i >=left;i--){
                list.add(matrix[bottom][i]);
            }
            if(--bottom<top){
                break;
            }
            for(int i = bottom;i >= top;i--){
                list.add(matrix[i][left]);
            }
            if(++left>right){
                break;
            }
        }
        return list;
    }
}

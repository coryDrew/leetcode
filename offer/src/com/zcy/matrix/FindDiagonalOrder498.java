package com.zcy.matrix;

import java.util.Arrays;

public class FindDiagonalOrder498 {
    //煞笔题目，恶心边界
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};

        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        //简单模拟
        int[] res = new int[mat.length * mat[0].length];
        int row  = mat.length,column = mat[0].length;
        int r = 0,c = 0;//当前遍历到的行和列
        for(int i = 0;i < res.length;i++){
            res[i] = mat[r][c];
            if((r+c)%2 == 0){//偶数，向上遍历
                if(c == column - 1){
                    r++;
                }//碰到右边,就向下
                else if(r == 0){
                    c++;
                }//碰到上面,就向右
                else{
                    r--;
                    c++;
                }
            }else{//奇数，向下遍历
                if(r == row - 1){//碰到下面，就向右
                    c++;
                }else if(c == 0){//碰到左边，就向下      恶心死了，和上面的顺序还不能反（因为可能同时到了左边界和下边界，这时应该向右），反了会发生越界的！！！！！！！！！，调半天bug才发现
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}

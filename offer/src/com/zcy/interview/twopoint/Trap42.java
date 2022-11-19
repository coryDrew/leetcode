package com.zcy.interview.twopoint;

import java.util.concurrent.locks.ReentrantLock;

public class Trap42 {
    //还得我左神的方法
    public int trap(int[] height) {
        ReentrantLock
        //每一列的雨水量   左边最高的和右边最高的取小，然后减去当前列的高度

        int len = height.length;
        if(len == 1)return 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int l = 1;
        int r = len - 2;
        int res = 0;
        while(l <= r){//两种情况，分别确定左边或右边的一个位置
            if(leftMax <= rightMax){
                res+=Math.max(0,leftMax - height[l]);
                leftMax = Math.max(leftMax,height[l]);
                l++;
            }else{
                res+=Math.max(0,rightMax - height[r]);
                rightMax = Math.max(rightMax,height[r]);
                r--;
            }
        }
        return res;
    }
}

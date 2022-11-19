package com.zcy.twoPoints;

public class SortedSquares977 {
    public int[] sortedSquares(int[] nums) {
        //双指针
        //找正负数的临界i，负数0~i递减，整数i+1~n递增
        int neg = -1;
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] < 0 && nums[i+1] >=0){
                neg = i;
                break;
            }
        }
        int len = nums.length;
        int[] res = new int[len];
        if(neg == -1){
            if(nums[0] < 0){
                for(int i = len- 1;i >= 0;i--){
                    res[len - i - 1] = nums[i]*nums[i];
                }
            }else{
                for(int i = 0;i <len;i++){
                    res[i] = nums[i]*nums[i];
                }
            }

            return res;
        }
        int l = neg,r = neg + 1;
        int index = 0;
        while(l>=0&&r<len){
            int lNum = nums[l]*nums[l];
            int rNum = nums[r]*nums[r];
            if(lNum > rNum){
                res[index++] = rNum;
                r++;
            }else{
                res[index++] = lNum;
                l--;
            }
        }
        if(l>=0){
            for(int i = l;i>=0;i--){
                res[index++] = nums[i]*nums[i];
            }
        }
        if(r<len){
            for(int i = r;i<len;i++){
                res[index++] = nums[i]*nums[i];
            }
        }
        return res;

    }
}

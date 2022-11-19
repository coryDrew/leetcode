package com.zcy.DP;

public class CombinationSum4 {
    //回溯超时！！！！！
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        backtrack(nums,target);
        return res;
    }
    private void backtrack(int[] nums,int target){
        if(target == 0){
            res++;
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(target - nums[i]>=0)
                backtrack(nums,target - nums[i]);
        }
    }//可以重复使用元素

    //正解：dp
    //想不起来啊，哎哎哎
    public int combinationSum4dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1;i <= target;i++){
            for(int j = 0;j < nums.length;j++){
                if(nums[j] <= i){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

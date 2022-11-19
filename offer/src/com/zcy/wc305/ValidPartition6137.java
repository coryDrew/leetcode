package com.zcy.wc305;

public class ValidPartition6137 {
    //自己dp写错了，写的很复杂
    //正解如下：
    //有些细节，越界等细节，没把握住，这周是最简单的了
    public boolean validPartition(int[] nums) {
        if(nums.length == 2){
            return nums[0] == nums[1];
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = false;
        dp[1] = nums[0] == nums[1] ? true:false;
        dp[2] = nums[0] == nums[1]&& nums[1] == nums[2] || nums[1] - nums[0] == 1&&nums[2] - nums[1] == 1;
        for(int i =  3;i < nums.length;i++){
            dp[i] = dp[i - 3]&&nums[i] == nums[i - 1]&& nums[i - 1] == nums[i - 2]
                    ||dp[i - 3] &&nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1
                    ||dp[i - 2] &&nums[i] == nums[i - 1];
        }
        return dp[nums.length - 1];
    }
}

package com.zcy.BAG;

public class FindTargetSumWays494 {
    //恶心
    //背包问题一般dp[i][j]中的i表示前i个，而不是0~i，为了防止下标越界！！！
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum+=nums[i];
        }
        if(sum - target < 0|| (sum - target) % 2 != 0){//为什么是奇数也不行？如果是奇数，除以2就是一个小数，而题目都是整数，无法组合成一个小数！！！！！
            return 0;
        }
        int need = (sum - target)/2;
        int len = nums.length;
        int[][]dp = new int[len+1][need+1];//dp[i][j]表示前i个数选出来和为j的方式，这里用前i个数，而不是0~i下标，是为了防止下标越界！！！
        dp[0][0] = 1;
        for(int i = 1;i <= len;i++){
            for(int j = 0;j <= need;j++){
                if(j<nums[i-1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[len][need];
    }
}

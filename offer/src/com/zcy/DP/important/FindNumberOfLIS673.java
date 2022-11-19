package com.zcy.DP.important;

import java.util.Arrays;

public class FindNumberOfLIS673 {
    //300题基础上加一个数组
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] combination = new int[nums.length];//记录次数

        Arrays.fill(dp, 1);
        Arrays.fill(combination, 1);

        int max = 1, res = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) { //如果+1长于当前LIS 则组合数不变
                        dp[i] = dp[j] + 1;
                        combination[i] = combination[j];
                    } else if (dp[j] + 1 == dp[i]) { //如果+1等于当前LIS 则说明找到了新组合
                        combination[i] += combination[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < nums.length; i++)
            if (dp[i] == max) res += combination[i];

        return res;
    }
}

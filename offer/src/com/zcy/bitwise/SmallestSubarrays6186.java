package com.zcy.bitwise;
/**
 妙的离谱
 dp数组，表示按位存储最近的1的位置。初始化为-1，表示没有1
 从后往前遍历，对于第i个位置：
 2.1 按位遍历，如果出现1，则修改当前位的dp为i。
 2.2 如果当前位的dp不为-1，说明需要计算最远的位置dp-i+1。
 2.3 所有位最远的位置即为最短的长度。
 */
import java.util.Arrays;

public class SmallestSubarrays6186 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[32];
        Arrays.fill(dp, -1);
        int[] ans = new int[n];
        for (int i = n-1; i >= 0; i--) {//倒着遍历，真难啊，这是关键
            int max = 1;
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    dp[j] = i;
                }
                if (dp[j] != -1) {
                    max = Math.max(max, dp[j]-i+1);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}

package com.zcy.DP;

public class NumberOfArithmeticSlices413 {
    //dp主要分析二者（三者）之间的联系，可以是dp[i]和dp[i - 1]之间的关系，也可以是dp[i]和dp[i - 1]和dp[i - 2]三者之间的关系等等，都有可能
    //首先要确定dp[i]代表的含义是什么！最关键的

    /**
     如果转成「自底向上」的思路，就变成了动态规划。

     类似于递归解法，我们定义 dp[i]dp[i] 是以 A[i]A[i] 为终点的等差数列的个数。
     ​

     类似于上面的递归思路，有两种情况：
     ​

     A[i] - A[i - 1] == A[i - 1] - A[i - 2]时，说明增加的A[i]能和前面构成等差数列，那么 dp[i] = dp[i - 1] + 1；
     A[i] - A[i - 1] != A[i - 1] - A[i - 2]时， 说明增加的 A[i]不能和前面构成等差数列，所以dp[i] = 0；
     动态规划的初始状态：dp[0] = 0, dp[1] = 0dp[0]=0,dp[1]=0。
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length <= 2){
            return 0;
        }
        dp[0] = 0;
        dp[1] = 0;
        int sum = 0;
        for(int i = 2;i < nums.length;i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
            }
            sum += dp[i];
        }
        return sum;
    }
}

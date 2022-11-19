package com.zcy.DP;

public class MaxSumTwoNoOverlap1031 {
    //枚举分割点！！在左边和右边分别算！
    //分割点太重要了，一下就清晰了
    /**
     思路:
     考虑题意: 必然存在一条分界线把 A 拆分成两半，存在两大类情况：
     长度为 L 的连续子数组在左边, 长度为 M 的连续子数组在右边
     或者反过来长度为 M 的连续子数组在左边, 长度为 L 的连续子数组在右边
     引入

     dp[i][0]: 从 A[0]-A[i] 连续 L 长度子数组最大的元素和
     dp[i][1]: 从 A[0]-A[i] 连续 M 长度子数组最大的元素和
     dp[i][2]: 从 A[i]-A[A.size()-1] 连续 L 长度子数组最大的元素和
     dp[i][3]: 从 A[i]-A[A.size()-1] 连续 M 长度子数组最大的元素和
     某些超出范围的下标, 值设置为 0 (默认值)
     代码中首先用滑动窗口计算了 dp, 然后将 dp 分成两组, 计算两大类情况下的结果，取最大值返回即可

     作者：blacksea3_nju
     链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/solution/c-dong-tai-gui-hua-hua-dong-chuang-kou-on-by-black/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[][] dp = new int[A.length+1][4];
        int presum = 0;
        int maxsum;
        for (int i = 0; i < L; ++i)
        {
            presum += A[i];
        }
        maxsum = presum;
        dp[L - 1][0] = maxsum;
        for (int i = L; i < A.length; ++i)
        {
            presum -= A[i - L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][0] = maxsum;
        }

        presum = 0;
        for (int i = 0; i < M; ++i)
        {
            presum += A[i];
        }
        maxsum = presum;
        dp[M - 1][1] = maxsum;
        for (int i = M; i < A.length; ++i)
        {
            presum -= A[i - M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][1] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - L; --i)
        {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - L][2] = maxsum;
        for (int i = A.length - L - 1; i >= 0; --i)
        {
            presum -= A[i + L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][2] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - M; --i)
        {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - M][3] = maxsum;
        for (int i = A.length - M - 1; i >= 0; --i)
        {
            presum -= A[i + M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][3] = maxsum;
        }

        //计算答案
        int res = 0;
        //L在M左边
        for (int i = L; i <= A.length - M; ++i)
            res = Math.max(res, dp[i - 1][0] + dp[i][3]);
        //M在L左边
        for (int i = M; i <= A.length - L; ++i)
            res = Math.max(res, dp[i - 1][1] + dp[i][2]);

        return res;
    }
}

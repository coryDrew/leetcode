package com.zcy.tree;

public class MaxValueLCP34 {
    //树形dp，好恶心
    public int maxValue(TreeNode root, int k) {
        int[] ans = traversal(root, k);
        int result = 0;
        // 找出最大值
        for (int a : ans) {
            result = Math.max(result, a);
        }
        return result;
    }

    int[] traversal(TreeNode cur, int k){
        if(cur == null){
            return new int[k + 1];
        }
        // 为什么是k + 1呢？
        // 因为dp[i] 表示对于当前节点为根节点，
        // 相邻蓝色节点数目为i的情况下的最大价值之和
        // 所以先0到k就代表相邻蓝色结点数目是0到k的所有情况
        int[] dp = new int[k + 1];
        int[] left = traversal(cur.left, k);
        int[] right = traversal(cur.right, k);

        // 如果我们选择染这个cur结点
        // 循环只能到k,因为我们还要加上一个当前结点
        for(int i = 0; i < k; i++){
            for(int j = 0; i + j < k; j++){
                // 依次在左边选i个,右边选j个,再加上当前结点
                dp[i + j + 1] = Math.max(dp[i + j + 1],
                        left[i] + right[j] + cur.val);
            }
        }

        // 如果我们不选择染这个cur结点
        // dp[0]就是cur结点为根,相邻蓝色节点数目为0的情况
        // 即表示当前节点为白色，此时无所谓相邻子节点什么颜色，
        // 所以当前节点为根价值总和的最大值为
        // 左子节点所有情况 和 右子节点所有情况 的最大值
        for(int i = 0; i <= k; i++){
            for(int j = 0; j <= k; j++){
                dp[0] = Math.max(dp[0], left[i] + right[j]);
            }
        }
        return dp;
    }
}

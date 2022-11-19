package com.zcy.offertwo.important;

public class Offer051 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        //maxGain指从当前节点开始往下走，能形成的最大节点值的和（有可能最后只是当前节点，下面的都不要）
        if(node == null)return 0;
        int leftMax = Math.max(maxGain(node.left),0);
        int rightMax = Math.max(maxGain(node.right),0);
        maxSum = Math.max(maxSum,node.val+leftMax+rightMax);
        return Math.max(leftMax,rightMax)+node.val;
    }
}

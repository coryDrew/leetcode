package com.zcy.interview.tree;

public class maxPathSum124 {
    //最简单的hard
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxForEach(root);
        return res;
    }
    public int maxForEach(TreeNode root){
        //每个点的最大贡献值
        if(root == null)return 0;
        int left = Math.max(maxForEach(root.left),0);
        int right = Math.max(maxForEach(root.right),0);
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right) + root.val;
    }
}

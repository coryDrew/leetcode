package com.zcy.interview.tree;

public class diameterOfBinaryTree543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        //两种可能，经过根节点与不经过根节点
        //经过根节点，就是两边的最大深度了
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int sec = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(Math.max(left,right),sec);
    }
    public int maxDepth(TreeNode root){
        if(root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

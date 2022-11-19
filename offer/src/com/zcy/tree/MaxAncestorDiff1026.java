package com.zcy.tree;

public class MaxAncestorDiff1026 {
    //带最大最小值的递归，能保证是祖先与子孙的关系
    public int maxAncestorDiff(TreeNode root) {
        int left = maxAncestorDiff(root.left, root.val, root.val);
        int right = maxAncestorDiff(root.right, root.val, root.val);
        return left > right ? left : right;
    }

    public int maxAncestorDiff(TreeNode root, int max, int min){
        if(root == null){
            return 0;
        }
        if(root.val > max){
            max = root.val;
        }
        else if(root.val < min){
            min = root.val;
        }
        if(root.left == null && root.right == null){
            return max - min;
        }
        int left = maxAncestorDiff(root.left, max, min);
        int right = maxAncestorDiff(root.right, max, min);
        return left > right ? left : right;
    }
}

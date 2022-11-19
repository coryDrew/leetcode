package com.zcy.offertwo;

public class Offer047 {
    public TreeNode pruneTree(TreeNode root) {
        return cut(root);
    }
    public TreeNode cut(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = cut(root.left);
        TreeNode right = cut(root.right);
        if(left == null && right == null && root.val == 0){
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}

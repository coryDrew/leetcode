package com.zcy.tree;

public class PruneTree814 {
    //简单递归
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(root.val == 1){
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
        }
        if(root.val == 0){
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root.left == null&&root.right == null ? null :root;
        }
        return root;
    }
}

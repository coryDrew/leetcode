package com.zcy.tree;

public class TrimBST669 {
    //二叉树解法：DFS、BFS、递归。。。。
    //递归，尽量宏观，别陷进去
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return root;
        }
        if(root.val < low){
            root = root.right;
            root = trimBST(root,low,high);
        }else if(root.val > high){
            root = root.left;
            root = trimBST(root,low,high);
        }else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        return root;
    }
}

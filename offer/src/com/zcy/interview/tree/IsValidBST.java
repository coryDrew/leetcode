package com.zcy.interview.tree;

public class IsValidBST {
    //一个flag一个pre
    boolean flag;
    long pre;
    public boolean isValidBST(TreeNode root) {
        pre = Long.MIN_VALUE;
        flag = true;
        dfs(root);
        return flag;
    }
    public void dfs(TreeNode root){
        if(!flag)return;
        if(root == null)return;
        if(root.left != null) dfs(root.left);
        if(root.val <= pre)flag = false;
        pre = root.val;
        if(root.right != null)dfs(root.right);
    }
}

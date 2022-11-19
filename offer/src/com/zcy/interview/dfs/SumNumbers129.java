package com.zcy.interview.dfs;

public class SumNumbers129 {
    //dfs，其实就是回溯
    StringBuilder sb = new StringBuilder();
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        if(root == null)return 0;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        sb.append(root.val);
        if(root.left == null && root.right == null)res+=Integer.valueOf(sb.toString());
        if(root.left != null){
            dfs(root.left);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(root.right != null){
            dfs(root.right);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

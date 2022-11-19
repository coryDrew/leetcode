package com.zcy.interview.tree;

public class kthLargestOffer54 {
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        res = 0;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(k == 0)return;
        if(root == null)return;
        dfs(root.right);
        k--;
        if(k == 0) res = root.val;
        dfs(root.left);
    }
}

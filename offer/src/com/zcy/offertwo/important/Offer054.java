package com.zcy.offertwo.important;

public class Offer054 {
    //按右左头的方式遍历，将值慢慢累加即可
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    public void  dfs(TreeNode root){
        if(root == null)return;
        dfs(root.right);
        sum+=root.val;
        root.val = sum;
        dfs(root.left);
    }
}

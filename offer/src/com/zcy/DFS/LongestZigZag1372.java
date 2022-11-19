package com.zcy.DFS;

public class LongestZigZag1372 {
    //超时啦
    int sum;
    int maxSum;
    public int longestZigZag(TreeNode root) {
        sum = 0;
        maxSum = 0;
        dfs(root);
        return maxSum;
    }
    public void dfs(TreeNode root){
        if(root == null)return;
        int max1;
        int max2;
        longLeft(root,0);
        max1 = sum;
        sum = 0;
        longRight(root,0);
        max2 = sum;
        sum = 0;
        maxSum = Math.max(Math.max(max1,max2),maxSum);
        dfs(root.left);
        dfs(root.right);
    }
    public void longRight(TreeNode root,int cnt){//以root为头的最长交错路径
        //先右后左和先左后右选最长的一个
        if(root == null)return;
        if(cnt%2 == 0){//找右边
            if(root.right != null){
                sum++;
                longRight(root.right,cnt+1);
            }
        }else{

            if(root.left != null){
                sum++;
                longRight(root.left,cnt+1);
            }
        }
    }
    public void longLeft(TreeNode root,int cnt){//以root为头的最长交错路径
        if(root == null)return;
        if(cnt%2 == 0){//找左边
            if(root.left != null){
                sum++;
                longLeft(root.left,cnt+1);
            }
        }else{

            if(root.right != null){
                sum++;
                longLeft(root.right,cnt+1);
            }
        }
    }
    //官解
    int maxAns;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }

    public void dfs(TreeNode o, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1);
            }
            if (o.right != null) {
                dfs(o.right, false, 1);//当方向不匹配时长度回退成1
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1);
            }
            if (o.left != null) {
                dfs(o.left, true, 1);
            }
        }
    }


}

package com.zcy.tree;

public class AverageOfSubtree2265 {
    //better
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        average(root);
        return count;
    }

    // 返回值为 0 ：当前树的结点值和 1：树的结点数目
    int[] average(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] leftAvg = average(root.left);
        int[] rightAvg = average(root.right);

        int sum = leftAvg[0] + rightAvg[0] + root.val;
        int n = leftAvg[1] + rightAvg[1] + 1;
        if (sum / n == root.val) count++;
        return new int[]{sum, n};
    }
    //******************************************
    //自写的破方法
    int res;
    int sum;
    int cnt;
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        sum = 0;
        cnt = 0;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        sum = 0;
        cnt = 0;
        sumCnt(root);
        if(root.val == sum/cnt){
            res++;
        }

        dfs(root.left);

        dfs(root.right);

    }
    public void sumCnt(TreeNode root){//以root为根节点，节点值的和
        if(root == null) return;
        sum+=root.val;
        cnt++;
        sumCnt(root.left);
        sumCnt(root.right);
    }
}

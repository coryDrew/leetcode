package com.zcy.tree;

public class DistributeCoins979 {
    //法一：递归（官解）
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int l =(dfs(node.left));
        int r = (dfs(node.right));
        ans +=  Math.abs(l)+Math.abs(r);
        return r + l + node.val - 1;
    }
    //法二：后续遍历 评论区
    /**
     * 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
     * x-1 < 0说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
     * x-1 == 0说明刚好，无需与父节点有金币的交换，次数加0
     * x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
     */
    private int ans1 = 0;// 移动次数
    public int distributeCoins1(TreeNode root) {
        lrd(root);
        return ans;
    }
    public int lrd(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null){
            root.val += lrd(root.left);
        }
        if(root.right != null){
            root.val += lrd(root.right);
        }
        ans1 += Math.abs(root.val - 1);
        return root.val - 1;
    }
}

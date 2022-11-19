package com.zcy.DFS;

public class MaxProduct1339 {
    //自写超时啦
    int sumForRoot;
    long res = 0;
    public int maxProduct(TreeNode root) {

        sumForRoot = sum(root);

        dfs(root);
        return (int)(res%1000000007);
    }
    public void dfs(TreeNode root){//深搜每一个节点找乘积最大的//这个dfs每个点都要算一个子树和，会超时
        if(root == null) return;
        int partSum = sum(root);
        res = Math.max(res,(long)partSum*(sumForRoot - partSum));
        dfs(root.left);
        dfs(root.right);

    }
    public int sum(TreeNode root){//求任一树的和
        if(root == null)return 0;
        return root.val+sum(root.left)+ sum(root.right);
    }
    //不超时写法
    double ans = Double.MIN_VALUE;
    double allSum;
    double nodeSum;
    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int)(ans % (int)(1e9 + 7));
    }

    public double sum(TreeNode node){
        if(node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }
    //要学会这种dfs的写法，其实有点反人类
    public double dfs(TreeNode node){//这个dfs就不是每个节点都算一遍了，但是仔细看，它和上面的方法不是一样吗，只是每次多算了一次ans而已！
        if(node == null)    return 0 ;
        nodeSum = node.val + dfs(node.left) + dfs(node.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }


}

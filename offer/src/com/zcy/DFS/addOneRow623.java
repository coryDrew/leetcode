package com.zcy.DFS;

public class addOneRow623 {
    //自写dfs，不容易写出来个dfs
    //bfs就很简单了
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode head = new TreeNode(val);
            head.left = root;
            return head;
        }
        dfs(root,val,1,depth);
        return root;
    }
    public void dfs(TreeNode root,int val,int curHeight,int depth){
        if(curHeight == depth - 1){
            //保存当前root的两个子节点
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode increaseleft = new TreeNode(val);
            TreeNode increaseright = new TreeNode(val);
            root.left = increaseleft;
            increaseleft.left = left;
            root.right = increaseright;
            increaseright.right = right;
            return;
        }
        if(root.left != null){
            dfs(root.left,val,curHeight + 1,depth);
        }
        if(root.right != null){
            dfs(root.right,val,curHeight + 1,depth);
        }
    }
}

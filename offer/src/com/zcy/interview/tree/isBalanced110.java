package com.zcy.interview.tree;

public class isBalanced110 {
    class Tmp{
        int height;
        boolean isBal;
        public Tmp(int a,boolean b){
            height = a;
            isBal = b;
        }
    }
    public boolean isBalanced(TreeNode root) {
        //从子树要条件，子树得是平衡二叉树，且两个子树的高度差不能超过1
        return isB(root).isBal;
    }
    public Tmp isB(TreeNode root){
        if(root == null) return new Tmp(0,true);
        Tmp t1 = isB(root.left);
        Tmp t2 = isB(root.right);
        int height = Math.max(t1.height,t2.height) + 1;
        boolean bal = t1.isBal && t2.isBal && Math.abs(t1.height - t2.height) <=1;
        return new Tmp(height,bal);
    }
}

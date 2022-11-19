package com.zcy.offertwo.important;

public class Offer053 {
    //自写
    TreeNode pre = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return res;
    }
    public void inorder(TreeNode node,TreeNode p){
        if(res!=null)return;
        if(node == null) return;
        inorder(node.left,p);
        if(pre == p && res == null){//这个判空很关键，因为直接return会导致pre没变，pre没变如果不判空会导致后面所有的节点都进入if块！
            res = node;
            return;
        }
        pre = node;
        inorder(node.right,p);
    }
}

package com.zcy.offertwo.important;

public class Offer052 {
    //展平，不用新的节点！！！
    TreeNode resNode;//用来遍历的节点
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        resNode.right = node;
        node.left = null;
        resNode = node;
        inorder(node.right);
    }
}

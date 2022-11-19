package com.zcy.tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST1382 {
    //中序遍历后递归构造
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return banlance(0,list.size() - 1);
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public TreeNode banlance(int l,int r){
        if(l>r)return null;
        int mid = ((r - l)>>1)+l;
        TreeNode head = list.get(mid);
        head.left = banlance(l,mid - 1);
        head.right = banlance(mid+1,r);
        return head;
    }
}

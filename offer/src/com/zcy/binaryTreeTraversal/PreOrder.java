package com.zcy.binaryTreeTraversal;

import com.zcy.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    //前中后都用栈，后序最难
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){//循环条件一定要记住啊
            while(root != null){
                res.add(root.val);//上来就加入res了，和另外两种都不一样
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
    public List<Integer> pre(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        while(!stack.isEmpty()|| root != null){
            if(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            root = tmp.right;
        }
    }
}

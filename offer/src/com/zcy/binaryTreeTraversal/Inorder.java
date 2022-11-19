package com.zcy.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inorder {
    //前序中序后序都是用栈
    //中序是简化的后序
    //中序和前序基本一样，只是加入集合的时机不一样
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    public List<Integer> inorder
}

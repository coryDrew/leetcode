package com.zcy.interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class postorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || pre == root.right){
                res.add(root.val);
                pre = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

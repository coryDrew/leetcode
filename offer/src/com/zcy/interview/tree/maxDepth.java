package com.zcy.interview.tree;

import java.util.LinkedList;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;
        if(root == null)return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            res++;
            for(int i = queue.size();i>0;i--){
                TreeNode tmp = queue.poll();
                if(tmp.left != null)queue.offer(tmp.left);
                if(tmp.right != null)queue.offer(tmp.right);
            }
        }
        return res;
    }
    //递归来求
    public int maxDepth(TreeNode root){
        if(root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

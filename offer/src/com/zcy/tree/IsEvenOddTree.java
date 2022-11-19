package com.zcy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int pre = -1;
            for(int i = queue.size();i > 0;i--){
                if(level % 2 == 0){
                    TreeNode tmp = queue.poll();
                    if(tmp.val%2 == 0) return false;
                    if(pre != -1&&tmp.val <=pre) return false;
                    pre = tmp.val;
                    if(tmp.left != null){
                        queue.offer(tmp.left);
                    }
                    if(tmp.right != null){
                        queue.offer(tmp.right);
                    }
                }else{
                    TreeNode tmp = queue.poll();
                    if(tmp.val%2 != 0) return false;
                    if(pre != -1&&tmp.val >=pre) return false;
                    pre = tmp.val;
                    if(tmp.left != null){
                        queue.offer(tmp.left);
                    }
                    if(tmp.right != null){
                        queue.offer(tmp.right);
                    }
                }
            }
            level++;
        }
        return true;
    }
}

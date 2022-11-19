package com.zcy.interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder102 {
    //deque保留了队列和栈的api
    //队列是offer和poll
    //栈是push和pop
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size();i > 0;i--){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

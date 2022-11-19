package com.zcy.interview.tree;

import java.util.List;

public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = s;i>0;i--){
                TreeNode tmp = queue.poll();
                if(i == s){
                    res.add(tmp.val);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
            }
        }
        return res;
    }
}

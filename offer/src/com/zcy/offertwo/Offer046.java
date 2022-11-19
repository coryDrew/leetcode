package com.zcy.offertwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer046 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            //从右往左的层序遍历
            res.add(queue.peek().val);
            for(int i = queue.size();i>0;i--){
                TreeNode tmp = queue.poll();
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

package com.zcy.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView199 {
    //无聊bfs
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = s;i > 0;i--){
                TreeNode tmp = queue.poll();
                if(i == 1){
                    res.add(tmp.val);
                }
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }
        return res;
    }
}

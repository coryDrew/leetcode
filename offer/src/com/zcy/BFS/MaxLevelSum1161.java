package com.zcy.BFS;

import java.util.LinkedList;

public class MaxLevelSum1161 {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxlevel = 1;
        int maxcnt = Integer.MIN_VALUE;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cnt = 0;

            for(int i = queue.size();i>0;i--){
                TreeNode tmp  = queue.poll();
                cnt+=tmp.val;
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            if(cnt > maxcnt){
                maxlevel = level;
                maxcnt = cnt;
            }
            level++;

        }
        return maxlevel;
    }
}

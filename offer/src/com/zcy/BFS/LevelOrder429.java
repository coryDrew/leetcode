package com.zcy.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder429 {//简单层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> part = new ArrayList<>();
            for(int i = queue.size();i> 0;i--){
                Node tmp = queue.poll();
                part.add(tmp.val);
                for(Node child: tmp.children){
                    queue.offer(child);
                }
            }
            res.add(part);
        }
        return res;
    }
}

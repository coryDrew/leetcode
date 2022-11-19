package com.zcy.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree662 {
    //给每个节点编号，root的左节点的编号是root的编号*2，右节点是*2+1
    //每层宽度就是最后一个编号-最开始的编号+1！
    //mlgb
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode,Integer> map = new HashMap<>();//存储节点对应的下标
        Queue<TreeNode> queue = new LinkedList<>();//通过队列实现bfs
        //初始化
        int max = 1;
        queue.offer(root);
        map.put(root,1);
        while (!queue.isEmpty()) {
            int start = map.get(queue.peek());//获取每层起始节点（即最左端点）的下标
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                int index = map.get(node);//获取此节点下标，用与给其的左右孩子确定下标
                if (node.left != null) {
                    map.put(node.left,index*2);//确定左孩子下标
                    queue.offer(node.left);//节点入队
                }
                if (node.right != null) {
                    map.put(node.right,index*2 + 1);//确定右孩子下标
                    queue.offer(node.right);//节点入队
                }
                if(size == 0) max = Math.max(max,index - start + 1);//本层遍历结束，更新层宽最大值
            }
        }
        return max;
    }
}

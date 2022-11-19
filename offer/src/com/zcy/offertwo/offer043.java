package com.zcy.offertwo;

import java.util.LinkedList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class offer043 {

    ReentrantLock
    //自写，速度慢
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        TreeNode node = dfs(root);
        if(node.left == null){
            node.left = new TreeNode(v);
        }else{
            node.right = new TreeNode(v);
        }
        return node.val;
    }
    public TreeNode dfs(TreeNode root){//层序遍历找到第一个儿女不双全的？
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i = queue.size();i> 0;i--){
                TreeNode tmp = queue.poll();
                if(tmp.left == null ||tmp.right == null){
                    return tmp;
                }
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        return null;
    }

    public TreeNode get_root() {
        return root;
    }
    //官解，动态记录不双全的的点
    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }

}

package com.zcy.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator173 {
    //用非递归做
    TreeNode cur;
    Deque<TreeNode> stack;
    public BSTIterator173(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.poll();
        int res = cur.val;
        cur = cur.right;
        return res;
    }




    public boolean hasNext() {
        return  cur != null || !stack.isEmpty();
    }
}



package com.zcy.offertwo.important;

import java.util.LinkedList;

public class offer055 {
    //非递归中序遍历
    TreeNode cur;
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int value = cur.val;
        cur = cur.right;
        return value;
    }

    public boolean hasNext() {
        return cur!=null||!stack.isEmpty();
    }
}

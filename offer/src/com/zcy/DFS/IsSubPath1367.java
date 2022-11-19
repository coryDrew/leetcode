package com.zcy.DFS;

import com.zcy.usualClass.ListNode;

public class IsSubPath1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head,root);
    }
    public boolean dfs(ListNode head,TreeNode root){
        if(root == null) return false;
        if(match(head,root)) return true;
        return dfs(head,root.left)||dfs(head,root.right);
    }
    public boolean match(ListNode head,TreeNode root){//以root节点为头能否匹配
        if(head == null)return true;
        if(root == null)return false;
        if(head.val == root.val){
            return match(head.next,root.left)||match(head.next,root.right);
        }
        return false;
    }
}

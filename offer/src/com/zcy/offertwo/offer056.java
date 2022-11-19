package com.zcy.offertwo;

import java.util.HashSet;
import java.util.Set;

public class offer056 {
    Set<Integer> set;
    boolean flag;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();

        flag = false;
        dfs(root,k);
        return flag;
    }
    public void dfs(TreeNode node,int k){
        if(node == null) return;
        if(flag) return;

        dfs(node.left,k);
        if(set.contains(k - node.val)){
            flag = true;
            return;
        }else{
            set.add(node.val);
        }
        dfs(node.right,k);
    }
    //官解更简洁
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }


}

package com.zcy.offertwo.important;

import com.zcy.tree.TreeInput;
import com.zcy.tree.pathProblem.PathSum113;

import java.util.*;

public class Offer50 {
    //硬遍历，没什么意思，每个节点都来一遍
    int count, num, targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        this.targetSum = targetSum;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){ // BFS遍历所有结点
            TreeNode head = q.remove();
            check(head, 0); // 考察以当前结点为起始的满足要求的路径数量
            if(head.left != null) q.add(head.left);
            if(head.right != null) q.add(head.right);
        }
        return count;
    }
    private void check(TreeNode node, int sum){
        if(node == null) return;
        sum = sum + node.val;
        if(sum == targetSum) count++; // 一旦满足，立即累计
        check(node.left, sum);
        check(node.right, sum);
    }
    //前缀和？？？
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }


}

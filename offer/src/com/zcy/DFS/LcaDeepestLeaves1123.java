package com.zcy.DFS;

import java.util.HashMap;

public class LcaDeepestLeaves1123 {
    // 如果左右子树不等高，高度小的那个子树节点的叶子节点的深度肯定不是最深的（因为比高度大的子树深度小）。 所以，最深叶子节点肯定在深度较大的子树当中，采用深度优先遍历，每次只要继续往深度更大的子树进行递归即可。 如果左右子树深度相同，表示获取到了最深叶子节点的最近公共祖先

    //如果左右子树深度相同，表示获取到了最深叶子节点的最近公共祖先！！！这句话太厉害了！！最关键的！！！一定要记住
    Map<TreeNode,Integer> cache = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root);
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        int l = depth(root.left);
        int r = depth(root.right);
        if(l == r) {
            return root;//！！！！！！！
        } else if(l > r) {
            return dfs(root.left);
        } else {
            return dfs(root.right);
        }
    }

    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(cache.containsKey(root)) {//缓存已经计算过的，避免重复计算
            return cache.get(root);
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int v = Math.max(left,right) + 1;
        cache.put(root,v);
        return v;
    }
}

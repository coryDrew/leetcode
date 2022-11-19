package com.zcy.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DelNodes1110 {
    //后序遍历，这个过程不好想啊
    Set<Integer> set = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null)
                ans.add(root.left);
            if (root.right != null)
                ans.add(root.right);
            root = null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int d : to_delete) {
            set.add(d);
        }
        if (!set.contains(root.val)) {
            ans.add(root);
        }
        dfs(root);
        return ans;
    }
}

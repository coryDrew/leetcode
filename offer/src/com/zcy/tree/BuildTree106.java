package com.zcy.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree106 {

    //可以用105的做法来做的，这个利用了一些遍历特征，简化了，但是不容易看懂，我没看懂
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }
    //******************105做法*****************
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // 将中序遍历放到map中
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        // 根节点在后序遍历中的下标
        int postorder_root = postorder_right;
        // 根节点在中序遍历中的根节点
        int inorder_root = map.get(postorder[postorder_root]);
        // 左子树的长度
        int size_left_subtree = inorder_root - inorder_left;
        // 建立根节点
        TreeNode root = new TreeNode(postorder[postorder_root]);
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + size_left_subtree - 1);
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_left + size_left_subtree, postorder_right - 1);
        return root;
    }
}

package com.zcy.tree;

import java.util.LinkedList;
import java.util.List;

public class CountPairs1530 {
    //字节面试题
    //很妙啊
    //对每个节点遍历时，求的都是不重复的节点对，自己画图看一下就能看出来！
    //求深度！
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        List<Integer> lefts = new LinkedList<>();
        countDepth(root.left, 0, lefts);
        List<Integer> rights = new LinkedList<>();
        countDepth(root.right, 0, rights);

        int res = 0;
        for (Integer l : lefts)
            for (Integer r : rights)
                if (l + r + 2 <= distance)
                    res++;

        res += countPairs(root.left, distance);
        res += countPairs(root.right, distance);
        return res;
    }

    void countDepth(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(depth);
            return;
        }
        countDepth(node.left, depth + 1, list);
        countDepth(node.right, depth + 1, list);
    }
}

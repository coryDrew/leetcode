package com.zcy.tree;

import java.util.ArrayList;
import java.util.List;

public class FlipMatchVoyage971 {
    /*思路

当做先序遍历的时候，我们可能会翻转某一个节点，尝试使我们当前的遍历序列与给定的行程序列相匹配。

如果我们希望先序遍历序列的下一个数字是 voyage[i] ，那么至多只有一种可行的遍历路径供我们选择，因为所有节点的值都不相同。

算法

进行深度优先遍历。如果遍历到某一个节点的时候，节点值不能与行程序列匹配，那么答案一定是 [-1]。

否则，当行程序列中的下一个期望数字 voyage[i] 与我们即将遍历的子节点的值不同的时候，我们就要翻转一下当前这个节点。


    * */
    List<Integer> flipped;
    int index;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList();
        index = 0;
        this.voyage = voyage;

        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }

        return flipped;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null &&
                    node.left.val != voyage[index]) {
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
    }
}

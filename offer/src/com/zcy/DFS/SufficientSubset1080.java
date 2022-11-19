package com.zcy.DFS;

public class SufficientSubset1080 {
    //看了一眼评论区发现是递归后自写
    //看见二叉树没思路再想不出递归，把手剁了
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null){
            return null;
        }
        //当前是叶子，若自身值达到要求则保留
        if(root.left == null &&root.right == null){
            return root.val>= limit?root:null;
        }
        //求左右，条件要相应减去根节点
        root.left = sufficientSubset(root.left,limit - root.val);
        root.right = sufficientSubset(root.right,limit - root.val);
        //都为null，说明两边都没有满足的，那根节点也得删掉
        if(root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}

package com.zcy.tree;

public class SubtreeWithAllDeepest865 {
    //递归无敌
    //// 思路：从每个树开始，获得当前节点的左右子树的最大深度
    //    // 深度相同，说明最深的节点在这个节点两边，那这个节点就是结果
    //    // 如果深度不相同，则去深度大的子树继续判断，最终就能得到结果
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null){
            return null;
        }
        if(maxDepth(root.left) == maxDepth(root.right)){
            return root;
        }else{
            return maxDepth(root.left)>maxDepth(root.right)?subtreeWithAllDeepest(root.left):subtreeWithAllDeepest(root.right);
        }
    }
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

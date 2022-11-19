package com.zcy.tree;

public class LowestCommonAncestor235 {
    //可以当做一般的树做，写八百遍了，还是会忘
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root ==  q)return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);//由于这个函数在只找到其中一个节点时也会有结果，但会是错的结果，所以才有下面的判断！！！
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
    //也可以利用二叉搜索树的性质
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int val;
        if( ( (long)(p.val - root.val) * (q.val - root.val)) <= 0){
            return root;
        }
        return (p.val > root.val ? lowestCommonAncestor(root.right,p,q):lowestCommonAncestor(root.left,p,q));
    }
}

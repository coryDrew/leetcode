package com.zcy.tree.pathProblem;

public class LongestUnivaluePath687 {
    //原题啊，还是没递归出来，问题出在返回值的选取，返回的是该节点能向上最大的贡献值
    int res;
    public int longestUnivaluePath(TreeNode root) {
        findLongestArrow(root);
        return res;
    }
    public int findLongestArrow(TreeNode root){//找以每个点为首的最长路径
        if(root == null){
            return 0;
        }

        int left = findLongestArrow(root.left),right = findLongestArrow(root.right);
        int arrowLeft = 0,arrowright = 0;

        if(root.left != null &&root.left.val == root.val){
            arrowLeft = 1+ left;
        }
        if(root.right != null&&root.right.val == root.val){
            arrowright = 1+right;
        }
        res = Math.max(res,arrowright + arrowLeft);
        return Math.max(arrowLeft,arrowright);
    }
}

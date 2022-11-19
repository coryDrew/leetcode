package com.zcy.tree;

public class GetDirections2096 {
    //先求个最近公共祖先//然后dfs找那两个节点即可
    StringBuilder res = new StringBuilder();
    StringBuilder start = new StringBuilder();
    StringBuilder dest = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = findRoot(root, startValue, destValue);
        dfsStart(ancestor, startValue);
        dfsDest(ancestor, destValue);
        return res.toString();
    }
    public void dfsStart(TreeNode root, int startValue){
        if(root == null){
            return;
        }
        if(root.val==startValue){
            res.append(start);
            return;
        }
        start.append("U");
        dfsStart(root.left, startValue);
        start.deleteCharAt(start.length()-1);
        start.append("U");
        dfsStart(root.right, startValue);
        start.deleteCharAt(start.length()-1);
    }

    public void dfsDest(TreeNode root, int destValue){
        if(root == null){
            return;
        }
        if(root.val == destValue){
            res.append(dest);
            return;
        }
        dest.append("L");
        dfsDest(root.left, destValue);
        dest.deleteCharAt(dest.length()-1);//记得回溯，这并不难理解
        dest.append("R");
        dfsDest(root.right, destValue);
        dest.deleteCharAt(dest.length()-1);
    }

    public TreeNode findRoot(TreeNode root, int startValue, int destValue){//先求个最近公共祖先
        if(root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode left = findRoot(root.left, startValue, destValue);
        TreeNode right = findRoot(root.right, startValue, destValue);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}

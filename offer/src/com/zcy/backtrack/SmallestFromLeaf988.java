package com.zcy.backtrack;

public class SmallestFromLeaf988 {
    //树的回溯
    String res;
    public String smallestFromLeaf(TreeNode root) {
        res = "";
        StringBuilder sb = new StringBuilder();
        backtrack(root,sb);
        return res;
    }
    public void backtrack(TreeNode node,StringBuilder sb){
        sb.append((char)(node.val+'a'));
        if(node.left == null && node.right == null){
            String s = sb.toString();
            StringBuilder sbb = new StringBuilder(s);
            s = sbb.reverse().toString();
            if(res.equals("")||res.compareTo(s)>0)
                res = s;
        }

        if(node.left != null){

            backtrack(node.left,sb);

        }
        if(node.right != null){

            backtrack(node.right,sb);

        }
        sb.deleteCharAt(sb.length() - 1);//sb的删除函数
    }
    //官解
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {//官解在reverse这边更加优雅简洁，要好好学一学
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}

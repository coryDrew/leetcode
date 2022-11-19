package com.zcy.tree;

public class FlipEquiv951 {
    //二叉树递归，yyds ^_^
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            if(root2 == null){
                return true;
            }else{
                return false;
            }
        }
        if(root2 == null||root1.val != root2.val)return false;
        return (flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right))||(flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left));
    }
}

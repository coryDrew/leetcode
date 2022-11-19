package com.zcy.tree;

public class RecoverTree99 {
    //空间复杂度o(H)，H为树高，递归调用栈占空间
    //中序遍历，结果中如果有一个降序对，说明该两个node需交换；若有两个降序对，说明第一对的前一个node和第二对的后一个node需要交换。
    TreeNode t1,t2,pre;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        //
        if(pre != null&& pre.val > root.val){
            if(t1 == null){
                t1 = pre;
            }
            t2 = root;
        }
        pre = root;
        dfs(root.right);
    }
}

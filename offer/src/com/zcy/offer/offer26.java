package com.zcy.offer;

public class offer26 {
    //自写dfs
    boolean flag;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null)return false;
        flag = false;
        dfs(A,B);
        return flag;
    }
    public void dfs(TreeNode cur,TreeNode B){
        if(cur == null) return;
        if(isEqu(cur,B)){
            flag = true;
            return;
        }
        dfs(cur.left,B);
        dfs(cur.right,B);
    }//遍历A每个节点
    public boolean isEqu(TreeNode A,TreeNode B){//A为首的子树是否包含B
        if(A == null && B== null)return true;
        if(B == null)return true;
        if(A == null)return false;
        if(A.val != B.val)return false;
        return isEqu(A.left,B.left)&&isEqu(A.right,B.right);
    }
}

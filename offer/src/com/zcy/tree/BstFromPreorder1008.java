package com.zcy.tree;

public class BstFromPreorder1008 {
    //你狠无聊啊
    public TreeNode bstFromPreorder(int[] preorder) {
        return BST(preorder,0,preorder.length - 1);
    }
    public TreeNode BST(int[] preorder,int start,int end){
        if(start > end) return null;
        if(start == end)return new TreeNode(preorder[start]);
        TreeNode head = new TreeNode(preorder[start]);
        int indexLeft = -1;
        for(int i = start+1;i <= end;i++){
            if(preorder[i] > preorder[start]){
                indexLeft = i;
                break;
            }

        }
        if(indexLeft == -1){
            head.left = BST(preorder,start+1,end);
            head.right = null;
        }else{
            head.left = BST(preorder,start+1,indexLeft - 1);
            head.right = BST(preorder,indexLeft,end);
        }
        return head;
    }
}

package com.zcy.tree;

public class ConstructFromPrePost889 {
    //前序和后序无法确定一个树
    //和105、106对比一下
    //只要有中序，就能完全确定一个树！
    //只有每个节点度为2或者0的时候前序和后序才能唯一确定一颗二叉树，只有一个子节点是无法确定的，因为你无法判断他是左子树还是右子树
    //根据左子树的头来确定长度！想到了
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return conTree(preorder,postorder,0,preorder.length - 1,0,postorder.length - 1);
    }
    public TreeNode conTree(int[] preorder,int[] postorder,int preStart,int preEnd,int postStart,int postEnd){
        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);
        TreeNode head = new TreeNode(preorder[preStart]);
        int valueLeft = preorder[preStart + 1];
        int index = -1;
        for(int i = postStart;i<=postEnd;i++){
            if(postorder[i] == valueLeft){
                index = i;
                break;
            }
        }
        int leftLen = index - postStart + 1;
        head.left = conTree(preorder,postorder,preStart + 1,preStart + leftLen,postStart,index);
        head.right = conTree(preorder,postorder,preStart + leftLen+1,preEnd,index+1,postEnd - 1);
        return head;

    }
}

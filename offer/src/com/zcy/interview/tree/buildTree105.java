package com.zcy.interview.tree;

public class buildTree105 {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    public TreeNode build(int[] preorder,int[] inorder,int pStart,int pEnd,int iStart,int iEnd){
        if(pStart>pEnd)return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = map.get(preorder[pStart]);
        int lenForLeft = index - iStart;
        root.left =  build(preorder,inorder,pStart+1,pStart+lenForLeft,iStart,index - 1);
        root.right =  build(preorder,inorder,pStart+lenForLeft+1,pEnd,index+1,iEnd);
        return root;
    }
}

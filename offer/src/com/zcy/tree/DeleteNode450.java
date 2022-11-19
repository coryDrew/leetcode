package com.zcy.tree;

public class DeleteNode450 {
    //看了一下题解之后自写，有收获
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left =  deleteNode(root.left,key);//为什么这里要用left接住，因为有可能最后left要变成null，不接住就没法完成更新，本来写的是
            //deleteNode(root.left,key);没有前面的root.left,所以错了
            return root;
        }
        if(root.val < key){
            root.right =  deleteNode(root.right,key);
            return root;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left != null&&root.right == null){
                return root.left;
            }
            if(root.left == null&&root.right != null){
                return root.right;
            }
            if(root.left != null&&root.right != null){
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }//要找到比root大的最小节点！！，这个值作为root的值
                root.val = cur.val;
                root.right = deleteNode(root.right,cur.val);
                return root;
            }
        }
        return root;
    }
}

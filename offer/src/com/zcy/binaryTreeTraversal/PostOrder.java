package com.zcy.binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    ///理解prev，记录右子树是否已遍历完
    /**
     栈遍历版本： 建议先做中序遍历，后序只是在中序上多了一些操作。

     与中序的不同之处在于：

     中序遍历中，从栈中弹出的节点，其左子树是访问完了，可以直接访问该节点，然后接下来访问右子树。
     后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
     因此，我们在后序遍历中，引入了一个prev来记录历史访问记录。

     当访问完一棵子树的时候，我们用prev指向该节点。
     这样，在回溯到父节点的时候，我们可以依据prev是指向左子节点，还是右子节点，来判断父节点的访问情况。
     */
    public List<Integer> method1(TreeNode root) {
        List<Integer> ans=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        //主要思想：
        //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //从栈中弹出的元素，左子树一定是访问完了的
            root=stack.pop();
            //现在需要确定的是是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点
            if(root.right==null||prev==root.right){
                ans.add(root.val);
                //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                prev=root;
                root=null;
            }else{
                //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                stack.push(root);
                root=root.right;
            }
        }
        return ans;
    }
}

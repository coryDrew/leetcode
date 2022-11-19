package com.zcy.interview.tree;

public class PreorderTraversal144 {
    //先加再压再找左，变null出来找右
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}

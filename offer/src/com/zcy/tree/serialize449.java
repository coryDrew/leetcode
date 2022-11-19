package com.zcy.tree;

public class serialize449 {
    //也可以通过105的方法反序列化，但是要得到两个遍历序列（如前序和中序），这题由于是二叉搜索树，可以通过其性质，只用一个遍历序列完成反序列化。
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();//stack倒出来的顺序是头右左
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);//大于val的节点，即头结点右边的节点，经过这一行 stack里只剩下头结点的左节点
        root.left = construct(lower, val, stack);//小于val的节点，即头结点左边的节点
        return root;
    }

}

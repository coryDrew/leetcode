package com.zcy.BFS;

import java.util.LinkedList;

public class Connect117 {
    //空间复杂度o（n）
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i = queue.size();i>0;i--){
                Node tmp = queue.poll();
                if(i != 1){
                    tmp.next = queue.peek();//如果i == 1，说明是最后一个，默认next就是null，所以不用额外操作
                }
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        return root;
    }
    //空间o（1）递归，难想
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                // 若右子树不为空，则左子树的 next 即为右子树
                root.left.next = root.right;
            } else {
                // 若右子树为空，则右子树的 next 由根节点的 next 得出
                root.left.next = nextNode(root.next);
            }
        }
        if (root.right != null) {
            // 右子树的 next 由根节点的 next 得出
            root.right.next = nextNode(root.next);
        }
        // 先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
        // 需要 root.left.next 下的节点的信息，若 root.right 下的节点未完全连
        // 接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
        // 返回错误的信息。可能出现的错误情况如下图所示。此时，底层最左边节点将无
        // 法获得正确的 next 信息：
        //                  o root
        //                 / \
        //     root.left  o —— o  root.right
        //               /    / \
        //              o —— o   o
        //             /        / \
        //            o        o   o
        connect(root.right);//先递归右边！！！！！
        connect(root.left);
        return root;
    }

    private Node nextNode(Node node) {//找next节点用
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}

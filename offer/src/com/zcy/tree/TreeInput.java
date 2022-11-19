package com.zcy.tree;

import java.util.*;

public class TreeInput {
    static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
}
    //方法入口
    public static void main(String[] args) {

        //输入是一个数组，当节点为空时用-1代表
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        //构建二叉树
        TreeNode root = build(arr);
        //层序遍历二叉树
        List<List<Integer>> r = help(root);
        //打印结果
        for (List<Integer> ans : r){
            System.out.print(ans);
        }
        averageOfSubtree(root);
        System.out.println(res);
    }
     static int res;
    static int sum;
    static int cnt;
    public static int averageOfSubtree(TreeNode root) {
        res = 0;
        sum = 0;
        cnt = 0;
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode root){
        if(root == null) return;
        sum = 0;
        cnt = 0;
        sumCnt(root);
        if(root.val == sum/cnt){
            res++;
        }

        dfs(root.left);

        dfs(root.right);

    }
    public static void sumCnt(TreeNode root){//以root为根节点，节点值的和
        if(root == null) return;
        sum+=root.val;
        cnt++;
        sumCnt(root.left);
        sumCnt(root.right);
    }
    //层序遍历二叉树
    private static List<List<Integer>> help(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
    //构建二叉树
    private static TreeNode build(int[] arr) {//真正的将数组构造成树的方法
        List<TreeNode> list = new ArrayList<>();//list默认容量为10
        Collections.fill(list, null);
        TreeNode root = null;
        for(int i = 0; i < arr.length; i++){
            TreeNode node = null;
            if(arr[i] != -1){
                node = new TreeNode(arr[i]);
            }
            list.add(i,node);//给list的每个位置赋一个节点，这里就是将数组中的数字变成了一个个节点，并保存在list中
            if(i == 0){
                root = node;
            }
        }
        //给每个位置的节点设置左孩子和右孩子
        for (int i = 0;  2 * i + 2 < arr.length ; i++) {//2 * i + 2不能越界，下面要用的
            if(list.get(i) != null){
                list.get(i).left = list.get(2 * i + 1);
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return root;//返回根节点
    }

}

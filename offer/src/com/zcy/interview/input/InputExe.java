package com.zcy.interview.input;

import com.zcy.binaryTreeTraversal.PreOrder;

import java.util.*;

public class InputExe {
    static class ListNode{
        int value;
        ListNode next;
        public ListNode(){}
        public ListNode(int value){
            this.value = value;
        }
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){
            this.val = value;
        }
    }
    public static void main(String[] args){
        //输入字符串
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();//只要没空格  就算是一整个
//        System.out.println(s+"fuck");
        //输入一维数组
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[sc.nextInt()];
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(arr));
        //输入二维数组
//        Scanner sc = new Scanner(System.in);
//        int[][] arr = new int[sc.nextInt()][sc.nextInt()];
//        for(int i = 0;i<arr.length;i++){
//            for(int j = 0;j < arr[0].length;j++){
//                arr[i][j] = sc.nextInt();
//            }
//            System.out.println(Arrays.toString(arr[i]));
//        }
        //输入链表(先定义内部类) 不难
        //先拿到一行  是字符串
        //然后将字符串根据空格分成字符串数组
        //然后创建整形数组，通过Integer.valueOf进行赋值
        //然后创建链表节点
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] arr = s.split(" ");
//        int[] array = new int[arr.length];
//        for(int i = 0;i < arr.length;i++){
//            array[i] = Integer.valueOf(arr[i]);
//        }
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        for(int i = 0;i < array.length;i++){
//            cur.next = new ListNode(array[i]);
//            cur = cur.next;
//        }
//        ListNode ans = reverse(head.next);
//        while(ans != null){
//            System.out.print(ans.value + "->");
//            ans = ans.next;
//        }
//        System.out.print("null");
        //输入二叉树
        //二叉树如果最后一个非叶子节点没有右孩子，输入的时候要补上-1！！！，要不然它的左孩子不会被赋上去（因为下面的2i+2机制问题）
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for(int i = 0;i < arr.length;i++){
            arr[i] = Integer.valueOf(str[i]);
        }
        TreeNode root = build(arr);
        List<TreeNode> list = preOrder(root);
        for(TreeNode node:list){
            System.out.print(node.val);
        }
    }
    //构建二叉树
    public static TreeNode build(int[] arr){
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = null;
        for(int i = 0;i < arr.length;i++){
            TreeNode node = null;
            if(arr[i] != -1){
                node = new TreeNode(arr[i]);
            }
            list.add(node);
            if(i == 0){
                root = node;
            }
        }
        for(int i = 0;2*i +2 < list.size();i++){
            if(list.get(i) != null){
                list.get(i).left = list.get(2*i+1);
                list.get(i).right = list.get(2*i+2);
            }
        }
        return root;
    }
    public static List<TreeNode> preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}


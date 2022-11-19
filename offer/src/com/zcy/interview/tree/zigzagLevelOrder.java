package com.zcy.interview.tree;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);

                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }

            }
            if(flag) res.add(list);
            if(!flag){
                List<Integer> list2 = new ArrayList<>();
                for(int i = list.size() - 1;i>= 0;i--){
                    list2.add(list.get(i));
                }
                res.add(list2);
            }
            flag = !flag;
        }
        return res;
    }
}

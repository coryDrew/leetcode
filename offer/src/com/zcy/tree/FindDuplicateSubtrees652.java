package com.zcy.tree;

import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees652 {
    //真好啊写的，草了
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);//调用一次就会把所有的子树进行遍历，真牛啊
        return ans;
    }

    public String collect(TreeNode node) {//深搜序列化，其实就是前序遍历
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}

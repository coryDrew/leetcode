package com.zcy.backtrack;

import java.util.*;

public class PseudoPalindromicPaths1457 {
    //写吐了，最后超时
    //用set存储 偶数次从set移除 奇数次往set添加 只有set.SIZE() 在0-1之间才是回文
    int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        Set<Integer> set = new HashSet<>();
        backtrack(set,root);
        return res;

    }
    public void backtrack(Set<Integer> set, TreeNode node){
        if(node == null)return;


        if(node.left == null&&node.right == null){
            if(set.size()==0||set.size()<=2&&set.contains(node.val))
                res++;
            return;
        } if(set.contains(node.val))set.remove(node.val);
        else set.add(node.val);

        backtrack(set,node.left);
        backtrack(set,node.right);
        if(set.contains(node.val))set.remove(node.val);
        else set.add(node.val);
    }
    public boolean canBePa(List<Integer> list){
        //出现奇数次的点值最多只能有一个
        if(list.size() == 0)return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        int cnt = 0;
        for(int x:map.values()){
            if(x%2 != 0)cnt++;
            if(cnt >1)return false;
        }
        return true;
    }
}

package com.zcy.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBinaryTree2196 {
    //自写，2000ms
    //正常也就是这个思路
    public TreeNode createBinaryTree(int[][] descriptions) {
        List<TreeNode> list = new ArrayList<>();//直接存节点，存完能取吗
        Map<Integer,Integer> map = new HashMap<>();//节点的值以及它对应在list中的索引
        for(int[] description:descriptions){
            if(!map.containsKey(description[0])){
                list.add(new TreeNode(description[0]));
                map.put(description[0],list.size() -1 );
            }
            if(!map.containsKey(description[1])){
                list.add(new TreeNode(description[1]));
                map.put(description[1],list.size() -1 );
            }
            if(description[2] == 1){
                list.get(map.get(description[0])).left = list.get(map.get(description[1]));
            }else{
                list.get(map.get(description[0])).right = list.get(map.get(description[1]));
            }

        }
        //一个集合来记录非根节点
        List<Integer> notRoot = new ArrayList<>();
        for(int i = 0;i < descriptions.length;i++){
            notRoot.add(descriptions[i][1]);
        }
        int res = -1;
        for(int x:map.keySet()){
            if(!notRoot.contains(x)){
                res = x;
                break;
            }
        }
        return list.get(map.get(res));

    }
}

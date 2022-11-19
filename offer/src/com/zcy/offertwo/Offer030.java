package com.zcy.offertwo;

import java.util.*;

public class Offer030 {
    //List+map
    //list能实现随机下标取值
    //list不能根据值来删除，只能根据下标来删除
    //map能记录元素对应的下标
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    /** Initialize your data structure here. */
    public Offer030() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            if(list.size() == 1){
                list.remove(0);
                map.remove(val,0);
                return true;
            }


            //和最后一个换，最后只需改变最后一个值的下标
            int index = map.get(val);
            if(index == list.size() - 1){//如果是最后一个
                list.remove(index);
                map.remove(val);
                return true;
            }
            int len = map.size();
            map.remove(val,index);
            map.remove(list.get(len - 1),len - 1);
            list.set(index,list.get(len - 1));
            list.remove(len - 1);
            map.put(list.get(index),index);
            /**
             if(!map.containsKey(val)) return false;
             int index = map.get(val);       // 获取val的下标index
             int lastNum = arr.get(--size);  // 获取最后一个元素last
             arr.set(index, lastNum);  // 利用last覆盖index
             map.put(lastNum, index);  // 改变map中last的index
             map.remove(val);    // 删除map中的val
             arr.remove(size);   // 删除最后一个元素
             这个写法不用判断特殊情况
             最后再删除
             */

            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

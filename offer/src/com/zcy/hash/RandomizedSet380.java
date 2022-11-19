package com.zcy.hash;

import java.util.*;

public class RandomizedSet380 {
     /*
    list可以用get方法返回任意下标的值，但无法进行对某具体元素的删除（只能按下标删除元素）。hashset可以按指定元素删除，但无法按下标随机返回元素。
    于是这里要将list和哈希表结合起来，用哈希表存储每个元素在list中的下标（便于list删除元素）
    */

     /*
    list可以用get方法返回任意下标的值，但无法进行对某具体元素的删除（只能按下标删除元素）。hashset可以按指定元素删除，但无法按下标随机返回元素。
    于是这里要将list和哈希表结合起来，用哈希表存储每个元素在list中的下标（便于list删除元素）
    */
    //自写，错误，错误！！！！！
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    public RandomizedSet380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){//换成list.contains(key)有问题吗？
                                // 没区别，都是错的，因为这样删会影响别的元素在list中的下标，会让下标发生改变！！！！！！！！
                                //此方法就是错的，要用最后一个元素与之做替换！
            return false;
        }
        list.add(val);
        map.put(val,list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!list.contains(val)){
            return false;
        }
        list.remove(map.get(val));
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    //*********************正确！**************************

    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    public RandomizedSet380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(list.contains(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!list.contains(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index,last);
        list.remove(list.size() - 1);
        map.put(last,index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

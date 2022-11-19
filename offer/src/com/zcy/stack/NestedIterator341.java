package com.zcy.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class NestedIterator341 {
    //法一：dfs递归，提前扁平化
    //面试必挂
    private LinkedList<Integer> ans;
    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
        DFS(nestedList);
    }

    @Override
    public Integer next() {
        return ans.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !ans.isEmpty();
    }

    public void DFS(List<NestedInteger> nestedList){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                ans.addLast(n.getInteger());
            }else{
                DFS(n.getList());
            }
        }
    }
    //法二：栈
    //迭代：调用 hasNext() 或者 next() 方法的时候扁平化当前的嵌套的子列表
    //这个方法更加有挑战性，也是这个题最正确的解法。因为对于大部分情况，我们希望迭代器能够一边迭代一边获取当前的结果，而不是提前初始化好。

    private Deque<NestedInteger> deque;
    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>();
        for(int i = nestedList.size() - 1 ; i >= 0 ; i--){//逆序存入栈
            deque.addLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger cur = deque.removeLast();
        return cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!deque.isEmpty()){
            NestedInteger top = deque.peekLast();
            if(top.isInteger()){
                return true;
            }
            deque.removeLast();
            for(int i = top.getList().size() - 1 ; i >= 0 ; i--){//逆序存入栈
                deque.addLast(top.getList().get(i));
            }
        }
        return false;
    }

}

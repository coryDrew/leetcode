package com.zcy.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner901 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        //当list装的是整数时，remove只能根据index来remove
        list.remove(0);

    }
    //两个栈
    private Stack<Integer> stack;
    private Stack<Integer> count;//这也太牛逼了

    public StockSpanner901() {
        stack = new Stack<>();
        count = new Stack<>();
    }

    public int next(int price) {
        if(stack.empty() || price < stack.peek()) {
            stack.push(price);
            count.push(1);
            return count.peek();
        }
        int cn = 1;
        while(!stack.empty() && price >= stack.peek()) {
            cn += count.pop();
            stack.pop();//单调栈，大于的全扔了
        }
        stack.push(price);
        count.push(cn);
        return cn;
    }
}

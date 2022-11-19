package com.zcy.DFS;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CanMeasureWater365 {
    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();//用栈，能保存所有待判断的状态，栈真的很有用，但是每次都想不起来，但这里用队列应该也行，没啥区别，都是起一个保存的作用
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<Long>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {//遇到重复的状态
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));//下面自己写的hash函数，来作为判断数组是否相同的条件

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{x, remain_y});
            // 把 Y 壶灌满。
            stack.push(new int[]{remain_x, y});
            // 把 X 壶倒空。
            stack.push(new int[]{0, remain_y});
            // 把 Y 壶倒空。
            stack.push(new int[]{remain_x, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];//自己写一个hash判断数组重复，这里的乘数和题目给的范围有关，
        // 题目给的是10的六次方，这里乘1000001即可保证唯一性
    }
}

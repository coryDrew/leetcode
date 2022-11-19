package com.zcy.tree;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidSerialization331 {
    //槽位，即每个点下面的两个子节点需要被填上（空节点填#），如果没填上（即最后栈不为空）则不是正确的序列化
    //但是这种解法和前序有何关系？可能是用栈就保证了前序？不太懂这里
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

}

package com.zcy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        boolean[] vis = new boolean[26];//记录每个字母是否在栈中
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];//记录每个字母在字符串中最后一次出现的位置
        for(int i = 0;i < len;i++){
            lastIndex[charArray[i] - 'a'] = i;
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0;i < len;i++){
            if(vis[charArray[i] - 'a'] == true){//当前遍历到的字母已经在栈中了，直接遍历下一个
                continue;
            }
            while(!stack.isEmpty()
                    && stack.peekLast() > charArray[i]
                    && lastIndex[stack.peekLast() - 'a'] > i){
                char top = stack.removeLast();
                vis[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            vis[charArray[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        // while(!stack.isEmpty()){
        //  sb.append(stack.removeFirst());这样也行
        //}
        for(char c:stack){//for循环默认是从栈底开始遍历，正好符合要求，其实就是从first->last的遍历，这里的first相当于栈底，last相当于栈顶，每次添加元素到last就相当于往栈顶添加元素，从而相当于实现了栈的功能
            sb.append(c);
        }
        return sb.toString();
    }
}

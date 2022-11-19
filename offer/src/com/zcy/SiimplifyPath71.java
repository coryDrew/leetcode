package com.zcy;

import java.util.ArrayDeque;
import java.util.Deque;

public class SiimplifyPath71 {
    public String simplifyPath(String path) {
        //双端队列
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {//退到上级目录，这层目录就不用了，直接出栈即可
                if (!stack.isEmpty()) {
                    stack.pollLast();//这里是last
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);//这里也是last
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());//这里是first
            }
        }
        return ans.toString();
    }
}

package com.zcy.brackets;

public class IsValid20 {
    public boolean isValid(String s) {
        //遇到右括号，和栈顶比较
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            //如果是左括号则直接入栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                //如果是右括号，并且此时栈不为空
                if (!stack.isEmpty()) {
                    if (ch == ')') {
                        if (stack.pop() != '(')
                            return false;
                    } else if (ch == '}') {
                        if (stack.pop() != '{')
                            return false;
                    } else {
                        if (stack.pop() != '[')
                            return false;
                    }
                }
                else{ //此时栈为空，但却来了个右括号，也直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
}

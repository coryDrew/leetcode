package com.zcy.brackets;

import java.util.Deque;
import java.util.LinkedList;

public class CheckValidString678 {
    //存下标，很多地方都用了！
    /**
     遍历一遍字符串，把能匹配的括号匹配掉，同时把遇到的星号存起来，能不用就先不用，必须要用的时候再用，因为星号是一张万能牌。

     定义用两个栈，

     左括号栈 存放左括号 ( 的下标，至于为什么存下标，后面再解释。

     星号栈 存放星号* 的下标，至于为什么存下标，后面再解释。

     从头遍历字符串，有三种情况：

     (1) 遇到左括号，把当前下标加入左括号栈。

     (2) 遇到右括号，

     (2a) 左括号栈不为空，则左括号栈弹出一个值，代表有一组" () "匹配掉了。
     (2b) 左括号栈为空，只能尝试使用万能牌星号代替一个左括号了，将星号栈弹出一个值，代表有一组“ *) ”匹配掉了。
     如果星号栈也为空，那对不起，左括号没有，万能牌也没有，匹配失败，返回false。

     (3) 遇到星号，这是张好牌，将当前下标加入星号栈。
     遍历结束，这个时候左括号栈有可能不为空，意味着还有没有匹配完的左括号。先做一个简单判断，如果左括号的数量比万能牌星号还多，哪怕将剩余万能牌全部用上，都一定都无法完成所有左括号的匹配，返回false。

     那么你会想，是不是此时万能牌的数量比左括号的数量多，就可以返回true了？不对！想象一个例子： * * * * ( ( ，这个例子最终还剩下4个星号，2个左括号，星号数多于左括号数，但是也无法完成匹配，因为位于左括号左侧的星号无法当做万能牌。这就是为什么我们一开始需要保存下标的原因，只有位于左括号右侧的星号才能当做万能牌用。保存的下标可以提供这个信息。

     最后就比较简单了，我对左括号栈peek一下，对星号栈peek一下，如果星号栈里的下标大于左括号栈里的下标，则两个栈均弹出一个值，代表成功匹配一组( * 。重复这一步直到一个栈为空。在这个过程中，如果星号栈里的下标小于左括号栈里的下标，则这个左括号永远无法完成匹配，返回false。

     最终返回true。
     */
    public boolean checkValidString(String s) {
        Deque<Integer> lStack = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                lStack.push(i);
            }
            if(s.charAt(i) =='*'){
                star.push(i);
            }
            if(s.charAt(i) ==')'){
                if(!lStack.isEmpty()){
                    lStack.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        if(lStack.size() > star.size()){
            return false;
        }
        while(!lStack.isEmpty()){
            if(lStack.peek() < star.peek()){
                lStack.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}

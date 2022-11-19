package com.zcy.generalUse;

public class testIntegerValueOf {
    public static void main(String[] args) {
        String s = "0001";
        System.out.println(Integer.valueOf(s));//该方法自动去前导零
    }
}

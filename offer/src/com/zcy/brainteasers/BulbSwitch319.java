package com.zcy.brainteasers;

public class BulbSwitch319 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(6));//sqrt默认返回的是浮点数
    }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}

package com.zcy.bitwise;

public class SingleNumber260 {
    //左神的方法还是记住了
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num:nums){
            x^=num;//x是a，b两数的异或结果，必有某一位是1
        }
        //取到x最右边的1
        int right = 1;
        while((x&right) == 0){
            right <<= 1;
        }
        int a = 0;
        for(int num: nums){
            if((num & right) != 0){
                a ^= num;
            }
        }
        int b = a ^ x;
        return new int[]{a,b};
    }
}

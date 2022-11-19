package com.zcy.bitwise;

public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0;i<32;i++){
            int sum = 0;//算每一位的数字之和
            for(int j = 0;j < nums.length;j++){
                sum+=(nums[j]&(1<<i))!=0?1:0;
            }
            //得到这个数在这一位是0还是1
            res|=(sum%3)<<i;//用或就不用担心正负数问题！
        }
        return res;
    }
}

package com.zcy.interview.sort;

import java.util.Arrays;

public class largestNumber179 {
    //恶心人
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }

        //比较器默认  o1在o2的前面位置,这是一个前提！关键!!!!!!!!!!!!!!!
        //返回正数，交换  返回负数，不交换
        Arrays.sort(arr,(o1, o2)-> (o2+o1).compareTo(o1+o2));
        if(arr[0].equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

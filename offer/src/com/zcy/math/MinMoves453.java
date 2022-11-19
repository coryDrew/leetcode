package com.zcy.math;

public class MinMoves453 {
    //因此，每次操作既可以理解为使 n-1n−1 个元素增加 11，也可以理解使 11 个元素减少 11。显然，后者更利于我们的计算。

    //于是，要计算让数组中所有元素相等的操作数，我们只需要计算将数组中所有元素都减少到数组中元素最小值所需的操作数
//n-1个 -> 1个 ！！！化繁为简
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            min = Math.min(min,nums[i]);
        }
        //   int minNum = Arrays.stream(nums).min().getAsInt();求min的快捷方式，用流
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res+=nums[i] - min;
        }
        return res;
    }
}

package com.zcy.interview.hash;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        //没想出来阿
        //遍历时，遍历左右，并顺便清除set
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int x:nums){

            if(set.remove(x)){
                int res = 1;
                int cur = x;
                while(set.remove(cur - 1))cur--;
                res+=x - cur;
                cur =  x;
                while(set.remove(cur + 1))cur++;
                res+=cur - x;
                ans = Math.max(ans,res);

            }
        }
        return ans;
    }
}

package com.zcy.offertwo;

import java.util.Arrays;

public class Offer008 {
    //自写滑动窗口，速度够了，但写的不好
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0,r = 0;
        int sum = nums[l];
        int ans = Integer.MAX_VALUE;
        while(r < n){
            if(sum >= target){
                ans = Math.min(ans,r - l + 1);
                if(ans == 1){
                    break;
                }
                sum-=nums[l];
                l++;
            }else {
                r++;
                if(r<n){
                    sum+=nums[r];
                }

            }
        }
        return ans != Integer.MAX_VALUE?ans:0;
    }
    //官方滑动
    public int minSubArrayLen6(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    //前缀和加二分
    public int minSubArrayLen66(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}

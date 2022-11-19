package com.zcy.twoPoints;

import java.util.Arrays;

public class ThreeSumClosest16 {
    //从三数之和改出来的，效率很低，击败18
    //官解也是这样，有小优化而已，时间复杂度o（n方）
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(ans - target)) {
                    ans = nums[i] + nums[left] + nums[right];

                } else if (nums[i]+nums[left] + nums[right] < target) {//小于，要大一点
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}

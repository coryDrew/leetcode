package com.zcy.twoPoints;

public class RemoveDuplicates80 {
    //优雅双指针
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int slow = 2,fast = 2;
        while(fast < nums.length){
            if(nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}

package com.zcy.twoPoints;

public class TwoSum167 {
    //无聊的重复题
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left+1,right+1};
            }else if(numbers[left] + numbers[right] < target){
                left++;
                while(numbers[left] == numbers[left - 1]){
                    left++;
                }
            }else{
                right--;
                while(numbers[right] == numbers[right + 1]){
                    right--;
                }
            }

        }
        return new int[]{-1,-1};
    }
}

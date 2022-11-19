package com.zcy.skill;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates442 {
    //法一：放到应该放的位置，非常乱，不好
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            //乱！！
            /**1.尽量让值为a的数字位于坐标a-1的位置，假如位置已经正确，那么不需要管它；2、假如位置不正确，那么就可以先找到它应该在的位置a-1，这个位置此时的值是b；3、假如a==b，也就是另一个a已经占据了那个位置，那么也可以跳过，否则交换两个数字的位置；4、交换完成了，那么数字b也就可能不在正确的位置，继续步骤3即可；
             */
            while(nums[i] != nums[nums[i] - 1]){//这里是while！，为什么？
                swap(nums,i,nums[i] - 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(nums[i] != i+1){
                res.add(nums[i]);
            }
        }
        return res;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //法二：取反，无敌！！！！！！！！
    //付雪明珠题解
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }


}

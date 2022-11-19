package com.zcy.interview.hash;

public class majorityElement169 {
    //摩尔投票   o（n）+o（1）
    //没想出来
    public int majorityElement(int[] nums) {
        //诸王争霸赛开始【规则是目前投票数为0的话换候选人，自己人给自己人投票，敌方减票】
        //摩尔投票法为啥成立？因为这里的众数是指大于总数数目的二分之一，举两个个极端例子
        //121311【肯定有相邻的，其他的】或者111123【全部联合起来，敌方都抵消不了】
        int num = nums[0];//我先来做霸王
        int cnt = 1;//目前帮派就我一个人，遍历下去看看还有没有自己人为自己撑腰打气，首先遇到对手就被搞下去了
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == num){
                cnt++;//帮派的人来撑腰了，票数++
            }
            else{
                cnt--;//敌方来骚扰我当霸王，票数--
                if(cnt == 0){//没了，目前帮派人不够地方多，话语权没有
                    num = nums[i];//更换霸王
                    cnt = 1;//新的霸王重新计数
                }
            }
        }
        //选出来笑到最后的霸王
        return num;
    }
}

package com.zcy.array;

import java.util.ArrayList;
import java.util.List;

public class GoodIndices6190 {
    //自写
    public List<Integer> goodIndices(int[] nums, int k) {
        if(k == nums.length/2 && nums.length %2 == 0){
            return new ArrayList<>();
        }
        //动态维护两个大小为k的集合，记录里面不合法的数量（违反规则的次数，每次移动时判断是否减少了违反规则的数量）
        List<Integer> pre = new ArrayList<>();
        int preCnt = 0;
        List<Integer> post = new ArrayList<>();
        int postCnt = 0;
        int len = nums.length;
        for(int i = 0;i < k;i++){//前k个的集合
            pre.add(nums[i]);
            if(i != k-1 &&nums[i] < nums[i+1]){
                preCnt++;
            }
        }
        for(int i = k+1;i < 2*k+1;i++){
            post.add(nums[i]);
            if(i != 2*k && nums[i] > nums[i+1]){
                postCnt++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = k;i < len - k;i++){
            if(preCnt == 0&&postCnt == 0){
                res.add(i);
            }
            if(pre.size() >1 && pre.get(0) < pre.get(1)){
                preCnt--;
            }
            pre.remove(0);
            if(pre.size() > 0&& pre.get(pre.size() - 1) < nums[i]){
                preCnt++;
            }
            pre.add(nums[i]);
            if(post.size() > 1&&post.get(0) > post.get(1)){
                postCnt--;
            }
            post.remove(0);
            if(i!=len - k - 1 &&post.size() > 0 && post.get(post.size() - 1) > nums[i+k+1]){
                postCnt++;
            }
            if(i!= len - k - 1){
                post.add(nums[i+k+1]);
            }

        }
        return res;

    }
}

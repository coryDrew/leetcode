package com.zcy.offertwo;

import java.util.HashMap;
import java.util.Map;

public class Offer011 {
    //哈希加前缀和
    public int findMaxLength(int[] nums) {
        //counter记录差值
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);//注意这里-1的设置
        int counter = 0;
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if(map.containsKey(counter)){
                res = Math.max(res,i-map.get(counter));//注意这里的长度
            }else{
                map.put(counter,i);
            }
        }
        return res;

    }
}

package com.zcy.prefixSum;

public class SubarraysDivByK974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//除k后余数，次数
        map.put(0,1);
        int len = nums.length;
        int sum = 0;
        int remainder = 0;
        int res = 0;
        for(int i = 0;i < len;i++){
            sum+=nums[i];
            //这里要消除正负数的差异，让正负数最终得到相同的结果 [-1,2] k = 2时的情况
            数学知识，java中的%是取余运算
            remainder = (sum % k + k) % k;//逆天！
            if(map.containsKey(remainder)){
                res+=map.get(remainder);
            }
            if(map.containsKey((remainder - k))){
                res+=map.get(remainder - k);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return res;
    }
}

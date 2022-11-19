package com.zcy.greedy;

public class NumRabbits781 {
    /**
     简单说一说思路吧： 用hash来统计answers中每个数字出现的次数； 然后就是开始处理哈希表里面的统计结果了； 例如， 5出现了8次， 那么至少得2*（5+1）只兔子； 如果5出现了6次呢？ 至少需要6只兔子； 如果5出现了3次呢？ 还是6只兔子； 当val出现了t次， 如果t%（val+1） == 0， 需要（t/（val+1））*（val+1）只兔子； 如果没有整除， 则至少需要(t/(val+1)+1)*(val+1)只兔子； 希望自己说清楚了
     */
    public int numRabbits(int[] answers) {
        int len = answers.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i <answers.length;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0) + 1);
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key == 0){
                res+=value;
                continue;
            }
            if(value/(key+1) == 0 || value == key + 1){
                res+=key+1;
            }else{
                res+=(value/(key+1))*(key+1);
                if(value%(key+1) != 0){
                    res+=key+1;
                }
            }
        }
        return res;
    }
}

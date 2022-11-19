package com.zcy.interview.presum;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;

public class subarraySum560 {
    public static void main(String[] args) {
        double x,y,a;
        char s[]=new char[]{'I',' ','l','o','v','e',' ','y','o','u','!'};
        int index=0;
        for(y=1.3f;y>-1.1f;y-=0.06f){
            index=0;
            for(x=-1.1f;x<=1.1f;x+=0.025f){
                double result=x*x+pow((5.0*y/4.0-sqrt(abs(x))),2);
                if(result<=1){
                    System.out.print((s[index]));
                    index=(index+1)%11;
                }
                else{
                    System.out.print(' ');
                }
            }
            System.out.println(" ");
        }


    }
    public int subarraySum(int[] nums, int k) {
        //返回的是个数
        Map<Integer,Integer> map = new HashMap<>();//第一个代表和，第二个代表个数
        int res = 0;
        int sum = 0;
        map.put(0,1);
        for(int i = 0;i < nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}

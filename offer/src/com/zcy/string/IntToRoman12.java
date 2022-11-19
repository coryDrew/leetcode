package com.zcy.string;

public class IntToRoman12 {
    public String intToRoman(int num) {
        //这个思想非常重要，很多题都有
        //如果要一下一下判断然后一下一下减，会有非常多ifelse以及for循环
        //如何避免？ 数组
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 13;i++){
            while(num>=values[i]){
                num-=values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }
}

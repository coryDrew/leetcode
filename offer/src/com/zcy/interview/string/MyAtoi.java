package com.zcy.interview.string;

public class MyAtoi {
    public int myAtoi(String s) {
        String str = s.trim();
        if(str.length() == 0)return 0;
        int base = 0;
        int res = 0;
        if(str.charAt(0) == '-'){
            base = -1;
        }else if(str.charAt(0) == '+'){
            base = 1;
        }else if(!Character.isDigit(str.charAt(0)))return 0;
        if(Character.isDigit(str.charAt(0))){
            res +=str.charAt(0) -'0';
            base = 1;
        }
        int i = 1;
        while(i < str.length() && (Character.isDigit(str.charAt(i)))){
            int num = (str.charAt(i))-'0';
            //提前判断！
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }

            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                return Integer.MIN_VALUE;
            }
            res = res*10+base*num;
            i++;
        }

        return  res;
    }
}

package com.zcy.brainteasers;

public class MagicString481 {
    public int magicalString(int n) {
        //相当于两个指针对一个字符串做操作
        if(n <= 3){
            return 1;
        }
        StringBuilder str =new StringBuilder("122");
        int numType = str.length() - 1; //记录下一个加入数的类型(是1还是2)
        int numCount = str.length() - 1;//记录加几个该类型数
        int count = 1;//记录1的个数

        //numType一直指向字符串的最后一个字符，而numCount是每次向右走一位
        while(str.length() < n){
            numType = str.length() - 1;
            if(str.charAt(numType) == '1'){
                if(str.charAt(numCount) == '1'){str.append("2");}
                else{str.append("22");}
            }else{
                if(str.charAt(numCount) == '1'){str.append("1");}
                else{str.append("11");}
            }
            numCount++;
        }
        for(int i = 1; i < n; i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}

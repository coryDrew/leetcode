package com.zcy.interview.string;

public class addStrings415 {
    public String addStrings(String num1, String num2) {
        int l = num1.length() - 1;
        int r = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int a = 0;
        int res = 0;
        while(l >= 0 || r >= 0){
            int n1 = l >= 0 ? num1.charAt(l) - '0' :0;
            int n2 = r >= 0 ? num2.charAt(r) - '0':0;
            sum = n1+n2;
            sum += a;
            res = sum % 10;
            a = sum / 10;
            sb.append(res);
            l--;
            r--;
        }
        if(a > 0)sb.append(a);
        return sb.reverse().toString();
    }
}

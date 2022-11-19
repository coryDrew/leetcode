package com.zcy.string;

public class Multiply43 {
    //简单模拟，注意细节即可
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String ans = "0";
        for(int i = num1.length()-1;i >=0;i--){
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for(int k = num1.length()-1;k>i;k--){
                sb.append("0");
            }
            for(int j = num2.length() - 1;j >= 0;j--){
                int sum = (num1.charAt(i) - '0')*(num2.charAt(j) - '0')+add;
                sb.append(sum%10);
                add = sum/10;
            }
            if(add!=0){
                sb.append(add);
            }

            ans = addStrings(ans,sb.reverse().toString());
        }
        return ans;
    }
    public String addStrings(String s1,String s2){
        int i = s1.length() - 1,j = s2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || add != 0){
            int x = i>=0? s1.charAt(i) - '0':0;
            int y = j>=0? s2.charAt(j) - '0':0;
            int sum = x+y+add;
            sb.append(sum%10);
            add = sum/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}

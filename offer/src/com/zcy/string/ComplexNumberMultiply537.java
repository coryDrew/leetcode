package com.zcy.string;

public class ComplexNumberMultiply537 {
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.valueOf(num1.substring(0,num1.indexOf('+')));
        int a2 = Integer.valueOf(num1.substring(num1.indexOf('+')+1,num1.length()-1));
        int b1 = Integer.valueOf(num2.substring(0,num2.indexOf('+')));
        int b2 = Integer.valueOf(num2.substring(num2.indexOf('+')+1,num2.length()-1));
        return a1*b1-a2*b2+ "+"+ (a1*b2+a2*b1)+"i";
    }
}

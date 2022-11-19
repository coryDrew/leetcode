package com.zcy.entrylevel;

import java.text.DecimalFormat;
import java.util.Scanner;

public class B2011 {


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            DecimalFormat df = new DecimalFormat("0.000000000");//注意他的包
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println(df.format(a/b));
        }

}

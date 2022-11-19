package com.zcy.entrylevel;

import java.util.Scanner;

public class B2004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 3;i++){
            int x = sc.nextInt();
            if(String.valueOf(x).length()>=8){
                System.out.print(x);
                System.out.print(" ");
            }else{
                for(int j = 0;j < 8-String.valueOf(x).length();j++){
                    System.out.print(" ");
                }
                System.out.print(x);
                System.out.print(" ");
            }
        }

    }
}

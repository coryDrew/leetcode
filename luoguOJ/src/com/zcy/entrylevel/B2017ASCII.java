package com.zcy.entrylevel;
import java.util.Scanner;
public class B2017ASCII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //char可以强转成int，String不能强转成int
        System.out.println((int)sc.next().charAt(0));//输入字符，得这样
    }
}

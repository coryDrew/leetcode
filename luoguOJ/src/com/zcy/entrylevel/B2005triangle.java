package com.zcy.entrylevel;
import java.util.*;
public class B2005triangle {



        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            for(int i = 0;i < 3;i++){
                for(int j = 0;j < 2*i + 1;j++){
                    System.out.print(s);
                }
                System.out.println("");
            }
        }

}

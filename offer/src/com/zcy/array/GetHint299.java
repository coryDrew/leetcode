package com.zcy.array;

public class GetHint299 {
    //创建两个数组
    public String getHint(String secret, String guess) {
        int[] sCnt = new int[10];
        int[] gCnt = new int[10];
        int bull = 0;
        for(int i = 0;i < secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }else{
                sCnt[secret.charAt(i) - '0']++;
                gCnt[guess.charAt(i) - '0']++;
            }
        }
        int cow = 0;
        for(int i = 0;i < 10;i++){
            cow+=Math.min(sCnt[i],gCnt[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cow);
        sb.append("B");
        return sb.toString();
    }
}

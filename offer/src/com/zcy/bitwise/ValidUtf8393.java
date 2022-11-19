package com.zcy.bitwise;

public class ValidUtf8393 {
    自写还挺快呢
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int i = 0;
        while(i < len){
            int cnt = oneNum(data[i]);
            switch(cnt){
                case 0:
                    i++;
                    break;
                case 1:
                    return false;

                case 2:
                    if(i+1 < len&&oneNum(data[i+1]) == 1){
                        i+=2;
                        break;
                    }else{
                        return false;
                    }
                case 3:
                    if(i+2 < len&&oneNum(data[i+1]) == 1&&oneNum(data[i+2]) == 1){
                        i+=3;
                        break;
                    }else{
                        return false;
                    }
                case 4:
                    if(i+3 < len&&oneNum(data[i+1]) == 1&&oneNum(data[i+2]) == 1&&oneNum(data[i+3]) == 1){
                        i+=4;
                        break;
                    }else{
                        return false;
                    }
                default:return false;
            }
        }
        return true;
    }
    public int oneNum(int x){
        int cnt = 0;
        int i = 7;
        while((i>=3)&&(((x>>i) & 1) != 0)){
            cnt++;
            i--;
        }
        return cnt;
    }
}

package com.zcy.greedy;

import java.util.Arrays;

public class IsNStraightHand846 {
    //自写9%
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        boolean[] isUsed = new boolean[hand.length];
        int t = hand.length/groupSize;
        if(groupSize == 1)return true;
        if(hand.length%groupSize != 0)return false;
        while(t > 0){
            int pre = -1;
            int cnt = 0;
            for(int i = 0;i < hand.length;i++){
                if((pre == -1||pre == hand[i] - 1)&&!isUsed[i]){
                    pre = hand[i];
                    cnt++;
                    isUsed[i] = true;
                }
                if(cnt == groupSize) {
                    t--;
                    break;
                }
            }
            if(cnt < groupSize)return false;
        }
        return true;
    }
}

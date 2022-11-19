package com.zcy.weeklyCompetition301;

import java.util.Arrays;
//ac两题
public class FillCups {
    //自写通过方法：纯暴力垃圾方法
    public int fillCups(int[] amount) {
        if(amount[0] == 0&&amount[1] == 0 && amount[2] == 0){
            return 0;
        }
        int res = 0;
        while(true){//直到三个杯子里都是0才退出
            int maxIndex = 0;
            for(int i = 1;i < 3;i++){
                if(amount[i]>amount[maxIndex]){
                    maxIndex = i;
                }
            }//获得最大下标，最大下标和其余两个任意一个各减一
            switch(maxIndex){
                case 0:
                    amount[0]--;
                    if(amount[1]>0){
                        amount[1]--;
                    }else if(amount[2]>0){
                        amount[2]--;
                    }
                    break;
                case 1:
                    amount[1]--;
                    if(amount[0]>0){
                        amount[0]--;
                    }else if(amount[2]>0){
                        amount[2]--;
                    }
                    break;
                case 2:
                    amount[2]--;
                    if(amount[1]>0){
                        amount[1]--;
                    }else if(amount[0]>0){
                        amount[0]--;
                    }
                    break;
                default:
                    break;
            }
            res++;
            if(amount[0] == 0&&amount[1] == 0 && amount[2] == 0){
                break;
            }
        }
        return res;
    }
    //好的贪心
    public int fillCups66(int[] amount) {
        /**贪心 & 分类讨论
         将饮料按数量从小到大排序，设数量为 xx，yy，zz。我们的目标是匹配尽量多不同的饮料。

         若 x + y \le zx+y≤z，显然每次用一个 zz 和一个 xx 或 yy 匹配是最优的。答案就是 zz。
         若 x + y > zx+y>z，考虑超出的部分 t = (x + y - z)t=(x+y−z)。
         若 tt 是偶数，那么我们可以先把 xx 和 yy 互相匹配 \frac{t}{2}
         2
         t
         ​
         次进行“内部消化”。操作过后有 x + y = zx+y=z，此时每次用一个 zz 和一个 xx 或 yy 匹配即可。答案就是 \frac{t}{2} + z
         2
         t
         ​
         +z。
         若 tt 是奇数，仍然先将 xx 和 yy 互相匹配 \frac{t - }{2}
         2
         t−
         ​
         次进行“内部消化”。操作过后有 x + y - 1 =z，此时每次用一个 zz 和一个 xx 或 yy 匹配，剩下一杯无法匹配。答案就是 \frac{t - 1}{2} + z + 1
         2
         t−1
         ​
         +z+1。
         分类讨论第二条中的内部消化是一定可以进行那么多次的，如果无法进行那么多次 xx 就耗尽了，说明原本 y > zy>z，不符合假设。

         */
        Arrays.sort(amount);
        int t = amount[0] + amount[1] - amount[2];
        if(amount[2]>amount[1]+amount[0]){
            return amount[2];
        }
        else{

            return (t + 1) / 2 + amount[2];
        }

    }


}

package com.zcy.taowaQuestion;

import java.util.Arrays;

public class PileBox {
    /*
    * 思路：每个箱子有三个维度，按照宽进行排序后降为二维，即可用最长上升子序列的思路来解。
状态方程：
dp[i] 表示以第 i 个箱子为最底端箱子时，箱堆的最大高度。
dp[i] = Max( dp[j] ) + box[i][2] 其中 0 <= j < i ,且 i 的三维都要比 j 大

作者：zxw901
链接：https://leetcode.cn/problems/pile-box-lcci/solution/-by-zxw901-fysg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int pileBox(int[][] box) {
        //套娃问题？对的，都是最长上升子序列的变种
        Arrays.sort(box,(x, y)->(x[0]-y[0]));
        int[] dp = new int[box.length];
        int res = 0;
        for(int i = 0;i < box.length;i++){
            for(int j = 0;j < i;j++){
                if(box[j][0]<box[i][0]&&box[j][1]<box[i][1]&&box[j][2]<box[i][2]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }

            }
            dp[i]+=box[i][2];
            res = Math.max(dp[i],res);
        }


        return res;
    }
}

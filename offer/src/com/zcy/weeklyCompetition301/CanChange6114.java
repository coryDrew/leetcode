package com.zcy.weeklyCompetition301;

public class CanChange6114 {
    //这都咋想的呢
    public boolean canChange(String start, String target) {
        /**首先，无论怎么移动，由于 L 和 R 无法互相穿过对方，那么去掉 _ 后的剩余字符应该是相同的，否则返回 false。

         然后用双指针遍历 \textit{start}[i]start[i] 和 \textit{target}[j]target[j]，分类讨论：

         如果当前字符为 L 且 i<ji<j，那么这个 L 由于无法向右移动，返回 false；
         如果当前字符为 R 且 i>ji>j，那么这个 R 由于无法向左移动，返回 false。
         遍历完，若中途没有返回 false 就返回 true。

         */
        if(!start.replaceAll("_","").equals(target.replaceAll("_",""))) return false;
        for(int i = 0,j = 0;i < start.length();i++){
            if(start.charAt(i) == '_') continue;
            while (target.charAt(j) == '_') ++j;
            //此时已经保证相对次序了，每次i和j碰到的都是同一个字符，仅需根据下标判断能移动
            if (i != j && (start.charAt(i) == 'L') != (i > j)) return false;
            //这句也太离谱了，一句有两个逻辑
            ++j;
        }
        return true;
    }
}

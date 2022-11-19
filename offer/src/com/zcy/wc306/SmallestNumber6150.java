package com.zcy.wc306;

public class SmallestNumber6150 {
    //dfs！！！！！！！dfs是弱项，要多练
    /**
     贪心优化
     因为是从小到大选择的数字，所以其实枚举到的第一个答案，就是最终答案，直接返回即可。
     */
    private String ans;
    private boolean[] vis;

    public void dfs(int index, int pre, StringBuilder sb, char[] pattern){
        // 如果本次dfs已经得到答案，直接返回
        if (!"".equals(ans)) return;
        if (index == pattern.length){
            // 枚举到第一个答案直接返回，因为是从小到达选择的字符
            ans = sb.toString();
            return;
        }

        // 根据pattern的值控制枚举范围，'I':(pre, 9], 'D':[1, pre)
        for (int i = (pattern[index] == 'I' ? pre + 1 : 1); i < (pattern[index] == 'I' ? 10 : pre); ++i){
            if (!vis[i]){
                sb.append(i);
                vis[i] = true;
                dfs(index + 1, i, sb, pattern);
                //if(!"".equals(ans)) break;感觉加上这句会更快啊，抄的题解里没加
                vis[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String smallestNumber(String pattern) {
        // 枚举第一个数字
        vis = new boolean[10];
        for (int i = 1; i <= 9; ++i){//这里第一个数字也要for循环，写出来有点蹩脚
            ans = "";
            vis[i] = true;
            dfs(0, i, new StringBuilder(String.valueOf(i)), pattern.toCharArray());
            vis[i] = false;
            // 如果枚举已经得到答案，直接返回
            if (!"".equals(ans)) break;
        }
        return ans;
    }
}

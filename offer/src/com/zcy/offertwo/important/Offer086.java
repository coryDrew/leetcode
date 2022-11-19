package com.zcy.offertwo.important;

public class Offer086 {
    //未写出
    //没看出来是回溯
    //这里通过一个f数组，用动态规划的方式求出了每个区间是否是回文串，最后调用时就是o（1）复杂度
    //回溯，每遇到一个回文串就加入当前list
    boolean[][] f;
    List<List<String>> tmp = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public String[][] partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        int rows = tmp.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = tmp.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = tmp.get(i).get(j);
            }
        }
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            tmp.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

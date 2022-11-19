package com.zcy.brackets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    //还是不会，笨，回溯
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateOne(res, "", n, n);
        return res;
    }

    private void generateOne(List<String> list, String string, int left, int right) {
        // left, rigth 分别代表可用的左括号数和可用的右括号数，初始都是 n个可用
        if (left == 0 && right == 0) {
            list.add(string);
            return;
        }
        //为什么这样就合理了？
        if (left > 0) {
            generateOne(list, string + "(", left - 1, right);
        }

        // 可用的括号 右括号大于左括号时，说明有 左括号先放置，才会是有效的括号组合
        if (right > left) {
            generateOne(list, string + ")", left, right - 1);
        }

    }
}

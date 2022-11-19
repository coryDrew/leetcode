package com.zcy.interview.backtrack;

public class letterCombinations17 {
    String[] str = new String[]{"","","abc","def","ghi","jkl",
            "mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if( digits.length() == 0)return res;
        backtrack(digits,0,new StringBuilder());
        return res;

    }
    public void backtrack(String digits,int i,StringBuilder sb){
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = str[digits.charAt(i) - '0'];//拿到当前的数字对应的字符串
        for(int j = 0;j < s.length();j++){
            sb.append(s.charAt(j));
            backtrack(digits,i+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

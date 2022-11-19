package com.zcy.bitwise;

public class CircularPermutation1238 {
    public List<Integer> circularPermutation(int n, int start) {

        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        for (int i = 0; i < n; i++)
            for (int j = grayCode.size() - 1; j >= 0; j--)
                grayCode.add(grayCode.get(j) + (1 << i));

        // rotate
        for (int i = 0; i < grayCode.size(); i++)
            if (grayCode.get(i) == start) {

                Collections.rotate(grayCode, -i);//旋转集合，牛逼，正好把他旁边一位转到最后了！！！！
                break;
            }

        return grayCode;
    }
}

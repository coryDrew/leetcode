package com.zcy.greedy;

public class maximumSwap670 {
    /**
     核心思路：将最靠后的最大的数，与最靠前的小于它的数交换(若存在)，方得最大结果。

     搞懂两个问题，便可彻底理解本题的贪心核心。

     选择哪个数作为候选数与前面的数交换？——将最靠后的数定为候选数，若它之前出现了更大的数，则更新候选数为该数。
     选择哪个数与候选数交换？——只有当候选数之前存在更小的数时，才需要交换这两数。若更靠前的位置出现小于候选数的数，则将它与候选数交换。
     两次贪心，1贪贪最大，2贪贪最前。
     */

    char[] charArray = String.valueOf(num).toCharArray();
    int n = charArray.length;
    int maxIdx = n - 1;
    int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
        if (charArray[i] > charArray[maxIdx]) {
            maxIdx = i;
        } else if (charArray[i] < charArray[maxIdx]) {
            idx1 = i;
            idx2 = maxIdx;
        }
    }
        if (idx1 >= 0) {
        swap(charArray, idx1, idx2);
        return Integer.parseInt(new String(charArray));
    } else {
        return num;
    }
}

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}

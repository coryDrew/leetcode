package com.zcy.string;

public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        //把indexOf用的非常六
        if (queryIP.indexOf('.') >= 0) {//如果不是.那就是:
            // IPv4
            int last = -1;
            for (int i = 0; i < 4; ++i) {
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
                //indexOf的重载，从last+1位置找'.'
                //取到新的.的位置，即这批数字的后一个位置
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 3) {//长度在1~3之间
                    return "Neither";
                }
                int addr = 0;
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j))) {//有非数字
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');//求和
                }
                if (addr > 255) {
                    return "Neither";
                }
                if (addr > 0 && queryIP.charAt(last + 1) == '0') {//有前导零
                    return "Neither";
                }
                if (addr == 0 && cur - last - 1 > 1) {//全是零
                    return "Neither";
                }
                last = cur;//上一个.的位置
            }
            return "IPv4";
        } else {
            // IPv6
            int last = -1;
            for (int i = 0; i < 8; ++i) {
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                    return "Neither";
                }
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                        return "Neither";
                    }
                }
                last = cur;
            }
            return "IPv6";
        }


    }
}

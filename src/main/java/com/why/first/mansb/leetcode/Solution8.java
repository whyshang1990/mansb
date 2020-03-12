package com.why.first.mansb.leetcode;

public class Solution8 {
    public int myAtoi(String str) {
        int temp = 0;
        int isFu = 1;
        boolean isFirst = true;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(temp);
            if (str.charAt(i) != (' ')) {
                if (isFirst) {
                    if ((str.charAt(i) == (int) ('-'))) {
                        isFu = -1;
                        isFirst = false;
                    } else if (charIsNum(str.charAt(i))) {
                        temp = temp * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
                        isFirst = false;
                    } else {
                        break;
                        // isFirst = true;
                    }
                } else {
                    if (charIsNum(str.charAt(i))) {
                        temp = temp * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
                    } else {
                        break;
                    }
                }
            }
        }

        return temp * isFu;
    }

    private boolean charIsNum(char c) {
        return (int) c >= (int) ('0') && (int) c <= (int) ('9');
    }

    public static void main(String[] args) {
        String s = "w-011";
        Solution8 solution = new Solution8();
        int ret = solution.myAtoi(s);
        System.out.println(ret);
    }
}

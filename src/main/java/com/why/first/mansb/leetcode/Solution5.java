package com.why.first.mansb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    // 第一次解法，91/103 通过测试用例。超时，需要优化
    public String longestPalindrome1(String s) {
        int length = s.length();
        int max = 0;
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        // String temp = "";
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String sub = s.substring(i, j+1);
                if (this.checkString(sub)) {
                    if (max < sub.length()) {
                        max = sub.length();
                        map.put(max, sub);
                    }
                }
                if (max == length - i) {
                    break;
                }
            }
        }
        return map.get(max);
    }

    private boolean checkString(String s) {
        int length = s.length();
        for (int i = 0; i < length - i; i++) {
            if(s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLen = 0;
        String maxPal = "";
        boolean[][] P = new boolean[length][length]; //存储子字符串是否为回文字符串，下标表字符串起始位置
        for (int len = 1; len <= length; len++) { // 遍历长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }


    public static void main(String[] args) {
        String s  = "atttaddd";
        Solution5 solution = new Solution5();
        String r = solution.longestPalindrome(s);
        System.out.println("result: " + r);
    }
}

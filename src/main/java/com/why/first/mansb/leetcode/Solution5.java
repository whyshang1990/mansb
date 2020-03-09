package com.why.first.mansb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    // 第一次解法，91/103 通过测试用例。超时，需要优化
    public String longestPalindrome(String s) {
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
            }
        }
        return map.get(max);
    }

    private boolean checkString(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length - i; i++) {
            if(s.charAt(i) != s.charAt(length - i - 1)) {
                break;
            }
            if (i == length - i - 1) {
                sum += 1;
            } else {
                sum += 2;
            }
        }
        return sum == length;
    }

    public static void main(String[] args) {
        String s  = "";
        Solution5 solution = new Solution5();
        String r = solution.longestPalindrome(s);
        System.out.println("result: " + r);
    }
}

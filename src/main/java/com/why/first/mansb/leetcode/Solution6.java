package com.why.first.mansb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    /**
     * 每一行使用StringBuilder 存储字符
     * 将输入字符串中的字符放到对应的StringBuilderzhong
     * 遍历所有StringBuilder获取结果字符串
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        boolean isAdd = false;
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                isAdd = !isAdd;
            }
            if (isAdd) {
                row += 1;
            } else {
                row -= 1;
            }
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) ret.append(sb);
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        Solution6 solution = new Solution6();
        String r = solution.convert(s, 3);
        System.out.println(r);
    }
}

package com.why.first.mansb.leetcode;

public class Solution6 {
    /**
     * numRows * 2 - 1
     * 思路：col, row(个字符一个循环)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int cols = s.length() / 2;
        char[][] array = new char[numRows][cols];
        int index = 0, row = 0, col = 0;
        while (index < s.length()) {
            while (row < numRows) {
                array[row++][col] = s.charAt(index++);
                if (index >= s.length()) {
                    break;
                }
            }
            if (index >= s.length()) {
                break;
            }
            row--;
            while (row > 0) {
                array[--row][++col] = s.charAt(index++);
                if (index >= s.length()) {
                    break;
                }
            }
            row++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // System.out.println(String.valueOf(array[i]));
            sb.append(String.valueOf(array[i]));
        }
        return sb.toString().replaceAll("\u0000", "");
    }

    public static void main(String[] args) {
        String s = "AA";
        Solution6 solution = new Solution6();
        String r = solution.convert(s, 2);
        System.out.println(r);
    }
}

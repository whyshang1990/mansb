package com.why.first.mansb.leetcode;

public class Solution7 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int num = x % 10;
            x = x /10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                rev = 0;
                break;
            }
            rev = num + rev  * 10 ;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        int ret = solution.reverse(1534236469);
        System.out.println(ret);
    }
}

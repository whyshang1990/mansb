package com.why.first.mansb.leetcode;

public class solution11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int start = 0, end = length -1;
        int area = getArea(start, end, height), newArea;
        while (start < end) {
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
            newArea = getArea(start, end, height);
            area = Math.max(area, newArea);
        }

        return area;
    }

    private int getArea(int start, int end, int[] height) {
        return (end - start) * Math.min(height[start], height[end]);
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        solution11 solution = new solution11();
        int area = solution.maxArea(height);
        System.out.println(area);
    }
}

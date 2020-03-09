package com.why.first.mansb.leetcode;

public class Solution4 {
    // 方法一时间复杂度达不到要求
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] nums = new int[size1 + size2];

        if (size1 == 0) {
            if (size2 % 2 != 0) {
                return (double)(nums2[size2 / 2]);
            } else {
                return (double)(nums2[size2 / 2] + nums2[size2 / 2 - 1]) / 2;
            }
        }
        if (size2 == 0) {
            if (size1 % 2 != 0) {
                return (double)(nums1[size1 / 2]);
            } else {
                return (double)(nums1[size1 / 2] + nums1[size1 / 2 - 1]) / 2;
            }
        }

        int i = 0, j = 0;
        int count = 0;
        while (count != (size1 + size2)) {
            if (i == size1) {
                while (j != size2) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == size2) {
                while (i != size1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    // 二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }

    private static boolean isJiSHu(int num) {
        return (num % 2) == 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,2};
        int[] nums2 = {2,2,2};
        Solution4 solution = new Solution4();
        double d = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }
}

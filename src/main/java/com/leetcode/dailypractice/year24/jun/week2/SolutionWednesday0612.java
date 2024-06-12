package com.leetcode.dailypractice.year24.jun.week2;

import java.util.Arrays;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/sort-colors/">Problem-Link</a>
 *
 * 75. Sort Colors
 * <p>
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * <p>
 * Seen this question in a real interview before?
 * 1/5
 * Yes
 * No
 * Accepted
 * 2M
 * Submissions
 * 3.2M
 * Acceptance Rate
 * 63.1%
 */
public class SolutionWednesday0612 {
    //Mine Solution / Best Solution
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int i = 0;
        while (count[0]-- > 0) {
            nums[i++] = 0;
        }
        while (count[1]-- > 0) {
            nums[i++] = 1;
        }
        while (count[2]-- > 0) {
            nums[i++] = 2;
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        var obj = new SolutionWednesday0612();
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {2, 0, 1};
        obj.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

    }
}

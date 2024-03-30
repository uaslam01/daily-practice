package com.leetcode.dailypractice.year24.mar.week4;

/**
 * <a href="https://leetcode.com/problems/ /">Problem-Link</a>
 * Count-subarrays-where-max-element-appears-at-least-k-times
 * <p>
 * You are given an integer array nums and a positive integer k.
 * <p>
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 * <p>
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 * <p>
 * Seen this question in a real interview before?
 * 1/4
 * Yes
 * No
 * Accepted
 * <p>
 * 35.6K
 */
public class SolutionFriday0329 {
    //Best Soluton1
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0, n = nums.length;
        for (int num : nums)
            max = Math.max(max, num);
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                res += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
        }
        return res;
    }
}

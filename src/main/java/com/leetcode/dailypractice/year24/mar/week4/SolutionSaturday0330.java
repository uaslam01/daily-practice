package com.leetcode.dailypractice.year24.mar.week4;

/**
 * Subarrays-with-k-different-integers
 * <p>
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 * <p>
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 *
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 */

public class SolutionSaturday0330 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0, sz = nums.length;
        int[] cnt = new int[sz + 1];
        for (int l = 0, m = 0, r = 0; r < sz; ++r) {
            if (++cnt[nums[r]] == 1)
                if (--k < 0) {
                    cnt[nums[m++]] = 0;
                    l = m;
                }
            if (k <= 0) {
                while (cnt[nums[m]] > 1)
                    --cnt[nums[m++]];
                res += m - l + 1;
            }
        }
        return res;
    }
}

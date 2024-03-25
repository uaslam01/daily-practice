package com.leetcode.dailypractice.year24.mar.week4;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-all-duplicates-in-an-array/">Problem-Link</a>
 *
 *
 * 442. Find All Duplicates in an Array
 *
 * Medium
 * Topics
 * Companies
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 *
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 *
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 *
 * Seen this question in a real interview before?
 * 1/4
 * Yes
 * No
 * Accepted
 * 717.8K
 * Submissions
 * 953K
 * Acceptance Rate
 * 75.3%
 */
public class SolutionMonday0326 {
    //Best Solution
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }

    //Best Solution 2
    private List<Integer> res;

    public List<Integer> findDuplicates(int[] nums) {
        return new AbstractList<Integer>() {
            public Integer get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                res = new ArrayList<>();
                int t;
                for (int i = 0; i < nums.length; i++) {
                    t = Math.abs(nums[i]);
                    if (nums[t - 1] < 0) {
                        res.add(t);
                    } else {
                        nums[t - 1] *= -1;
                    }
                }
            }
        };
    }
}

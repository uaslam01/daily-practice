package com.leetcode.dailypractice.year24.feb.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/largest-divisible-subset/">Problem-Link</a>
 * 
 * 368. Largest Divisible Subset
 * 
 * Solved Medium Topics Companies
 * 
 * Given a set of distinct positive integers nums, return the largest subset
 * answer such that every pair (answer[i], answer[j]) of elements in this subset
 * satisfies:
 * 
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0
 * 
 * If there are multiple solutions, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * 
 * Output: [1,2]
 * 
 * Explanation: [1,3] is also accepted.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,4,8]
 * 
 * Output: [1,2,4,8]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 2 * 109
 * 
 * All the integers in nums are unique.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 238.9K
 * Submissions 548.8K Acceptance Rate 43.5%
 */
public class SolutionFriday0209 {
	// Best Solution
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		Arrays.sort(nums);

		int maxSize = 1, maxIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (dp[i] > maxSize) {
						maxSize = dp[i];
						maxIndex = i;
					}
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		int num = nums[maxIndex];
		for (int i = maxIndex; i >= 0; i--) {
			if (num % nums[i] == 0 && dp[i] == maxSize) {
				result.add(nums[i]);
				num = nums[i];
				maxSize--;
			}
		}

		return result;
	}

}
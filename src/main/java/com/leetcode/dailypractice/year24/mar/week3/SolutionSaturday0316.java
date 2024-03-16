package com.leetcode.dailypractice.year24.mar.week3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/contiguous-array/">Problem-Link</a>
 * 
 * 525. Contiguous Array
 * 
 * Medium Topics Companies
 * 
 * Given a binary array nums, return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1]
 * 
 * Output: 2
 * 
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number
 * of 0 and 1.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0,1,0]
 * 
 * Output: 2
 * 
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 373.7K
 * Submissions 785.5K Acceptance Rate 47.6%
 */
public class SolutionSaturday0316 {
	// Mine Solution / Time Limit Exceeds
	public int findMaxLength1(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int zerosCount = 0;
			int onesCount = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0)
					zerosCount++;
				else
					onesCount++;
				if (zerosCount == onesCount && (res < j - i)) {
					res = j - i + 1;
				}

			}
		}
		return res;
	}

	// Best Solution
	public int findMaxLength2(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> mp = new HashMap<>();
		int sum = 0;
		int subArrayLength = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			if (sum == 0) {
				subArrayLength = i + 1;
			} else if (mp.containsKey(sum)) {
				subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
			} else {
				mp.put(sum, i);
			}
		}
		return subArrayLength;
	}

	// Best Solution 2
	public int findMaxLength(int[] nums) {
		int N = nums.length;
		int[] mp = new int[2 * N + 2];
		int current = N;
		int result = 0;

		for (int i = 0; i < N; i++) {
			current += (nums[i] << 1) - 1;
			if (current == N) {
				result = i + 1;
			} else if (mp[current] == 0) {
				mp[current] = i + 1;
			} else {
				result = Math.max(result, i - mp[current] + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::print;
		var obj = new SolutionSaturday0316();
		cons.accept(obj.findMaxLength(new int[] { 0, 1 }));
		System.out.println();
		cons.accept(obj.findMaxLength(new int[] { 0, 1, 0 }));
		System.out.println();

		// Custom Input
		cons.accept(obj.findMaxLength(new int[] { 1, 0, 0, 1, 0 }));
		System.out.println();
		cons.accept(obj.findMaxLength(new int[] { 1, 0, 1, 1, 0 }));
		System.out.println();
		cons.accept(obj.findMaxLength(new int[] { 1, 1, 1, 1, 0 }));
		System.out.println();

	}
}

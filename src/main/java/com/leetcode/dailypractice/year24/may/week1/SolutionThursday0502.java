package com.leetcode.dailypractice.year24.may.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/">Problem-Link</a>
 *
 * 2441. Largest Positive Integer That Exists With Its Negative
 * 
 * Solved Easy Topics Companies Hint
 * 
 * Given an integer array nums that does not contain any zeros, find the largest
 * positive integer k such that -k also exists in the array.
 * 
 * Return the positive integer k. If there is no such integer, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,-3,3] Output: 3 Explanation: 3 is the only valid k we can
 * find in the array.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [-1,10,6,7,-7,1] Output: 7 Explanation: Both 1 and 7 have their
 * corresponding negative values in the array. 7 has a larger value.
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [-10,8,6,7,-2,-3] Output: -1 Explanation: There is no a single
 * valid k, we return -1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 -1000 <= nums[i] <= 1000 nums[i] != 0
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 164.1K
 * Submissions 220.4K Acceptance Rate 74.5%
 */
public class SolutionThursday0502 {
	//Mine Solution
	public int findMaxK1(int[] nums) {
		boolean[] arrSum = new boolean[1001];
		Set<Integer> keySet = new HashSet<>();
		for (int val : nums) {
			if (val > 0) {
				arrSum[val] = true;
				keySet.add(val);
			} else {
				keySet.add(-val);
				arrSum[-val] = false;
			}
		}
		for (int i = 1000; i > 0; i--) {
			if (keySet.contains(i) && !arrSum[i])
				return i;
		}

		return -1;

	}
	//Best Solution
	public int findMaxK2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int res = -1;
		for (int k : nums) {
			if (k > 0 && set.contains(-k)) {
				res = Math.max(res, k);
			}
		}
		return res;
	}
	//Best Solution 2
	public int findMaxK3(int[] nums) {
		if (nums.length < 2) {
			return -1;
		}
		Arrays.sort(nums);
		int lp = 0;
		int rp = nums.length - 1;
		while (lp < rp) {
			if (0 - nums[lp] == nums[rp]) {
				return nums[rp];
			} else if (0 - nums[lp] < nums[rp]) {
				rp--;
			} else {
				lp++;
			}
		}
		return -1;

	}
	//Best Solution 3
	public int findMaxK4(int[] nums) {

		int result = -1;
		int maxVal = 0;
		for (int num : nums) {
			if (num > 0 && num > maxVal && checkNegExists(nums, -1 * num)) {
				maxVal = num;
				result = maxVal;
			}
		}
		return result;
	}

	public boolean checkNegExists(int[] nums, int k) {
		for (int num : nums) {
			if (k == num) {
				return true;
			}
		}
		return false;
	}

	//Best Solution 4
	public int findMaxK(int[] nums) {
		int[] sum = new int[1001];
		int max = -1;
		for (int n : nums) {
			int index = n > 0 ? n : -n;
			if (sum[index] != n) {
				sum[index] += n;
			}

			if (sum[index] == 0) {
				max = max > index ? max : index;
			}
		}
		return max;
	}

	public static void main(String[] arg) {
		var obj = new SolutionThursday0502();
		System.out.println(obj.findMaxK(new int[] {-1,2,-3,3}));
		System.out.println(obj.findMaxK(new int[] {-1,10,6,7,-7,1}));
		System.out.println(obj.findMaxK(new int[] {-10,8,6,7,-2,-3}));

		//Wrong Output
		System.out.println(obj.findMaxK(new int[] {-9,-43,24,-23,-16,-30,-38,-30}));

	}
}

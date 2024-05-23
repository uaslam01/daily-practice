package com.leetcode.dailypractice.year24.may.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/the-number-of-beautiful-subsets/">
 * Problem-Link</a>
 * 
 * 2597. The Number of Beautiful Subsets
 * 
 * Medium Topics Companies Hint
 * 
 * You are given an array nums of positive integers and a positive integer k. A
 * subset of nums is beautiful if it does not contain two integers with an
 * absolute difference equal to k. Return the number of non-empty beautiful
 * subsets of the array nums. A subset of nums is an array that can be obtained
 * by deleting some (possibly none) elements from nums. Two subsets are
 * different if and only if the chosen indices to delete are different.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,4,6], k = 2
 * 
 * Output: 4
 * 
 * Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2,
 * 6].
 * 
 * It can be proved that there are only 4 beautiful subsets in the array
 * [2,4,6].
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The beautiful subset of the array nums is [1]. It can be proved that there is
 * only 1 beautiful subset in the array [1].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 20 1 <= nums[i], k <= 1000
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 71.1K
 * Submissions 152.8K Acceptance Rate 46.5%
 **/

public class SolutionThursday0523 {
	// Mine Solution
	public int beautifulSubsets(int[] nums, int k) {
		int len = nums.length;
		int count = 0;
		for (int i = 0; i < 1 << len; i++) {
			int num = i;
			int ind = 0;
			List<Integer> subset = new ArrayList<>();
			while (num > 0) {
				if (num % 2 == 1) {
					subset.add(nums[ind]);
				}
				ind++;
				num = num / 2;
			}
			if (isBeautifulSubSet(subset, k)) {
				count++;
			}
		}
		return count;
	}

	private boolean isBeautifulSubSet(List<Integer> subset, int k) {
		if (subset.isEmpty())
			return false;
		int len = subset.size();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (Math.abs(subset.get(i) - subset.get(j)) == k) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		var obj = new SolutionThursday0523();

		System.out.println(obj.beautifulSubsets(new int[] {2, 4, 6}, 2));
		System.out.println(obj.beautifulSubsets(new int[] {1}, 1));
		//Custom Input
		System.out.println(obj.beautifulSubsets(new int[] {2, 3, 6}, 2));

	}
}

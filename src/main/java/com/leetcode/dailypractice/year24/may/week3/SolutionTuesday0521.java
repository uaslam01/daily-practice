package com.leetcode.dailypractice.year24.may.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/subsets/"> Problem-Link</a>
 * 
 * 78. Subsets
 * 
 * Medium Topics Companies
 * 
 * Given an integer array nums of unique elements, return all possible
 * subset(the power set). The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * 
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0]
 * 
 * Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10 -10 <= nums[i] <= 10 All the numbers of nums are
 * unique.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 1.9M
 * Submissions 2.4M Acceptance Rate 77.8%
 **/
public class SolutionTuesday0521 {
	// Mine Solution
	public List<List<Integer>> subsets(int[] nums) {
		int len = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		double totalCombination = Math.pow(2, len);
		for (int i = 0; i < totalCombination; i++) {
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
			list.add(subset);
		}
		return list;
	}

	// Best Solution
	public int subsetXORSum3(int[] nums) {
		return helper(nums, 0, 0);
	}

	public int helper(int[] nums, int index, int currValue) {
		if (index == nums.length)
			return currValue;

		return helper(nums, index + 1, currValue ^ nums[index]) + helper(nums, index + 1, currValue);
	}

	public static void main(String[] arg) {
		var obj = new SolutionTuesday0521();
		Consumer<List<Integer>> listConsumer = x -> {
			x.forEach(i -> {
				System.out.print(i + " ");
			});
			System.out.println();
		};

		Consumer<List<List<Integer>>> cons = x -> x.forEach(listConsumer);
		cons.accept(obj.subsets(new int[] {1, 2, 3}));
		cons.accept(obj.subsets(new int[] {0}));
		//Custom Input
		cons.accept(obj.subsets(new int[] {1, 2, 3, 4}));
	}

}

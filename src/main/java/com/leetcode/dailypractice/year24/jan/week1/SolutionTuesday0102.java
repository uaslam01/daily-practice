package com.leetcode.dailypractice.year24.jan.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">Problem-Link</a>
 *
 * 
 * avatar 2610. Convert an Array Into a 2D Array With Conditions Medium 1K 47
 * Companies
 * 
 * You are given an integer array nums. You need to create a 2D array from nums
 * satisfying the following conditions:
 * 
 * The 2D array should contain only the elements of the array nums. Each row in
 * the 2D array contains distinct integers. The number of rows in the 2D array
 * should be minimal. Return the resulting array. If there are multiple answers,
 * return any of them.
 * 
 * Note that the 2D array can have a different number of elements on each row.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,1,2,3,1]
 * 
 * Output: [[1,3,4,2],[1,3],[1]] Explanation: We can create a 2D array that
 * contains the following rows: - 1,3,4,2 - 1,3 - 1 All elements of nums were
 * used, and each row of the 2D array contains distinct integers, so it is a
 * valid answer. It can be shown that we cannot have less than 3 rows in a valid
 * array. Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * 
 * Output: [[4,3,2,1]] Explanation: All elements of the array are distinct, so
 * we can keep all of them in the first row of the 2D array.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200 1 <= nums[i] <= nums.length Accepted 104.2K
 * Submissions 118.8K Acceptance Rate 87.7% Seen this question in a real
 * interview before? 1/4
 **/
public class SolutionTuesday0102 {
	// Mine Solution
	public List<List<Integer>> findMatrix1(int[] nums) {
		int[] numbersCount = new int[201];
		for (int i : nums) {
			numbersCount[i]++;
		}
		boolean isContinue = true;
		List<List<Integer>> res = new ArrayList<>();
		while (isContinue) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 1; i < numbersCount.length; i++) {
				if (numbersCount[i] > 0) {
					temp.add(i);
					numbersCount[i]--;
				}
			}
			if (temp.isEmpty())
				isContinue = false;
			else
				res.add(temp);
		}
		return res;
	}

	// Best Solution 1
	public List<List<Integer>> findMatrix(int[] nums) {
		int[] freq = new int[nums.length + 1];
		List<List<Integer>> ans = new ArrayList<>();

		for (int c : nums) {
			if (freq[c] >= ans.size()) {
				ans.add(new ArrayList<>());
			}

			ans.get(freq[c]).add(c);
			freq[c]++;
		}

		return ans;
	}
	

	public static void main(String[] args) {
		Consumer<List<List<Integer>>> cons = i -> i.forEach(j -> {
			j.forEach(k -> System.out.print(k + ","));
			System.out.println();
		});
		var obj = new SolutionTuesday0102();
		cons.accept(obj.findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 }));
		cons.accept(obj.findMatrix(new int[] { 1, 2, 3, 4 }));

	}
}

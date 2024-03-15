package com.leetcode.dailypractice.year24.mar.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/product-of-array-except-self/">Problem-Link</a>
 * 
 * 238. Product of Array Except Self
 * 
 * Solved Medium Topics Companies
 * 
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4]
 * 
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3]
 * 
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 -30 <= nums[i] <= 30 The product of any prefix or
 * suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 2.4M
 * Submissions 3.7M Acceptance Rate 65.8%
 */
public class SolutionFriday0315 {
	// Mine Solution/ Old one
	public int[] productExceptSelf1(int[] nums) {
		List<Integer> res = new ArrayList<>();

		List<Integer> preArr = new ArrayList<>();
		List<Integer> postArr = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			preArr.add(1);
			postArr.add(1);
		}
		int product = nums[0];
		preArr.add(1);
		for (int i = 1; i < nums.length; i++) {
			preArr.set(i, product);
			product *= nums[i];
		}
		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			postArr.set(i, product);
			product *= nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			res.add(preArr.get(i) * postArr.get(i));
		}

		return res.stream().mapToInt(Integer::intValue).toArray();

	}

	// Mine Solution / Best Solution
	public int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];
		List<Integer> zeroList = new ArrayList<>();
		int totalProduct = 1;
		int zeroInd = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroList.add(0);
				zeroInd = i;
			}
			totalProduct *= nums[i];
		}
		if (zeroList.isEmpty()) {
			for (int i = 0; i < nums.length; i++) {
				res[i] = totalProduct / nums[i];
			}
		} else if (zeroList.size() == 1) {
			res[zeroInd] = 1;
			for (int i = 0; i < zeroInd; i++) {
				res[zeroInd] *= nums[i];
			}
			for (int i = zeroInd + 1; i < nums.length; i++) {
				res[zeroInd] *= nums[i];
			}
		}
		return res;
	}

	// Best Solution 3
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[i] = product;
			product = product * nums[i];
		}
		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] = ans[i] * product;
			product = product * nums[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::print;
		Consumer<int[]> arrConsumer = x -> Arrays.stream(x).forEach(cons);
		var obj = new SolutionFriday0315();
		arrConsumer.accept(obj.productExceptSelf(new int[] { 1, 2, 3, 4 }));
		System.out.println();
		arrConsumer.accept(obj.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));
		System.out.println();

		// Custom Input
		arrConsumer.accept(obj.productExceptSelf(new int[] { 1, 2, 1, 2, 2 }));
		System.out.println();

	}
}

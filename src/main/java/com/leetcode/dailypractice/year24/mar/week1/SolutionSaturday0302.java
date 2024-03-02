package com.leetcode.dailypractice.year24.mar.week1;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/squares-of-a-sorted-array/">Problem-Link</a>
 *
 * 977. Squares of a Sorted Array
 * 
 * Solved Easy Topics Companies
 * 
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10]
 * 
 * Output: [0,1,9,16,100]
 * 
 * Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting,
 * it becomes [0,1,9,16,100].
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [-7,-3,2,3,11]
 * 
 * Output: [4,9,9,49,121]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -104 <= nums[i] <= 104
 * 
 * nums is sorted in non-decreasing order.
 * 
 * 
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.7M
 * Submissions 2.4M Acceptance Rate 72.4%
 */
public class SolutionSaturday0302 {
	// Mine Solution
	public int[] sortedSquares2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] *= nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}

	// Mine Solution 2
	public static int[] sortedSquares1(int[] nums) {
		int[] squaresNums = Arrays.stream(nums).map(x -> x * x).toArray();
		Arrays.sort(squaresNums);
		return squaresNums;
	}

	// Best Soltuion
	public int[] sortedSquares(int[] nums) {
		int left = 0, right = nums.length - 1;
		int[] result = new int[nums.length];
		int i = nums.length - 1, sq = 0;
		while (left <= right) {
			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				sq = nums[left];
				left++;
			} else {
				sq = nums[right];
				right--;
			}
			result[i--] = sq * sq;
		}
		return result;
	}

	public static void main(String[] arg) {
		IntConsumer cons = System.out::println;
		Consumer<IntStream> listCons = i -> i.forEach(cons);
		int[] arr = new int[] { -7, -3, 2, 3, 11 };
		var obj = new SolutionSaturday0302();
		listCons.accept(Arrays.stream(obj.sortedSquares(arr)));
	}

}

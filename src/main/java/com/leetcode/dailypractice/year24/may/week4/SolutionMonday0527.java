package com.leetcode.dailypractice.year24.may.week4;

import java.util.Arrays;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/">
 * Problem-Link</a>
 * 
 * 1608. Special Array With X Elements Greater Than or Equal X
 * 
 * Easy Topics Companies Hint
 * 
 * You are given an array nums of non-negative integers. nums is considered
 * special if there exists a number x such that there are exactly x numbers in
 * nums that are greater than or equal to x.
 * 
 * Notice that x does not have to be an element in nums. Return x if the array
 * is special, otherwise, return -1. It can be proven that if nums is special,
 * the value for x is unique.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,5]
 * 
 * Output: 2
 * 
 * Explanation: There are 2 values (3 and 5) that are greater than or equal to
 * 2.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0,0]
 * 
 * Output: -1
 * 
 * Explanation: No numbers fit the criteria for x. If x = 0, there should be 0
 * numbers >= x, but there are 2. If x = 1, there should be 1 number >= x, but
 * there are 0. If x = 2, there should be 2 numbers >= x, but there are 0. x
 * cannot be greater since there are only 2 numbers in nums.
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [0,4,3,0,4]
 * 
 * Output: 3
 * 
 * Explanation: There are 3 values that are greater than or equal to 3.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 1000
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 130.7K
 * Submissions 203.5K Acceptance Rate 64.2%
 **/
class SolutionMonday0527 {
	// Mine Solution
	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int lastVal =  nums[len-1];
		for(int i=len-1;i>=0;i--) {
			if(nums[i]==0 && lastVal-1 == len-i-1) {
				return lastVal-1;
			}
			else if(nums[i]==len-i && (i-1<0 || nums[i-1]!=nums[i])) {
				return nums[i];
			}
			lastVal = nums[i];
		}
		
		return lastVal-1 == len?lastVal-1:-1;
	}
	

	public static void main(String[] args) {
		var obj = new SolutionMonday0527();
		System.out.println(obj.specialArray(new int[] { 1,0,0,6,4,9 }));
		System.out.println(obj.specialArray(new int[] { 1, 1, 1 }));

		System.out.println(obj.specialArray(new int[] { 0, 2 }));
		
		System.out.println(obj.specialArray(new int[] { 3, 5 }));
		System.out.println(obj.specialArray(new int[] { 0, 0 }));
		System.out.println(obj.specialArray(new int[] { 0, 4, 3, 0, 4 }));
		System.out.println(obj.specialArray(new int[] { 3,6,7,7,0 }));

	}
}

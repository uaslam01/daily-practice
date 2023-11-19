package com.leetcode.dailypractice.year23.nov.week3;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 * Reduction Operations to Make the Array Elements Equal Medium 983 42 Companies
 * Given an integer array nums, your goal is to make all elements in nums equal.
 * To complete one operation, follow these steps:
 * 
 * Find the largest value in nums. Let its index be i (0-indexed) and its value
 * be largest. If there are multiple elements with the largest value, pick the
 * smallest i. Find the next largest value in nums strictly smaller than
 * largest. Let its value be nextLargest. Reduce nums[i] to nextLargest. Return
 * the number of operations to make all elements in nums equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,1,3] Output: 3 Explanation: It takes 3 operations to make
 * all elements in nums equal: 1. largest = 5 at index 0. nextLargest = 3.
 * Reduce nums[0] to 3. nums = [3,1,3]. 2. largest = 3 at index 0. nextLargest =
 * 1. Reduce nums[0] to 1. nums = [1,1,3]. 3. largest = 3 at index 2.
 * nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1]. Example 2:
 * 
 * Input: nums = [1,1,1] Output: 0 Explanation: All elements in nums are already
 * equal. Example 3:
 * 
 * Input: nums = [1,1,2,2,3] Output: 4 Explanation: It takes 4 operations to
 * make all elements in nums equal: 1. largest = 3 at index 4. nextLargest = 2.
 * Reduce nums[4] to 2. nums = [1,1,2,2,2]. 2. largest = 2 at index 2.
 * nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1,2,2]. 3. largest = 2 at
 * index 3. nextLargest = 1. Reduce nums[3] to 1. nums = [1,1,1,1,2]. 4. largest
 * = 2 at index 4. nextLargest = 1. Reduce nums[4] to 1. nums = [1,1,1,1,1].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 104 1 <= nums[i] <= 5 * 104
 */
public class SolutionSunday1119 {
	//Mine
	public int reductionOperations1(int[] nums) {
		Arrays.sort(nums);
		int count=0;
		int len = nums.length;
		for(int i=len-1;i>0;i--) {
			int j=i-1;
			while(j>=0&&nums[j]==nums[i]) {
				j--;
			}
			i=j+1;
			if(j==-1)
				return count;
			
			count+=(len-1-j);
		}
		return count;		
	}
	//Best Solution
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int operations = 0;
        int prevUnique = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == prevUnique) continue;

            if (nums[i] < prevUnique) {
                operations += nums.length - 1 - i;
            }

            prevUnique = nums[i];
        }

        return operations;        
    }
	public static void main(String[] args) {

		Consumer cons = System.out::println;
		var obj = new SolutionSunday1119();
		cons.accept(obj.reductionOperations(new int[] {1,2,1 }));
		cons.accept(obj.reductionOperations(new int[] {1,2,2,3,3,3 }));
		cons.accept(obj.reductionOperations(new int[] {1,2,4,2,3 }));

		cons.accept(obj.reductionOperations(new int[] {1,1,1 }));

		cons.accept(obj.reductionOperations(new int[] {5,1,3 }));
		cons.accept(obj.reductionOperations(new int[] {1,1,2,2,3 }));

	}
}
package com.leetcode.dailypractice.year23.nov.week4;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Sum of Absolute Differences in a Sorted Array Medium 1.4K 44 Companies You
 * are given an integer array nums sorted in non-decreasing order.
 * 
 * Build and return an integer array result with the same length as nums such
 * that result[i] is equal to the summation of absolute differences between
 * nums[i] and all the other elements in the array.
 * 
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j <
 * nums.length and j != i (0-indexed).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,5] Output: [4,3,5] Explanation: Assuming the arrays are
 * 0-indexed, then result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4, result[1]
 * = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3, result[2] = |5-2| + |5-3| + |5-5| =
 * 3 + 2 + 0 = 5. Example 2:
 * 
 * Input: nums = [1,4,6,8,10] Output: [24,15,13,15,21]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 1 <= nums[i] <= nums[i + 1] <= 104 Accepted 51.5K
 * Submissions 77K Acceptance Rate 66.9%
 */
public class SolutionSaturday1125 {
	//Mine Time limit exceeds
    public int[] getSumAbsoluteDifferences1(int[] nums) {
    	final int len = nums.length;
    	AtomicInteger index = new AtomicInteger(0);
    	final int[] arr = new int[len];
        Arrays.stream(nums).forEach(i->{
        	arr[index.getAndIncrement()]=Arrays.stream(nums).map(m->Math.abs(m-i)).sum();
        	});
        return arr;
    }
    //Best
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int A = 0, B = 0;
        for (int x : nums) {
            B += x;
        }

        int[] ans = new int[n];
        int i = 0;
        for (int x : nums) {
            ans[i] = (2 * i - n) * x + B - A;
            A += x;
            B -= x;
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {

		Consumer cons = i-> Arrays.stream((int[]) i).forEach(System.out::print);
		var obj = new SolutionSaturday1125();
		cons.accept(obj.getSumAbsoluteDifferences(new int[] {2,3,5 }));
		System.out.println();
		cons.accept(obj.getSumAbsoluteDifferences(new int[] {1,4,6,8,10 }));

	}

}

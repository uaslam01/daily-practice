package com.leetcode.dailypractice.year24.mar.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/count-elements-with-maximum-frequency/">Problem-Link</a>
 * 
 * 3005. Count Elements With Maximum Frequency
 * 
 * Easy Topics Companies Hint
 * 
 * You are given an array nums consisting of positive integers.
 * 
 * Return the total frequencies of elements in nums such that those elements all
 * have the maximum frequency.
 * 
 * The frequency of an element is the number of occurrences of that element in
 * the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1,4]
 * 
 * Output: 4
 * 
 * Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum
 * frequency in the array. So the number of elements in the array with maximum
 * frequency is 4.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5]
 * 
 * Output: 5
 * 
 * Explanation: All elements of the array have a frequency of 1 which is the
 * maximum. So the number of elements in the array with maximum frequency is 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 1 <= nums[i] <= 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 80.6K
 * Submissions 103.4K Acceptance Rate 78.0%
 */
public class SolutionFriday0308 {
	// Mine Solution / Best Solution
	public int maxFrequencyElements1(int[] nums) {
		byte[] freqs = new byte[101];
		for (int num : nums) {
			freqs[num]++;
		}
		int maxFreq = 1;
		for (byte freq : freqs) {
			if (freq > maxFreq)
				maxFreq = freq;
		}
		int count = 0;
		for (byte freq : freqs) {
			if (freq == maxFreq)
				count++;
		}
		return count * maxFreq;
	}
	
	//Best Solution 2
	public int maxFrequencyElements2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            int newFreq = freq.getOrDefault(i, 0) + 1;
            max = Math.max(max, newFreq);
            freq.put(i, newFreq);
        }

        int ttl = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                ttl += entry.getValue();
            }
        }

        return ttl;
    }
	
	//Best Solution 3
	public int maxFrequencyElements(int[] nums) {
        int[] x = new int[100];
        int max = 0;
        int ans = 0;
        for (int num : nums) {
            x[num - 1]++;
            if (x[num - 1] == max)
                ans += max;
            else if (x[num - 1] > max) {
                max = x[num - 1];
                ans = max;
            }
        }
        return ans;
    }
	

	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionFriday0308();

		cons.accept(obj.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
		cons.accept(obj.maxFrequencyElements(new int[] { 1, 2, 3, 4, 5 }));
		// Custom Input
		cons.accept(obj.maxFrequencyElements(new int[] { 1, 2, 1, 2, 2 }));
	}
}

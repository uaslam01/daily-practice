package com.leetcode.dailypractice.year23.nov.week3;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 * Frequency of the Most Frequent Element Medium 3.8K 128 Companies The
 * frequency of an element is the number of times it occurs in an array.
 * 
 * You are given an integer array nums and an integer k. In one operation, you
 * can choose an index of nums and increment the element at that index by 1.
 * 
 * Return the maximum possible frequency of an element after performing at most
 * k operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,4], k = 5 Output: 3 Explanation: Increment the first
 * element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3. Example 2:
 * 
 * Input: nums = [1,4,8,13], k = 5 Output: 2 Explanation: There are multiple
 * optimal solutions: - Increment the first element three times to make nums =
 * [4,4,8,13]. 4 has a frequency of 2. - Increment the second element four times
 * to make nums = [1,8,8,13]. 8 has a frequency of 2. - Increment the third
 * element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * Example 3:
 * 
 * Input: nums = [3,9,6], k = 2 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 105 1 <= k <= 105 Accepted 99.2K Subm
 */
public class SolutionSaturday1118 {
	// Mine Solution
    public int maxFrequency1(int[] nums, int k) {
		Arrays.sort(nums);
		short maxFreq = 1;
		int len = nums.length;
		for(int i=len-1;i>=0;i--) {
			short ithFreq = 1;
			int ithK=k;
			for(int j=i-1;j>=0;j--) {
				if(nums[j]==nums[i]) {
					ithFreq++;
				} else if(nums[j]+ithK>=nums[i]) {
					ithK-=nums[i]-nums[j];
					ithFreq++;
				} else {
					break;
				}
			}
			if(ithFreq>maxFreq)
				maxFreq = ithFreq;
		}
		return maxFreq;
    }

	// Best Solution
	
    public int maxFrequency(int[] nums, int k) {
        int maxFrequency = 0; // Initialize the maximum frequency
        long currentSum = 0; // Initialize the current sum of the subarray elements

        Arrays.sort(nums); // Sort the array in ascending order

        for (int left = 0, right = 0; right < nums.length; ++right) {
            currentSum += nums[right]; // Include the current element in the subarray sum

            // Check if the current subarray violates the condition (sum + k < nums[right] * length)
            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left]; // Adjust the subarray sum by removing the leftmost element
                left++; // Move the left pointer to the right
            }

            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
	public static void main(String[] args) {

		Consumer cons = System.out::println;
		var obj = new SolutionSaturday1118();
		cons.accept(obj.maxFrequency(new int[] {1,2,4 },5));

		cons.accept(obj.maxFrequency(new int[] {1,4,8,13 },5));
		cons.accept(obj.maxFrequency(new int[] {3,9,6 },2));

	}
}
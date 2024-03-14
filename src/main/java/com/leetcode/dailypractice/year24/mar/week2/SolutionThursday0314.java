package com.leetcode.dailypractice.year24.mar.week2;

import java.util.HashMap;
import java.util.function.IntConsumer;

/**
 * 
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/binary-subarrays-with-sum/">Problem-Link</a>
 *
 * 930. Binary Subarrays With Sum
 * 
 * Medium Topics Companies
 * 
 * Given a binary array nums and an integer goal, return the number of non-empty
 * subarrays with a sum goal.
 * 
 * A subarray is a contiguous part of the array.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,1,0,1], goal = 2
 * 
 * Output: 4
 * 
 * Explanation: The 4 subarrays are bolded and underlined below: [1,0,1,0,1]
 * [1,0,1,0,1] [1,0,1,0,1] [1,0,1,0,1]
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0,0,0,0,0], goal = 0
 * 
 * Output: 15
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 nums[i] is either 0 or 1. 0 <= goal <=
 * nums.length
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 143.2K
 * Submissions 242.6K Acceptance Rate 59.0%
 */
public class SolutionThursday0314 {
	// Mine Solution
	public int numSubarraysWithSum1(int[] nums, int goal) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			int sum = 0;
			for(int j=i;j<nums.length;j++) {
				sum+=nums[j];
				if(sum==goal) {
					count++;
				}
			}
		}
		return count;
	}
	//Best Solution
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int ans=0,sum=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(sum, 1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-goal)){
                ans+=map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

	public static void main(String[] arg) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionThursday0314();
		cons.accept(obj.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));
		cons.accept(obj.numSubarraysWithSum(new int[] { 0, 0, 0, 0, 0 }, 0));

		// Custom Input
		cons.accept(obj.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 3));
		cons.accept(obj.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 4));
		cons.accept(obj.numSubarraysWithSum(new int[] { 1, 0, 1, 1, 1 }, 3));

	}
}

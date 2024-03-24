package com.leetcode.dailypractice.year24.mar.week4;

import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-the-duplicate-number/">Problem-Link</a>
 * 
 * 287. Find the Duplicate Number
 * 
 * Solved Medium Topics Companies
 * 
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,2,2] 
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [3,1,3,4,2] 
 * 
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [3,3,3,3,3] 
 * 
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 105 nums.length == n + 1 1 <= nums[i] <= n
 * 
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * Follow up:
 * 
 * How can we prove that at least one duplicate number must exist in nums? Can
 * you solve the problem in linear runtime complexity?
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.7M
 * Submissions 2.8M Acceptance Rate 60.5%
 */
public class SolutionSunday0325 {
	//Basic Solution 
	//Time Limit Exceeded
	public int findDuplicate1(int[] nums) {
        for(int i=0;i<nums.length;i++){
        	for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])
                	return nums[i];
            }
        }
        return -1;
    }
	
	//Mine Solution Best Solution
    public int findDuplicate2(int[] nums) {
        boolean[] markerArr = new boolean[nums.length];
        for(int num: nums){
            if(markerArr[num])
            {
                markerArr[num]=true;
            } else
            {
                return num;
            }
        }
        return -1;
    }
    
    //With array changes
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])] < 0)
                return Math.abs(nums[i]);

            nums[Math.abs(nums[i])] *= -1;     
        }
        return 0;
    }
    public static void main(String[] args) {
    	IntConsumer cons = System.out::print;
		var obj = new SolutionSunday0325();
		cons.accept(obj.findDuplicate(new int[] { 1,3,4,2,2 }));
		System.out.println();
		cons.accept(obj.findDuplicate(new int[] { 3,1,3,4,2}));
		System.out.println();
		cons.accept(obj.findDuplicate(new int[] {3,3,3,3,3}));
		System.out.println();
    }
}

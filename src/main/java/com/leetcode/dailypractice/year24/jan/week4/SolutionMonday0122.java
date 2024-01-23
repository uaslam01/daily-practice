package com.leetcode.dailypractice.year24.jan.week4;

import java.util.Arrays;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/set-mismatch/">Problem-Link</a>
 * 
 * 645. Set Mismatch 
 * 
 * Solved Easy Topics Companies 
 * 
 * You have a set of integers s,
 * which originally contains all the numbers from 1 to n. Unfortunately, due to
 * some error, one of the numbers in s got duplicated to another number in the
 * set, which results in repetition of one number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set
 * after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return
 * them in the form of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,4] Output: [2,3] 
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,1] Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 104 1 <= nums[i] <= 104 
 * 
 * Seen this question in a real
 * interview before? 1/4 Yes No Accepted 417.8K Submissions 937.1K Acceptance
 * Rate 44.6%
 */
public class SolutionMonday0122 {
	//Mine Solution 1
    public int[] findErrorNums3(int[] nums) { 
    	int expectedSumOfN = (nums.length*(nums.length+1))/2;
    	int actualSumOfN = 0;
    	for(int i: nums) {
    		actualSumOfN+=i;
    	}
    	int diff = expectedSumOfN-actualSumOfN;
    	boolean[] markerArr = new boolean[nums.length];
    	int duplicate = 0;
    	for(int i: nums) {
    		if(markerArr[i-1]==false) {
    			markerArr[i-1] = true;
    		} else {
    			duplicate = i;
    			break;
    		}
    		
    	}
    	return new int[] {duplicate, duplicate+diff};
    }	
	//Mine Solution 2/Best Solution
    public int[] findErrorNums2(int[] nums) { 
    	int expectedSumOfN = (nums.length*(nums.length+1))/2;
    	int actualSumOfN = 0;
    	for(int i: nums) {
    		actualSumOfN+=i;
    	}
    	Arrays.sort(nums);
    	int diff = expectedSumOfN-actualSumOfN;
    	for(int i=0; i<nums.length-1;i++) {
    		if(nums[i]==nums[i+1]) 
				return new int[] {nums[i], nums[i]+diff};
    	}
    	return new int[0];
    }	
	
	//Best Solution
    public int[] findErrorNums1(int[] nums) {
        int dup = -1, missing = -1;
        
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
        }
        
        return new int[] {dup, missing};
    }
    //Best Solution 2
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        int mis = 0;
        int dub = 0;
        int res[] = new int[2];

        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) {
                res[0] = nums[i];
                res[1] = i + 1;
            }
        }
        return res;  
    }
	public static void main(String[] args) {
		var obj = new SolutionMonday0122();
		Arrays.stream(obj.findErrorNums(new int[] {1,2,2,4})).forEach(System.out::print);
		System.out.println("\n");
		Arrays.stream(obj.findErrorNums(new int[] { 1, 1 })).forEach(System.out::print);
		System.out.println("\n");
		Arrays.stream(obj.findErrorNums(new int[] { 2, 2 })).forEach(System.out::print);

	}
}

package com.leetcode.dailypractice.year24.may.week3;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/sum-of-all-subset-xor-totals/">
 * Problem-Link</a>
 * 
 * 1863. Sum of All Subset XOR Totals
 * 
 * Easy Topics Companies Hint
 * 
 * The XOR total of an array is defined as the bitwise XOR of all its elements,
 * or 0 if the array is empty.
 * 
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1. Given
 * an array nums, return the sum of all XOR totals for every subset of nums.
 * Note: Subsets with the same elements should be counted multiple times. An
 * array a is a subset of an array b if a can be obtained from b by deleting
 * some (possibly zero) elements of b.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3] Output: 6 Explanation: The 4 subsets of [1,3] are: - The
 * empty subset has an XOR total of 0. - [1] has an XOR total of 1. - [3] has an
 * XOR total of 3. - [1,3] has an XOR total of 1 XOR 3 = 2. 0 + 1 + 3 + 2 = 6
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [5,1,6] Output: 28 Explanation: The 8 subsets of [5,1,6] are: -
 * The empty subset has an XOR total of 0. - [5] has an XOR total of 5. - [1]
 * has an XOR total of 1. - [6] has an XOR total of 6. - [5,1] has an XOR total
 * of 5 XOR 1 = 4. - [5,6] has an XOR total of 5 XOR 6 = 3. - [1,6] has an XOR
 * total of 1 XOR 6 = 7. - [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2. 0 + 5
 * + 1 + 6 + 4 + 3 + 7 + 2 = 28
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [3,4,5,6,7,8] Output: 480
 * 
 * Explanation: The sum of all XOR totals for every subset is 480.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 12 1 <= nums[i] <= 20
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 116K
 * Submissions 135.8K Acceptance Rate 85.4%
 **/
public class SolutionMonday0520 {
	//Mine Solution
    public int subsetXORSum(int[] nums) {
        int len = nums.length;
        int xORSum = 0;
        double totalCombination = Math.pow(2, len);
        for (int i = 0; i < totalCombination; i++) {
            int num = i;
            int ind = 0;
            int xOR = 0;

            while (num > 0) {
                if (num%2 == 1) {
                    xOR ^= nums[ind];
                }
                ind++;
                num = num / 2;
            }

            xORSum += xOR;
        }
        return xORSum;
    }
    
    //Best Solution 2
    public int subsetXORSum2(int[] nums) {
        int len = nums.length;
        int xORSum = 0;
        double totalCombination = Math.pow(2, len);
        for (int i = 0; i < totalCombination; i++) {
            int num = i;
            int ind = 0;
            int xOR = 0;

            while (num > 0) {
                if (num%2 == 1) {
                    xOR ^= nums[ind];
                }
                ind++;
                num = num / 2;
            }

            xORSum += xOR;
        }
        return xORSum;
    }
    
    //Best Solution
    public int subsetXORSum3(int[] nums) {
        return helper(nums , 0 , 0);
    }

    public int helper(int[] nums, int index, int currValue){
        if(index == nums.length) return currValue;

        return helper(nums, index+1, currValue^nums[index]) + helper(nums, index+1, currValue);
    }
	public static void main(String[] arg) {
		var obj = new SolutionMonday0520();
		System.out.println(obj.subsetXORSum(new int[] { 1, 3 }));		
		System.out.println(obj.subsetXORSum(new int[] { 5,1,6 }));
		System.out.println(obj.subsetXORSum(new int[] { 3,4,5,6,7,8 }));
		
	}

}

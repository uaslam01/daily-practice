package com.leetcode.dailypractice.year23.dec.week2;

import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * 1464. Maximum Product of Two Elements in an Array Easy 2.4K 228 Companies
 * Given the array of integers nums, you will choose two different indices i and
 * j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,5,2] Output: 12 Explanation: If you choose the indices i=1
 * and j=2 (indexed from 0), you will get the maximum value, that is,
 * (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. Example 2:
 * 
 * Input: nums = [1,5,4,5] Output: 16 Explanation: Choosing the indices i=1 and
 * j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 * 
 * Input: nums = [3,7] Output: 12
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 500 1 <= nums[i] <= 10^3 Accepted 330.2K Submissions
 * 401.5K Acceptance Rate 82.2% Seen this question in a real interview before?
 * 1/4
 */
public class SolutionTuesday1212 {
	//Mine
	public int maxProduct(int[] nums) {
        int maxInd = nums[0]>nums[1]?nums[0]:nums[1];
        int secMaxInd = nums[0]>nums[1]?nums[1]:nums[0];
        for(int i=2;i<nums.length;i++){
            if(nums[i]>maxInd){
                secMaxInd = maxInd;
                maxInd = nums[i];
            } else if (nums[i]>secMaxInd){
                secMaxInd = nums[i];
            }
        }
        return (maxInd-1)*(secMaxInd-1);
    }
    //Best Solution 1
    public int maxProduct2(int[] nums) {
        int res = 0;
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, (curMax - 1) * (nums[i] - 1));
            curMax = Math.max(curMax, nums[i]);
        }

        return res;        
    }
    //Best Solution 2
    public int maxProduct3(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
    public static void main(String[] args) {
        Consumer cons = System.out::println;
        var obj = new SolutionTuesday1212();
        cons.accept(obj.maxProduct(new int[]{3,7}));
        cons.accept(obj.maxProduct(new int[]{10,2,5,2}));
    }
}
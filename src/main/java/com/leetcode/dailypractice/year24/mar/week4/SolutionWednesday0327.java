package com.leetcode.dailypractice.year24.mar.week4;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">Problem-Link</a>
 * <p>
 * subarray-product-less-than-k
 * <p>
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class SolutionWednesday0327 {
    //Best Solution
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int l = 0;
        int product = 1;

        int count = 0;

        for(int r=0; r<nums.length; r++){
            product *= nums[r];
            while(l<=r && product >= k){
                product /= nums[l];
                l++;
            }

            count += r-l+1;
        }

        return count;

    }
}

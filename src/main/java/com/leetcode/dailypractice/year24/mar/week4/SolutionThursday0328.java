package com.leetcode.dailypractice.year24.mar.week4;

import java.util.HashMap;

/**
 *   <a href=
 *  "https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">Problem-Link</a>
 *
 * Length-of-longest-subarray-with-at-most-k-frequency
 * <p>
 * <p>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * The frequency of an element x is the number of times it occurs in an array.
 * <p>
 * An array is called good if the frequency of each element in this array is less than or equal to k.
 * <p>
 * Return the length of the longest good subarray of nums.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,2,3,1,2], k = 2
 * Output: 6
 * Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
 * It can be shown that there are no good subarrays with length more than 6.
 * <p>
 * <p>
 *  <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,2,1,2,1,2], k = 1
 * Output: 2
 * Explanation: The longest possible good subarray is [1,2] since the values 1 and 2 occur at most once in this subarray. Note that the subarray [2,1] is also good.
 * It can be shown that there are no good subarrays with length more than 2.
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [5,5,5,5,5,5,5], k = 4
 * Output: 4
 * Explanation: The longest possible good subarray is [5,5,5,5] since the value 5 occurs 4 times in this subarray.
 * It can be shown that there are no good subarrays with length more than 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= nums.length
 */
class SolutionThursday0328 {
    public int maxSubarrayLength1(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.get(nums[r]) > k) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> h=new HashMap<>();
        int i=0,j=0,max=0;
        while(i<nums.length){
            h.put(nums[i], h.getOrDefault(nums[i],0)+1);
            while(j<=i&&h.get(nums[i])>k){
                h.put(nums[j], h.get(nums[j])-1);
                j++;
            }
            max=Math.max(max, i++ - j + 1);

        }
        return max;
    }
   
}

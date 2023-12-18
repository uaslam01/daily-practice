package com.leetcode.dailypractice.year23.dec.week3;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/maximum-product-difference-between-two-pairs/">Problem-Link</a>
 * 
 * 1913. Maximum Product Difference Between Two Pairs Easy 1.3K 59 Companies The
 * product difference between two pairs (a, b) and (c, d) is defined as (a * b)
 * - (c * d).
 * 
 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2
 * * 7) = 16. Given an integer array nums, choose four distinct indices w, x, y,
 * and z such that the product difference between pairs (nums[w], nums[x]) and
 * (nums[y], nums[z]) is maximized.
 * 
 * Return the maximum such product difference.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,6,2,7,4] Output: 34 Explanation: We can choose indices 1 and
 * 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
 * The product difference is (6 * 7) - (2 * 4) = 34.
 * 
 * Example 2:
 * 
 * Input: nums = [4,2,5,9,7,4,8] Output: 64 Explanation: We can choose indices 3
 * and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2,
 * 4). The product difference is (9 * 8) - (2 * 4) = 64.
 * 
 * 
 * Constraints:
 * 
 * 4 <= nums.length <= 104 1 <= nums[i] <= 104 Accepted 182.3K Submissions
 * 219.4K Acceptance Rate 83.1%
 */
public class SolutionMonday1218 {
	//Mine
	public int maxProductDifference1(int[] nums) {
		int firstMin = 100001;
		int secMin = 100001;
		int firstMax = -1;
		int secMax =-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>firstMax) {
				secMax = firstMax;
				firstMax = nums[i];
			} else if (nums[i]>secMax) {
				secMax = nums[i];
			}
			if(nums[i]<firstMin) {
				secMin = firstMin;
				firstMin = nums[i];
			} else if (nums[i]<secMin) {
				secMin = nums[i];
			}
		}
		return firstMax*secMax-firstMin*secMin;	
    }

	//Best Solution
    public int maxProductDifference(int[] nums) {
        int firstBig = 0;
        int secondBig = 0;
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = n;
            } else if (n < secondSmall) {
                secondSmall = n;
            }

            if (n > firstBig) {
                secondBig = firstBig;
                firstBig = n;
            } else if (n > secondBig) {
                secondBig = n;
            }
        }

        return firstBig * secondBig - firstSmall * secondSmall;        
    }

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday1218();
		cons.accept(obj.maxProductDifference(new int[] { 5, 6, 2, 7, 4 }));
		cons.accept(obj.maxProductDifference(new int[] { 4, 2, 5, 9, 7, 4, 8 }));
		cons.accept(obj.maxProductDifference(new int[] { 1,6,7,5,2,4,10,6,4 }));

	}
}

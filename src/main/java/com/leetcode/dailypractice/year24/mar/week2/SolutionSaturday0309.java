package com.leetcode.dailypractice.year24.mar.week2;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/minimum-common-value/">Problem-Link</a>
 * 
 * 2540. Minimum Common Value
 * 
 * Easy Topics Companies Hint
 * 
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * return the minimum integer common to both arrays. If there is no common
 * integer amongst nums1 and nums2, return -1.
 * 
 * Note that an integer is said to be common to nums1 and nums2 if both arrays
 * have at least one occurrence of that integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3], nums2 = [2,4]
 * 
 * Output: 2
 * 
 * Explanation: The smallest element common to both arrays is 2, so we return 2.
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * 
 * Output: 2
 * 
 * Explanation: There are two common elements in the array 2 and 3 out of which
 * 2 is the smallest, so 2 is returned.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 105 1 <= nums1[i], nums2[j] <= 109 Both
 * nums1 and nums2 are sorted in non-decreasing order.
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No
 * 
 * Accepted 161.3K Submissions 274.3K Acceptance Rate 58.8%
 */
public class SolutionSaturday0309 {
	//Mine Solution
    public int getCommon1(int[] nums1, int[] nums2) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;    	
    	int ith = 0;
    	int jth = 0;
    	for(int i=0; ith<len1 && jth<len2; i++) {
    		if(nums1[ith]==nums2[jth]) {
    			return nums1[ith];
    		} else if (nums1[ith]<nums2[jth]) {
    			ith++;
    		} else {
    			jth++;
    		}
    	}
    	return -1;
    }
    //Best Solution
    public int getCommon2(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int length1=nums1.length;
        int length2= nums2.length;
        // For faster solution
        if (nums1[length1-1] < nums2[0] || nums2[length2-1] < nums1[0])
            return -1;

        // Two pointer approach
        while (i<length1 && j<length2) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        } return -1;
    }
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0) {
                return nums1[i];
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionSaturday0309();

		cons.accept(obj.getCommon(new int[] { 1, 2, 3}, new int[] { 2, 4 }));
		cons.accept(obj.getCommon(new int[] { 1, 2, 3, 6 }, new int[] { 2, 3, 4, 5 }));
		// Custom Input
		cons.accept(obj.getCommon(new int[] { 4, 5, 6, 7 },new int[] { 1,2 ,3, 4 }));
		cons.accept(obj.getCommon(new int[] { 1, 1, 2 },new int[] { 2,4 }));

	}

}

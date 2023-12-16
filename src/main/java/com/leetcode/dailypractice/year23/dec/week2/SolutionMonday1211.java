package com.leetcode.dailypractice.year23.dec.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <pre>
 * 
 * <a href=
 * "https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/">Problem-Link</a>
 * 
 * 
 * 1287. Element Appearing More Than 25% In Sorted Array 
 * Easy 1.6K 72 Companies
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time, return that
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,2,6,6,6,6,7,10] Output: 6 
 * 
 * Example 2:
 * 
 * Input: arr = [1,1] Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 104 0 <= arr[i] <= 105 Accepted 191.5K Submissions 313K
 * Acceptance Rate 61.2% Seen this question in a real interview before? 1/4
 **/
public class SolutionMonday1211 {
	//Mine
    public int findSpecialInteger1(int[] arr) {
    	int len25Percent = (int) Math.ceil(arr.length/3.99);
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num: arr) {
    		if(map.containsKey(num)) {
    			int count = map.get(num)+1;
    			if(count== len25Percent)
    				return num;
    			map.put(num, count);
    			
    		} else
    			map.put(num, 1);
    	}
        return arr[0];
    }
//    Best Solution
//    Time complexity: O(n−quarter)
//    Space complexity: O(1)
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        for (int i = 0; i < n - quarter; i++) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }

        return -1;
    }
//    Best Solution2
//    Time complexity: O(clogn)
//    n is length of input array
//    c is number of candidates
//    c = (n - qurater) / qurater
//    Space complexity: O(1)
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        // Handle the case where quarter is zero
        if (quarter == 0) {
            return n > 0 ? arr[0] : -1;
        }

        // Check every possible candidate element
        for (int i = quarter; i < n; i += quarter) {
            // Use binary search to find the first and last occurrence of the candidate element
            int leftOccurrence = binarySearch(arr, arr[i], true);
            int rightOccurrence = binarySearch(arr, arr[i], false);

            // Check if the frequency is greater than 25%
            if (rightOccurrence - leftOccurrence + 1 > quarter) {
                return arr[i];
            }
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target, boolean isFirst) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday1211();
		cons.accept(obj.findSpecialInteger(new int[] { 1,2,2,6,6,6,6,7,10}));
		cons.accept(obj.findSpecialInteger(new int[] { 1,1}));
		cons.accept(obj.findSpecialInteger(new int[] { 1,2,3,3}));

	}
}

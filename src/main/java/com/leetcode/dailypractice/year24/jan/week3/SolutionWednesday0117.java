package com.leetcode.dailypractice.year24.jan.week3;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/unique-number-of-occurrences/">Problem-Link</a>
 * 
 * 1207. Unique Number of Occurrences
 * 
 * Easy Topics Companies Hint Given an array of integers arr, return true if the
 * number of occurrences of each value in the array is unique or false
 * otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,2,1,1,3] Output: true
 * 
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two
 * values have the same number of occurrences.
 * 
 * Example 2:
 * 
 * Input: arr = [1,2] Output: false
 * 
 * Example 3:
 * 
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 -1000 <= arr[i] <= 1000 Seen this question in a real
 * interview before? 1/4 Yes No Accepted 490.1K Submissions 641.2K Acceptance
 * Rate 76.4%
 */
public class SolutionWednesday0117 {
	//Mine Solution
    public boolean uniqueOccurrences(int[] arr) {
        short[] mapToTrackRepeatedVals = new short[2000];
        for(var val: arr) {
        	mapToTrackRepeatedVals[val+1000]++;
        }
        Arrays.sort(mapToTrackRepeatedVals);
        
        for(int i=0; i<mapToTrackRepeatedVals.length-1; i++) {
        	if(mapToTrackRepeatedVals[i]!=0 && mapToTrackRepeatedVals[i]==mapToTrackRepeatedVals[i+1])
        		return false;
        }
        return true;
    }
    //Best Solution
    public boolean uniqueOccurrences1(int[] arr) {
        return false;
    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday0117();
		cons.accept(obj.uniqueOccurrences(new int[] { 2,4,6,8,10 }));
		cons.accept(obj.uniqueOccurrences(new int[] {1,2,2,1,1,3 }));
		cons.accept(obj.uniqueOccurrences(new int[] {1,2 }));
		cons.accept(obj.uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0 }));


	}
}

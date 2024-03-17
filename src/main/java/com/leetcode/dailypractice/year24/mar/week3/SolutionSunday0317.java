package com.leetcode.dailypractice.year24.mar.week3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/insert-interval/">Problem-Link</a>
 * 
 * 57. Insert Interval
 * 
 * Medium Topics Companies
 * 
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 
 * Output: [[1,2],[3,10],[12,16]]
 * 
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * 
 * 
 * Constraints:
 * 
 * 0 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
 * 105 intervals is sorted by starti in ascending order. newInterval.length == 2
 * 0 <= start <= end <= 105
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1M
 * Submissions 2.5M Acceptance Rate 41.0%
 */
public class SolutionSunday0317 {
	//Mine Solution
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newtotalIntervals = intervals.length;
     
        for(int i=0;i<newtotalIntervals;i++) {
        	if(newInterval[0] <= intervals[i][1]) {
        		newtotalIntervals--;
        		if(i+1<newtotalIntervals && newInterval[1] < intervals[i+1][0]) {
        			break;
        		}
        	}
        }
        int[][] newIntervals = new int[newtotalIntervals][2];
        for(int i=0;i<newtotalIntervals;i++) {
    		int totalMergeCount = intervals.length-newtotalIntervals+1;
        	if(newInterval[0] <= intervals[i][1]) {
        		if(newInterval[0] <= intervals[i][0]) {
            		newIntervals[i][0]=newInterval[0];
        		} else {
            		newIntervals[i][0]=intervals[i][0];
        		}
        		if(newInterval[1] > intervals[i+totalMergeCount-1][1]) {
            		newIntervals[i][1]=newInterval[1];
        		} else {
            		newIntervals[i][1]=intervals[i+totalMergeCount-1][1];
        		}
        		
        		for(int j=i+totalMergeCount+1; j<intervals.length;j++) {
            		newIntervals[i+1][0]=intervals[j][0];
            		newIntervals[++i][1]=intervals[j][1];	
        		}
        		break;
        	} else {
        		newIntervals[i][0]=intervals[i][0];
        		if(i+1==intervals.length && newInterval[1]>intervals[i][1]) {
            		newIntervals[i][1]=newInterval[1];
        		} else {
            		newIntervals[i][1]=intervals[i][1];
        		}
        	}
        	
        }        
        return newIntervals;
    }
    
    
	public static void main(String[] args) {
		IntConsumer cons = System.out::print;
		Consumer<int[][]> arrConsumer = x -> Arrays.stream(x).forEach(x1->Arrays.stream(x1).forEach(cons));
		
		var obj = new SolutionSunday0317();

		arrConsumer.accept(obj.insert(new int[][] { {1, 3}, {6, 9} }, new int[] {2, 5}));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { {1,2},{3,5},{6,7},{8,10},{12,16} }, new int[] {4, 8}));
		System.out.println();

		// Custom Input
		arrConsumer.accept(obj.insert(new int[][] { {1, 10} }, new int[] {2, 4}));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { {1, 10} }, new int[] {12, 14}));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { {1, 10} }, new int[] {10, 14}));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { {1, 10} }, new int[] {12, 14}));

	}
    
}

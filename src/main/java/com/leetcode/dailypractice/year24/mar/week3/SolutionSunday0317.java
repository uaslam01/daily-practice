package com.leetcode.dailypractice.year24.mar.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	// Mine Solution
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int start = -1;
		int end = -1;
		for (int i = 0; i < intervals.length; i++) {
			if (start == -1 && newInterval[0] <= intervals[i][1]) {
				start = i;
			}
			if (newInterval[1] <= intervals[i][1]) {
				end = i;
				break;
			}
		}
		int[][] newIntervals = new int[intervals.length - end + start+1][2];
		for (int i = 0; i < intervals.length; i++) {
			if (i == start) {
				if (newInterval[0] <= intervals[i][0]) {
					newIntervals[i][0] = newInterval[0];
					newIntervals[i][1] = intervals[i][1];
				} else {
					newIntervals[i][0] = intervals[i][0];
					newIntervals[i][1] = intervals[i][1];
				}
				
			}
			if (i == end) {
				if (newInterval[1] == intervals[i][0]) {
					newIntervals[start][1] = intervals[i][1];
					
				} else if(newInterval[1] < intervals[i][0]){
					newIntervals[i-(end-start)+1][0] = newInterval[1];
					newIntervals[i-(end-start)+1][1] = intervals[i][1];

				} else {
					newIntervals[i-(end-start)+1][0] = intervals[i][0];
					newIntervals[i-(end-start)+1][0] = intervals[i][1];

				}

			}
			
			if(i<start || i>end) {
				newIntervals[i][0] = intervals[i][0];
				newIntervals[i][1] = intervals[i][1];
				
			} else {
				i = i + ( end - start)-1;
			}
			

		}
		return newIntervals;
	}

	// Best Solution
	public int[][] insert1(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int i = 0;

		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval);

		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}

		int[][] arr = new int[result.size()][2];
		for (int j = 0; j < result.size(); j++) {
			arr[j] = result.get(j);
		}

		return arr;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::print;
		Consumer<int[][]> arrConsumer = x -> Arrays.stream(x).forEach(x1 -> Arrays.stream(x1).forEach(cons));

		var obj = new SolutionSunday0317();

		arrConsumer.accept(obj.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
		System.out.println();
		arrConsumer.accept(
				obj.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
		System.out.println();

		// Custom Input
		arrConsumer.accept(obj.insert(new int[][] { { 1, 10 } }, new int[] { 2, 4 }));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { { 1, 10 } }, new int[] { 12, 14 }));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { { 1, 10 } }, new int[] { 10, 14 }));
		System.out.println();
		arrConsumer.accept(obj.insert(new int[][] { { 1, 10 } }, new int[] { 12, 14 }));

	}

}

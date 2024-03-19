package com.leetcode.dailypractice.year24.mar.week3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * *
 * 
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Problem-Link</a>
 * 
 * 452. Minimum Number of Arrows to Burst Balloons
 * 
 * Solved Medium Topics Companies
 * 
 * There are some spherical balloons taped onto a flat wall that represents the
 * XY-plane. The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter
 * stretches between xstart and xend. You do not know the exact y-coordinates of
 * the balloons.
 * 
 * Arrows can be shot up directly vertically (in the positive y-direction) from
 * different points along the x-axis. A balloon with xstart and xend is burst by
 * an arrow shot at x if xstart <= x <= xend. There is no limit to the number of
 * arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting
 * any balloons in its path.
 * 
 * Given the array points, return the minimum number of arrows that must be shot
 * to burst all balloons.
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * 
 * Output: 2
 * 
 * Explanation: The balloons can be burst by 2 arrows: - Shoot an arrow at x =
 * 6, bursting the balloons [2,8] and [1,6]. - Shoot an arrow at x = 11,
 * bursting the balloons [10,16] and [7,12].
 * 
 * Example 2:
 * 
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * 
 * Output: 4
 * 
 * Explanation: One arrow needs to be shot for each balloon for a total of 4
 * arrows.
 * 
 * 
 * Example 3:
 * 
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * 
 * Output: 2
 * 
 * Explanation: The balloons can be burst by 2 arrows: - Shoot an arrow at x =
 * 2, bursting the balloons [1,2] and [2,3]. - Shoot an arrow at x = 4, bursting
 * the balloons [3,4] and [4,5].
 * 
 * 
 * Constraints:
 * 
 * 1 <= points.length <= 105 points[i].length == 2 -231 <= xstart < xend <= 231
 * - 1
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 489.9K
 * Submissions 834.1K Acceptance Rate 58.7%
 */
public class SolutionMonday0318 {

	// Best Solution
	public int findMinArrowShots(int[][] points) {
		// Sort the balloons based on their end coordinates
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		int arrows = 1;
		int prevEnd = points[0][1];

		// Count the number of non-overlapping intervals
		for (int i = 1; i < points.length; ++i) {
			if (points[i][0] > prevEnd) {
				arrows++;
				prevEnd = points[i][1];
			}
		}

		return arrows;
	}
	
	public static void main(String[] args) {
		IntConsumer cons = System.out::print;

		var obj = new SolutionMonday0318();

		cons.accept(obj.findMinArrowShots(new int[][] { {10,16},{2,8},{1,6},{7,12 } }));
		System.out.println();
		cons.accept(obj.findMinArrowShots(new int[][] { { 1,2},{3,4},{5,6},{7,8 } }));
		System.out.println();
		cons.accept(obj.findMinArrowShots(new int[][] { { 1,2},{2,3},{3,4},{4,5} }));
		System.out.println();

		// Custom Input
		cons.accept(obj.findMinArrowShots(new int[][] { { 1,2},{2,3},{3,4},{4,5} }));
		System.out.println();

	}
}

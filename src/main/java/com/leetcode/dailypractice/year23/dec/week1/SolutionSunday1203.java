package com.leetcode.dailypractice.year23.dec.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/minimum-time-visiting-all-points/">Problem-Link</a>
 * 
 * 1266. Minimum Time Visiting All Points 
 * Easy 2.1K 215 Companies 
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the
 * minimum time in seconds to visit all the points in the order given by points.
 * 
 * You can move according to these rules:
 * 
 * In 1 second, you can either: move vertically by one unit, move horizontally
 * by one unit, or move diagonally sqrt(2) units (in other words, move one unit
 * vertically then one unit horizontally in 1 second). You have to visit the
 * points in the same order as they appear in the array. You are allowed to pass
 * through points that appear later in the order, but these do not count as
 * visits.
 * 
 * 
 * Example 1:
 * <p>
 * <img src="1626_example_1.png" width="80%"/>
 * Input: points = [[1,1],[3,4],[-1,0]] Output: 7 
 * 
 * Explanation: One optimal path
 * is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0] Time
 * from [1,1] to [3,4] = 3 seconds Time from [3,4] to [-1,0] = 4 seconds Total
 * time = 7 seconds Example 2:
 * 
 * Input: points = [[3,2],[-2,2]] Output: 5
 * 
 * 
 * Constraints:
 * 
 * points.length == n 1 <= n <= 100 points[i].length == 2 -1000 <= points[i][0],
 * points[i][1] <= 1000 Accepted 218K Submissions 264.2K Acceptance Rate 82.5%
 */
public class SolutionSunday1203 {
	// Mine
	public int minTimeToVisitAllPoints1(int[][] points) {
		return 0;
	}

	// Best Solution 1
	public int minTimeToVisitAllPoints(int[][] points) {
		int res = 0;

		for (int i = 1; i < points.length; i++) {
			res += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
		}

		return res;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionSunday1203();
		cons.accept(obj.minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
		cons.accept(obj.minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
	}
}

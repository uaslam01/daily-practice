package com.leetcode.dailypractice.year24.jan.week5;

import java.util.Arrays;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/daily-temperatures/">Problem-Link</a>
 * 
 * 
 * 739. Daily Temperatures
 * 
 * 
 * Medium Topics Companies Hint
 * 
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * 
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * 
 * Example 2:
 * 
 * Input: temperatures = [30,40,50,60]
 * 
 * Output: [1,1,1,0]
 * 
 * 
 * Example 3:
 * 
 * Input: temperatures = [30,60,90]
 * 
 * Output: [1,1,0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= temperatures.length <= 105 30 <= temperatures[i] <= 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 835.9K
 * Submissions 1.3M Acceptance Rate 66.0%
 */
public class SolutionWednesday0131 {
	// Mine Solution
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Arrays.fill(res, Integer.MIN_VALUE);
		for (int i = temperatures.length-1; i >= 0; i--) {
			res[i] = getHigherThan(res, temperatures, i+1, temperatures[i], 0);
		}
		return res;
	}

	int getHigherThan(int[] res, int[] arr, int start, int val, int count) {
		if (start == arr.length)
			return 0;
		if (res[start] != Integer.MIN_VALUE)
			return res[start];

		if(arr[start]> val) {
			res[start] = ++count;
			return count;
		} else {
			return getHigherThan(res, arr, start+1, val, count);
		}
	}

	public static void main(String[] args) {
		var obj = new SolutionWednesday0131();

		Arrays.stream(obj.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })).forEach(System.out::println);
		System.out.println("----");
		Arrays.stream(obj.dailyTemperatures(new int[] { 30, 40, 50, 60 })).forEach(System.out::println);
		System.out.println("----");
		Arrays.stream(obj.dailyTemperatures(new int[] { 30, 60, 90 })).forEach(System.out::println);
		System.out.println("----");

	}
}
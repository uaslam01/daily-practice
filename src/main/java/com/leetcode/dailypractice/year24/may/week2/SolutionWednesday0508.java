package com.leetcode.dailypractice.year24.may.week2;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/relative-ranks/"> Problem-Link</a>
 * 
 * 506. Relative Ranks
 * 
 * Easy Topics Companies
 * 
 * You are given an integer array score of size n, where score[i] is the score
 * of the ith athlete in a competition. All the scores are guaranteed to be
 * unique. The athletes are placed based on their scores, where the 1st place
 * athlete has the highest score, the 2nd place athlete has the 2nd highest
 * score, and so on. The placement of each athlete determines their rank:
 * 
 * The 1st place athlete's rank is "Gold Medal". The 2nd place athlete's rank is
 * "Silver Medal". The 3rd place athlete's rank is "Bronze Medal". For the 4th
 * place to the nth place athlete, their rank is their placement number (i.e.,
 * the xth place athlete's rank is "x"). Return an array answer of size n where
 * answer[i] is the rank of the ith athlete.
 * 
 * 
 * Example 1:
 * 
 * Input: score = [5,4,3,2,1] 
 * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"] 

 * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 * 
 * 
 * Example 2:
 * 
 * Input: score = [10,3,8,9,4] 
 * 
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"] 
 * 
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 * 
 * 
 * 
 * Constraints:
 * 
 * n == score.length 1 <= n <= 104 0 <= score[i] <= 106 All the values in score
 * are unique.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 230.3K
 * Submissions 333.6K Acceptance Rate 69.0%
 **/

public class SolutionWednesday0508 {
	// Mine Solution/Best Solution 1
	public String[] findRelativeRanks(int[] score) {
    	String[] ranks = new String[score.length];
    	return null;
    }

	// Best Solution 1
	public String[] findRelativeRanks1(int[] score) {
		int n = score.length;
		int[][] sortedPairs = new int[n][2];
		for (int i = 0; i < n; i++)
			sortedPairs[i] = new int[] { i, score[i] };
		Arrays.sort(sortedPairs, (x, y) -> (y[1] - x[1]));
		String[] ans = new String[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				ans[sortedPairs[i][0]] = "Gold Medal";
			} else if (i == 1) {
				ans[sortedPairs[i][0]] = "Silver Medal";
			} else if (i == 2) {
				ans[sortedPairs[i][0]] = "Bronze Medal";
			} else {
				ans[sortedPairs[i][0]] = String.valueOf(i + 1);
			}
		}
		return ans;
	}

	// Best Solution 2
	public String[] findRelativeRanks2(int[] score) {

		int n = score.length;

		int maxScore = 0;
		for (int i = 0; i < n; i++) {
			maxScore = Math.max(maxScore, score[i]);
		}

		int[] score2Index = new int[maxScore + 1];

		for (int i = 0; i < n; i++) {
			score2Index[score[i]] = i + 1;
		}

		String[] ans = new String[n];

		int place = 1;

		for (int i = maxScore; i >= 0; i--) {

			if (score2Index[i] == 0)
				continue;

			int actualIndex = score2Index[i] - 1;
			if (place == 1) {
				ans[actualIndex] = "Gold Medal";
			} else if (place == 2) {
				ans[actualIndex] = "Silver Medal";
			} else if (place == 3) {
				ans[actualIndex] = "Bronze Medal";
			} else {
				ans[actualIndex] = String.valueOf(place);
			}
			place++;
		}

		return ans;
	}

	public static void main(String[] arg) {
		var obj = new SolutionWednesday0508();
		Consumer<String> cons = System.out::println;
		Consumer<String[]> arrConsumer = x -> Arrays.stream(x).forEach(cons);
		arrConsumer.accept(obj.findRelativeRanks1(new int[] {5,4,3,2,1}));
		System.out.println("---");
		arrConsumer.accept(obj.findRelativeRanks1(new int[] { 10,3,8,9,4}));
		System.out.println("---");

		//Customer Input
		arrConsumer.accept(obj.findRelativeRanks1(new int[] { 1, 2, 3 }));
		System.out.println("---");

		
		
	}
}

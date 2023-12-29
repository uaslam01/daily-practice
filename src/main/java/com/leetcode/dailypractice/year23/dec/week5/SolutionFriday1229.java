package com.leetcode.dailypractice.year23.dec.week5;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">Problem-Link</a>
 * 
 * 1335. Minimum Difficulty of a Job Schedule Hard 3.1K 284 Companies
 * 
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To
 * work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * 
 * You have to finish at least one task every day. The difficulty of a job
 * schedule is the sum of difficulties of each day of the d days. The difficulty
 * of a day is the maximum difficulty of a job done on that day.
 * 
 * You are given an integer array jobDifficulty and an integer d. The difficulty
 * of the ith job is jobDifficulty[i].
 * 
 * Return the minimum difficulty of a job schedule. If you cannot find a
 * schedule for the jobs return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="img.png" width="80%"/>
 * 
 * 
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2 Output: 7
 * 
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * 
 * The difficulty of the schedule = 6 + 1 = 7
 * 
 * Example 2:
 * 
 * Input: jobDifficulty = [9,9,9], d = 4 Output: -1
 * 
 * Explanation: If you finish a job per day you will still have a free day. you
 * cannot find a schedule for the given jobs.
 * 
 * Example 3:
 * 
 * Input: jobDifficulty = [1,1,1], d = 3 Output: 3
 * 
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 * 
 * 
 * Constraints:
 * 
 * 1 <= jobDifficulty.length <= 300 0 <= jobDifficulty[i] <= 1000 1 <= d <= 10
 * Accepted 160K Submissions 270.1K Acceptance Rate 59.2% Seen this question in
 * a real interview before? 1/4
 */
public class SolutionFriday1229 {
	public int minDifficulty(int[] jobDifficulty, int d) {
		if (d > jobDifficulty.length)
			return -1;
		else if (d == jobDifficulty.length)
			return Arrays.stream(jobDifficulty).sum();
		if (jobDifficulty[0] == jobDifficulty[jobDifficulty.length - 1])
			return d * jobDifficulty[0];
		int totalMinDifficulty = 0;
		int startInd = 0;
		int endInd = jobDifficulty.length - 1;

		// Extra tasks left if we divide them per day
		int extraTasks = jobDifficulty.length - d;
		int j = startInd + 1;
		int effort = jobDifficulty[startInd] >= jobDifficulty[j] ? jobDifficulty[startInd] : 0;
		while (true) {
			while (extraTasks > 0 && jobDifficulty[startInd] >= jobDifficulty[j]) {
				j++;
				extraTasks--;
			}
			if (extraTasks == 0) {
				startInd = j;
				totalMinDifficulty += effort;
				break;
			}
			if (jobDifficulty[j] >= (jobDifficulty[endInd - 1] + jobDifficulty[endInd])) {
				effort += jobDifficulty[j];
				extraTasks--;
			} else {
				if (jobDifficulty[endInd] >= jobDifficulty[endInd - 1]) {
					effort += jobDifficulty[endInd--];
				} else {
					effort += jobDifficulty[--endInd];
				}
			}
			startInd = j;
			j = startInd + 1;
		}
		for (; startInd <= endInd; startInd++) {
			totalMinDifficulty += jobDifficulty[startInd];
		}
		return totalMinDifficulty;
	}

	public static void main(String[] args) {
		Consumer<Integer> cons = System.out::println;
		var obj = new SolutionFriday1229();
		cons.accept(obj.minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
		cons.accept(obj.minDifficulty(new int[] { 9, 9, 9 }, 4));
		cons.accept(obj.minDifficulty(new int[] { 1, 1, 1 }, 3));
		cons.accept(obj.minDifficulty(new int[] { 7, 1, 7, 1, 7, 1 }, 3));
		cons.accept(obj.minDifficulty(new int[] {11,111,22,222,33,333,44,444 }, 6));

		
	}
}

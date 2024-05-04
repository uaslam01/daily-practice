package com.leetcode.dailypractice.year24.may.week1;

import java.util.Arrays;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/boats-to-save-people/">
 * Problem-Link</a>
 *
 * 
 * 881. Boats to Save People Medium Topics Companies
 * 
 * You are given an array people where people[i] is the weight of the ith
 * person, and an infinite number of boats where each boat can carry a maximum
 * weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * 
 * Return the minimum number of boats to carry every given person.
 * 
 * 
 * Example 1:
 * 
 * Input: people = [1,2], limit = 3 Output: 1 Explanation: 1 boat (1, 2)
 * 
 * 
 * Example 2:
 * 
 * Input: people = [3,2,2,1], limit = 3 Output: 3 Explanation: 3 boats (1, 2),
 * (2) and (3)
 * 
 * 
 * Example 3:
 * 
 * Input: people = [3,5,3,4], limit = 5 Output: 4 Explanation: 4 boats (3), (3),
 * (4), (5)
 * 
 * 
 * Constraints:
 * 
 * 1 <= people.length <= 5 * 104 1 <= people[i] <= limit <= 3 * 104 Seen this
 * question in a real interview before? 1/5 Yes No Accepted 373.3K Submissions
 * 634.7K Acceptance Rate 58.8%
 **/

public class SolutionSaturday0504 {
	// Mine Solution/Best Solution
	public int numRescueBoats1(int[] people, int limit) {
		if (people.length == 1)
			return 1;
		Arrays.sort(people);
		if (people[0] + people[1] > limit)
			return people.length;
		int leftInd = 0;
		int rightInd = people.length - 1;
		int counter = 0;
		while (leftInd <= rightInd) {
			if (people[leftInd] + people[rightInd] <= limit) {
				leftInd++;
			}
			rightInd--;
			counter++;
		}

		return counter;
	}

	// Best Solution2
	// optimized
	// TC: O(n)
	// SC: O(n)
	public int numRescueBoats(int[] people, int limit) {

		int[] buckets = new int[limit + 1];
		for (int weight : people) {
			buckets[weight]++;
		}

		int start = 0;
		int end = buckets.length - 1;
		int boats = 0;
		while (start <= end) {
			while (start <= end && buckets[start] <= 0)
				start++;
			while (start <= end && buckets[end] <= 0)
				end--;

			if (buckets[start] <= 0 && buckets[end] <= 0)
				break;

			boats++;
			if (start + end <= limit) {
				buckets[start]--;
			}
			buckets[end]--;
		}
		return boats;
	}

	public static void main(String[] arg) {
		var obj = new SolutionSaturday0504();
		System.out.println(obj.numRescueBoats(new int[] { 1, 2 }, 3));
		System.out.println(obj.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3));
		System.out.println(obj.numRescueBoats(new int[] { 3, 5, 3, 4 }, 5));

		// Customer Input
		System.out.println(obj.numRescueBoats(new int[] { 5, 5, 5, 5 }, 5));
		System.out.println(obj.numRescueBoats(new int[] { 2, 3, 4, 5 }, 5));

	}
}

package com.leetcode.dailypractice.year24.feb.week3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * *
 * 
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/furthest-building-you-can-reach/">Problem-Link</a>
 * 
 * 1642. Furthest Building You Can Reach
 * 
 * 
 * Medium Topics Companies Hint
 * 
 * 
 * You are given an integer array heights representing the heights of buildings,
 * some bricks, and some ladders.
 * 
 * 
 * You start your journey from building 0 and move to the next building by
 * possibly using bricks or ladders.
 * 
 * 
 * While moving from building i to building i+1 (0-indexed),
 * 
 * 
 * If the current building's height is greater than or equal to the next
 * building's height, you do not need a ladder or bricks. If the current
 * building's height is less than the next building's height, you can either use
 * one ladder or (h[i+1] - h[i]) bricks. Return the furthest building index
 * (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 
 * Output: 4
 * 
 * 
 * Explanation: Starting at building 0, you can follow these steps: - Go to
 * building 1 without using ladders nor bricks since 4 >= 2. - Go to building 2
 * using 5 bricks. You must use either bricks or ladders because 2 < 7. - Go to
 * building 3 without using ladders nor bricks since 7 >= 6. - Go to building 4
 * using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more
 * bricks or ladders.
 * 
 * 
 * Example 2:
 * 
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 
 * Output: 7
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * 
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= heights.length <= 105 1 <= heights[i] <= 106 0 <= bricks <= 109 0 <=
 * ladders <= heights.length
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 147K
 * Submissions 299.9K Acceptance Rate 49.0%
 */
public class SolutionSaturday0217 {
	// Mine Solution
	public int furthestBuilding1(int[] heights, int bricks, int ladders) {
		int[] diffHeights = new int[heights.length - 1];
		int count = 0;
		int start = 0;
		int end = heights.length - 1;
		for (int i = 0; i < end; i++) {
			if (heights[i + 1] - heights[i] < 0)
				diffHeights[i] = 0;
			else
				diffHeights[i] = heights[i + 1] - heights[i];
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		while (bricks >= 0 && start != end) {
			bricks -= diffHeights[start];
			if (bricks >= 0) {
				queue.add(diffHeights[start]);
				count++;
			} else {
				if (ladders > 0) {
					if (!queue.isEmpty() && queue.peek() >= diffHeights[start]) {
						bricks += queue.poll();
					} else {
						bricks += diffHeights[start];
					}
					count++;
					ladders--;
				}
			}
			start++;

		}
		return count;
	}

	// Best Solution 1
	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		int i;
		int diff = 0;

		for (i = 0; i < heights.length - 1; i++) {

			diff = heights[i + 1] - heights[i];

			if (diff <= 0) {
				continue;
			}

			bricks -= diff;
			pq.offer(diff);

			if (bricks < 0) {
				bricks += pq.poll();
				ladders--;
			}

			if (ladders < 0)
				break;
		}

		return i;
	}

	// Best Solution 2
	public int furthestBuilding2(int[] heights, int bricks, int ladders) {

		int len = heights.length;
		int maxBricksNeeded = 0;
		for (int i = 1; i < len; i++)
			if (heights[i] > heights[i - 1])
				maxBricksNeeded += heights[i] - heights[i - 1];
		if (bricks >= maxBricksNeeded)
			return len - 1;

		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
			return i2 - i1;
		});
		int max = 0;
		for (int i = max; i < len; i++) {
			max = i;
			if (i < len - 1 && heights[i + 1] > heights[i]) {
				int needed = heights[i + 1] - heights[i];
				if (bricks < needed) {
					if (ladders > 0) {
						if (!pq.isEmpty()) {
							int height = pq.peek();
							if (height > needed) {
								pq.poll();
								bricks += height - needed;
								pq.offer(needed);
							}
						}
						ladders--;
					} else
						break;
				} else {
					bricks -= needed;
					pq.offer(needed);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionSaturday0217();

		// Runtime Error
		// 1,13,1,1,13,5,11,11
		cons.accept(obj.furthestBuilding(new int[] { 1, 13, 1, 1, 13, 5, 11, 11 }, 10, 8));

		cons.accept(obj.furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1));
		cons.accept(obj.furthestBuilding(new int[] { 4, 12, 2, 7, 3, 18, 20, 3, 19 }, 10, 2));
		cons.accept(obj.furthestBuilding(new int[] { 14, 3, 19, 3 }, 17, 0));

	}

}
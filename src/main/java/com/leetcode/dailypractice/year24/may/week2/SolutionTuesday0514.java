package com.leetcode.dailypractice.year24.may.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/path-with-maximum-gold/">
 * Problem-Link</a>
 * 
 * 1219. Path with Maximum Gold
 * 
 * Medium Topics Companies Hint
 * 
 * In a gold mine grid of size m x n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty. Return the
 * maximum amount of gold you can collect under the conditions:
 * 
 * Every time you are located in a cell you will collect all the gold in that
 * cell. From your position, you can walk one step to the left, right, up, or
 * down. You can't visit the same cell more than once. Never visit a cell with 0
 * gold. You can start and stop collecting gold from any position in the grid
 * that has some gold.
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 
 * Output: 24
 * 
 * Explanation:
 * 
 * <code>
* [[0,6,0],
* [5,8,7], 
* [0,9,0]] 
 </code>
 * 
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * 
 * Example 2:
 * 
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 
 * Output: 28
 * 
 * Explanation: <code>
  [[1,0,7],
  [2,0,6],
  [3,4,5],
  [0,3,0], 
  [9,0,20]] 
 </code>
 * 
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 15 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 138.9K
 * Submissions 213.1K Acceptance Rate 65.2%
 **/

public class SolutionTuesday0514 {
	private class Node {
		public int val;
		public String key;
		public boolean isVisited;
		public List<Node> adjNodes = new ArrayList<>();

		public Node(String key, int val) {
			this.key = key;
			this.val = val;
		}

	}

	// Mine Solution /Best Solution 1
	public int getMaximumGold(int[][] grid) {
		maxScore = 0;
		Map<String, Node> map = new HashMap<>();
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] != 0) {
					Node temp = null;
					if (map.containsKey(i + "" + j)) {
						temp = map.get(i + "" + j);

					} else
						temp = new Node(i + "" + j, grid[i][j]);
					if (i - 1 >= 0 && grid[i - 1][j] > 0) {
						if (map.containsKey((i - 1) + "" + j)) {
							Node node = map.get((i - 1) + "" + j);
							temp.adjNodes.add(node);
						} else {
							Node node = new Node((i-1) + "" + j, grid[i-1][j]);
							temp.adjNodes.add(node);
							map.put((i-1) + "" + j, node);
						}
					}
					if (j - 1 >= 0 && grid[i][j-1] > 0) {
						if (map.containsKey(i + "" + (j - 1))) {
							Node node = map.get(i + "" + (j - 1));
							temp.adjNodes.add(node);
						} else {
							Node node = new Node(i + "" + (j - 1), grid[i][j-1]);
							temp.adjNodes.add(node);
							map.put(i + "" + (j - 1), node);
						}
					}
					if (i + 1 < rows && grid[i + 1][j] > 0) {
						if (map.containsKey((i+ 1) + "" + j)) {
							Node node = map.get((i + 1) + "" + j);
							temp.adjNodes.add(node);
						} else {
							Node node = new Node((i+1) + "" + j, grid[i+1][j]);
							temp.adjNodes.add(node);
							map.put((i+1) + "" + j, node);
						}
					}
					if (j + 1 < cols && grid[i][j+1] > 0) {
						if (map.containsKey(i + "" + (j + 1))) {
							Node node = map.get(i + "" + (j + 1));
							temp.adjNodes.add(node);
						} else {
							Node node = new Node(i + "" + (j + 1), grid[i][j+1]);
							temp.adjNodes.add(node);
							map.put(i + "" + (j + 1), node);
						}
					}
					map.put(i + "" + j, temp);
				}
			}

		}
		for (var node : map.values()) {
			getTotalGoldByDFS(node, map);

		}
		return maxScore;
	}

	private int getTotalGoldByDFS(Node temp, Map<String, Node> map) {
		temp.isVisited = true;
		List<Node> list = temp.adjNodes;
		int score = 0;
		if (list == null)
			return temp.val;
		for (Node node : list) {
			if (!node.isVisited) {
				score = Math.max(score, getTotalGoldByDFS(node, map));

			}
		}
		score += temp.val;
		if (score > maxScore)
			maxScore = score;
		return score;
	}

	static int maxScore = 0;

	public int max = 0;

	public void ways(int[][] grid, int r, int c, int gold) {
		if (gold > max) {
			max = gold;
		}
		if (grid[r][c] == 0) {
			return;
		}
		int a = grid[r][c];
		grid[r][c] = 0;
		if (r - 1 >= 0) {
			ways(grid, r - 1, c, gold + a);
		}
		if (r + 1 <= grid.length - 1) {
			ways(grid, r + 1, c, gold + a);
		}
		if (c + 1 <= grid[0].length - 1) {
			ways(grid, r, c + 1, gold + a);
		}
		if (c - 1 >= 0) {
			ways(grid, r, c - 1, gold + a);
		}
		grid[r][c] = a;
		return;

	}

	public int gridWithNoZeros(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					return -1;
				} else
					count += grid[i][j];
			}
		}
		return count;
	}

	// Best Solution 2
	public int getMaximumGold2(int[][] grid) {

		int count = gridWithNoZeros(grid);
		if (count != -1)
			return count;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				ways(grid, i, j, 0);
			}
		}
		return max;
	}

	public static void main(String[] arg) {
		var obj = new SolutionTuesday0514();

		System.out.println(obj.getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));
		System.out.println(obj.getMaximumGold(new int[][] { { 1,0,7}, {2,0,6}, {3,4,5}, {0,3,0}, {9,0,20 } }));

		// Customer Input
		//System.out.println(obj.getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));

	}
}

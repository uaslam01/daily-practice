package com.leetcode.dailypractice.year24.feb.week2;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/cherry-pickup-ii/">Problem-Link</a>
 *
 * 1463. Cherry Pickup II
 * 
 * Hard Topics Companies Hint
 * 
 * You are given a rows x cols matrix grid representing a field of cherries
 * where grid[i][j] represents the number of cherries that you can collect from
 * the (i, j) cell.
 * 
 * 
 * You have two robots that can collect cherries for you:
 * 
 * Robot #1 is located at the top-left corner (0, 0), and
 * 
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * 
 * Return the maximum number of cherries collection using both robots by
 * following the rules below:
 * 
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i
 * + 1, j + 1).
 * 
 * When any robot passes through a cell, It picks up all cherries, and the cell
 * becomes an empty cell.
 * 
 * When both robots stay in the same cell, only one takes the cherries.
 * 
 * Both robots cannot move outside of the grid at any moment.
 * 
 * Both robots should reach the bottom row in grid.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="sample_1_1802.png" width="80%"/>
 * 
 * 
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * 
 * Output: 24
 * 
 * Explanation: Path of robot #1 and #2 are described in color green and blue
 * respectively.
 * 
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12. Cherries taken by Robot #2,
 * (1 + 5 + 5 + 1) = 12.
 * 
 * Total of cherries: 12 + 12 = 24.
 * 
 * 
 * Example 2:
 * 
 * <img src="sample_2_1802.png" width="80%"/>
 * 
 * Input: grid =
 * [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * 
 * Output: 28
 * 
 * Explanation: Path of robot #1 and #2 are described in color green and blue
 * respectively.
 * 
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17. Cherries taken by Robot #2,
 * (1 + 3 + 4 + 3) = 11.
 * 
 * Total of cherries: 17 + 11 = 28.
 * 
 * 
 * Constraints:
 * 
 * rows == grid.length cols == grid[i].length 2 <= rows, cols <= 70 0 <=
 * grid[i][j] <= 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 137.5K
 * Submissions 192.3K Acceptance Rate 71.5%
 *
 */
public class SolutionSunday0211 {
	// Best Solution
	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		Integer[][][] dp = new Integer[n][m][m];

		return dfs(grid, n, m, 0, 0, m - 1, dp);
	}

	private int dfs(int[][] grid, int n, int m, int r, int col1, int col2, Integer[][][] dp) {
		if (r < 0 || r >= n || col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
			return 0;
		}

		if (dp[r][col1][col2] != null) {
			return dp[r][col1][col2];
		}

		int maxCherries = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int newCol1 = col1 + i;
				int newCol2 = col2 + j;

				maxCherries = Math.max(maxCherries, dfs(grid, n, m, r + 1, newCol1, newCol2, dp));
			}
		}

		int currCherry = 0;
		if (col1 == col2) {
			currCherry = grid[r][col1];
		} else {
			currCherry = grid[r][col1] + grid[r][col2];
		}

		dp[r][col1][col2] = currCherry + maxCherries;
		return dp[r][col1][col2];
	}

	// Best Solution2
	public int cherryPickup2(int[][] grid) {
		int C = grid[0].length;
		int[][] dp = new int[C][C], old = new int[C][C];
		for (int r = grid.length - 1; r >= 0; r--) {
			for (int c1 = Math.min(r, C - 1); c1 >= 0; c1--) {
				for (int c2 = Math.max(c1, C - 1 - r); c2 < C; c2++) {
					int max = 0;
					for (int i = c1 - 1; i <= c1 + 1; i++) {
						for (int j = c2 - 1; j <= c2 + 1; j++) {
							if (i >= 0 && i < C && j >= 0 && j < C && i <= j)
								max = Math.max(max, old[i][j]);
						}
					}
					dp[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
				}
			}
			int[][] temp = dp;
			dp = old;
			old = temp;
		}
		return old[0][C - 1];
	}

}

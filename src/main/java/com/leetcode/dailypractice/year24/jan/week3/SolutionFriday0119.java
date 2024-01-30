package com.leetcode.dailypractice.year24.jan.week3;

import java.util.Arrays;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/minimum-falling-path-sum/">Problem-Link</a>
 * 
 * 
 * 
 * 931. Minimum Falling Path Sum
 * 
 * Medium Topics Companies
 * 
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="failing1-grid.jpg" width="50%" height="30%"/>
 * 
 * 
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 
 * Output: 13
 * 
 * Explanation: There are two falling paths with a minimum sum as shown.
 * 
 * 
 * Example 2:
 * 
 * <img src="failing2-grid.jpg" width="30%" height="30%"/>
 * 
 * Input: matrix = [[-19,57],[-40,-5]]
 * 
 * Output: -59
 * 
 * Explanation: The falling path with a minimum sum is shown.
 * 
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length 1 <= n <= 100 -100 <= matrix[i][j] <=
 * 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 400.9K
 * Submissions 617.7K Acceptance Rate 64.9%
 */
public class SolutionFriday0119 {
	public int minFallingPathSum(int[][] A) {
		int[][] mem = new int[A.length][A[0].length];
		Arrays.fill(mem, Integer.MAX_VALUE);
		dpSolution(A, mem, A.length-1, 0);
		return 0;
	} 
	int dpSolution(int[][] A, int[][] mem, int rowInd, int colInd)
	{
		if(rowInd==-1|| colInd==-1 || colInd>= A[0].length)
			return Integer.MIN_VALUE;
		if(mem[rowInd][colInd]!=Integer.MAX_VALUE)
			return mem[rowInd][colInd];
		return 0;
	}

	// Best Solution
	public int minFallingPathSum1(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		if (m == 1 || n == 1)
			return A[0][0];

		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; ++i) {
			ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
		}

		return ans;
	}

	private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
		int m = A.length;
		int n = A[0].length;

		if (dp[row][col] != Integer.MAX_VALUE)
			return dp[row][col];

		if (row == m - 1)
			return dp[row][col] = A[row][col];

		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

		if (col > 0)
			left = minFallingPathSum(A, row + 1, col - 1, dp);

		int straight = minFallingPathSum(A, row + 1, col, dp);

		if (col < n - 1)
			right = minFallingPathSum(A, row + 1, col + 1, dp);

		dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

		return dp[row][col];
	}
	public static void main(String[] args) {
		var obj = new SolutionFriday0119();
		System.out.println(obj.minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}}));
		System.out.println(obj.minFallingPathSum(new int[][] {{-19,57},{-40,-5}}));

	}
}

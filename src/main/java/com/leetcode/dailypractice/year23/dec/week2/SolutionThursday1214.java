package com.leetcode.dailypractice.year23.dec.week2;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * 
 * <a href=
 * "https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Problem-Link</a>
 * 
 * 2482. Difference Between Ones and Zeros in Row and Column Medium 830 53
 * Companies
 * 
 * You are given a 0-indexed m x n binary matrix grid.
 * 
 * A 0-indexed m x n difference matrix diff is created with the following
 * procedure:
 * 
 * Let the number of ones in the ith row be onesRowi. Let the number of ones in
 * the jth column be onesColj. Let the number of zeros in the ith row be
 * zerosRowi. Let the number of zeros in the jth column be zerosColj. diff[i][j]
 * = onesRowi + onesColj - zerosRowi - zerosColj Return the difference matrix
 * diff.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="image-20221106171729-5.png" width="80%"/> Input: grid =
 * [[0,1,1],[1,0,1],[0,0,1]] Output: [[0,0,4],[0,0,4],[-2,-2,2]] Explanation: -
 * diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 =
 * 0 - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0
 * = 4 - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 -
 * 2 = 0 - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1
 * - 2 = 0 - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 -
 * 1 - 0 = 4 - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1
 * - 2 - 2 = -2 - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 +
 * 1 - 2 - 2 = -2 - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1
 * + 3 - 2 - 0 = 2 Example 2:
 * 
 * <img src="image-20221106171747-6.png" width="80%"/>
 * 
 * 
 * Input: grid = [[1,1,1],[1,1,1]] Output: [[5,5,5],[5,5,5]] Explanation: -
 * diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 =
 * 5 - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0
 * = 5 - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 -
 * 0 = 5 - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0
 * - 0 = 5 - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 -
 * 0 - 0 = 5
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 105 1 <= m * n <= 105
 * grid[i][j] is either 0 or 1. Accepted 74.3K Submissions 88K Acceptance Rate
 * 84.5%
 */
public class SolutionThursday1214 {
	// Mine
	public int[][] onesMinusZeros1(int[][] grid) {
		var res = new int[grid.length][grid[0].length];
		int[] colArrOfZeros = new int[grid[0].length];
		int[] rowArrOfDiff = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			int zerosCount = 0;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					zerosCount++;
					colArrOfZeros[j]++;
				}
			}
			rowArrOfDiff[i] = grid[i].length - 2 * zerosCount;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// no of ones for ith row = total cols of ith row - no of zeros of ith row
				// and similarly no of ones for ith col = total rows of ith col - no of zeros of
				// ith col
				res[i][j] = rowArrOfDiff[i] + (grid.length - colArrOfZeros[j]) - colArrOfZeros[j];
			}
		}

		return res;
	}

	// Mine previous
	public int[][] onesMinusZeros2(int[][] grid) {
		var res = new int[grid.length][grid[0].length];
		int[] colArrOfZeros = new int[grid[0].length];
		int[] rowArrOfZeros = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			int zerosCount = 0;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					zerosCount++;
					colArrOfZeros[j]++;
				}
			}
			rowArrOfZeros[i] = zerosCount;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// no of ones for ith row = total cols of ith row - no of zeros of ith row
				// and similarly no of ones for ith col = total rows of ith col - no of zeros of
				// ith col
				res[i][j] = (grid[i].length - rowArrOfZeros[i]) - rowArrOfZeros[i] + (grid.length - colArrOfZeros[j])
						- colArrOfZeros[j];
			}
		}

		return res;
	}

	// Mine 3
	public int[][] onesMinusZeros3(int[][] grid) {
		int[] colArrOfOnes = new int[grid[0].length];
		int[] rowArrOfOnes = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				colArrOfOnes[j] += grid[i][j];
				rowArrOfOnes[i] += grid[i][j];
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 2 * (colArrOfOnes[j] + rowArrOfOnes[i]) - (grid[0].length + grid.length);
			}
		}

		return grid;
	}

	// Best Solution
	public int[][] onesMinusZeros(int[][] grid) {
		int[] rowOnes = new int[grid.length];
		int[] colOnes = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				rowOnes[i] += grid[i][j];
				colOnes[j] += grid[i][j];
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = 2 * (rowOnes[i] + colOnes[j]) - grid.length - grid[0].length;
			}
		}

		return grid;
	}

	public static void main(String[] args) {
		Consumer cons = i -> Arrays.stream((int[][]) i)
				.forEach(j -> Arrays.stream((int[]) j).forEach(System.out::print));
		var obj = new SolutionThursday1214();
		cons.accept(obj.onesMinusZeros(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 } }));
		cons.accept(obj.onesMinusZeros(new int[][] { { 1, 1, 1 }, { 1, 1, 1 } }));
	}
}

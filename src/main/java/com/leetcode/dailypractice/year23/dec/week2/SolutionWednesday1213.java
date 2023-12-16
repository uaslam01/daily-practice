package com.leetcode.dailypractice.year23.dec.week2;

import java.util.function.Consumer;

/**
 * <pre>
 * 
 * <a href=
 * "https://leetcode.com/problems/special-positions-in-a-binary-matrix/">Problem-Link</a>
 * 
 * 1582. Special Positions in a Binary Matrix Easy 1.1K 44 Companies
 * 
 * Given an m x n binary matrix mat, return the number of special positions in
 * mat.
 * 
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements
 * in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * 
 * Example 1:
 * 
 * <img src="special1.jpg" width="80%" />
 * 
 * 
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]] Output: 1 Explanation: (1, 2) is a
 * special position because mat[1][2] == 1 and all other elements in row 1 and
 * column 2 are 0. Example 2:
 *
 * <img src="special-grid.jpg" width="80%"/> Input: mat =
 * [[1,0,0],[0,1,0],[0,0,1]]
 * 
 * Output: 3 Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 * 
 * 
 * Constraints:
 * 
 * m == mat.length n == mat[i].length 1 <= m, n <= 100 mat[i][j] is either 0 or
 * 1. Accepted 89.9K Submissions 132.3K Acceptance Rate 67.9%
 */
public class SolutionWednesday1213 {
	// Mine
	public int numSpecial1(int[][] mat) {
		int count = 0;
		for (int i = 0; i < mat.length; i++) {
			boolean isHavingOne = false;
			int colInd = -1;
			for (int j = 0; j < mat[i].length; j++) {
				if (isHavingOne && mat[i][j] == 1) {
					colInd = -1;
					break;
				}
				if (mat[i][j] != 0 && !isHavingOne) {
					isHavingOne = true;
					colInd = j;
				}
			}
			if (colInd != -1 && (checkColumnAsZeros(mat, colInd))) {
				count++;
			}
		}
		return count;
	}

	boolean checkColumnAsZeros(int[][] mat, int colIndex) {
		boolean isHavingOne = false;
		for (int i = 0; i < mat.length; i++) {
			if (isHavingOne && mat[i][colIndex] == 1) {
				return false;
			}
			if (mat[i][colIndex] != 0 && !isHavingOne) {
				isHavingOne = true;
			}
		}
		return true;
	}

	// Best Solution
	public int numSpecial(int[][] mat) {

		int specials = 0;

		for (int i = 0; i < mat.length; i++) {
			int index = checkRow(mat, i);
			if (index >= 0 && checkColumn(mat, i, index))
				specials++;
		}

		return specials;
	}

	private int checkRow(int[][] mat, int i) {
		int index = -1;
		for (int j = 0; j < mat[0].length; j++) {
			if (mat[i][j] == 1) {
				if (index >= 0)
					return -1;
				else
					index = j;
			}
		}
		return index;
	}

	private boolean checkColumn(int[][] mat, int i, int index) {
		for (int j = 0; j < mat.length; j++) {
			if (mat[j][index] == 1 && j != i)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday1213();
		cons.accept(obj.numSpecial(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } }));
		cons.accept(obj.numSpecial(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 0, 1, 0 } }));
	}
}
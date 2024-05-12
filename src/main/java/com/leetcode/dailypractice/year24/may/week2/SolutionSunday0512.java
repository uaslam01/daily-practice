package com.leetcode.dailypractice.year24.may.week2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/largest-local-values-in-a-matrix/">
 * Problem-Link</a>
 * 
 * 2373. Largest Local Values in a Matrix
 * 
 * Easy Topics Companies Hint
 * 
 * You are given an n x n integer matrix grid.
 * 
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid
 * centered around row i + 1 and column j + 1. In other words, we want to find
 * the largest value in every contiguous 3 x 3 matrix in grid. Return the
 * generated matrix.
 * 
 * 
 * Example 1:
 * 
 * <img src="ex1.png" width="50%"/>
 * 
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]] Output: [[9,9],[8,6]]
 * Explanation: The diagram above shows the original matrix and the generated
 * matrix. Notice that each value in the generated matrix corresponds to the
 * largest value of a contiguous 3 x 3 matrix in grid.
 * 
 * 
 * Example 2:
 * 
 * <img src="ex2.png" width="50%"/>
 * 
 * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * Output: [[2,2,2],[2,2,2],[2,2,2]] Explanation: Notice that the 2 is contained
 * within every contiguous 3 x 3 matrix in grid.
 * 
 * 
 * Constraints:
 * 
 * n == grid.length == grid[i].length 3 <= n <= 100 1 <= grid[i][j] <= 100
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 104.4K
 * Submissions 119.7K Acceptance Rate 87.2%
 **/

public class SolutionSunday0512 {
	// Mine Solution /Best Solution 1
    public int[][] largestLocal(int[][] grid) {
    	int rows = grid.length-2;
    	int cols = grid[0].length-2;
    	int[][] matrix = new int[3][3];
    	int[][] res = new int[rows][cols];
    	for(int i=0;i<rows;i++) {
    		copyElements(grid, matrix, i);
    		res[i][0] = getMaximum(matrix);
    		for(int j=1;j<cols;j++) {
    			shifColumn(grid, matrix, i, j);
        		res[i][j] = getMaximum(matrix);
    		}
    	}
        return res;
    }
    private void shifColumn(int[][] grid, int[][] matrix, int i, int j) {
    	matrix[0][(j+2)%3] = grid[i][j+2];
		matrix[1][(j+2)%3] = grid[i+1][j+2];		
		matrix[2][(j+2)%3] = grid[i+2][j+2];
	}
	private void copyElements(int[][] grid, int[][] matrix, int index) {
		matrix[0][0] = grid[index][0];
		matrix[0][1] = grid[index][1];
		matrix[0][2] = grid[index][2];
		matrix[1][0] = grid[index+1][0];
		matrix[1][1] = grid[index+1][1];
		matrix[1][2] = grid[index+1][2];
		matrix[2][0] = grid[index+2][0];
		matrix[2][1] = grid[index+2][1];
		matrix[2][2] = grid[index+2][2];
	}
	int getMaximum(int[][] matrix) {
		int max = -1;
    	for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
        		if(max<matrix[i][j]) {
        			max = matrix[i][j];
        		}
        	}	
    	}
    	return max;
    }
	public static void main(String[] arg) {
		var obj = new SolutionSunday0512();
		IntConsumer cons = System.out::println;
		Consumer<int[][]> arrConsumer = x -> Arrays.stream(x).forEach(x1->Arrays.stream(x1).forEach(cons));
		
		arrConsumer.accept(obj.largestLocal(new int[][] {{20,8,20,6,16,16,7,16,8,10},{12,15,13,10,20,9,6,18,17,6},{12,4,10,13,20,11,15,5,17,1},{7,10,14,14,16,5,1,7,3,11},{16,2,9,15,9,8,6,1,7,15},{18,15,18,8,12,17,19,7,7,8},{19,11,15,16,1,3,7,4,7,11},{11,6,5,14,12,18,3,20,14,6},{4,4,19,6,17,12,8,8,18,8},{19,15,14,11,11,13,12,6,16,19}}));
		System.out.println("---");

		arrConsumer.accept(obj.largestLocal(new int[][] {{9, 9, 8, 1},{5, 6, 2, 6},{8, 2, 6, 4},{6, 2, 2, 2}}));
		System.out.println("---");
		arrConsumer.accept(obj.largestLocal(new int[][] {{1, 1, 1, 1, 1},{1, 1, 1, 1, 1},{1, 1, 2, 1, 1},{1, 1, 1, 1, 1},{1, 1, 1, 1, 1}}));
		System.out.println("---");

	}
}

package com.leetcode.dailypractice.year23.nov.week4;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Largest Submatrix With Rearrangements Medium 1.5K 69 Companies You are given
 * a binary matrix matrix of size m x n, and you are allowed to rearrange the
 * columns of the matrix in any order.
 * 
 * Return the area of the largest submatrix within matrix where every element of
 * the submatrix is 1 after reordering the columns optimally.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[0,0,1],[1,1,1],[1,0,1]] Output: 4 Explanation: You can
 * rearrange the columns as shown above. The largest submatrix of 1s, in bold,
 * has an area of 4. Example 2:
 * 
 * 
 * Input: matrix = [[1,0,1,0,1]] Output: 3 Explanation: You can rearrange the
 * columns as shown above. The largest submatrix of 1s, in bold, has an area of
 * 3. Example 3:
 * 
 * Input: matrix = [[1,1,0],[1,0,1]] Output: 2 Explanation: Notice that you must
 * rearrange entire columns, and there is no way to make a submatrix of 1s
 * larger than an area of 2.
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m * n <= 105 matrix[i][j] is
 * either 0 or 1. Accepted 43.3K Submissions 59.5K Acceptance Rate 72.8%
 */
public class SolutionSunday1126 {
	//Mine
    public int largestSubmatrix1(int[][] matrix) {
        int max = 0;
        return max;
    }
    //Best Solution
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Calculate heights for each column
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            // Sort the heights in ascending order
            Arrays.sort(matrix[i]);

            // Iterate through the sorted heights
            for (int j = 0; j < col; j++) {
                int height = matrix[i][j];
                int width = col - j;
                res = Math.max(res, height * width);
            }
        }

        return res;        
    }
    public static void main(String[] args) {
    	Consumer cons = i-> Arrays.stream((int[]) i).forEach(System.out::print);
		var obj = new SolutionSunday1126();
		cons.accept(obj.largestSubmatrix(new int[] []{{} }));
    }
}


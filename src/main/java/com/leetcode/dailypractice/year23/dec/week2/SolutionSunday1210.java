package com.leetcode.dailypractice.year23.dec.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/transpose-matrix/">Problem-Link</a>
 * 
 * 867. Transpose Matrix Easy 3.6K 439 Companies Given a 2D integer array
 * matrix, return the transpose of matrix.
 * 
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 *  
 * <img src="hint_transpose.png" width="90%" height = "40%" />
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * 
 * Input: matrix = [[1,2,3],[4,5,6]] Output: [[1,4],[2,5],[3,6]]
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 1000 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109 Accepted 360.8K Submissions 512K Acceptance Rate
 * 70.5% Seen this question in a real interview before? 1/4 Yes No
 */
public class SolutionSunday1210 {
	//Mine
    public int[][] transpose1(int[][] matrix) {
        return null;
       
    }
//    Best Solution
//    Time Complexity: O(m * n) where m and n are the number of rows and columns in the matrix.
//    Space Complexity: O(m * n) for the transposed matrix.
    public int[][] transpose2(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int arr[][]=new int[col][row];
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
            arr[i][j]=matrix[j][i];
            }
        }
        return arr;
    }
//    Best Solution 2
//    Time complexity: O(r∗c)O(r * c)O(r∗c)
//    Space complexity: O(r∗c)O(r * c)O(r∗c)
    public int[][] transpose(int[][] matrix) {
        List<List<Integer>> resList = new ArrayList<>();

        for (int c = 0; c < matrix[0].length; c++) {
            List<Integer> temp = new ArrayList<>();

            for (int r = 0; r < matrix.length; r++) {
                temp.add(matrix[r][c]);
            }

            resList.add(temp);
        }

        // Convert List<List<Integer>> to int[][]
        int[][] res = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            List<Integer> row = resList.get(i);
            res[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }

        return res;        
    }
	public static void main(String[] args) {
		Consumer cons = i -> Arrays.stream((int[][]) i)
				.forEach(j -> Arrays.stream((int[]) j).forEach(System.out::print));		
		var obj = new SolutionSunday1210();
		cons.accept(obj.transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
		System.out.println();
		cons.accept(obj.transpose(new int[][] {{1,2,3},{4,5,6}}));
	}

}
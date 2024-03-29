package com.leetcode.dailypractice.year24.jan.week4;

import java.util.HashMap;
import java.util.Map;

/**
   * <pre>
 * <a href=
 * "https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/">Problem-Link</a>
 * 
 * 
 * 1074. Number of Submatrices That Sum to Target
 * 
 * Solved Hard Topics Companies Hint
 * 
 * 
 * Given a matrix and a target, return the number of non-empty submatrices that
 * sum to target.
 * 
 * 
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
 * <= x2 and y1 <= y <= y2.
 * 
 * 
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
 * they have some coordinate that is different: for example, if x1 != x1'.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="mate1.jpg" width="70%" height="70%"/>

 * 
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 
 * Output: 4
 * 
 * Explanation: The four 1x1 submatrices that only contain 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * 
 * Output: 5
 * 
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the
 * 2x2 submatrix.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [[904]], target = 0
 * 
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= matrix.length <= 100 1 <= matrix[0].length <= 100 -1000 <= matrix[i] <=
 * 1000 -10^8 <= target <= 10^8
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 125.6K
 * Submissions 172K Acceptance Rate 73.0%
 * 
 */
public class SolutionSunday0128 {
	//Best Solution
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int count = 0;

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < m; row++) {
                    sum += matrix[row][c2] - (c1 > 0 ? matrix[row][c1 - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
	public static void main(String[] args) {
		var obj = new SolutionSunday0128();
		System.out.println(obj.numSubmatrixSumTarget(new int[][] {{0,1,0},{1,1,1},{0,1,0}}, 0));
		System.out.println(obj.numSubmatrixSumTarget(new int[][] {{1,-1},{-1,1}}, 0));
		System.out.println(obj.numSubmatrixSumTarget(new int[][] {{904}}, 0));

	}
}
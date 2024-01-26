package com.leetcode.dailypractice.year24.jan.week4;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/out-of-boundary-paths/description/">Problem-Link</a>
 * 
 * 576. Out of Boundary Paths
 * 
 * Medium Topics Companies Hint
 * 
 * 
 * There is an m x n grid with a ball. The ball is initially at the position
 * [startRow, startColumn]. You are allowed to move the ball to one of the four
 * adjacent cells in the grid (possibly out of the grid crossing the grid
 * boundary). You can apply at most maxMove moves to the ball.
 * 
 * Given the five integers m, n, maxMove, startRow, startColumn, return the
 * number of paths to move the ball out of the grid boundary. Since the answer
 * can be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="out_of_boundary_paths_1.png" width="80%"/>
 * 
 * 
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 
 * Output: 6
 * 
 * 
 * 
 * Example 2:
 * 
 * <img src="out_of_boundary_paths_2.png" width="80%"/>
 * 
 * 
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 
 * Output: 12
 * 
 * 
 * Constraints:
 * 
 * 1 <= m, n <= 50 0 <= maxMove <= 50 0 <= startRow < m 0 <= startColumn < n
 * Seen this question in a real interview before? 1/4 Yes No Accepted 171.6K
 * Submissions 367.2K Acceptance Rate 46.7%
 */
public class SolutionFriday0126 {
//	private enum Directions{
//		LEFT,RIGHT,UP,DOWN,ALL
//	}
	//Mine Solution
    public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {    	
    	return getTotalPaths(m, n, maxMove, startRow, startColumn, 0);
    }
    int getTotalPaths(int m,int n, int maxMove, int i, int j, int count) {
    	if(maxMove<=0)
    		return count;
    	boolean left = true;
    	boolean right = true;
    	boolean up = true;
    	boolean down = true;
    	if(i==0) {
    		count++;
    		up = false;
    	}
    	if(i+1==m) {
    		count++;
    		down= false;
    	}
    	if(j==0) {
    		count++;
    		left = false;
    	}
    	if(j+1==n) {
    		count++;
    		right = false;
    	}
    	if(up==true) {
    		count=getTotalPaths(m, n, maxMove-1, i-1, j, count);
    	}
    	if(down==true) {
    		count=getTotalPaths(m, n, maxMove-1, i+1, j, count);
    	}
    	if(left==true) {
    		count=getTotalPaths(m, n, maxMove-1, i, j-1, count);
    	}
    	if(right==true) {
    		count=getTotalPaths(m, n, maxMove-1, i, j+1, count);
    	}    	
    	return count;
    }
    //Best Solution

    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int dp[][][] = new int[m][n][maxMove + 1];

        for(int [][] i : dp) 
            for(int s1[] : i) {
                Arrays.fill(s1, -1);
            }
        
        return findPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    public int findPaths(int m, int n, int N, int i, int j, int dp[][][]) {

        if(i == m || j == n || i < 0 || j < 0) return 1;
        if(N == 0) return 0;

        if(dp[i][j][N] >= 0) return dp[i][j][N];

        dp[i][j][N] = (
            (findPaths(m, n, N-1, i-1, j, dp) + findPaths(m, n, N-1, i+1, j, dp)) % mod +
            (findPaths(m, n, N-1, i, j-1, dp) + findPaths(m, n, N-1, i, j+1, dp)) % mod) % mod;
        
        return dp[i][j][N];
    }
    
	public static void main(String[] args) {
		var obj = new SolutionFriday0126();
		//Time limit exceeds on my solution
		System.out.println(obj.findPaths(8, 7, 16, 1, 5));
		//Sample input
		System.out.println(obj.findPaths(2, 2, 2, 0, 0));
		System.out.println(obj.findPaths(1, 3, 3, 0, 1));
	}

    
}

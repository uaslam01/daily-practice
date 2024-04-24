package com.leetcode.dailypractice.year24.apr.week4;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/n-th-tribonacci-number/">Problem-Link</a>
 * 
 * 
 * 1137. N-th Tribonacci Number
 * 
 * 
 * Solved Easy Topics Companies Hint
 * 
 * 
 * The Tribonacci sequence Tn is defined as follows:
 * 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4 Output: 4
 * 
 * Explanation: T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 + 2 = 4
 * 
 * 
 * Example 2:
 * 
 * Input: n = 25 Output: 1389537
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 37 The answer is guaranteed to fit within a 32-bit integer, ie.
 * answer <= 2^31 - 1. Seen this question in a real interview before? 1/5 Yes No
 * Accepted 733.6K Submissions 1.2M Acceptance Rate 63.8%
 */
public class SolutionWednesdday0424 {

	// Mine/ Best Solution 1
	public int tribonacci1(int n) {
		return getNTerm(n);
	}

	public int getNTerm(int n) {
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int nth = 0;
		int n0 = 0;
		int n1 = 1;
		int n2 = 1;
		for (int i = 3; i <= n; i++) {
			nth = n0 + n1 + n2;
			n0 = n1;
			n1 = n2;
			n2 = nth;
		}
		return nth;
	}

	// Best Solution 2
	public int tribonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];

	}
}

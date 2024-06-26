package com.leetcode.dailypractice.year24.apr.week4;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/longest-ideal-subsequence/">Problem-Link</a>
 * 
 * 2370. Longest Ideal Subsequence
 * 
 * Medium Topics Companies Hint
 * 
 * You are given a string s consisting of lowercase letters and an integer k. We
 * call a string t ideal if the following conditions are satisfied:
 * 
 * t is a subsequence of the string s. The absolute difference in the alphabet
 * order of every two adjacent letters in t is less than or equal to k. Return
 * the length of the longest ideal string.
 * 
 * A subsequence is a string that can be derived from another string by deleting
 * some or no characters without changing the order of the remaining characters.
 * 
 * Note that the alphabet order is not cyclic. For example, the absolute
 * difference in the alphabet order of 'a' and 'z' is 25, not 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "acfgbd", k = 2 Output: 4 Explanation: The longest ideal string is
 * "acbd". The length of this string is 4, so 4 is returned. Note that "acfgbd"
 * is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
 * 
 * 
 * Example 2:
 * 
 * Input: s = "abcd", k = 3 Output: 4
 * 
 * Explanation: The longest ideal string is "abcd". The length of this string is
 * 4, so 4 is returned.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 0 <= k <= 25 s consists of lowercase English letters.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 48.9K
 * Submissions 114.3K Acceptance Rate 42.8%
 */
public class SolutionThursday0425 {
	// Mine Solution
	public int longestIdealString(String s, int k) {
		char temp = s.charAt(0);
		StringBuilder strBuilder = new StringBuilder();

		int len = s.length();

		for (int i = 1; i < len; i++) {

		}
		return strBuilder.toString().length();
	}

	// Best Solution
	public int longestIdealString1(String s, int k) {

		int[] dp = new int[27];
		int n = s.length();

		for (int i = n - 1; i >= 0; i--) {
			char cc = s.charAt(i);
			int idx = cc - 'a';
			int max = Integer.MIN_VALUE;

			int left = Math.max((idx - k), 0);
			int right = Math.min((idx + k), 26);

			for (int j = left; j <= right; j++) {
				max = Math.max(max, dp[j]);
			}

			dp[idx] = max + 1;
		}

		int max = Integer.MIN_VALUE;

		for (int ele : dp) {
			max = Math.max(ele, max);
		}

		return max;
	}

}

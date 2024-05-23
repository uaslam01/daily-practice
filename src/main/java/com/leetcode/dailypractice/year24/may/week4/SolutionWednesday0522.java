package com.leetcode.dailypractice.year24.may.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/palindrome-partitioning/">
 * Problem-Link</a>
 * 
 * 131. Palindrome Partitioning Medium Topics Companies
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * 
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * 
 * Example 2:
 * 
 * Input: s = "a"
 * 
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 16 s contains only lowercase English letters.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 832.5K
 * Submissions 1.2M Acceptance Rate 68.3%
 **/

public class SolutionWednesday0522 {
	// Mine Solution / Best Solution
	public List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			StringBuilder strBuilder = new StringBuilder();
			List<String> subset = new ArrayList<>();
			for (int j = i; j < len; j++) {
				strBuilder.append(s.charAt(j));
				String str = strBuilder.toString();
				StringBuilder strBuilderForReverse = new StringBuilder(str);
				String reverseStr  = strBuilderForReverse.reverse().toString();
				if (str.equals(reverseStr)) {
					subset.add(str);
				}
			}
			list.add(subset);
		}
		return list;
	}

	public static void main(String[] arg) {
		var obj = new SolutionWednesday0522();

		System.out.println(obj.partition("aabaabaab"));

	}
}

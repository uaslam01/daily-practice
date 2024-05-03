package com.leetcode.dailypractice.year24.may.week1;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/compare-version-numbers/">
 * Problem-Link</a>
 *
 * 165. Compare Version Numbers
 * 
 * Medium Topics Companies
 * 
 * Given two version numbers, version1 and version2, compare them.
 * 
 * Version numbers consist of one or more revisions joined by a dot '.'. Each
 * revision consists of digits and may contain leading zeros. Every revision
 * contains at least one character. Revisions are 0-indexed from left to right,
 * with the leftmost revision being revision 0, the next revision being revision
 * 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 * 
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal. If a version number
 * does not specify a revision at an index, then treat the revision as 0. For
 * example, version 1.0 is less than version 1.1 because their revision 0s are
 * the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 * 
 * Return the following:
 * 
 * If version1 < version2, return -1. If version1 > version2, return 1.
 * Otherwise, return 0.
 * 
 * 
 * Example 1:
 * 
 * Input: version1 = "1.01", version2 = "1.001" Output: 0 Explanation: Ignoring
 * leading zeroes, both "01" and "001" represent the same integer "1".
 * 
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0", version2 = "1.0.0" Output: 0 Explanation: version1
 * does not specify revision 2, which means it is treated as "0".
 * 
 * 
 * Example 3:
 * 
 * Input: version1 = "0.1", version2 = "1.1" Output: -1 Explanation: version1's
 * revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 <
 * version2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= version1.length, version2.length <= 500 version1 and version2 only
 * contain digits and '.'. version1 and version2 are valid version numbers. All
 * the given revisions in version1 and version2 can be stored in a 32-bit
 * integer.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 400.7K
 * Submissions 1.1M Acceptance Rate 37.7%
 **/
public class SolutionFriday0503 {
	// Mine Solution
	public int compareVersion(String version1, String version2) {
		String[] v1List = version1.split("\\.");
		String[] v2List = version2.split("\\.");

		int longVersionLen = v1List.length > v2List.length ? v1List.length : v2List.length;
		int shortVersionLen = v1List.length > v2List.length ? v2List.length : v1List.length;
		String[] longVerList = v1List.length > v2List.length ? v1List : v2List;

		int answer = v1List.length > v2List.length ? 1 : -1;
		;
		for (int i = 0; i < shortVersionLen; i++) {
			int v1 = Integer.parseInt(v1List[i]);
			int v2 = Integer.parseInt(v2List[i]);
			if (v1 < v2)
				return -1;
			else if (v1 > v2)
				return 1;
		}

		for (int i = shortVersionLen; i < longVersionLen; i++) {
			int v1 = Integer.parseInt(longVerList[i]);
			if (v1 != 0)
				return answer;

		}
		return 0;

	}

	// Best Solution
	public int compareVersion1(String version1, String version2) {
		int n = version1.length(), m = version2.length();
		int i = 0, j = 0;
		while (i < n || j < m) {
			int x = 0;
			for (; i < n && version1.charAt(i) != '.'; ++i) {
				x = x * 10 + version1.charAt(i) - '0';
			}
			++i; // 跳过点号
			int y = 0;
			for (; j < m && version2.charAt(j) != '.'; ++j) {
				y = y * 10 + version2.charAt(j) - '0';
			}
			++j; // 跳过点号
			if (x != y) {
				return x > y ? 1 : -1;
			}
		}
		return 0;
	}

	public static void main(String[] arg) {
		var obj = new SolutionFriday0503();
		System.out.println(obj.compareVersion("1.01", "1.001"));
		System.out.println(obj.compareVersion("1.0", "1.0.0"));
		System.out.println(obj.compareVersion("0.1", "1.1"));
		// Custom Input
		System.out.println(obj.compareVersion("10.1.11.01.2", "10.1.11.01.2"));
		System.out.println(obj.compareVersion("10.1.11.01.2", "10.11.11."));
		System.out.println(obj.compareVersion("10", "10.00"));

	}

}

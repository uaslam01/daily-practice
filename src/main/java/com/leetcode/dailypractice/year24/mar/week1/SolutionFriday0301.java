package com.leetcode.dailypractice.year24.mar.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/maximum-odd-binary-number/">Problem-Link</a>
 *
 * 2864. Maximum Odd Binary Number
 * 
 * Easy Topics Companies Hint
 * 
 * You are given a binary string s that contains at least one '1'.
 * 
 * You have to rearrange the bits in such a way that the resulting binary number
 * is the maximum odd binary number that can be created from this combination.
 * 
 * Return a string representing the maximum odd binary number that can be
 * created from the given combination.
 * 
 * Note that the resulting string can have leading zeros.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "010"
 * 
 * Output: "001"
 * 
 * Explanation: Because there is just one '1', it must be in the last position.
 * So the answer is "001".
 * 
 * Example 2:
 * 
 * Input: s = "0101"
 * 
 * Output: "1001"
 * 
 * Explanation: One of the '1's must be in the last position. The maximum number
 * that can be made with the remaining digits is "100". So the answer is "1001".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s consists only of '0' and '1'. s contains at least one
 * '1'.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 81.2K
 * Submissions 100.6K Acceptance Rate 80.7%
 */
public class SolutionFriday0301 {
	// Mine Solution
	public String maximumOddBinaryNumber(String s) {
		int onesCount = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				onesCount++;
			}
		}
		return repeat("1", onesCount - 1) + repeat("0", s.length() - onesCount) + "1";
	}

	public String repeat(String s, int count) {
		StringBuilder strBuilder = new StringBuilder();
		if (count > 0) {
			while (count-- > 0) {
				strBuilder.append(s);
			}
		}
		return strBuilder.toString();
	}

	// Best Solution
	public String maximumOddBinaryNumber1(String s) {
		int onesCount = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				onesCount++;
			}
		}
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < onesCount - 1; i++) {
			strBuilder.append("1");

		}
		for (int i = 0; i < s.length() - onesCount; i++) {
			strBuilder.append("0");

		}
		return strBuilder.append("1").toString();
	}

	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new SolutionFriday0301();
		cons.accept(obj.maximumOddBinaryNumber("010"));
		cons.accept(obj.maximumOddBinaryNumber("0101"));

	}
}

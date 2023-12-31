package com.leetcode.dailypractice.year23.dec.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/largest-odd-number-in-string/">Problem-Link</a>
 * 
 * 1903. Largest Odd Number in String Easy 1.7K 93 Companies 
 * You are given a string num, representing a large integer. Return the largest-valued odd
 * integer (as a string) that is a non-empty substring of num, or an empty
 * string "" if no odd integer exists.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "52" Output: "5" Explanation: The only non-empty substrings are
 * "5", "2", and "52". "5" is the only odd number. Example 2:
 * 
 * Input: num = "4206" Output: "" Explanation: There are no odd numbers in
 * "4206". Example 3:
 * 
 * Input: num = "35427" Output: "35427" Explanation: "35427" is already an odd
 * number.
 * 
 * 
 * Constraints:
 * 
 * 1 <= num.length <= 105 num only consists of digits and does not contain any
 * leading zeros. Accepted 163.5K Submissions 259.5K Acceptance Rate 63.0%
 */
public class SolutionThursday1207 {
	// Best Solution
	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}
	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new SolutionThursday1207();
		cons.accept(obj.largestOddNumber("52"));
		cons.accept(obj.largestOddNumber("4206"));
		cons.accept(obj.largestOddNumber("35427"));

	}
}
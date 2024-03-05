package com.leetcode.dailypractice.year24.mar.week1;

import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/bag-of-tokens/">Problem-Link</a>
 *
 * 1750. Minimum Length of String After Deleting Similar Ends
 * 
 * Medium Topics Companies Hint
 * 
 * Given a string s consisting only of characters 'a', 'b', and 'c'. You are
 * asked to apply the following algorithm on the string any number of times:
 * <ol>
 * <li>Pick a non-empty prefix from the string s where all the characters in the
 * prefix are equal.
 * <li>Pick a non-empty suffix from the string s where all the characters in
 * this suffix are equal.
 * <li>The prefix and the suffix should not intersect at any index.
 * <li>The characters from the prefix and suffix must be the same.
 * <li>Delete both the prefix and the suffix.
 * </ol>
 * 
 * Return the minimum length of s after performing the above operation any
 * number of times (possibly zero times).
 * 
 * Example 1:
 * 
 * Input: s = "ca"
 * 
 * Output: 2
 * 
 * Explanation: You can't remove any characters, so the string stays as is.
 * 
 * 
 * Example 2:
 * 
 * Input: s = "cabaabac"
 * 
 * Output: 0
 * 
 * Explanation: An optimal sequence of operations is: - Take prefix = "c" and
 * suffix = "c" and remove them, s = "abaaba". - Take prefix = "a" and suffix =
 * "a" and remove them, s = "baab". - Take prefix = "b" and suffix = "b" and
 * remove them, s = "aa". - Take prefix = "a" and suffix = "a" and remove them,
 * s = "".
 * 
 * 
 * Example 3:
 * 
 * Input: s = "aabccabba"
 * 
 * Output: 3
 * 
 * Explanation: An optimal sequence of operations is: - Take prefix = "aa" and
 * suffix = "a" and remove them, s = "bccabb". - Take prefix = "b" and suffix =
 * "bb" and remove them, s = "cca".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s only consists of characters 'a', 'b', and 'c'.
 * 
 * Seen this question in a real interview before?
 * 
 * 1/4 Yes No Accepted 56.4K Submissions 108.3K Acceptance Rate 52.1%
 */
public class SolutionTueday0305 {
	public int minimumLength(String s) {
		int start = 0;
		int end = s.length() - 1;
		if(start==end) {
			return 1;
		}
		char[] charArr = s.toCharArray();
		while (start != end && charArr[start] == charArr[end]) {
			char key = charArr[start];
			while (start != end && key == charArr[start]) {
				start++;

			}
			while (start != end && key == charArr[end]) {
				end--;
			}
		}
		return end == start && charArr[start-1]==charArr[start] ? 0 : end - start + 1;
	}
	

	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionTueday0305();

		cons.accept(obj.minimumLength("ca"));
		cons.accept(obj.minimumLength("cabaabac"));
		cons.accept(obj.minimumLength("aabccabba"));
		System.out.println("---");
		// Custom Input
		cons.accept(obj.minimumLength("c"));
		cons.accept(obj.minimumLength("cc"));
		cons.accept(obj.minimumLength("ccc"));

		cons.accept(obj.minimumLength("cac"));
		cons.accept(obj.minimumLength("caac"));
		cons.accept(obj.minimumLength("aadaad"));

	}
}

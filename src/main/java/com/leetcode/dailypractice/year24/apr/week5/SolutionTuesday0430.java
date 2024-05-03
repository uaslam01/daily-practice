package com.leetcode.dailypractice.year24.apr.week5;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/number-of-wonderful-substrings/">
 * Problem-Link</a>
 *
 * 1915. Number of Wonderful Substrings
 * 
 * Solved Medium Topics Companies Hint
 * 
 * A wonderful string is a string where at most one letter appears an odd number
 * of times.
 * 
 * For example, "ccjjc" and "abab" are wonderful, but "ab" is not. Given a
 * string word that consists of the first ten lowercase English letters ('a'
 * through 'j'), return the number of wonderful non-empty substrings in word. If
 * the same substring appears multiple times in word, then count each occurrence
 * separately.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "aba" Output: 4 Explanation: The four wonderful substrings are
 * underlined below: - "aba" -> "a" - "aba" -> "b" - "aba" -> "a" - "aba" ->
 * "aba"
 * 
 * 
 * Example 2:
 * 
 * Input: word = "aabb" Output: 9 Explanation: The nine wonderful substrings are
 * underlined below: - "aabb" -> "a" - "aabb" -> "aa" - "aabb" -> "aab" - "aabb"
 * -> "aabb" - "aabb" -> "a" - "aabb" -> "abb" - "aabb" -> "b" - "aabb" -> "bb"
 * - "aabb" -> "b"
 * 
 * 
 * Example 3:
 * 
 * Input: word = "he" Output: 2 Explanation: The two wonderful substrings are
 * underlined below: - "he" -> "h" - "he" -> "e"
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 105 word consists of lowercase English letters from 'a'
 * to 'j'.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 78.4K
 * Submissions 116.5K Acceptance Rate 67.3%
 **/
public class SolutionTuesday0430 {

	// Mine Solution
	//Time Limit Exceeds
	public long wonderfulSubstrings(String word) {
		long counter = 0;
		for (int i = 0; i < word.length(); i++) {
			int[] alphabetsCountArr = new int[10];
			alphabetsCountArr[word.charAt(i) - 'a']++;
			while (!validOddCharCount(alphabetsCountArr)) {
				if (++i < word.length())
					alphabetsCountArr[word.charAt(i) - 'a']++;
				else
					return counter;
			}
			counter++;
			for (int j = i + 1; j < word.length(); j++) {
				alphabetsCountArr[word.charAt(j) - 'a']++;
				if (validOddCharCount(alphabetsCountArr)) {
					counter++;
				}
			}
		}
		return counter;
	}

	private boolean validOddCharCount(int[] alphabetsCountArr) {
		boolean isOddMarked = false;
		for (int i = 0; i < 10; i++) {
			if (alphabetsCountArr[i] % 2 == 1) {
				if (!isOddMarked) {
					isOddMarked = true;
				} else
					return false;
			}
		}
		return true;
	}

	// Best Solution
	public long wonderfulSubstrings1(String word) {
		long[] count = new long[1024]; // 2^10 to store XOR values
		long result = 0;
		int prefixXor = 0;
		count[prefixXor] = 1;

		for (char ch : word.toCharArray()) {
			int charIndex = ch - 'a';
			prefixXor ^= 1 << charIndex;
			result += count[prefixXor];
			for (int i = 0; i < 10; i++) {
				result += count[prefixXor ^ (1 << i)];
			}
			count[prefixXor]++;
		}

		return result;
	}

	public static void main(String[] arg) {
		var obj = new SolutionTuesday0430();
		System.out.println(obj.wonderfulSubstrings("he"));

		System.out.println(obj.wonderfulSubstrings("aba"));
		System.out.println(obj.wonderfulSubstrings("aabb"));

		// Customer Input
		System.out.println(obj.wonderfulSubstrings("ab"));
		System.out.println(obj.wonderfulSubstrings("abcabcdefdefghgh"));
		System.out.println(obj.wonderfulSubstrings("abhab"));
		System.out.println(obj.wonderfulSubstrings("aaabbbccc"));
	}
}

package com.leetcode.dailypractice.year24.jan.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * *
 * 
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/determine-if-string-halves-are-alike/">Problem-Link</a>
 * 1704. Determine if String Halves Are Alike Solved Easy Topics Companies Hint
 * You are given a string s of even length. Split this string into two halves of
 * equal lengths, and let a be the first half and b be the second half.
 * 
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i',
 * 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and
 * lowercase letters.
 * 
 * Return true if a and b are alike. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "book" Output: true
 * 
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel.
 * Therefore, they are alike. Example 2:
 * 
 * Input: s = "textbook" Output: false
 * 
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2.
 * Therefore, they are not alike. Notice that the vowel o is counted twice.
 * 
 * 
 * Constraints:
 * 
 * 2 <= s.length <= 1000 s.length is even. s consists of uppercase and lowercase
 * letters. Seen this question in a real interview before? 1/4 Yes No Accepted
 * 277.1K Submissions 353.8K Acceptance Rate 78.3%
 **/
public class SolutionFriday0112 {
	// Best Solution
	public boolean halvesAreAlike(String s) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');

		int length = s.length();
		int midPoint = length / 2;

		String firstHalf = s.substring(0, midPoint);
		String secondHalf = s.substring(midPoint);

		return countVowels(firstHalf, vowels) == countVowels(secondHalf, vowels);
	}

	private int countVowels(String str, Set<Character> vowels) {
		int count = 0;
		for (char c : str.toCharArray()) {
			if (vowels.contains(c)) {
				count++;
			}
		}
		return count;
	}
}
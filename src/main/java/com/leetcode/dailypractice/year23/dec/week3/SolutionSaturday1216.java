package com.leetcode.dailypractice.year23.dec.week3;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/valid-anagram/">Problem-Link</a>
 * 
 * 242. Valid Anagram Easy 11.3K 356 Companies
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 5 * 104 s and t consist of lowercase English
 * letters.
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * 
 * Accepted 2.9M Submissions 4.6M Acceptance Rate 63.8%
 * 
 */
public class SolutionSaturday1216 {
	// Mine
	public boolean isAnagram1(String s, String t) {
		int[] sCharCountArr = new int[26];
		int[] tCharCountArr = new int[26];

		for (char ch : s.toCharArray()) {
			sCharCountArr[ch - 'a']++;
		}
		for (char ch : t.toCharArray()) {
			tCharCountArr[ch - 'a']++;
		}
		int i = 0;
		while (i < 26 && sCharCountArr[i] == tCharCountArr[i]) {
			i++;
		}
		return i == 26;
	}

	// Also mine
	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sCharArr = s.toCharArray();
		char[] tCharArr = t.toCharArray();
		Arrays.sort(sCharArr);
		Arrays.sort(tCharArr);
		for (int i = 0; i < sCharArr.length; i++) {
			if (sCharArr[i] != tCharArr[i])
				return false;
		}
		return true;
	}

	// Best Solution
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < t.length(); i++) {
			if (count[t.charAt(i) - 'a'] == 0) {
				return false;
			}
			count[t.charAt(i) - 'a'] -= 1;
		}

		return true;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionSaturday1216();
		cons.accept(obj.isAnagram("anagram", "nagaram"));
		cons.accept(obj.isAnagram("rat", "car"));

	}

}

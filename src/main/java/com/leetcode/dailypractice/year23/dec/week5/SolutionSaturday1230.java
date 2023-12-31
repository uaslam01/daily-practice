package com.leetcode.dailypractice.year23.dec.week5;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/">Problem-Link</a>
 * 
 * 1897. Redistribute Characters to Make All Strings Equal Easy 883 65 Companies
 * You are given an array of strings words (0-indexed).
 * 
 * In one operation, pick two distinct indices i and j, where words[i] is a
 * non-empty string, and move any character from words[i] to any position in
 * words[j].
 * 
 * Return true if you can make every string in words equal using any number of
 * operations, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["abc","aabc","bc"]
 * 
 * Output: true Explanation: Move the first 'a' in words[1] to the front of
 * words[2], to make words[1] = "abc" and words[2] = "abc". All the strings are
 * now equal to "abc", so return true.
 * 
 * Example 2:
 * 
 * Input: words = ["ab","a"]
 * 
 * Output: false Explanation: It is impossible to make all the strings equal
 * using the operation.
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] consists of
 * lowercase English letters. Accepted 94.9K Submissions 142K Acceptance Rate
 * 66.9% Seen this question in a real interview before? 1/4 Yes No
 **/
public class SolutionSaturday1130 {
	// Mine Solution 
	//Same
	public boolean makeEqual(String[] words) {
		int[] alphabetsArr = new int[26];
		for (var word : words) {
			for (char ch : word.toCharArray()) {
				alphabetsArr[ch-'a']++;
			}
		}
		for (int chCount : alphabetsArr) {
			if(chCount%words.length!=0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Consumer<Boolean> cons = System.out::println;
		var obj = new SolutionSaturday1130();
		cons.accept(obj.makeEqual(new String[] { "abc", "aabc", "bc" }));
		cons.accept(obj.makeEqual(new String[] { "ab", "a" }));
	}
}

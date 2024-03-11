package com.leetcode.dailypractice.year24.mar.week2;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/custom-sort-string/">Problem-Link</a>
 * 
 * 791. Custom Sort String
 * 
 * Medium Topics Companies
 * 
 * You are given two strings order and s. All the characters of order are unique
 * and were sorted in some custom order previously.
 * 
 * Permute the characters of s so that they match the order that order was
 * sorted. More specifically, if a character x occurs before a character y in
 * order, then x should occur before y in the permuted string.
 * 
 * Return any permutation of s that satisfies this property.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: order = "cba", s = "abcd"
 * 
 * Output: "cbad"
 * 
 * Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c"
 * should be "c", "b", and "a".
 * 
 * Since "d" does not appear in order, it can be at any position in the returned
 * string. "dcba", "cdba", "cbda" are also valid outputs.
 * 
 * 
 * Example 2:
 * 
 * Input: order = "bcafg", s = "abcd"
 * 
 * Output: "bcad"
 * 
 * Explanation: The characters "b", "c", and "a" from order dictate the order
 * for the characters in s. The character "d" in s does not appear in order, so
 * its position is flexible.
 * 
 * Following the order of appearance in order, "b", "c", and "a" from s should
 * be arranged as "b", "c", "a". "d" can be placed at any position since it's
 * not in order. The output "bcad" correctly follows this rule. Other
 * arrangements like "bacd" or "bcda" would also be valid, as long as "b", "c",
 * "a" maintain their order.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= order.length <= 26 1 <= s.length <= 200 order and s consist of lowercase
 * English letters. All the characters of order are unique.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 326.5K
 * Submissions 465.4K Acceptance Rate 70.2%
 */
public class SolutionMonday0311 {
	//Mine Solution
    public String customSortString(String order, String s) {
//    	int orderLen = order.length();
//    	char[] chOrder = new char[orderLen];
//    	for(int i=0; i<orderLen; i++) {
//    		chOrder[i]=order.charAt(i);
//    	}
    	int[] charCount = new int[26];
    	for(char ch: s.toCharArray()) {
    		charCount[ch-'a']++;
    	}
    	StringBuilder result = new StringBuilder();
    	for(int i=0; i<order.length(); i++) {
    		if(charCount[order.charAt(i)-'a']>0) {
    			result.append(getRepeatedChar(order.charAt(i), charCount[order.charAt(i)-'a']));
    			charCount[order.charAt(i)-'a'] = 0;
    		}
    	}
    	for(int i=0;i<26;i++) {
    		if(charCount[i]>0) {
    			result.append(getRepeatedChar((char) ('a'+i),charCount[i]));
    		}
    	}
    	return result.toString();
    }
    String getRepeatedChar(char ch, int count) {
    	StringBuilder res = new StringBuilder();
    	for(int i=0;i<count;i++) {
    		res.append(ch);
    	}
    	return res.toString();
    }
	public static void main(String[] args) {

		var obj = new SolutionMonday0311();

		System.out.println(obj.customSortString("cba","abcd"));
		System.out.println(obj.customSortString("bcafg","abcd"));

		// Custom Input
		System.out.println(obj.customSortString("sdf","abcdefghqrst"));
		System.out.println(obj.customSortString("abd","bbddaac"));

	}
}

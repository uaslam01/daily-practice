package com.leetcode.dailypractice.year24.apr.week1;

/**
 * <a href= "https://leetcode.com/problems/isomorphic-strings/description/">Problem-Link</a>
 *
 * Isomorphic-strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order
 * of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:q
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * <p>c
 *
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 *  <p>
 *
  <p>
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class SolutionTuesday0402 {
    //Best Solution
    public boolean isIsomorphic(String s, String t) {
        // Create arrays to store the frequency of characters in both strings
        int[] freqS = new int[200]; // Stores frequency of characters in string s
        int[] freqT = new int[200]; // Stores frequency of characters in string t

        // Get the length of both strings
        int len = s.length();

        // If the lengths of the two strings are different, they can't be isomorphic
        if(len != t.length()) {
            return false;
        }

        // Iterate through each character of the strings
        for(int i = 0; i < len; i++) {
            // Check if the frequency of the current character in string s
            // is different from the frequency of the corresponding character in string t
            if(freqS[s.charAt(i)] != freqT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }

            // Update the frequencies of characters in both strings
            freqS[s.charAt(i)] = i + 1; // Incrementing frequency of character in string s
            freqT[t.charAt(i)] = i + 1; // Incrementing frequency of character in string t
        }

        // If the loop completes without returning false, strings are isomorphic
        return true;
    }
}

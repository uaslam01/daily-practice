package com.leetcode.dailypractice.year23.oct.week4;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/ Longest
 * Palindromic Substring Medium 27.8K 1.6K Companies Given a string s, return
 * the longest palindromic
 * 
 * substring in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" Explanation: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: s = "cbbd" Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consist of only digits and English letters.
 */
public class SolutionFriday1027 {
	// Approach 1 using brute force mine
	public String longestPalindrome1(String s) {
		int len = s.length();
		String maxLenPalindromStr = "";
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				StringBuilder str = new StringBuilder(s.substring(i, j + 1));
				if (str.length() > maxLenPalindromStr.length() && str.toString().equals(str.reverse().toString())) {
					maxLenPalindromStr = str.toString();
				}
			}
		}
		return maxLenPalindromStr;
	}

	// Approach 1 using bracket one (mine)
	public String longestPalindrome(String s) {
		int len = s.length();
		int leftCur = 0;
		int rightCur = len - 1;
		String maxLenPalindromStr = "";
		while (leftCur <= rightCur) {
			if (s.charAt(leftCur) == s.charAt(rightCur)) {
				StringBuilder str = new StringBuilder(s.substring(leftCur, rightCur + 1));
				if (str.toString().equals(str.reverse().toString())) {
					return maxLenPalindromStr.length() > str.length() ? maxLenPalindromStr : str.toString();
				}
				// leftCur++;
			}
			if (s.charAt(leftCur + 1) == s.charAt(rightCur)) {
				leftCur++;
			} else if (s.charAt(leftCur) == s.charAt(rightCur - 1)) {
				rightCur--;
			} else {
				int nextRightChLen = rightCur - leftCur
						- s.substring(leftCur + 1, rightCur + 1).indexOf(s.charAt(rightCur)); // findNextPositionOfCh(s,s.charAt(rightCur));
				int nextleftChLen = rightCur - leftCur - (new StringBuilder(s.substring(leftCur, rightCur)).reverse())
						.toString().indexOf(s.charAt(leftCur));
				if (nextleftChLen > nextRightChLen) {
					StringBuilder str = new StringBuilder(s.substring(rightCur - nextRightChLen, rightCur + 1));
					if (str.length() > maxLenPalindromStr.length() && str.toString().equals(str.reverse().toString())) {
						maxLenPalindromStr = str.toString();
					}
					rightCur--;
				} else if (nextRightChLen > nextleftChLen) {
					StringBuilder str = new StringBuilder(s.substring(leftCur, nextleftChLen + 1));
					if (str.length() > maxLenPalindromStr.length() && str.toString().equals(str.reverse().toString())) {
						maxLenPalindromStr = str.toString();
					}
					leftCur++;
				} else {
					String s1 = longestPalindrome(s.substring(leftCur + 1, rightCur + 1));
					String s2 = longestPalindrome(s.substring(leftCur, rightCur));
					return s1.length() >= s2.length() ? s1 : s2;
				}
			}

		}
		return maxLenPalindromStr;
	}

	// Remote Solution
	public String longestPalindromeSolution(String s) {
		// Check if the input string is empty, return an empty string if so
		if (s.isEmpty())
			return "";

		// Initialize variables to store the indices of the longest palindrome found
		int[] longestPalindromeIndices = { 0, 0 };

		// Loop through the characters in the input string
		for (int i = 0; i < s.length(); ++i) {
			// Find the indices of the longest palindrome centered at character i
			int[] currentIndices = expandAroundCenter(s, i, i);

			// Compare the length of the current palindrome with the longest found so far
			if (currentIndices[1] - currentIndices[0] > longestPalindromeIndices[1] - longestPalindromeIndices[0]) {
				// Update the longest palindrome indices if the current one is longer
				longestPalindromeIndices = currentIndices;
			}

			// Check if there is a possibility of an even-length palindrome centered at
			// character i and i+1
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				// Find the indices of the longest even-length palindrome centered at characters
				// i and i+1
				int[] evenIndices = expandAroundCenter(s, i, i + 1);

				// Compare the length of the even-length palindrome with the longest found so
				// far
				if (evenIndices[1] - evenIndices[0] > longestPalindromeIndices[1] - longestPalindromeIndices[0]) {
					// Update the longest palindrome indices if the even-length one is longer
					longestPalindromeIndices = evenIndices;
				}
			}
		}

		// Extract and return the longest palindrome substring using the indices
		return s.substring(longestPalindromeIndices[0], longestPalindromeIndices[1] + 1);
	}

	// Helper function to find and return the indices of the longest palindrome
	// extended from s[i..j] (inclusive) by expanding around the center
	private int[] expandAroundCenter(final String s, int i, int j) {
		// Expand the palindrome by moving outward from the center while the characters
		// match
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--; // Move the left index to the left
			j++; // Move the right index to the right
		}
		// Return the indices of the longest palindrome found
		return new int[] { i + 1, j - 1 };
	}

	public static void main(String[] args) {
//		System.out.println(new SolutionFriday1028().longestPalindrome("afffa"));
//		System.out.println(new SolutionFriday1028().longestPalindrome("a"));
//		System.out.println(new SolutionFriday1028().longestPalindrome("afffad"));
//		System.out.println(new SolutionFriday1028().longestPalindrome("dadffffda"));
//
//		System.out.println(new SolutionFriday1028().longestPalindrome("dadffffsa"));
		System.out.println(new SolutionFriday1027().longestPalindrome("aacabdkacaa"));
		System.out.println(new SolutionFriday1027().longestPalindrome("bacabab"));

	}
}

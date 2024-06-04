package com.leetcode.dailypractice.year24.jun.week1;


/**
 * <pre>
 * <a href= "https://leetcode.com/problems/longest-palindrome/">Problem-Link</a>
 *
409. Longest Palindrome

Solved
Easy
Topics
Companies

Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 

Example 1:

Input: s = "abccccdd"

Output: 7

Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.


Example 2:

Input: s = "a"

Output: 1

Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

Seen this question in a real interview before?
1/5
Yes
No
Accepted
751.2K
Submissions
1.4M
Acceptance Rate
55.0%
 */
public class SolutionTueday0406 {
	// Mine Solution Best Solution
    public int longestPalindrome(String s) {
        int[] charArr = new int[58];

        boolean isOddCharPresent = false;

        for (char ch : s.toCharArray()) {
            charArr[ch - 'A']++;
            
        }
        int res = 0;
        for (int i = 0; i < 58; i++) {
            if (charArr[i] % 2 == 0) {
                res += charArr[i];
            } else {
                res += charArr[i] - 1;
                isOddCharPresent = true;
            }

        }
        if (isOddCharPresent)
            res++;
        return res;
    }

	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionTueday0406();

		cons.accept(obj.longestPalindrome("ca"));
		cons.accept(obj.longestPalindrome("cabaabac"));
		cons.accept(obj.longestPalindrome("aabccabba"));
		System.out.println("---");
		// Custom Input
		cons.accept(obj.longestPalindrome("c"));
		cons.accept(obj.longestPalindrome("cc"));
		cons.accept(obj.longestPalindrome("ccc"));

		cons.accept(obj.longestPalindrome("cac"));
		cons.accept(obj.longestPalindrome("caac"));
		cons.accept(obj.longestPalindrome("aadaad"));

	}
}

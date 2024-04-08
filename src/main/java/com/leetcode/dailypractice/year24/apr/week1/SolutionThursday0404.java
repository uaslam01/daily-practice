package com.leetcode.dailypractice.year24.apr.week1;

/**
 * <a href= "https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/">Problem-Link</a>
 * <p>
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 * Maximum-nesting-depth-of-the-parentheses
 * <p>
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * <p>
 * <p>
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS represented as string s, return the nesting depth of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
 * It is guaranteed that parentheses expression s is a VPS.
 */
public class SolutionThursday0404 {
    //Best Solution
    public int maxDepth(String s) {
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            max = Math.max(count, max);
            if (s.charAt(i) == ')') count--;
        }
        return max;
    }

    //Best Solution2
    public int maxDepth1(String s) {
        int ans = 0;
        int temp = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {

                temp++;
            }
            if (i == ')') {
                temp--;
            }
            ans = temp > ans ? temp : ans;

        }
        return ans;
    }
}

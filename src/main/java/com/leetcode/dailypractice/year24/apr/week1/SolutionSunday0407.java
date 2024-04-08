package com.leetcode.dailypractice.year24.apr.week1;

/**
 * <a href= "https://leetcode.com/problems/valid-parenthesis-string/description/">Problem-Link</a>
 * Valid-parenthesis-string
 * <p>
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * <p>
 * The following rules define a valid string:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "(*)"
 * Output: true
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(*))"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s[i] is '(', ')' or '*'.
 */
public class SolutionSunday0407 {
    public boolean checkValidString(String s) {
        int leftCount = 0, rightCount = 0;

        for (char c : s.toCharArray()) {
            leftCount += c == '(' ? 1 : -1;
            rightCount += c == ')' ? -1 : 1;

            if (rightCount < 0) {
                break;
            }

            leftCount = Math.max(leftCount, 0);
        }

        return leftCount == 0;
    }

}

package com.leetcode.dailypractice.year24.apr.week1;

import java.util.Stack;

/**
 * Make-the-string-great:
 * <p>
 * <a href= "https://leetcode.com/problems/make-the-string-great/description/">Problem-Link</a>
 *
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: We have many possible scenarios, and all lead to the same answer. For example:
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: s = "s"
 * Output: "s"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 */
public class SolutionFriday0405 {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    //Best Solution2
    public String makeGood1(String s) {
        if(s.isEmpty() || s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            //Push if Top is not eith Upper/Lower case of current
            //Else Pop
            if(sb.isEmpty()) {
                sb.append(s.charAt(i));
                continue;
            }

            char top = sb.charAt(sb.length() - 1);
            char current = s.charAt(i);
            if(Math.abs(top - current) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}

package com.leetcode.dailypractice.year23.dec.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/largest-3-same-digit-number-in-string/">Problem-Link</a>
 * 2264. Largest 3-Same-Digit Number in String Easy 938 42 Companies You are
 * given a string num representing a large integer. An integer is good if it
 * meets the following conditions:
 * 
 * It is a substring of num with length 3. It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such
 * integer exists.
 * 
 * Note:
 * 
 * A substring is a contiguous sequence of characters within a string. There may
 * be leading zeroes in num or a good integer.
 * 
 * 
 * Example 1:
 * 
 * Input: num = "6777133339" Output: "777" Explanation: There are two distinct
 * good integers: "777" and "333". "777" is the largest, so we return "777".
 * Example 2:
 * 
 * Input: num = "2300019" Output: "000" Explanation: "000" is the only good
 * integer. Example 3:
 * 
 * Input: num = "42352338" Output: "" Explanation: No substring of length 3
 * consists of only one unique digit. Therefore, there are no good integers.
 * 
 * 
 * Constraints:
 * 
 * 3 <= num.length <= 1000 num only consists of digits.
 * 
 */
public class SolutionMonday1204 {
	//Mine
	public String largestGoodInteger1(String num) {
		return null;
	}
	//Best Solution
	public String largestGoodInteger(String num) {
        int target = -1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                int current = Integer.parseInt(num.substring(i, i + 3));
                if (current > target) {
                    target = current;
                }
            }
        }
        if (target != -1) {
            if (target == 0) {
                return target + "00";
            }
            return Integer.toString(target);
        }
        return "";
    }
	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new SolutionMonday1204();
		cons.accept(obj.largestGoodInteger("6777133339"));
		cons.accept(obj.largestGoodInteger("2300019"));
		cons.accept(obj.largestGoodInteger("42352338"));

	}
}

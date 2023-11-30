package com.leetcode.dailypractice.year23.nov.week5;

import java.util.function.Consumer;

/**
 * 1611. Minimum One Bit Operations to Make Integers Zero Hard 731 805 Companies
 * Given an integer n, you must transform it into 0 using the following
 * operations any number of times:
 * 
 * Change the rightmost (0th) bit in the binary representation of n. Change the
 * ith bit in the binary representation of n if the (i-1)th bit is set to 1 and
 * the (i-2)th through 0th bits are set to 0. Return the minimum number of
 * operations to transform n into 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: 2 Explanation: The binary representation of 3 is "11".
 * "11" -> "01" with the 2nd operation since the 0th bit is 1. "01" -> "00" with
 * the 1st operation. Example 2:
 * 
 * Input: n = 6 Output: 4 Explanation: The binary representation of 6 is "110".
 * "110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through
 * 0th bits are 0. "010" -> "011" with the 1st operation. "011" -> "001" with
 * the 2nd operation since the 0th bit is 1. "001" -> "000" with the 1st
 * operation.
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 109 Accepted 41.1K Submissions 55.8K Acceptance Rate 73.7%
 */
public class SolutionThursday1130 {
	// Best Solution
	public int minimumOneBitOperations(int n) {
		int ans = 0, f = 0;

		for (int i = 31; i >= 0; i--) {
			if (((n >> i) & 1) == 1) {
				if (f == 0) {
					ans = ans + ((1 << (i + 1))) - 1;
					f = 1;
				} else {
					ans = ans - ((1 << (i + 1)) - 1);
					f = 0;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionThursday1130();
		cons.accept(obj.minimumOneBitOperations(6));
		cons.accept(obj.minimumOneBitOperations(3));

	}
}

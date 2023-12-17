package com.leetcode.dailypractice.year23.dec.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/calculate-money-in-leetcode-bank/">Problem-Link</a>
 * 1716. Calculate Money in Leetcode Bank Easy 1.4K 46 Companies
 * 
 * Hercy wants to save money for his first car. He puts money in the Leetcode
 * bank every day.
 * 
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday
 * to Sunday, he will put in $1 more than the day before. On every subsequent
 * Monday, he will put in $1 more than the previous Monday. Given n, return the
 * total amount of money he will have in the Leetcode bank at the end of the nth
 * day.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4 Output: 10 Explanation: After the 4th day, the total is 1 + 2 +
 * 3 + 4 = 10. Example 2:
 * 
 * Input: n = 10 Output: 37 Explanation: After the 10th day, the total is (1 + 2
 * + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy
 * only puts in $2. Example 3:
 * 
 * Input: n = 20 Output: 96 Explanation: After the 20th day, the total is (1 + 2
 * + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8)
 * = 96.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000 Accepted 142.9K Submissions 183K Acceptance Rate 78.1%
 */
public class SolutionWednesday1206 {
	// Mine
	public int totalMoney1(int n) {
		return 0;
	}

	// Best Solution
	public int totalMoney(int n) {
		int weeks = n / 7;
		int days = n % 7;
		int lowest = 28;
		int highest = 28 + 7 * (weeks - 1);
		int total = (lowest + highest) * weeks / 2;

		int monday = weeks + 1;
		for (int i = 0; i < days; i++) {
			total += i + monday;
		}

		return total;
	}

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday1206();
		cons.accept(obj.totalMoney(4));
		cons.accept(obj.totalMoney(10));
		cons.accept(obj.totalMoney(20));

	}
}

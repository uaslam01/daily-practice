package com.leetcode.dailypractice.year23.dec.week3;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/buy-two-chocolates/">Problem-Link</a>
 * 2706. Buy Two Chocolates
 * 
 * Easy 752 48 Companies
 * 
 * You are given an integer array prices representing the prices of various
 * chocolates in a store. You are also given a single integer money, which
 * represents your initial amount of money.
 * 
 * You must buy exactly two chocolates in such a way that you still have some
 * non-negative leftover money. You would like to minimize the sum of the prices
 * of the two chocolates you buy.
 * 
 * Return the amount of money you will have leftover after buying the two
 * chocolates. If there is no way for you to buy two chocolates without ending
 * up in debt, return money. Note that the leftover must be non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [1,2,2], money = 3 Output: 0 Explanation: Purchase the
 * chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0
 * units of money afterwards. Thus, we return 0.
 * 
 * Example 2:
 * 
 * Input: prices = [3,2,3], money = 3 Output: 3 Explanation: You cannot buy 2
 * chocolates without going in debt, so we return 3.
 * 
 * 
 * Constraints:
 * 
 * 2 <= prices.length <= 50 1 <= prices[i] <= 100 1 <= money <= 100 Accepted
 * 118.6K Submissions 168.9K Acceptance Rate 70.3% Seen this question in a real
 * interview before? 1/4
 */
public class SolutionWednesday1220 {
	//Mine Solution
	public int buyChoco1(int[] prices, int money) {
		int firstSmall = Integer.MAX_VALUE;
		int secondSmall = Integer.MAX_VALUE;

		for (int n : prices) {
			if (n < firstSmall) {
				secondSmall = firstSmall;
				firstSmall = n;
			} else if (n < secondSmall) {
				secondSmall = n;
			}

			
		}
		return (money-secondSmall-firstSmall)<0?money:(money-secondSmall-firstSmall);
	}
	//Best Solution
    public int buyChoco(int[] prices, int money) {
        // Assume minimum and second minimum
        int minimum = Math.min(prices[0], prices[1]);
        int secondMinimum = Math.max(prices[0], prices[1]);

        // Iterate over the remaining elements
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < minimum) {
                secondMinimum = minimum;
                minimum = prices[i];
            } else if (prices[i] < secondMinimum) {
                secondMinimum = prices[i];
            }
        }

        // Minimum Cost
        int minCost = minimum + secondMinimum;

        // We can buy chocolates only if we have enough money
        if (minCost <= money) {
            // Return the Amount of Money Left
            return money - minCost;
        }

        // We cannot buy chocolates. Return the initial amount of money
        return money;
    }


	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday1220();
		cons.accept(obj.buyChoco(new int[] { 1, 2, 2 }, 3));
		cons.accept(obj.buyChoco(new int[] { 3, 2, 3 }, 3));

	}

}

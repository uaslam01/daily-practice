package com.leetcode.dailypractice.year24.mar.week2;

import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-the-pivot-integer/">Problem-Link</a>
 *
 * 2485. Find the Pivot Integer
 * 
 * Easy Topics Companies Hint
 * 
 * Given a positive integer n, find the pivot integer x such that:
 * 
 * The sum of all elements between 1 and x inclusively equals the sum of all
 * elements between x and n inclusively.
 * 
 * Return the pivot integer x. If no such integer exists, return -1. It is
 * guaranteed that there will be at most one pivot index for the given input.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 8
 * 
 * Output: 6
 * 
 * Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8
 * = 21.
 * 
 * 
 * Example 2:
 * 
 * Input: n = 1
 * 
 * Output: 1
 * 
 * Explanation: 1 is the pivot integer since: 1 = 1.
 * 
 * 
 * Example 3:
 * 
 * Input: n = 4
 * 
 * Output: -1
 * 
 * Explanation: It can be proved that no such integer exist.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 174K
 * Submissions 206.9K Acceptance Rate 84.1%
 */
public class SolutionWednesday0313 {
    //Mine Solution
	public int pivotInteger1(int n) {
		int pivotInt = -1;
		int count = 1;
		int totalNSum = (n*n+n)/2;
		while(count <= n) {
			int firstHalfSum = (count*count+count)/2;
			int secHalfSum = totalNSum-firstHalfSum+count;
			if(firstHalfSum==secHalfSum) {
				pivotInt = count;
				break;
			} else if (firstHalfSum>secHalfSum) {
				break;
			}
			count++;
		}
        return pivotInt;
    }
	//Best Solution
	//If a given number is perfect square, then sq root of this number, means that sum of all integers set till the answer 
	//and after the answer till the given number is always equal
    public int pivotInteger(int n) {
        int y = n*(n+1)/2;
        int x = (int)Math.sqrt(y);
        if(x*x==y) return x;
        else return -1;
    }
	public static void main(String[] arg) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionWednesday0313();
		cons.accept(obj.pivotInteger(8));
		cons.accept(obj.pivotInteger(1));
		cons.accept(obj.pivotInteger(4));

		//Custom Input
		cons.accept(obj.pivotInteger(2));
	}
}


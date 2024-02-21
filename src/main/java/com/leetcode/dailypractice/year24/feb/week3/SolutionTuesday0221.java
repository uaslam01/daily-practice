package com.leetcode.dailypractice.year24.feb.week3;

import java.util.function.Consumer;

/**
  * <pre>
 * <a href= "https://leetcode.com/problems/bitwise-and-of-numbers-range/">Problem-Link</a>
 *
 * 
 * 201. Bitwise AND of Numbers Range

Medium
Topics
Companies

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.


 

Example 1:

Input: left = 5, right = 7

Output: 4


Example 2:

Input: left = 0, right = 0

Output: 0


Example 3:

Input: left = 1, right = 2147483647

Output: 0
 


Constraints:

0 <= left <= right <= 231 - 1


Seen this question in a real interview before?
1/4
Yes
No
Accepted
340.5K
Submissions
750.3K
Acceptance Rate
45.4%*/
public class SolutionTuesday0221 {
	//Mine Solution
    public int rangeBitwiseAnd(int left, int right) {
    	if(left==0)
    		return 0;
    	if(left==right)
    		return left;
    	int nearestLog2NumberFromRight = (int)Math.floor(Math.log(right)/Math.log(2));
    	int nearestLog2NumberFromLeft = (int)Math.floor(Math.log(left)/Math.log(2));
    	if(nearestLog2NumberFromLeft!=nearestLog2NumberFromRight)
    		return 0;
    	int res = left++;
    	for(;left<right;left++) {
    		res&=left;
    	}
    	
        return res&right;
    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionTuesday0221();
		//Time Limit Exceeds
		cons.accept(obj.rangeBitwiseAnd(2147483647,2147483647));

		cons.accept(obj.rangeBitwiseAnd(2147483646,2147483647));

		cons.accept(obj.rangeBitwiseAnd(5,7));
		cons.accept(obj.rangeBitwiseAnd(0,0));
		cons.accept(obj.rangeBitwiseAnd(1,2147483647));


	}

}
package com.leetcode.dailypractice.year24.feb.week3;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/power-of-two/">Problem-Link</a>
 *
 * 231. Power of Two Easy Topics Companies Given an integer n, return true if it
 * is a power of two. Otherwise, return false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true Explanation: 20 = 1 Example 2:
 * 
 * Input: n = 16 Output: true Explanation: 24 = 16 Example 3:
 * 
 * Input: n = 3 Output: false
 * 
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.2M
 * Submissions 2.5M Acceptance Rate 47.4% 231. Power of Two
 * 
 * Easy Topics Companies
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true
 * 
 * Explanation: 20 = 1
 * 
 * 
 * Example 2:
 * 
 * Input: n = 16 Output: true
 * 
 * Explanation: 24 = 16
 * 
 * 
 * Example 3:
 * 
 * Input: n = 3 Output: false
 * 
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.2M
 * Submissions 2.5M Acceptance Rate 47.4%
 */
public class SolutionMonday0219 {
	//Mine Solution
    public boolean isPowerOfTwo1(int n) {
        if(n==1)
        	return true;
        if(n==0)
        	return false;
        if(n%2!=0)
        	return false;
        return isPowerOfTwo(n/2);
    }
    
    //Best Solution
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
    
    
	public static void main(String[] args) {
		Consumer<Boolean> cons = System.out::println;
		var obj = new SolutionMonday0219();
		//Wrong Output stack over flow error, added zero check
		cons.accept(obj.isPowerOfTwo(0));
		
		cons.accept(obj.isPowerOfTwo(1));
		cons.accept(obj.isPowerOfTwo(16));
		cons.accept(obj.isPowerOfTwo(3));
		

	}
}

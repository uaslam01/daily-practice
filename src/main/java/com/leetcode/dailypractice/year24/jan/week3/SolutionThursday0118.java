package com.leetcode.dailypractice.year24.jan.week3;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/climbing-stairs/">Problem-Link</a>
 * 
 * 
 * 70. Climbing Stairs
 * 
 * Easy Topics Companies Hint
 * 
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * 
 * Output: 2
 * 
 * 
 * Explanation: There are two ways to climb to the top. 1. 1 step + 1 step 2. 2
 * steps
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * 
 * Output: 3
 * 
 * 
 * Explanation: There are three ways to climb to the top. 1. 1 step + 1 step + 1
 * step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 45
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 3M
 * Submissions 5.7M Acceptance Rate 52.8%
 */
public class SolutionThursday0118 {
	//Mine/Best Solution 100% beats
	//Time limit exceeds
	public int climbStairs1(int n) {
        if(n<0)
        	return 0;
        if(n==0)
        	return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
	//Memoization Mine Solution Top to Down
	public int climbStairs(int n) {
		int[] mem = new int[n];
        return dpSolution(n, mem);
    }
	public int dpSolution(int n, int[] mem) {
		if(n<0)
			return 0;
        if(n==0)
        	return 1;
		if(mem[n-1]!=0)
			return mem[n-1];
		mem[n-1] = dpSolution(n-1, mem)+dpSolution(n-2, mem);
		return mem[n-1];
	}

	public static void main(String[] args) {
		var obj = new SolutionThursday0118();
		System.out.println(obj.climbStairs(1));
		System.out.println(obj.climbStairs(2));
		System.out.println(obj.climbStairs(3));
		System.out.println(obj.climbStairs(4));
		System.out.println(obj.climbStairs(5));
	}
}

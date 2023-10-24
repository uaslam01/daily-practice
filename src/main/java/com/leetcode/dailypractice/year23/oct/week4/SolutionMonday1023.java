package com.leetcode.dailypractice.year23.oct.week4;

/*Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?*/
public class SolutionMonday1023 {
	public static void main(String[] args) {
		System.out.println(new SolutionMonday1023().isPowerOfFour(16));
		System.out.println(new SolutionMonday1023().isPowerOfFour(5));
		System.out.println(new SolutionMonday1023().isPowerOfFour(1));
	}
	public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        if(n>0){
            int i = 0;
            int res = 1;
            while(res<n){
                i++;
                res=(int)Math.pow(4.0,i);
            }
            return n==res&&n%4==0;
        }  else {
            return false;
        }
    }
}

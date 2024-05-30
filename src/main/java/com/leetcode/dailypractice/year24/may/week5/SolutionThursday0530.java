package com.leetcode.dailypractice.year24.may.week5;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/">
 * Problem-Link</a>
 * 
1404. Number of Steps to Reduce a Number in Binary Representation to One

Medium
Topics
Companies
Hint

Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.
If the current number is odd, you have to add 1 to it.
It is guaranteed that you can always reach one for all test cases.


Example 1:

Input: s = "1101"

Output: 6

Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1.  


Example 2:

Input: s = "10"

Output: 1

Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.  


Example 3:

Input: s = "1"

Output: 0
 

Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'

Seen this question in a real interview before?
1/5
Yes
No
Accepted
83.6K
Submissions
143.3K
Acceptance Rate
58.3%
 **/
public class SolutionThursday0530 {
	//Mine Solution works only for small string
    public int numSteps1(String s) {
        int num = Integer.parseInt(s, 2);
        int steps = 0;
        while(num>1) {
        	int res = num&1;
        	if(res>0) 
        		num++;
        	else 
        		num/=2;
        	steps++;
        }
        return steps;
    }
    public int numSteps(String s) {
        int num = Integer.parseInt(s, 2);
        int len = s.length();
        int steps = len-1;

        for(int i = len -1; i>0;i--) {
        	if(s.charAt(i)=='1') {
        		steps+=2;
        	}
        }
        return steps;
    }
    
    public static void main(String[] args) {
		var obj = new SolutionThursday0530();
		System.out.println(obj.numSteps("1101"));
		System.out.println(obj.numSteps("10"));
		System.out.println(obj.numSteps("1"));

		//Custom Input
		System.out.println(obj.numSteps("10"));
		System.out.println(obj.numSteps("11"));
		System.out.println(obj.numSteps("100"));
		System.out.println(obj.numSteps("101"));
		System.out.println(obj.numSteps("110"));
		System.out.println(obj.numSteps("111"));
		System.out.println(obj.numSteps("1000"));
		System.out.println(obj.numSteps("1001"));

	}
}

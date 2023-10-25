package com.leetcode.dailypractice.year23.oct.week4;

/**
 https://leetcode.com/problems/k-th-symbol-in-grammar/
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1
*/
public class SolutionWednesday1025 {
    //Going to use bit negatiion operation, because on close deep look, getting prevBinary+revert(prevBinary)
	//Memory Constraint failed
	public int kthGrammarMine(int n, int k) {
		StringBuilder str = new StringBuilder();
		str.append('0');
		for(int i=1;i<n;i++) {
			String temp = str.toString();
			StringBuilder revertTemp = new StringBuilder();
			for(int j=0;j<temp.length();j++) {
				revertTemp.append(temp.charAt(j)=='0'?'1':'0');
			}
			str.append(revertTemp);
		}
        return str.toString().charAt(k-1)-'0';
    }
	//Approach 1 
	public int kthGrammar1(int n, int k) {
        if (n == 1) return 0;
        int length = 1 << (n - 2);
        if (k <= length) return kthGrammar(n - 1, k);
        else return 1 - kthGrammar(n - 1, k - length);
    }
	//Approach by counting bits of k-1 number
	public int kthGrammar(int n, int k) {
        String binary = Integer.toBinaryString(k-1);
        long onesCount = binary.chars().filter(x->x=='1').count();
        return onesCount%2==0?0:1;
    }
	public static void main(String[] args) {
		System.out.println(new SolutionWednesday1025().kthGrammar(2, 2));
		System.out.println(new SolutionWednesday1025().kthGrammar(2, 1));
		System.out.println(new SolutionWednesday1025().kthGrammar(1, 1));

		System.out.println(new SolutionWednesday1025().kthGrammar(3, 4));
		System.out.println(new SolutionWednesday1025().kthGrammar(4, 8));
		System.out.println(new SolutionWednesday1025().kthGrammar(6, 16));

		
	}
}

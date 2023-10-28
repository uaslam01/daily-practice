package com.leetcode.dailypractice.year23.oct.week4;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Count Vowels Permutation
Hard
3K
205
Companies
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 * */
public class SolutionSaturday1028 {
	//Mine
    public int countVowelPermutationMine(int n) {
    	return 0;
    }
    
    //Top Solution
    public int countVowelPermutation(int n) {
        final int MOD = (int) 1e9 + 7;
        long a_count = 1, e_count = 1, i_count = 1, o_count = 1, u_count = 1;
        
        for (int i = 1; i < n; ++i) {
            long new_a = (e_count + i_count + u_count) % MOD;
            long new_e = (a_count + i_count) % MOD;
            long new_i = (e_count + o_count) % MOD;
            long new_o = i_count;
            long new_u = (i_count + o_count) % MOD;
            
            a_count = new_a;
            e_count = new_e;
            i_count = new_i;
            o_count = new_o;
            u_count = new_u;
        }
        
        long total = (a_count + e_count + i_count + o_count + u_count) % MOD;
        
        return (int) total;
    }
    
	public static void main(String[] args) {
		System.out.println(new SolutionSaturday1028().countVowelPermutation(5));
	}

}

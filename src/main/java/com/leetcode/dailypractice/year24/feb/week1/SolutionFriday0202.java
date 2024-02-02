package com.leetcode.dailypractice.year24.feb.week1;

import java.util.ArrayList;
import java.util.List;

/**
  * <pre>
 * <a href=
 * "https://leetcode.com/problems/sequential-digits/">Problem-Link</a> 
 * 
 * 1291. Sequential Digits

Solved
Medium
Topics
Companies
Hint


An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 


Example 1:


Input: low = 100, high = 300

Output: [123,234]

Example 2:


Input: low = 1000, high = 13000

Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9

Seen this question in a real interview before?
1/4
Yes
No
Accepted
157.6K
Submissions
245.3K
Acceptance Rate
64.2%

 * */
public class SolutionFriday0202 {
	//Best Solution
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int num = Integer.parseInt(s.substring(i, j + 1));

                if (num > high) break;
                if (low <= num) res.add(num);
            }
        }

        res.sort(null);
        return res;        
    }
	public static void main(String[] args) {
		var obj = new SolutionFriday0202();
		System.out.println(obj.sequentialDigits(100, 300));
		System.out.println("----");

		System.out.println(obj.sequentialDigits(1000, 13000));
		System.out.println("----");

	}
}

package com.leetcode.dailypractice.year24.may.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-the-safest-path-in-a-grid/">
 * Problem-Link</a>
 * 
 * 3075. Maximize Happiness of Selected Children
 * 
 * Medium Topics Companies Hint
 * 
 * You are given an array happiness of length n, and a positive integer k.
 * 
 * There are n children standing in a queue, where the ith child has happiness
 * value happiness[i]. You want to select k children from these n children in k
 * turns. In each turn, when you select a child, the happiness value of all the
 * children that have not been selected till now decreases by 1. Note that the
 * happiness value cannot become negative and gets decremented only if it is
 * positive. Return the maximum sum of the happiness values of the selected
 * children you can achieve by selecting k children.
 * 
 * 
 * Example 1:
 * 
 * <img src="example1.png" width="50%"/>
 * 
 * 
 * Input: happiness = [1,2,3], k = 2 Output: 4 Explanation: We can pick 2
 * children in the following way: - Pick the child with the happiness value ==
 * 3. The happiness value of the remaining children becomes [0,1]. - Pick the
 * child with the happiness value == 1. The happiness value of the remaining
 * child becomes [0]. Note that the happiness value cannot become less than 0.
 * The sum of the happiness values of the selected children is 3 + 1 = 4.
 * 
 * 
 * Example 2:
 * 
 * <img src="example2.png" width="50%"/>
 * 
 * Input: happiness = [1,1,1,1], k = 2 Output: 1 Explanation: We can pick 2
 * children in the following way: - Pick any child with the happiness value ==
 * 1. The happiness value of the remaining children becomes [0,0,0]. - Pick the
 * child with the happiness value == 0. The happiness value of the remaining
 * child becomes [0,0]. The sum of the happiness values of the selected children
 * is 1 + 0 = 1.
 * 
 * 
 * Example 3:
 * 
 * <img src="example3.png" width="50%"/>
 * 
 * Input: happiness = [2,3,4,5], k = 1 Output: 5 Explanation: We can pick 1
 * child in the following way: - Pick the child with the happiness value == 5.
 * The happiness value of the remaining children becomes [1,2,3]. The sum of the
 * happiness values of the selected children is 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n == happiness.length <= 2 * 105 1 <= happiness[i] <= 108 1 <= k <= n
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 76.2K
 * Submissions 150.1K Acceptance Rate 50.7%
 **/

public class SolutionThursday0515 {
	// Mine Solution /Best Solution 1
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        return 0;
    }

	public static void main(String[] arg) {
		var obj = new SolutionThursday0515();
		List<List<Integer>> list = new ArrayList<>();

		System.out.println(obj.maximumSafenessFactor(list));

	}
}

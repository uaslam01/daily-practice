package com.leetcode.dailypractice.year23.oct.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Binary Trees With Factors
 * https://leetcode.com/problems/binary-trees-with-factors/ Medium 2.6K 192
 * Companies Given an array of unique integers, arr, where each integer arr[i]
 * is strictly greater than 1.
 * 
 * We make a binary tree using these integers, and each number may be used for
 * any number of times. Each non-leaf node's value should be equal to the
 * product of the values of its children.
 * 
 * Return the number of binary trees we can make. The answer may be too large so
 * return the answer modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,4] Output: 3 Explanation: We can make these trees: [2], [4],
 * [4, 2, 2] Example 2:
 * 
 * Input: arr = [2,4,5,10] Output: 7 Explanation: We can make these trees: [2],
 * [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 2 <= arr[i] <= 109 All the values of arr are unique.
 */
public class SolutionThursday1026 {
	// Remote
	// I should use set instead of map
	// Use dp for storing factors of already processed number

	private static final int MOD = 1000000007;

	public int numFactoredBinaryTrees(int[] arr) {
		Arrays.sort(arr);
		Set<Integer> s = new HashSet<>();
		for (int x : arr)
			s.add(x);

		Map<Integer, Integer> dp = new HashMap<>();
		for (int x : arr)
			dp.put(x, 1);

		for (int i : arr) {
			for (int j : arr) {
				if (j > Math.sqrt(i))
					break;
				if (i % j == 0 && s.contains(i / j)) {
					long temp = (long) dp.get(j) * dp.get(i / j);
					dp.put(i, (int) ((dp.get(i) + (i / j == j ? temp : temp * 2)) % MOD));
				}
			}
		}

		int result = 0;
		for (int val : dp.values()) {
			result = (result + val) % MOD;
		}
		return result;
	}

	// Mine
	public int numFactoredBinaryTreesMine(int[] arr) {
		int count = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (map.containsKey(arr[i] * arr[j])) {
					int result = arr[i] * arr[j];
					while (map.containsKey(result)) {
						count = (count + 1) % 1_000_000_007;
						result = result * result;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new SolutionThursday1026().numFactoredBinaryTrees(new int[] { 2, 4 }));
		System.out.println(new SolutionThursday1026().numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));

	}

}

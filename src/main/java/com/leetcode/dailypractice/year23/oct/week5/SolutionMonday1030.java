package com.leetcode.dailypractice.year23.oct.week5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/ Sort
 * Integers by The Number of 1 Bits Easy 2.3K 111 Companies You are given an
 * integer array arr. Sort the integers in the array in ascending order by the
 * number of 1's in their binary representation and in case of two or more
 * integers have the same number of 1's you have to sort them in ascending
 * order.
 * 
 * Return the array after sorting it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [0,1,2,3,4,5,6,7,8] Output: [0,1,2,4,8,3,5,6,7] Explantion: [0]
 * is the only integer with 0 bits. [1,2,4,8] all have 1 bit. [3,5,6] have 2
 * bits. [7] has 3 bits. The sorted array by bits is [0,1,2,4,8,3,5,6,7] Example
 * 2:
 * 
 * Input: arr = [1024,512,256,128,64,32,16,8,4,2,1] Output:
 * [1,2,4,8,16,32,64,128,256,512,1024] Explantion: All integers have 1 bit in
 * the binary representation, you should just sort them in ascending order.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 500 0 <= arr[i] <= 104
 */
public class SolutionMonday1030 {
	public int[] sortByBits(int[] arr) {
		// Convert the input integer array to Integer objects for sorting
		Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		// Create a custom comparator to sort by bit count and then numerically
		Comparator<Integer> comparator = new BitCountComparator();

		// Sort the array using the custom comparator
		Arrays.sort(integerArr, comparator);

		// Convert the sorted array back to primitive integers
		int[] sortedArr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();

		return sortedArr;
	}

	public static void main(String[] args) {
		Arrays.stream(new SolutionMonday1030().sortByBits(new int[] {0,1,2,3,4,5,6,7,8 })).forEach(System.out::print);
		System.out.println("");
		Arrays.stream(new SolutionMonday1030().sortByBits(new int[] { 1024,512,256,128,64,32,16,8,4,2,1 })).forEach(System.out::print);
	}
}

class BitCountComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		// Compare based on the count of set bits (1s) in the binary representation
		int bitCountA = Integer.bitCount(a);
		int bitCountB = Integer.bitCount(b);

		if (bitCountA == bitCountB) {
			// If bit counts are the same, compare numerically
			return a - b;
		} else {
			// Sort by the number of set bits in ascending order
			return bitCountA - bitCountB;
		}
	}
}
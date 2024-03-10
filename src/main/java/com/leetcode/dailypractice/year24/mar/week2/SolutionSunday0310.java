package com.leetcode.dailypractice.year24.mar.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/intersection-of-two-arrays/">Problem-Link</a>
 * 
 * 349. Intersection of Two Arrays
 * 
 * Easy Topics Companies
 * 
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * 
 * Output: [2]
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 
 * Output: [9,4]
 * 
 * Explanation: [4,9] is also accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 1000 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.1M
 * Submissions 1.5M Acceptance Rate 73.7%
 */
public class SolutionSunday0310 {
	// Works if arrays are sorted
	public int[] intersection12(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		Set<Integer> set = new HashSet<>();
		int ith = 0;
		int jth = 0;
		for (int i = 0; ith < len1 && jth < len2; i++) {
			if (nums1[ith] == nums2[jth]) {
				set.add(nums1[ith]);
				ith++;
				jth++;
			} else if (nums1[ith] < nums2[jth]) {
				ith++;
			} else {
				jth++;
			}
		}
		return set.stream().mapToInt(x -> x).toArray();
	}

	// Mine Solution
	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}
		Set<Integer> set2 = new HashSet<>();
		for (int num : nums2) {
			set2.add(num);
		}
		set1.retainAll(set2);
		return set1.stream().mapToInt(x -> x).toArray();
	}

	// Best Solution with some modifications
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		for (int num : nums1) {
			set.add(num);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				list.add(nums2[i]);
				set.remove(nums2[i]);
			}
		}

		int[] arr = new int[list.size()];
		int i = 0;
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			arr[i++] = iterator.next();
		}
		return arr;
	}

	// Best Solution
	public int[] inters5ection3(int[] nums1, int[] nums2) {
		var s1 = new HashSet<Integer>(nums1.length);
		for (var i : nums1)
			s1.add(i);
		var s2 = new HashSet<Integer>(nums2.length);
		for (var i : nums2) {
			if (s1.contains(i))
				s2.add(i);
		}
		var res = new int[s2.size()];
		int j = 0;
		for (var i : s2) {
			res[j++] = i;
		}
		return res;
	}

	public int[] intersection4(int[] nums1, int[] nums2) {
		var arr1 = new boolean[1001];
		for (var i : nums1)
			arr1[i] = true;
		int resCount = 0;
		var arr2 = new boolean[1001];
		for (var i : nums2) {
			if (arr1[i] && !arr2[i]) {
				arr2[i] = true;
				resCount++;
			}
		}
		var res = new int[resCount];

		for (int i = 0; i < 1001 && resCount >= 0; ++i) {
			if (arr2[i])
				res[--resCount] = i;
		}
		return res;
	}

	// Best Best Solution
	public int[] intersection(int[] nums1, int[] nums2) {
		final int N = 1001;
		var set = new int[N];
		for (var i : nums1)
			set[i] = 1;
		int resCount = 0;
		for (var i : nums2) {
			if (set[i] == 1) {
				set[i] = 2;
				++resCount;
			}
		}
		var res = new int[resCount];
		var i = 0;
		var nums = nums2.length > nums1.length ? nums1 : nums2;
		for (var v : nums) {
			if (set[v] == 2) {
				res[i++] = v;
				set[v] = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::print;
		Consumer<int[]> arrConsumer = x -> Arrays.stream(x).forEach(cons);
		var obj = new SolutionSunday0310();

		arrConsumer.accept(obj.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
		System.out.println();
		arrConsumer.accept(obj.intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
		System.out.println();

		// Custom Input
		arrConsumer.accept(obj.intersection(new int[] { 1, 2, 3 }, new int[] { 2, 4 }));
		System.out.println();
		arrConsumer.accept(obj.intersection(new int[] { 1, 2, 3, 6 }, new int[] { 2, 3, 4, 5 }));
		System.out.println();

		arrConsumer.accept(obj.intersection(new int[] { 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4 }));

		System.out.println();
		arrConsumer.accept(obj.intersection(new int[] { 1, 1, 2 }, new int[] { 2, 4 }));
		System.out.println();

	}
}
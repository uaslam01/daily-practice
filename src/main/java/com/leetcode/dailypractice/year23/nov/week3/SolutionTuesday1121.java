package com.leetcode.dailypractice.year23.nov.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Count Nice Pairs in an Array Medium 1.5K 64 Companies You are given an array
 * nums that consists of non-negative integers. Let us define rev(x) as the
 * reverse of the non-negative integer x. For example, rev(123) = 321, and
 * rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the
 * following conditions:
 * 
 * 0 <= i < j < nums.length nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too
 * large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:	
 * 
 * Input: nums = [42,11,1,97] Output: 2 Explanation: The two pairs are: - (0,3)
 * : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121. - (1,2) : 11 +
 * rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12. Example 2:
 * 
 * Input: nums = [13,10,35,24,76] Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 0 <= nums[i] <= 109 Accepted 75.6K Submissions 156.8K
 * Acceptance Rate 48.2%
 */
public class SolutionTuesday1121 {
	//Mine
	public int countNicePairs1(int[] nums) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int[] diffWithRev = Arrays.stream(nums).map(i->i-reverseNumber(i, map)).sorted().toArray();
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(diffWithRev[i]==diffWithRev[j]) {
					count = (count+1)%1000_000_007;
				} else {
					break;
				}
			}
		}
		return count;
	}
	int reverseNumber(int num, Map<Integer, Integer> map) {
		if(map.containsKey(num))
			return map.get(num);
		int revNum = 0;
		while(num>0) {
			revNum=revNum*10+num%10;
			num/=10;
		}
		map.put(num, revNum);
		return revNum;
	}
	//Best Solution
	public int countNicePairs(int[] nums) {
		int res = 0;
		int mod = (int) Math.pow(10, 9) + 7;
		Map<Integer, Integer> count = new HashMap<>();;

		for (int n : nums) {
			int rev = rev(n);
			int cur = count.getOrDefault(n - rev, 0);
			count.put(n - rev, cur + 1);
			res = (res + cur) % mod;
		}

		return res;  			
	}
	private int rev(int num) {
		int reversedNum = 0;

		while (num > 0) {
			int digit = num % 10;
			reversedNum = reversedNum * 10 + digit;
			num = num / 10;
		}

		return reversedNum;
	}  
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionTuesday1121();
		cons.accept(obj.countNicePairs(new int[] {42,11,1,97 }));
		cons.accept(obj.countNicePairs(new int[] { 13,10,35,24,76 }));

	}
}

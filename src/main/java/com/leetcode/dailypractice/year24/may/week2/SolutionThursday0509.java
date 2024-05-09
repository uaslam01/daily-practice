package com.leetcode.dailypractice.year24.may.week2;

import java.util.Arrays;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/maximize-happiness-of-selected-children/">
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

public class SolutionThursday0509 {
	//Mine Solution /Best Solution 1
	public long maximumHappinessSum(int[] happiness, int k) {
		Arrays.sort(happiness);
		long sum = 0;
		int count = 0;
		for (int i = happiness.length - 1; i >= 0; i--) {
			if (happiness[i] - count >= 0)
				sum += happiness[i] - count++;
			k--;
			if (k == 0)
				break;
		}
		return sum;
	}

	//Best Solution 2
	public long maximumHappinessSum2(int[] happiness, int k) {
		Arrays.sort(happiness);
		long sum = 0;
		int count = 0;
		int value = 0;
		for (int i = happiness.length - 1; i >= happiness.length-k; i--) {
			value = happiness[i] - count++;
			if (value > 0)
				sum += value;
		}
		return sum;
	}

	//Best Solution 3
    public long maximumHappinessSum3(int[] happiness, int k) {
        
        int left = 0, right = k;
        while(left < right){
            int mid = left + right >> 1;
            if(check(happiness, mid))
                left = mid + 1;
            else
                right = mid;
        }
        
        k = left;
        int n = happiness.length;
        quickSort(happiness, 0, n - 1, n - k);
        long sum = -(long)k * (k - 1) >> 1;
        for(int i = n -1; k-- > 0; --i)
            sum += happiness[i];
        
        return sum;
    }
    
    public boolean check(int[] happiness, int mid) {
        int count = 0;
        for(int x:happiness){
            if(x < mid) continue;
            if(++count > mid) 
               return true;
        }
        
        return false;
    }
    
    private void quickSort(int nums[], int low, int high, int k) {
        if (low == high) 
            return;
        
        int left = low - 1, right = high + 1, mid = low + high >> 1;
        int x = nums[mid];
        while (left < right) {
            while (nums[++left] < x) continue;
            while (nums[--right] > x) continue;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        } 
        
        if (right < k) 
            quickSort(nums, right + 1, high, k);
        else
            quickSort(nums, low, right, k);
    }  
    
    
	public static void main(String[] arg) {
		var obj = new SolutionThursday0509();

		System.out.println(obj.maximumHappinessSum(new int[] { 1, 2, 3 }, 2));
		System.out.println(obj.maximumHappinessSum(new int[] { 1, 1, 1, 1 }, 2));
		System.out.println(obj.maximumHappinessSum(new int[] { 2, 3, 4, 5 }, 1));

		System.out.println(obj.maximumHappinessSum(new int[] { 2, 3, 4, 5 }, 3));

	}
}

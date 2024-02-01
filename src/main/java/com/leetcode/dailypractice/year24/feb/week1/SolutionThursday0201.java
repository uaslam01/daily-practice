package com.leetcode.dailypractice.year24.feb.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/">Problem-Link</a>
 * 
 * 2966. Divide Array Into Arrays With Max Difference
 * 
 * Medium Topics Companies Hint
 * 
 * You are given an integer array nums of size n and a positive integer k.
 * 
 * 
 * Divide the array into one or more arrays of size 3 satisfying the following
 * conditions:
 * 
 * 
 * Each element of nums should be in exactly one array. The difference between
 * any two elements in one array is less than or equal to k. Return a 2D array
 * containing all the arrays. If it is impossible to satisfy the conditions,
 * return an empty array. And if there are multiple answers, return any of them.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * 
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * 
 * Explanation: We can divide the array into the following arrays: [1,1,3],
 * [3,4,5] and [7,8,9]. The difference between any two elements in each array is
 * less than or equal to 2. Note that the order of elements is not important.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,3,2,7,3], k = 3
 * 
 * Output: []
 * 
 * Explanation: It is not possible to divide the array satisfying all the
 * conditions.
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= n <= 105 n is a multiple of 3. 1 <= nums[i] <= 105 1 <=
 * k <= 105
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 92K
 * Submissions 131.7K Acceptance Rate 69.9%
 */
public class SolutionThursday0201 {
	//Mine Solution
    public int[][] divideArray1(int[] nums, int k) {
    	return null;
    }
	public static void main(String[] args) {
		var obj = new SolutionThursday0201();
		Consumer< ?super int[]> arrayConsumer = x -> Arrays.stream(x).forEach(System.out::println);
		Arrays.stream(obj.divideArray(new int[] { 1,3,4,8,7,9,3,5,1}, 2)).forEach(arrayConsumer);
		System.out.println("----");

		Arrays.stream(obj.divideArray(new int[] {1,3,3,2,7,3}, 3)).forEach(arrayConsumer);
		System.out.println("----");

	}

    public int[][] divideArray(int[] nums, int k) {
        int size = nums.length;
        if (size % 3 != 0)
            return new int[0][0];

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int groupIndex = 0;
        for (int i = 0; i < size; i += 3) {
            if (i + 2 < size && nums[i + 2] - nums[i] <= k) {
                result.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
                groupIndex++;
            } else {
                return new int[0][0];
            }
        }
        return (int[][]) result.toArray();
    }
  //Best Solution
    public int[][] divideArray2(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[0][0];
        
        for (int i = 0; i + 2 < nums.length; ++i) {
            if (i % 3 == 0) {
                if (nums[i + 2] - nums[i] <= k) {
                    int[] triplet = {nums[i], nums[i + 1], nums[i + 2]};
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = triplet;
                } else {
                    return new int[0][0];
                }
            }
        }
        
        return result;
    }
}


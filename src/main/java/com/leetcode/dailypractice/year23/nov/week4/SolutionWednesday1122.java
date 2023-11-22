package com.leetcode.dailypractice.year23.nov.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/ Diagonal Traverse II
 * Medium 1.7K 129 Companies Given a 2D integer array nums, return all elements
 * of nums in diagonal order as shown in the below images.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,4,2,7,5,3,8,6,9] Example
 * 2:
 * 
 * 
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]] Output:
 * [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i].length <= 105 1 <= sum(nums[i].length)
 * <= 105 1 <= nums[i][j] <= 105 Accepted 92.1K Submissions 167.6K Acceptance
 * Rate 55.0%
 */
public class SolutionWednesday1122 {
	//Best Solution
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> resList = new ArrayList<>();
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            resList.add(nums.get(p[0]).get(p[1]));

            if (p[1] == 0 && p[0] + 1 < nums.size()) {
                q.offer(new int[]{p[0] + 1, 0});
            }

            if (p[1] + 1 < nums.get(p[0]).size()) {
                q.offer(new int[]{p[0], p[1] + 1});
            }
        }

        // Convert List<Integer> to int[]
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;         
    }
    
}

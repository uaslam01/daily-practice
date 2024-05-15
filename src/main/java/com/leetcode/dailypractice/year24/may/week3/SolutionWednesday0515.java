package com.leetcode.dailypractice.year24.may.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

public class SolutionWednesday0515 {
	// Mine Solution /Best Solution 1
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        return 0;
    }
    
    //Best Solution
    private int[] roww = {0, 0, -1, 1};
    private int[] coll = {-1, 1, 0, 0};
    private void bfs(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            int s = score[x][y];

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && score[newX][newY] > 1 + s) {
                    score[newX][newY] = 1 + s;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }

    public int maximumSafenessFactor2(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] score = new int[n][n];
        for (int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);
        bfs(grid, score, n);

        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{score[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int safe = temp[0];
            int i = temp[1], j = temp[2];

            if (i == n - 1 && j == n - 1) return safe;
            vis[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int newX = i + roww[k];
                int newY = j + coll[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis[newX][newY]) {
                    int s = Math.min(safe, score[newX][newY]);
                    pq.offer(new int[]{s, newX, newY});
                    vis[newX][newY] = true;
                }
            }
        }

        return -1;
    }

	public static void main(String[] arg) {
		var obj = new SolutionWednesday0515();
		List<List<Integer>> list = new ArrayList<>();

		System.out.println(obj.maximumSafenessFactor(list));

	}
}

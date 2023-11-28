package com.leetcode.dailypractice.year23.nov.week4;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/knight-dialer/ 935. Knight Dialer Medium 2.9K
 * 435 Companies The chess knight has a unique movement, it may move two squares
 * vertically and one square horizontally, or two squares horizontally and one
 * square vertically (with both forming the shape of an L). The possible
 * movements of chess knight are shown in this diagaram:
 * 
 * A chess knight can move as indicated in the chess diagram below:
 * 
 * 
 * We have a chess knight and a phone pad as shown below, the knight can only
 * stand on a numeric cell (i.e. blue cell).
 * 
 * 
 * Given an integer n, return how many distinct phone numbers of length n we can
 * dial.
 * 
 * You are allowed to place the knight on any numeric cell initially and then
 * you should perform n - 1 jumps to dial a number of length n. All jumps should
 * be valid knight jumps.
 * 
 * As the answer may be very large, return the answer modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: 10 Explanation: We need to dial a number of length 1, so
 * placing the knight over any numeric cell of the 10 cells is sufficient.
 * Example 2:
 * 
 * Input: n = 2 Output: 20 Explanation: All the valid number we can dial are
 * [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92,
 * 94] Example 3:
 * 
 * Input: n = 3131 Output: 136006598 Explanation: Please take care of the mod.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 5000 Accepted 160.5K Submissions 270.6K Acceptance Rate 59.3%
 */
public class SolutionMonday1127 {
	//Best Solution
    public int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
                }
            }
        }

        int result = 0;
        for (int count : dp[n - 1]) {
            result = (result + count) % MOD;
        }

        return result;
    }
    public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday1127();
		cons.accept(obj.knightDialer(1));
		cons.accept(obj.knightDialer(2));
		cons.accept(obj.knightDialer(3131));

	}

}

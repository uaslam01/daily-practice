package com.leetcode.dailypractice.year24.apr.week1;

/**
 * <a href= "https://leetcode.com/problems/word-search/description/">Problem-Link</a>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <img src="word2.jpg" width="40%" />
 *
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * <p>
 * <p>
 *
 * Example 2:
 *
 * <p>
 *<img src="word-1.jpg" width="40%" />
 * <p>
 * <p>
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 *  <p>
 *  <img src="word3.jpg" width="40%" />
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 */

public class SolutionWednesday0403 {
    //Best Solution1
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                backtrack(board, word, visited, i - 1, j, index + 1) ||
                backtrack(board, word, visited, i, j + 1, index + 1) ||
                backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
    //Best Solution2

    public boolean exist1(char[][] board, String word) {
        if (!canBeFound(board, word)) return false;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(board, word, i, j, 0, dirs)) return true;
            }
        }

        return false;
    }

    private boolean canBeFound(char[][] board, String word) {
        int m = board.length, n = board[0].length, l = word.length();
        if (m * n < l) return false;

        int[] count = new int[128];
        for (char[] arr : board) for (char c : arr) count[c]++;
        for (char c : word.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }

        return true;
    }

    private boolean solve(char[][] board, String word, int i, int j, int idx, int[][] dirs) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if (word.charAt(idx) != board[i][j]) return false;
        board[i][j] = '#';

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (solve(board, word, x, y, idx + 1, dirs)) return true;
        }
        board[i][j] = word.charAt(idx);

        return false;
    }
}

package com.leetcode.dailypractice.year24.jan.week4;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/">Problem-Link</a>
 * 
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * 
 * Solved Medium Topics Companies Hint
 * 
 * Given a binary tree where node values are digits from 1 to 9. A path in the
 * binary tree is said to be pseudo-palindromic if at least one permutation of
 * the node values in the path is a palindrome.
 * 
 * Return the number of pseudo-palindromic paths going from the root node to
 * leaf nodes.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [2,3,1,3,1,null,1] Output: 2
 * 
 * Explanation: The figure above represents the given binary tree. There are
 * three paths going from the root node to leaf nodes: the red path [2,3,3], the
 * green path [2,1,1], and the path [2,3,1]. Among these paths only red path and
 * green path are pseudo-palindromic paths since the red path [2,3,3] can be
 * rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be
 * rearranged in [1,2,1] (palindrome).
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1] Output: 1
 * 
 * Explanation: The figure above represents the given binary tree. There are
 * three paths going from the root node to leaf nodes: the green path [2,1,1],
 * the path [2,1,3,1], and the path [2,1]. Among these paths only the green path
 * is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1]
 * (palindrome).
 * 
 * Example 3:
 * 
 * Input: root = [9] Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 105]. 1 <= Node.val <= 9
 * Seen this question in a real interview before? 1/4 Yes No Accepted 178.4K
 * Submissions 262.2K Acceptance Rate 68.0%
 */
public class SolutionWednesday0124 {
	// Mine
	static int count = 0;

	public int pseudoPalindromicPaths1(TreeNode root) {
		count = 0;
		int[] digitCount = new int[9];
		preOrder(root, digitCount);
		return count;
	}

	void preOrder(TreeNode root, int[] digitCount) {
		if (root == null)
			return;
		digitCount[root.val - 1]++;
		preOrder(root.left, digitCount);
		preOrder(root.right, digitCount);
		if (root.left == null & root.right == null) {
			checkPseudoPalindromicPaths(digitCount);
		}
		digitCount[root.val - 1]--;

	}

	private void checkPseudoPalindromicPaths(int[] digitCount) {
		boolean oneElementWithOddCount = false;
		for (int i : digitCount) {
			if (i % 2 != 0) {
				if (!oneElementWithOddCount) {
					oneElementWithOddCount = true;
				} else
					return;
			}
		}
		count++;
	}

	// Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	//Best Solution
    public int pseudoPalindromicPaths(TreeNode root) {
        return countPseudoPalindromicPaths(root, 0);
    }

    private int countPseudoPalindromicPaths(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }

        path ^= (1 << node.val);

        if (node.left == null && node.right == null) {
            return (path & (path - 1)) == 0 ? 1 : 0;
        }

        return countPseudoPalindromicPaths(node.left, path) + countPseudoPalindromicPaths(node.right, path);
    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		TreeNode temp = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		temp.left.left = new TreeNode(3);
		temp.left.right = new TreeNode(1);
		temp.right.right = new TreeNode(1);

		TreeNode temp1 = new TreeNode(2, new TreeNode(1), new TreeNode(1));
		temp1.left.left = new TreeNode(1);
		temp1.left.right = new TreeNode(3);
		temp1.left.right.right = new TreeNode(1);

		var obj = new SolutionWednesday0124();
		cons.accept(obj.pseudoPalindromicPaths(temp));
		cons.accept(obj.pseudoPalindromicPaths(temp1));
		cons.accept(obj.pseudoPalindromicPaths(new TreeNode(9)));

	}
}
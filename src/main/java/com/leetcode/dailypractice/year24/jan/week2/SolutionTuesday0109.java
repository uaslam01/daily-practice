package com.leetcode.dailypractice.year24.jan.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/leaf-similar-trees/">Problem-Link</a>
 * 
 * 
 * 872. Leaf-Similar Trees Easy 3.8K 88 Companies Consider all the leaves of a
 * binary tree, from left to right order, the values of those leaves form a leaf
 * value sequence.
 * 
 * 
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
 * 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * <img src="leaf-similar-1.jpg" width="80%"/> 
 * 
 * 
 * Input: root1 =
 * [3,5,1,6,2,9,8,null,null,7,4], root2 =
 * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 
 * Output: true 
 * 
 * 
 * Example 2:
 * 
 * 
 * <img src="leaf-similar-2.jpg" width="80%"/> 
 * 
 * Input: root1 = [1,2,3], root2 =
 * [1,3,2] 
 * 
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each tree will be in the range [1, 200]. Both of the
 * given trees will have values in the range [0, 200]. Accepted 381K Submissions
 * 547K Acceptance Rate 69.7%
 */
public class SolutionTuesday0109 {

	// Mine Solution
	public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
		List<Integer> tree1 = new ArrayList<>();
		List<Integer> tree2 = new ArrayList<>();
		traverseBST(root1, tree1);
		traverseBST(root2, tree2);
		return tree1.equals(tree2);
	}

	private void traverseBST(TreeNode root, List<Integer> leafNodes) {
		if (root == null) {
			return;
		}
		traverseBST(root.left, leafNodes);
		traverseBST(root.right, leafNodes);
		if (root.left == null && root.right == null)
			leafNodes.add(root.val);
	}

	// Best Solution
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		helper(list1, root1);
		helper(list2, root2);

		if (list1.equals(list2))
			return true;
		else
			return false;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		} else {
			helper(list, root.left);
			helper(list, root.right);
		}
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

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		TreeNode temp = new TreeNode(3, new TreeNode(5), new TreeNode(1));
		temp.left.left = new TreeNode(6);
		temp.left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
		temp.right.left = new TreeNode(9);
		temp.right.right = new TreeNode(8);

		TreeNode temp1 = new TreeNode(3, new TreeNode(5), new TreeNode(1));
		temp1.left.left = new TreeNode(6);
		temp1.left.right = new TreeNode(7);
		temp1.right.left = new TreeNode(4);
		temp1.right.right = new TreeNode(2, new TreeNode(9), new TreeNode(8));

		var obj = new SolutionTuesday0109();
		cons.accept(obj.leafSimilar(temp, temp1));
		temp = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		temp1 = new TreeNode(1, new TreeNode(3), new TreeNode(2));

		cons.accept(obj.leafSimilar(temp, temp1));

	}
}

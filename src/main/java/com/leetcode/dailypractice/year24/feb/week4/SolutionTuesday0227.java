package com.leetcode.dailypractice.year24.feb.week4;

import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/diameter-of-binary-tree/">Problem-Link</a>
 * 
 * 543. Diameter of Binary Tree
 * 
 * Easy Topics Companies
 * 
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="diamtree.jpg" width="80%"/>
 * 
 * Input: root = [1,2,3,4,5]
 * 
 * Output: 3
 * 
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * 
 * Example 2:
 * 
 * Input: root = [1,2]
 * 
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -100 <= Node.val <=
 * 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.4M
 * Submissions 2.3M Acceptance Rate 59.4%
 */
public class SolutionTuesday0227 {
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

	static int diameter;

	public int getHeightOfTree(TreeNode root, int initialHeight) {
		if (root == null)
			return initialHeight;
		int leftHeight = 0;
		int rightHeight = 0;
		if (root.left == null && root.right == null)
			return 0;
		if (root.left != null)
			leftHeight = 1;
		if (root.right != null)
			rightHeight = 1;
		leftHeight += getHeightOfTree(root.left, 0) - initialHeight;
		rightHeight += getHeightOfTree(root.right, 0) - initialHeight;
		int sum = leftHeight + rightHeight;
		if (diameter < sum)
			diameter = sum;
		return Math.max(leftHeight, rightHeight);
	}

	// Mine Solution
	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		getHeightOfTree(root, 0);
		return diameter;
	}

	//Best Solution 1
	public int getHeightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = 0;
		int rightHeight = 0;
		leftHeight += getHeightOfTree(root.left);
		rightHeight += getHeightOfTree(root.right);
		int sum = leftHeight + rightHeight;
		if (diameter < sum)
			diameter = sum;
		return Math.max(leftHeight, rightHeight)+1;
	}

	
	// Best Solution 2
	public class DiameterData {
		int diameter;
		int height;

		DiameterData(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	public DiameterData calculateDiameterAndHeight(TreeNode root) {
		if (root == null) {
			return new DiameterData(0, 0);
		}

		DiameterData leftData = calculateDiameterAndHeight(root.left);
		DiameterData rightData = calculateDiameterAndHeight(root.right);

		int currentDiameter = Math.max(leftData.height + rightData.height,
				Math.max(leftData.diameter, rightData.diameter));
		int currentHeight = Math.max(leftData.height, rightData.height) + 1;

		return new DiameterData(currentDiameter, currentHeight);
	}

	public int diameterOfBinaryTree1(TreeNode root) {
		// Calculate diameter and height using helper function
		DiameterData data = calculateDiameterAndHeight(root);

		// Return the diameter (maximum path length)
		return data.diameter;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionTuesday0227();

		TreeNode temp = new TreeNode(1, null, new TreeNode(3));
		temp.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		cons.accept(obj.diameterOfBinaryTree(temp));

		temp = new TreeNode(1, new TreeNode(2), null);
		cons.accept(obj.diameterOfBinaryTree(temp));
		temp = new TreeNode(1, null, new TreeNode(3));

		temp.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		temp.left.right.left =  new TreeNode(6, new TreeNode(7), new TreeNode(8));
		temp.left.right.right = new TreeNode(9, new TreeNode(10), null);
		temp.left.right.left.right.left = new TreeNode(11);
		temp.left.right.right.left.left = new TreeNode(12);
		cons.accept(obj.diameterOfBinaryTree(temp));

	}
}
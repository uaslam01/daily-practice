package com.leetcode.dailypractice.year23.nov.week1;

import java.util.Arrays;

/**
 * . Find Mode in Binary Search Tree
 * https://leetcode.com/problems/median-of-two-sorted-arrays/ Easy 3.2K 702
 * Companies Given the root of a binary search tree (BST) with duplicates,
 * return all the mode(s) (i.e., the most frequently occurred element) in it.
 * 
 * If the tree has more than one mode, return them in any order.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key. The right subtree of a node contains only nodes with keys
 * greater than or equal to the node's key. Both the left and right subtrees
 * must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,2] Output: [2] Example 2:
 * 
 * Input: root = [0] Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -105 <= Node.val <=
 * 105
 */
public class SolutionWednesday1101 {
	public int[] findMode(TreeNode root) {
		return null;
	}
	public static void main(String[] args) {

	Arrays.stream(new SolutionWednesday1101().findMode(null)).forEach(System.out::print);
	System.out.println("");
	Arrays.stream(new SolutionWednesday1101().findMode(null)).forEach(System.out::print);
	}
}

// Definition for a binary tree node.
class TreeNode {
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

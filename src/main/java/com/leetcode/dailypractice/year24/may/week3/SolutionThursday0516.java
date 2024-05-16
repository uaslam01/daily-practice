package com.leetcode.dailypractice.year24.may.week3;

import com.leetcode.dailypractice.common.TreeNode;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/evaluate-boolean-binary-tree/">
 * Problem-Link</a>
 * 
 * 2331. Evaluate Boolean Binary Tree
 * 
 * Solved Easy Topics Companies Hint
 * 
 * You are given the root of a full binary tree with the following properties:
 * 
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1
 * represents True. Non-leaf nodes have either the value 2 or 3, where 2
 * represents the boolean OR and 3 represents the boolean AND. The evaluation of
 * a node is as follows:
 * 
 * If the node is a leaf node, the evaluation is the value of the node, i.e.
 * True or False. Otherwise, evaluate the node's two children and apply the
 * boolean operation of its value with the children's evaluations. Return the
 * boolean result of evaluating the root node.
 * 
 * A full binary tree is a binary tree where each node has either 0 or 2
 * children. A leaf node is a node that has zero children.
 * 
 * 
 * Example 1:
 * 
 * <img src="example1drawio1.png" width="50%" height="15%"/>
 * 
 * Input: root = [2,1,3,null,null,0,1]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The above diagram illustrates the evaluation process. The AND node evaluates
 * to False AND True = False. The OR node evaluates to True OR False = True. The
 * root node evaluates to True, so we return true.
 * 
 * Example 2:
 * 
 * Input: root = [0]
 * 
 * Output: false
 * 
 * Explanation: The root node is a leaf node and it evaluates to false, so we
 * return false.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000]. 0 <= Node.val <= 3
 * Every node has either 0 or 2 children. Leaf nodes have a value of 0 or 1.
 * Non-leaf nodes have a value of 2 or 3.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 99.4K
 * Submissions 123.6K Acceptance Rate 80.4%
 **/

public class SolutionThursday0516 {
	// Mine Solution /Best Solution 1
	public boolean evaluateTree(TreeNode root) {
		if (root.left == null)
			return root.val == 1 ? true : false;
		if (root.val == 2) {
			return evaluateTree(root.left) || evaluateTree(root.right);
		} else {
			return evaluateTree(root.left) && evaluateTree(root.right);
		}
	}

	// Best Solution 2
	public boolean evaluateTree2(TreeNode root) {
		switch (root.val) {
		case 0:
			return false;
		case 1:
			return true;
		case 2:
			return evaluateTree(root.left) || evaluateTree(root.right);
		case 3:
			return evaluateTree(root.left) && evaluateTree(root.right);
		default:
			throw new IllegalArgumentException("invalid value in tree: " + root.val);
		}
	}

	public static void main(String[] arg) {
		var obj = new SolutionThursday0516();
		TreeNode temp = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		temp.right.left = new TreeNode(0);
		temp.right.right = new TreeNode(1);
		System.out.println(obj.evaluateTree(temp));
		System.out.println(obj.evaluateTree(new TreeNode(0)));

		// Custom Input
		System.out.println(obj.evaluateTree(new TreeNode(1)));
	}
}

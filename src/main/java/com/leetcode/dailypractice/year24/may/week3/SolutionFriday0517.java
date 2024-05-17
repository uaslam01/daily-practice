package com.leetcode.dailypractice.year24.may.week3;

import com.leetcode.dailypractice.common.TreeNode;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/delete-leaves-with-a-given-value/">
 * Problem-Link</a>
 * 
 * 1325. Delete Leaves With a Given Value
 * 
 * Medium Topics Companies Hint
 * 
 * Given a binary tree root and an integer target, delete all the leaf nodes
 * with value target. Note that once you delete a leaf node with value target,
 * if its parent node becomes a leaf node and has the value target, it should
 * also be deleted (you need to continue doing that until you cannot).
 * 
 * 
 * Example 1:
 * 
 * <img src="sample_1_1684.png" width="50%" height="15%"/>
 * 
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * 
 * Output: [1,null,3,null,4]
 * 
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture
 * in left). After removing, new nodes become leaf nodes with value (target = 2)
 * (Picture in center).
 * 
 * Example 2:
 * 
 * <img src="sample_2_1684.png" width="50%" height="15%"/>
 * 
 * Input: root = [1,3,3,3,2], target = 3
 * 
 * Output: [1,3,null,null,2]
 * 
 * 
 * Example 3:
 * 
 * <img src="sample_3_1684.png" width="50%" height="15%"/>
 * 
 * Input: root = [1,2,null,2,null,2], target = 2 Output: [1]
 * 
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each
 * step.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 3000]. 1 <= Node.val,
 * target <= 1000
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 138.9K
 * Submissions 183.3K Acceptance Rate 75.8%
 **/

public class SolutionFriday0517 {
	// Mine Solution /Best Solution 1
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		return root = preOrderTraversal(root, target);
	}

	private TreeNode preOrderTraversal(TreeNode root, int target) {
		if (root == null || root.left == null && root.right == null && root.val == target)
			return null;
		if (root.left != null)
			root.left = preOrderTraversal(root.left, target);
		if (root.right != null)
			root.right = preOrderTraversal(root.right, target);
		if (root.left == null && root.right == null && root.val == target)
			return null;
		else
			return root;

	}
	

	public static void main(String[] arg) {
		var obj = new SolutionFriday0517();
		TreeNode temp = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		temp.right.left = new TreeNode(0);
		temp.right.right = new TreeNode(1);
		TreeNode.InOrderTraversal(obj.removeLeafNodes(TreeNode.generateTestCase(new Integer[] {1,2,3,2,null,2,4}), 2));
		System.out.println("---");
		TreeNode.InOrderTraversal(obj.removeLeafNodes(TreeNode.generateTestCase(new Integer[] {1,3,3,3,2}), 3));
		System.out.println("---");
		TreeNode.InOrderTraversal(obj.removeLeafNodes(TreeNode.generateTestCase(new Integer[] {1,2,null,2,null,2}), 2));
		System.out.println("---");
		
		
		// Custom Input
		TreeNode.InOrderTraversal(obj.removeLeafNodes(new TreeNode(1), 4));
		System.out.println("---");
	}
}

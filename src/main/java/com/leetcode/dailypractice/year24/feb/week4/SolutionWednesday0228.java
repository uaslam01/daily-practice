package com.leetcode.dailypractice.year24.feb.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-bottom-left-tree-value/">Problem-Link</a>
 * 
 * 513. Find Bottom Left Tree Value
 * 
 * Medium Topics Companies
 * 
 * Given the root of a binary tree, return the leftmost value in the last row of
 * the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="tree1.jpg" width="80%"/>
 * 
 * Input: root = [2,1,3]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * <img src="tree2.jpg" width="80%"/>
 * 
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * 
 * Output: 7
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -231 <= Node.val <=
 * 231 - 1
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 287.1K
 * Submissions 413K Acceptance Rate 69.5%
 */

public class SolutionWednesday0228 {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;
		double noOfNodes = Math.pow(2, level);
		int nullCount = 0;
		boolean findLeftMost = false;
		int leftMost = root.val;
		while (!queue.isEmpty()) {
			noOfNodes--;
			TreeNode temp = queue.poll();
			if(temp==null) {
				queue.add(null);
				queue.add(null);
				nullCount+=2;
			} else {
				if(temp.left==null)
					nullCount++;
				else if(!findLeftMost) {
					leftMost = temp.left.val;
					findLeftMost = true;
				}
					
				if(temp.right==null)
					nullCount++;
				else if(!findLeftMost) {
					leftMost = temp.right.val;
					findLeftMost = true;
				}
				queue.add(temp.left);
				queue.add(temp.right);

			}
			if (noOfNodes == 0) {
				if(nullCount==Math.pow(2, level+1)) {
					break;
				}
				level++;
				nullCount = 0;
				noOfNodes = Math.pow(2, level);
				findLeftMost = false;
			}
		}

		return leftMost;
	}

	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		var obj = new SolutionWednesday0228();

		TreeNode temp = new TreeNode(1, null, new TreeNode(3));
		temp.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		cons.accept(obj.findBottomLeftValue(temp));

		temp = new TreeNode(1, new TreeNode(2), null);
		cons.accept(obj.findBottomLeftValue(temp));
		temp = new TreeNode(1, null, new TreeNode(3));

		temp.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		temp.left.right.left = new TreeNode(6, new TreeNode(7), new TreeNode(8));
		temp.left.right.right = new TreeNode(9, new TreeNode(10), null);
		temp.left.right.left.right.left = new TreeNode(11);
		temp.left.right.right.left.left = new TreeNode(12);
		cons.accept(obj.findBottomLeftValue(temp));

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

}
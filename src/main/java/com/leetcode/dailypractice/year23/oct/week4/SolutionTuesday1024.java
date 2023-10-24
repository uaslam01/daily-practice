package com.leetcode.dailypractice.year23.oct.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

		 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1*/
public class SolutionTuesday1024 {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = root != null?queue.add(root):false;
		while (!queue.isEmpty()) {
			int maxVal = Integer.MIN_VALUE;
			for(int i=0;i<queue.size();i++) {
				TreeNode temp = queue.poll();	
				maxVal = Math.max(maxVal, temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
				} 
				if (temp.right != null) {
					queue.add(temp.right);
				} 
			}
			list.add(maxVal);
		}
		return list;
	}
	//Mine
	public List<Integer> largestValuesMine(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = root != null?queue.add(root):false;
		int treeLevel = 0;
		int i = 0;
		int maxVal = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			i++;
			TreeNode temp = queue.poll();
			if (maxVal < temp.val) {
				maxVal = temp.val;
			}
			if (i == Math.pow(2, treeLevel)) {
				list.add(maxVal);
				maxVal = Integer.MIN_VALUE;
				treeLevel++;
				i = 0;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			} else i++;
			if (temp.right != null) {
				queue.add(temp.right);
			} else i++;
		}
		if(maxVal!=Integer.MIN_VALUE)
			list.add(maxVal);
		return list;
	}
	
	public static void main(String[] args) {
//		TreeNode temp = new TreeNode(1, new TreeNode(3), new TreeNode(2));
//		temp.left.left = new TreeNode(5);
//		temp.left.right = new TreeNode(3);
//		temp.right.right = new TreeNode(9);

		TreeNode temp = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//		TreeNode temp = new TreeNode(1, new TreeNode(2), null);
//		TreeNode temp = new TreeNode(1, null, new TreeNode(3));

//		TreeNode temp = new TreeNode(10, new TreeNode(5), new TreeNode(15));
//		temp.right.left = new TreeNode(6);
//		temp.right.right = new TreeNode(20);

		List<Integer> list = new SolutionTuesday1024().largestValues(temp);
		System.out.println(list);
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

package com.leetcode.dailypractice.common;

import java.util.ArrayDeque;
import java.util.Queue;

// Definition for a binary tree node.
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static TreeNode generateTestCase(Integer[] values) {
		if(values==null || values.length==0)
			return null;
		Queue<TreeNode> queue = new ArrayDeque<>();
		TreeNode node = new TreeNode(values[0]);
		queue.add(node);
		int i=1;
		int size = values.length;
		while(!queue.isEmpty()){
			int queueSize = queue.size();
			for (int k=0; k<queueSize; k++) {
				TreeNode treeNode = queue.remove();
				if(i<size && values[i]!=null) {
					treeNode.left = new TreeNode(values[i]);
					queue.add(treeNode.left);
				}
				i++;
				if(i<size && values[i]!=null) {
					treeNode.right = new TreeNode(values[i]);
					queue.add(treeNode.right);
				}
				i++;
				
			}
			
		}
		return node;
	}
	public static void InOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		System.out.println(root.val);
		InOrderTraversal(root.left);
		InOrderTraversal(root.right);
		System.out.println();
	}
}
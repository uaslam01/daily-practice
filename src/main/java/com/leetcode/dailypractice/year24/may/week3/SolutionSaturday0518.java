package com.leetcode.dailypractice.year24.may.week3;

import com.leetcode.dailypractice.common.TreeNode;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/distribute-coins-in-binary-tree/">
 * Problem-Link</a>
 * 
979. Distribute Coins in Binary Tree

Medium
Topics
Companies

You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
Return the minimum number of moves required to make every node have exactly one coin.
 

Example 1:

<img src="tree1.png" width="50%" height="25%"/>

Input: root = [3,0,0]

Output: 2

Explanation: 
From the root of the tree, we move one coin to its left child, and one coin to its right child.


Example 2:

<img src="tree2.png" width="50%" height="25%"/>

Input: root = [0,3,0]

Output: 3

Explanation: 
From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
 

Constraints:

The number of nodes in the tree is n.
1 <= n <= 100
0 <= Node.val <= n
The sum of all Node.val is n.

Seen this question in a real interview before?
1/5
Yes
No
Accepted
136.8K
Submissions
184.4K
Acceptance Rate
74.2%
 **/

public class SolutionSaturday0518 {
	static int totalOperations;
	int dfsForDistributeCoins(TreeNode root) {
		if(root.left==null && root.right==null) {
        	totalOperations+=root.val-1;
        	return root.val-1;
        }
        if(root.left!=null) {
        	root.val+=dfsForDistributeCoins(root.left);
        }
        if(root.right!=null) {
        	root.val+=dfsForDistributeCoins(root.right);
        }
        return root.val-1;
	}
    public int distributeCoins(TreeNode root) {
    	dfsForDistributeCoins(root);
		return totalOperations;   
    }
    
	public static void main(String[] arg) {
		var obj = new SolutionSaturday0518();
		int a = 100;
		String str = a+"0";
		System.out.println(str);
		System.out.println(str.equals("1000"));
		
		System.out.println(
				obj.distributeCoins(TreeNode.generateTestCase(new Integer[] { 3,0,0})));
		System.out.println("---");
		System.out.println(obj.distributeCoins(TreeNode.generateTestCase(new Integer[] { 0,3,0 })));
		System.out.println("---");
		

		// Custom Input
		System.out.println(obj.distributeCoins(new TreeNode(1)));
		System.out.println("---");
	}
}

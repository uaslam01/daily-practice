package com.leetcode.dailypractice.year24.feb.week4;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/same-tree/">Problem-Link</a>
 * 
 * 100. Same Tree Easy Topics Companies Given the roots of two binary trees p
 * and q, write a function to check if they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="ex1.jpg" width="80%"/>
 * 
 * Input: p = [1,2,3], q = [1,2,3]
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * <img src="ex2.jpg" width="80%"/>
 * 
 * Input: p = [1,2], q = [1,null,2]
 * 
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * <img src="ex3.jpg" width="80%"/>
 * 
 * Input: p = [1,2,1], q = [1,1,2]
 * 
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both trees is in the range [0, 100].
 * 
 * -104 <= Node.val <= 104
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 2M
 * Submissions 3.2M Acceptance Rate 61.1%
 */
public class SolutionMonday0226 {
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
	//Mine Solution/ Best Solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        else if (p==null || q==null || p.val!=q.val)
        	return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
		Consumer cons = System.out::println;
		TreeNode temp = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode temp1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		var obj = new SolutionMonday0226();
		cons.accept(obj.isSameTree(temp, temp1));
		
		temp = new TreeNode(1, new TreeNode(2), null);
		temp1 = new TreeNode(1, null, new TreeNode(2));
		cons.accept(obj.isSameTree(temp, temp1));

		temp = new TreeNode(1, new TreeNode(2), new TreeNode(1));
		temp1 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
		cons.accept(obj.isSameTree(temp, temp1));

	}
}

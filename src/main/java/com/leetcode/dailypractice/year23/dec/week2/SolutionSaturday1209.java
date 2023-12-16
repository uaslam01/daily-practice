package com.leetcode.dailypractice.year23.dec.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/binary-tree-inorder-traversal/">Problem-Link</a>
 * 
 * 94. Binary Tree Inorder Traversal Easy 12.9K 706 Companies Given the root of
 * a binary tree, return the inorder traversal of its nodes' values.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="inorder_1.jpg" width="80%" height = "40%" />
 * 
 * Input: root = [1,null,2,3] Output: [1,3,2] 
 * 
 * Example 2:
 * 
 * Input: root = [] Output: [] 
 * 
 * Example 3:
 * 
 * Input: root = [1] Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * Accepted 2.3M Submissions 3.1M Acceptance Rate 75.5%
 */
public class SolutionSaturday1209 {
	//Mine
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
        	return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
        
    }
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null)
        	return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        
    }
    
    
//    Best Solution
//    Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node once.
//    Space Complexity: O(h), where h is the height of the binary tree. The space is used for the recursive call stack, and in the worst case (skewed tree), it's O(n). In the average case (balanced tree), it's O(log n).
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
//    Best Solution2
//    Time complexity: O(n)O(n)O(n)
//    Space complexity: O(n)O(n)O(n)
//    In the worst case, we have skewed tree.
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;        
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }    
	public static void main(String[] args) {
		Consumer<List<Integer>> cons = x -> x.forEach(i -> System.out.print(i+" "));
		var obj = new SolutionSaturday1209();
		TreeNode node = new TreeNode(1, null, new TreeNode(2,new TreeNode(3),  null ));
		cons.accept(obj.inorderTraversal(node));
		System.out.println();
		cons.accept(obj.inorderTraversal(null));
		System.out.println();
		cons.accept(obj.inorderTraversal(new TreeNode(1)));
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
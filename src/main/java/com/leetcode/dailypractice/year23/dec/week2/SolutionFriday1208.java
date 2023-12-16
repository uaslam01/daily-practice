package com.leetcode.dailypractice.year23.dec.week2;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/construct-string-from-binary-tree/">Problem-Link</a>
 * 
 * <b>606. Construct String from Binary Tree Easy 3.1K 3.6K Companies</b>
 * 
 * Given the root of a binary tree, construct a string consisting of parenthesis
 * and integers from a binary tree with the preorder traversal way, and return
 * it.
 * 
 * Omit all the empty parenthesis pairs that do not affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="cons1-tree.jpg" width="80%" height= "40%"/>
 * 
 * Input: root = [1,2,3,4] Output: "1(2(4))(3)" Explanation: Originally, it
 * needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary
 * empty parenthesis pairs. And it will be "1(2(4))(3)"
 * 
 * Example 2: <img src="cons2-tree.jpg" width="80%" height= "40%"/>
 * 
 * Input: root = [1,2,3,null,4] Output: "1(2()(4))(3)" Explanation: Almost the
 * same as the first example, except we cannot omit the first parenthesis pair
 * to break the one-to-one mapping relationship between the input and the
 * output.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -1000 <= Node.val
 * <= 1000 Accepted 279.3K Submissions 412.9K Acceptance Rate 67.6% Seen this
 * question in a real interview before?
 * 1/4https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class SolutionFriday1208 {
	// Mine Solution
	public String tree2str(TreeNode root) {
		StringBuilder strBuilder = new StringBuilder();
		preOrderTraversal(root, strBuilder);
		return strBuilder.toString();
	}
	public void preOrderTraversal(TreeNode root, StringBuilder str) {
		if (root == null)
			return;
		str.append(root.val);
		if (root.left == null) {
			if(root.right!=null) {
				str.append("()");
			}
		}else {
			str.append("(");
			preOrderTraversal(root.left, str);
			str.append(")");
		} if(root.right!=null) {
			str.append("(");	
			preOrderTraversal(root.right, str);
			str.append(")");	
		}

	}

	// Best Solution
	public String tree2str2(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		dfs(root, result);
		return result.toString();
	}

	private void dfs(TreeNode node, StringBuilder result) {
		if (node == null) {
			return;
		}

		result.append(node.val);

		if (node.left != null || node.right != null) {
			result.append("(");
			dfs(node.left, result);
			result.append(")");

			if (node.right != null) {
				result.append("(");
				dfs(node.right, result);
				result.append(")");
			}
		}
	}

	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new SolutionFriday1208();
		TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
		cons.accept(obj.tree2str(node));
		node = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
		cons.accept(obj.tree2str(node));
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

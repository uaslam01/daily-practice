package com.leetcode.dailypractice.year24.jan.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * 938. Range Sum of BST Easy 6.4K 358 Companies Given the root node of a binary
 * search tree and two integers low and high, return the sum of values of all
 * nodes with a value in the inclusive range [low, high].
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="bst1.jpg" width="80%"/>
 * 
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15 Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 * 
 * <img src="bst2.jpg" width="80%"/> Input: root = [10,5,15,3,7,13,18,1,null,6],
 * low = 6, high = 10 Output: 23 Explanation: Nodes 6, 7, and 10 are in the
 * range [6, 10]. 6 + 7 + 10 = 23.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 2 * 104]. 1 <= Node.val
 * <= 105 1 <= low <= high <= 105 All Node.val are unique. Accepted 891.4K
 * Submissions 1M Acceptance Rate 86.2% Seen this question in a real interview
 * before? 1/4
 */
public class SolutionMonday0108 {
	//Mine Solution
    public int rangeSumBST(TreeNode root, int low, int high) {
    	List<Integer> sortedArr = new ArrayList<>();
		traverseBST(root, sortedArr);
        int sum=0;
        for(var num: sortedArr) {
        	if(num>high)
        		break;
        	if(num>=low) {
        		sum+=num;
        	}
        }
        return sum;
    }
    
    
    private void traverseBST(TreeNode root, List<Integer> sortedArr) {
		if(root==null) {
			return;
		}
		if(root.left!= null)
			traverseBST(root.left, sortedArr);
		sortedArr.add(root.val);
		if(root.right!= null)
			traverseBST(root.right, sortedArr);    	
	}

	//Best Solution
    public int rangeSumBST1(TreeNode root, int low, int high) {
        // Initialize the sum to 0
        int sum = 0;

        // Check if the current node is null
        if (root == null) {
            // If it is, return 0
            return 0;
        }

        // Check if the value of the current node is within the range
        if (root.val >= low && root.val <= high) {
            // If it is, add it to the sum
            sum += root.val;
        }

        // Recursively search the left and right subtrees for nodes in the range
        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);

        // Return the sum of the values of all nodes in the range
        return sum;
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
	public static void main(String[] args) {
		IntConsumer cons = System.out::println;
		TreeNode temp = new TreeNode(10, new TreeNode(5), new TreeNode(15));
		temp.left.left = new TreeNode(3);
		temp.left.right = new TreeNode(7);
		temp.right.right = new TreeNode(18);

		var obj = new SolutionMonday0108();
		cons.accept(obj.rangeSumBST(temp, 7,15));
		temp.right.left =  new TreeNode(13);
		temp.left.left.left = new TreeNode(1);
		temp.left.right.left = new TreeNode(6);
		cons.accept(obj.rangeSumBST(temp, 6, 10));

	}
}

package com.leetcode.dailypractice.year24.feb.week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/even-odd-tree/">Problem-Link</a>
 * 1609. Even Odd Tree
 * 
 * Medium Topics Companies Hint
 * 
 * A binary tree is named Even-Odd if it meets the following conditions:
 * 
 * The root of the binary tree is at level index 0, its children are at level
 * index 1, their children are at level index 2, etc.
 * 
 * For every even-indexed level, all nodes at the level have odd integer values
 * in strictly increasing order (from left to right).
 * 
 * For every odd-indexed level, all nodes at the level have even integer values
 * in strictly decreasing order (from left to right).
 * 
 * Given the root of a binary tree, return true if the binary tree is Even-Odd,
 * otherwise return false.
 * 
 * 
 * 
 * Example 1:
 *
 * <img src="sample_1_1966.png" width="80%"/>
 * 
 * Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 
 * Output: true
 * 
 * Explanation: The node values on each level are: Level 0: [1] Level 1: [10,4]
 * Level 2: [3,7,9] Level 3: [12,8,6,2] Since levels 0 and 2 are all odd and
 * increasing and levels 1 and 3 are all even and decreasing, the tree is
 * Even-Odd.
 * 
 * 
 * Example 2:
 * 
 * <img src="sample_2_1966.png" width="80%"/>
 * 
 * 
 * Input: root = [5,4,2,3,3,7]
 * 
 * Output: false
 * 
 * Explanation: The node values on each level are: Level 0: [5] Level 1: [4,2]
 * Level 2: [3,3,7] Node values in level 2 must be in strictly increasing order,
 * so the tree is not Even-Odd.
 * 
 * 
 * Example 3:
 * 
 * <img src="sample_1_333_1966.png" width="80%"/>
 * 
 * Input: root = [5,9,1,3,5,7]
 * 
 * Output: false
 * 
 * Explanation: Node values in the level 1 should be even integers.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 105]. 1 <= Node.val <=
 * 106
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 95.1K
 * Submissions 153.3K Acceptance Rate 62.1%
 */
public class SolutionThursday0229 {
	// Mine Solution
	public boolean isEvenOddTree1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isEvenLevel = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int lastVal = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (isEvenLevel) {
					if (temp.val % 2 == 0 || lastVal >= temp.val)
						return false;
				} else {
					if (temp.val % 2 != 0 || lastVal <= temp.val)
						return false;
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				lastVal = temp.val;

			}
			isEvenLevel = !isEvenLevel;
		}

		return true;
	}

	// Mine Solution 2
	public boolean isEvenOddTree2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isEvenLevel = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int lastVal = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (i == 0) {
					lastVal = temp.val;
				}
				if (isEvenLevel) {
					if (temp.val % 2 == 0 || lastVal >= temp.val && i != 0)
						return false;
				} else {
					if (temp.val % 2 != 0 || lastVal <= temp.val && i != 0)
						return false;
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				lastVal = temp.val;
			}
			isEvenLevel = !isEvenLevel;
		}

		return true;
	}
	
	
	//Best Solution
    private int[] h;
    private boolean recur(TreeNode root, int level){
        if(root == null){
            return true;
        }
        if((level & 1) == 0){
            if((root.val & 1) == 0){
                return false;
            }
            if(h[level] == 0){
                h[level] = root.val;
            }else{
                if(h[level] >= root.val){
                    return false;
                }else{
                    h[level] = root.val;
                }
            }
        }else{
            if((root.val & 1) == 1){
                return false;
            }
            if(h[level] == 0){
                h[level] = root.val;
            }else{
                if(h[level] <= root.val){
                    return false;
                }else{
                    h[level] = root.val;
                }
            }
        }
        return recur(root.left, level + 1) && recur(root.right, level + 1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        h = new int[100001];
        return recur(root, 0);
    }

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionThursday0229();
		TreeNode temp = new TreeNode(1);
		temp.left = new TreeNode(10);
		temp.left.left = new TreeNode(3, new TreeNode(12), new TreeNode(8));
		temp.right = new TreeNode(4, new TreeNode(7), new TreeNode(9));
		temp.right.left.left = new TreeNode(6);
		temp.right.right.right = new TreeNode(2);
		cons.accept(obj.isEvenOddTree(temp));

		temp = new TreeNode(5);
		temp.left = new TreeNode(4, new TreeNode(3), new TreeNode(3));
		temp.right = new TreeNode(2, new TreeNode(7), null);
		cons.accept(obj.isEvenOddTree(temp));

		temp = new TreeNode(5);
		temp.left = new TreeNode(9, new TreeNode(3), new TreeNode(5));
		temp.right = new TreeNode(1, new TreeNode(7), null);
		cons.accept(obj.isEvenOddTree(temp));
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

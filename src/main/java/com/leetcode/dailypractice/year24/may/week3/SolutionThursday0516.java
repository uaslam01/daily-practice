package com.leetcode.dailypractice.year24.may.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.leetcode.dailypractice.common.TreeNode;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/evaluate-boolean-binary-tree/">
 * Problem-Link</a>
 * 
 * 2331. Evaluate Boolean Binary Tree
 * 
 * Solved Easy Topics Companies Hint
 * 
 * You are given the root of a full binary tree with the following properties:
 * 
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1
 * represents True. Non-leaf nodes have either the value 2 or 3, where 2
 * represents the boolean OR and 3 represents the boolean AND. The evaluation of
 * a node is as follows:
 * 
 * If the node is a leaf node, the evaluation is the value of the node, i.e.
 * True or False. Otherwise, evaluate the node's two children and apply the
 * boolean operation of its value with the children's evaluations. Return the
 * boolean result of evaluating the root node.
 * 
 * A full binary tree is a binary tree where each node has either 0 or 2
 * children. A leaf node is a node that has zero children.
 * 
 * 
 * Example 1:
 * 
 * <img src="example1drawio1.png" width="50%" height="15%"/>
 * 
 * Input: root = [2,1,3,null,null,0,1]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The above diagram illustrates the evaluation process. The AND node evaluates
 * to False AND True = False. The OR node evaluates to True OR False = True. The
 * root node evaluates to True, so we return true.
 * 
 * Example 2:
 * 
 * Input: root = [0]
 * 
 * Output: false
 * 
 * Explanation: The root node is a leaf node and it evaluates to false, so we
 * return false.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000]. 0 <= Node.val <= 3
 * Every node has either 0 or 2 children. Leaf nodes have a value of 0 or 1.
 * Non-leaf nodes have a value of 2 or 3.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 99.4K
 * Submissions 123.6K Acceptance Rate 80.4%
 **/

public class SolutionThursday0516 {
	// Mine Solution /Best Solution 1
	public boolean evaluateTree(TreeNode root) {
		if (root.left == null)
			return root.val == 1 ? true : false;
		if (root.val == 2) {
			return evaluateTree(root.left) || evaluateTree(root.right);
		} else {
			return evaluateTree(root.left) && evaluateTree(root.right);
		}
	}

	// Best Solution 2
	public boolean evaluateTree2(TreeNode root) {
		switch (root.val) {
		case 0:
			return false;
		case 1:
			return true;
		case 2:
			return evaluateTree(root.left) || evaluateTree(root.right);
		case 3:
			return evaluateTree(root.left) && evaluateTree(root.right);
		default:
			throw new IllegalArgumentException("invalid value in tree: " + root.val);
		}
	}

	public boolean increasingTriplet(int[] nums) {
		int firstMin = nums[0];
		int secMin = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (secMin < nums[i]) {
				return true;
			}
			if (nums[i] <= firstMin) {
				firstMin = nums[i];
			} else
				secMin = nums[i];
		}
		return false;
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int maxVal = 0;
		for (int n : candies) {
			if (n > maxVal)
				maxVal = n;
		}
		List<Boolean> result = new LinkedList<>();
		for (int n : candies) {
			if (n + extraCandies >= maxVal)
				result.add(true);
			else
				result.add(false);
		}
		return result;
	}

	public boolean isSubsequence(String s, String t) {
		if (s.length() == t.length())
			return s.equals(t);
		else if (s.length() == 0)
			return true;
		int seqLen = s.length();
		int i = 0;
		for (var ch : t.toCharArray()) {
			if (ch == s.charAt(i)) {
				i++;
				if (i == seqLen)
					return true;
			}
		}
		return false;
	}

	public String reverseVowels(String s) {
		int left = 0;
		int right = s.length() - 1;
		char[] charArr = s.toCharArray();
		while (left < right) {
			while (!"aeiouAEIOU".contains(charArr[left] + "") && ++left < right) {
			}
			while (!"aeiouAEIOU".contains(charArr[right] + "") && left < --right) {
			}
			if (left < right) {
				char temp = charArr[left];
				charArr[left] = charArr[right];
				charArr[right] = temp;
				left++;
				right--;
			}
		}
		return new String(charArr);
	}
	
    public String gcdOfStrings(String str1, String str2) {
       
    	str1.matches(str2)
    }

	public int compress(char[] chars) {
		int count = 1;
		int index = 0;
		char lastCh = chars[0];
		int len = chars.length;
		for (int i = 1; i < len; i++) {

			if (lastCh == chars[i]) {
				count++;
			} else {
				chars[index++] = chars[i - 1];
				lastCh = chars[i];
				if (count>1) {
					String str = count +"";
					for(var ch: str.toCharArray()) {
						chars[index++] = ch;						
					}
				}
				count = 1;
			}
		}
		chars[index++] = chars[len - 1];
		if (count>1) {
			String str = count +"";
			for(var ch: str.toCharArray()) {
				chars[index++] = ch;						
			}
		}
		return index;
	}

	public String reverseWords(String s) {
		String[] arr = s.split(" +");
		StringBuilder strBuilder = new StringBuilder();
		for (int i = arr.length - 1; i > 0; i--) {
			strBuilder.append(arr[i]).append(" ");
		}
		strBuilder.append(arr[0]);
		return strBuilder.toString();
	}

	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> numbersMap = new HashMap<>();
		int count = 0;
		Arrays.sort(nums, 0, k);
		for (var n : nums) {
			if (numbersMap.containsKey(k - n)) {
				count++;
				int numberCount = numbersMap.get(k - n);
				if (numberCount - 1 == 0) {
					numbersMap.remove(k - n);
				} else
					numbersMap.put(k - n, numberCount - 1);
			} else if (numbersMap.containsKey(n)) {
				numbersMap.put(n, numbersMap.get(n) + 1);
			} else {
				numbersMap.put(n, 1);
			}
		}
		return count;
	}

	public static void main(String[] arg) {
		var obj = new SolutionThursday0516();
		
		System.out.println(obj.compress(new char[] { 'a' }));

		System.out.println(obj.compress(new char[] { 'a', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c' }));

		System.out.println(obj.reverseWords("a good   example"));

		System.out.println(
				obj.maxOperations(new int[] { 2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2 }, 3));

		System.out.println(obj.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(obj.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(obj.increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));

		System.out.println(obj.increasingTriplet(new int[] { 2, 12, 0, 4, 0 }));
		System.out.println(obj.increasingTriplet(new int[] { 2, 1, 2, 4, 4, 6 }));
		System.out.println(obj.increasingTriplet(new int[] { 20, 100, 10, 12, 5, 13 }));

//		TreeNode temp = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//		temp.right.left = new TreeNode(0);
//		temp.right.right = new TreeNode(1);
//		System.out.println(obj.evaluateTree(temp));
//		System.out.println(obj.evaluateTree(new TreeNode(0)));
//
//		// Custom Input
//		System.out.println(obj.evaluateTree(new TreeNode(1)));
	}
}

package com.leetcode.dailypractice.year24.mar.week1;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Problem-Link</a>
 *
 * 19. Remove Nth Node From End of List
 * 
 * Medium Topics Companies Hint
 * 
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="remove_ex1.jpg" width="80%"/>
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * 
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1], n = 1
 * 
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * Input: head = [1,2], n = 1
 * 
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz. 1 <= sz <= 30 0 <= Node.val <= 100 1
 * <= n <= sz
 * 
 * 
 * Follow up: Could you do this in one pass?
 */
public class SolutionSunday0303 {
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode temp = head;
		Stack<ListNode> stack = new Stack<>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		ListNode nextNode = null;
		while (--n > 0) {
			nextNode = stack.pop();
		}
		stack.pop();
		if (!stack.isEmpty())
			stack.pop().next = nextNode;
		else
			head = nextNode;
		return head;
	}

	// Best Solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode left = head;
		ListNode right = head.next;
		int i = 1;
		while (right != null) {
			right = right.next;
			if (i > n) {
				left = left.next;
			}
			i++;
		}

		if (i == n) {
			return head.next;
		}

		left.next = left.next.next;
		return head;
	}

	public static void main(String[] args) {
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		var obj = new SolutionSunday0303();

		ListNode temp = new ListNode(1, new ListNode(2));
		ListNode temp1 = new ListNode(3, new ListNode(4));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(5);

		cons.accept(obj.removeNthFromEnd(temp, 1));
		System.out.println("---");

		temp = new ListNode(1);
		cons.accept(obj.removeNthFromEnd(temp, 1));
		System.out.println("---");

	}

	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

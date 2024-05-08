package com.leetcode.dailypractice.year24.may.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/">
 * Problem-Link</a>
 * 
 * 
 * 2816. Double a Number Represented as a Linked List
 * 
 * Medium Topics Companies Hint
 * 
 * You are given the head of a non-empty linked list representing a non-negative
 * integer without leading zeroes. Return the head of the linked list after
 * doubling it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,8,9] Output: [3,7,8] Explanation: The figure above
 * corresponds to the given linked list which represents the number 189. Hence,
 * the returned linked list represents the number 189 * 2 = 378.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [9,9,9] Output: [1,9,9,8] Explanation: The figure above
 * corresponds to the given linked list which represents the number 999. Hence,
 * the returned linked list reprersents the number 999 * 2 = 1998.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 104] 0 <= Node.val <= 9
 * The input is generated such that the list represents a number that does not
 * have leading zeros, except the number 0 itself.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 99.9K
 * Submissions 170.9K Acceptance Rate 58.5%
 **/

public class SolutionTuesday0507 {
	// Mine Solution/Best Solution 1
	public ListNode doubleIt(ListNode head) {
		ListNode reverseListHead = reverseList(head);
		ListNode temp = reverseListHead;
		int carry = 0;
		int digit = 0;
		while (temp.next != null) {
			digit = (temp.val * 2 + carry) % 10;
			carry = (temp.val * 2) / 10;
			temp.val = digit;
			temp = temp.next;
		}
		digit = (temp.val * 2 + carry) % 10;
		carry = (temp.val * 2) / 10;
		temp.val = digit;
		if (carry > 0) {
			temp.next = new ListNode(carry);
		}
		return reverseList(reverseListHead);
	}

	public ListNode reverseList(ListNode head) {
		ListNode temp = head;
		ListNode reverseHead = null;
		if (temp == null)
			return null;
		while (temp.next != null) {
			ListNode temp1 = new ListNode(temp.val);
			temp1.next = reverseHead;
			reverseHead = temp1;
			temp = temp.next;
		}
		ListNode temp1 = new ListNode(temp.val);
		temp1.next = reverseHead;
		return temp1;

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

	public static void main(String[] arg) {
		var obj = new SolutionTuesday0507();
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		ListNode temp = new ListNode(1, new ListNode(8));
		ListNode temp1 = new ListNode(9, new ListNode(9));
		temp.next.next = new ListNode(9);
		temp1.next.next = new ListNode(9);
		cons.accept(obj.doubleIt(temp));
		System.out.println("---");

		cons.accept(obj.doubleIt(temp1));
		System.out.println("---");

		cons.accept(obj.doubleIt(new ListNode(3)));
		// Wrong output
		//[3]
		// Expected Output: [6]
	}
}

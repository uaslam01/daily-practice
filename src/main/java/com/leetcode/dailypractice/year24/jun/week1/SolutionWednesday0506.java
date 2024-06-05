package com.leetcode.dailypractice.year24.mar.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/linked-list-cycle/">Problem-Link</a>
 *
 * 141. Linked List Cycle
 * 
 * Easy Topics Companies
 * 
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * <img src="circularlinkedlist.png" width="80%"/>
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * 
 * Output: true
 * 
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).
 * 
 * Example 2:
 * 
 * <img src="circularlinkedlist_test2.png" width="40%" >
 * 
 * Input: head = [1,2], pos = 0
 * 
 * Output: true
 * 
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 0th node.
 * 
 * 
 * Example 3:
 * 
 * <img src="circularlinkedlist_test3.png" width="40%" height = "20%"/>
 * 
 * Input: head = [1], pos = -1
 * 
 * Output: false
 * 
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the list is in the range [0, 104]. -105 <=
 * Node.val <= 105 pos is -1 or a valid index in the linked-list.
 * 
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class SolutionWednesday0306 {
	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Mine Solution / Best Solution
	public boolean hasCycle1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				return false;
			if (slow == fast)
				return true;
		}
		return false;
	}

	// Best Solution 2
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] arg) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday0306();
		ListNode cycle = new ListNode(2);
		ListNode temp = new ListNode(3);
		temp.next = cycle;
		temp.next.next = new ListNode(0);
		temp.next.next.next = new ListNode(4);
		temp.next.next.next.next = cycle;
		cons.accept(obj.hasCycle(temp));
		cycle = new ListNode(1);
		temp = cycle;
		temp.next = new ListNode(2);
		temp.next.next = cycle;
		cons.accept(obj.hasCycle(temp));
		cons.accept(obj.hasCycle(new ListNode(1)));

	}

}

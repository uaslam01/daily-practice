package com.leetcode.dailypractice.year24.mar.week3;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/merge-in-between-linked-lists/">Problem-Link</a>
 * 
 * 1669. Merge In Between Linked Lists
 * 
 * Medium Topics Companies Hint
 * 
 * 
 * You are given two linked lists: list1 and list2 of sizes n and m
 * respectively.
 * 
 * Remove list1's nodes from the ath node to the bth node, and put list2 in
 * their place.
 * 
 * The blue edges and nodes in the following figure indicate the result:
 * 
 * <img src="fig1.png" width="80%" />
 * 
 * Build the result list and return its head.
 * 
 * 
 * Example 1:
 * 
 * <img src="ll.png" width="80%" />
 * 
 * Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 =
 * [1000000,1000001,1000002]
 * 
 * Output: [10,1,13,1000000,1000001,1000002,5]
 * 
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their
 * place. The blue edges and nodes in the above figure indicate the result.
 * 
 * 
 * Example 2:
 * 
 * <img src="merge_linked_list_ex2.png" width="80%" />
 * 
 * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 =
 * [1000000,1000001,1000002,1000003,1000004]
 * 
 * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 
 * Explanation: The blue edges and nodes in the above figure indicate the
 * result.
 * 
 * 
 * Constraints:
 * 
 * 3 <= list1.length <= 104 1 <= a <= b < list1.length - 1 1 <= list2.length <=
 * 104
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 139.6K
 * Submissions 178.5K Acceptance Rate 78.2%
 */
public class SolutionWednesday0320 {
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

	// Mine Solution
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode temp = list1;
		ListNode list2Last = null;
		ListNode list2Temp = list2;
		while (list2Temp.next != null)
			list2Temp = list2Temp.next;
		list2Last = list2Temp;
		int i = 1;
		while (i++ < a) {
			temp = temp.next;
		}
		ListNode temp2 = temp.next;
		temp.next = list2;
		
		int j = i-1;
		while (j++ < b) {
			temp2 = temp2.next;
		}
		list2Last.next = temp2.next;

		return list1;
	}

	public static void main(String[] args) {
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		var obj = new SolutionWednesday0320();

		ListNode temp = new ListNode(10, new ListNode(1));
		ListNode temp1 = new ListNode(13, new ListNode(6));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(9, new ListNode(5));

		ListNode list2 = new ListNode(1000000, new ListNode(1000001));
		list2.next.next = new ListNode(1000002);
		cons.accept(obj.mergeInBetween(temp, 3, 4, list2));
		System.out.println("---");

		temp = new ListNode(0, new ListNode(1));
		temp1 = new ListNode(2, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(4, new ListNode(5));
		temp1.next.next.next.next = new ListNode(6);

		list2.next.next = new ListNode(1000002, new ListNode(1000003));
		list2.next.next.next.next = new ListNode(1000004);
		cons.accept(obj.mergeInBetween(temp, 2, 5, list2));
		System.out.println("---");

	}

}

package com.leetcode.dailypractice.common;

public class ListNode {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode result = null;
		ListNode resultHead = null;
		int carry = 0;
		int digit = 0;
		while (temp1 != null || temp2 != null) {
			if (temp1 != null && temp2 != null) {
				digit = (temp1.val + temp2.val + carry) % 10;
				carry = (temp1.val + temp2.val + carry) / 10;
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else if (temp1 != null) {
				digit = (temp1.val + carry) % 10;
				carry = (temp1.val + carry) / 10;
				temp1 = temp1.next;
			} else {
				digit = (temp2.val + carry) % 10;
				carry = (temp2.val + carry) / 10;
				temp2 = temp2.next;
			}
			if (result == null) {
				result = new ListNode(digit);
				resultHead = result;
			} else {
				result.next = new ListNode(digit);
				result = result.next;
			}

		}
		if (carry > 0) {
			result.next = new ListNode(carry);
			result = result.next;
		}

		return resultHead;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;

		ListNode temp = null;
		if (list1.val < list2.val) {
			temp = list1;
			list1 = list1.next;
		} else {
			temp = list2;
			list2 = list2.next;
		}

		ListNode head = temp;

		while (list1 != null || list2 != null) {
			if (list1 == null) {
				temp.next = list2;
				list2 = list2.next;
			} else if (list2 == null) {
				temp.next = list1;
				list1 = list1.next;

			} else {
				if (list1.val < list2.val) {
					temp.next = list1;

					list1 = list1.next;
				} else {
					temp.next = list2;
					list2 = list2.next;
				}
			}
			temp = temp.next;
		}
		return head;
	}

}

package com.leetcode.dailypractice.year24.mar.week3;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/reverse-linked-list/">Problem-Link</a>
 * 
 * 206. Reverse Linked List
 * 
 * Easy Topics Companies
 * 
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * Example 1:
 * 
 * <img src="rev1ex1.jpg" width="80%" />
 * 
 * Input: head = [1,2,3,4,5] Output: [5,4,3,2,1]
 * 
 * 
 * Example 2:
 * 
 * <img src="rev1ex2.jpg" width="40%" />
 * 
 * Input: head = [1,2] Output: [2,1]
 * 
 * 
 * Example 3:
 * 
 * Input: head = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000]. -5000 <= Node.val <=
 * 5000
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 3.9M
 * Submissions 5.2M Acceptance Rate 76.0%
 */
public class SolutionThursday0321 {

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

	// Mine Solution / Best Solution
	public ListNode reverseList1(ListNode head) {
		ListNode temp = head;
		ListNode reverseHead = null;
		if(temp==null)
			return null;
		while(temp.next!=null) {
			ListNode temp1 = new ListNode(temp.val);
			temp1.next = reverseHead;
			reverseHead = temp1;
			temp = temp.next;
		}
		ListNode temp1 = new ListNode(temp.val);
		temp1.next = reverseHead;
		return temp1;
		
	}

	//Best Solution 2
	public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp;
        while(head!=null)
        {
            temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;

    }
	public static void main(String[] args) {
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		var obj = new SolutionThursday0321();

		ListNode temp = new ListNode(10, new ListNode(1));
		ListNode temp1 = new ListNode(13, new ListNode(6));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(9, new ListNode(5));

		cons.accept(obj.reverseList(temp));
		System.out.println("---");

		temp = new ListNode(0, new ListNode(1));
		temp1 = new ListNode(2, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(4, new ListNode(5));
		temp1.next.next.next.next = new ListNode(6);

		cons.accept(obj.reverseList(temp));
		System.out.println("---");

	}
}

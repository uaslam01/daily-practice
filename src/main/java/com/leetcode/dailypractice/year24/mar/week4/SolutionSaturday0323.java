package com.leetcode.dailypractice.year24.mar.week4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/reorder-list/">Problem-Link</a>
 * 
 * 143. Reorder List
 * 
 * Medium Topics Companies
 * 
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="reorder1linked-list.jpg" width="40%" />
 * 
 * Input: head = [1,2,3,4]
 * 
 * Output: [1,4,2,3]
 * 
 * 
 * Example 2:
 * 
 * <img src="reorder2-linked-list.jpg" width="40%" />
 * 
 * Input: head = [1,2,3,4,5]
 * 
 * Output: [1,5,2,4,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 5 * 104]. 1 <= Node.val
 * <= 1000
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 919.2K
 * Submissions 1.6M Acceptance Rate 57.7%
 */
public class SolutionSaturday0323 {

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
	public void reorderList1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow = slow.next;
		Deque<ListNode> stack  = new LinkedList<>();
		while(slow!=null) {
			stack.push(slow);
			slow = slow.next;
		}
		ListNode temp = head;
		ListNode temp1;

		while(!stack.isEmpty()) {
			temp1 = temp.next;
			temp.next = stack.pop();
			temp = temp.next;
			temp.next = temp1;
			temp = temp.next;
		}
		temp.next = null;
	}

	
	//Best Solution 1
	private ListNode temp;
    private boolean isStop;

    public void reorderList2(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }

        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }
    
    
    //Best Solution 2
    public static void reorderList(ListNode head) {
		if (head.next == null) {
			return;
		}
		reorderList2(head, head.next);
	}

	public static ListNode reorderList2(ListNode head, ListNode curr) {
		ListNode temp;
		if (curr.next != null) {
			temp = reorderList2(head, curr.next);
		} else {
			temp = head;
		}
		if(temp == null) {
			return null;
		}
		if (temp == curr  || temp.next == curr) {
			curr.next=null;
			return null;
		}

		curr.next = temp.next;
		temp.next = curr;
		return curr.next;
	}
	public static void main(String[] args) {
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		var obj = new SolutionSaturday0323();

		ListNode temp = new ListNode(1, new ListNode(2));
		ListNode temp1 = new ListNode(3, new ListNode(4));
		temp.next.next = temp1;
		obj.reorderList(temp);
		cons.accept(temp);
		System.out.println("---");

		temp = new ListNode(0, new ListNode(1));
		temp1 = new ListNode(2, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(4, new ListNode(5));
		temp1.next.next.next.next = new ListNode(6);

		obj.reorderList(temp);
		cons.accept(temp);
		System.out.println("---");

	}
}

package com.leetcode.dailypractice.year24.mar.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/middle-of-the-linked-list/">Problem-Link</a>
 *
 * 
 * 876. Middle of the Linked List
 * 
 * Easy Topics Companies
 * 
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="lc-midlist1.jpg" width="40%" />
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * 
 * Output: [3,4,5]
 * 
 * Explanation: The middle node of the list is node 3.
 * 
 * 
 * Example 2:
 * 
 * <img src="lc-midlist2.jpg" width="40%" >
 * 
 * Input: head = [1,2,3,4,5,6]
 * 
 * Output: [4,5,6]
 * 
 * Explanation: Since the list has two middle nodes with values 3 and 4, we
 * return the second one.
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 100]. 1 <= Node.val <=
 * 100
 */
public class SolutionThursday0307 {
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
    public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast!=null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    
    //Another Solution / Best Solution 2
    int counter = 0;
    int counter1 = 0;
    public ListNode middleNode1(ListNode head) {
        if(head == null){
            counter1 = counter;
            return head;
        }
        counter++;
        ListNode head1 = middleNode(head.next);
        System.out.println(counter + " " +  counter1);
        if((counter /2) + 1 == counter1 ){
            counter1--;
            return head;
        }
        counter1--;
        return head1;
        
    }
	
	public static void main(String[] arg) {
		Consumer cons = System.out::println;
		var obj = new SolutionThursday0307();
		
		ListNode temp = new ListNode(1);
		temp.next = new ListNode(2);
		temp.next.next = new ListNode(3);
		temp.next.next.next = new ListNode(4);
		temp.next.next.next.next = new ListNode(5);
		cons.accept(obj.middleNode(temp).val);
		temp.next.next.next.next.next = new ListNode(6);
		cons.accept(obj.middleNode(temp).val);
		//Custom Input
		temp = new ListNode(1);
		temp.next = new ListNode(2);
		temp.next.next = new ListNode(3);
		cons.accept(obj.middleNode(temp).val);
		cons.accept(obj.middleNode(new ListNode(1)).val);

	}
}

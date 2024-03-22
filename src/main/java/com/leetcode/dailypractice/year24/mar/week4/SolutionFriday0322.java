package com.leetcode.dailypractice.year24.mar.week4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/palindrome-linked-list/">Problem-Link</a>
 * 
 * 234. Palindrome Linked List
 * 
 * Easy Topics Companies
 * 
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * <img src="pal1linked-list.jpg" width="40%" />
 * 
 * Input: head = [1,2,2,1]
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * <img src="pal2linked-list.jpg" width="40%" />
 * 
 * Input: head = [1,2]
 * 
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105]. 0 <= Node.val <= 9
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.8M
 * Submissions 3.4M Acceptance Rate 52.2%
 */
public class SolutionFriday0322 {

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
	public boolean isPalindrome1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode start = head;
		slow = slow.next;
		Deque<Integer> stack  = new LinkedList<>();
		while(slow!=null) {
			stack.push(slow.val);
			slow = slow.next;
		}
		while(!stack.isEmpty()) {
			if(stack.pop()!=start.val)
				return false;
			start = start.next;
		}
		return true;
	}
	// Best Solution 
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        ListNode mid = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast= fast.next.next;
        }
        
        ListNode prev= null;
        ListNode next = null;
        
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev= mid;
            mid = next;
        }
        
        while(prev!= null){

            if(prev.val!= start.val){
                return false;
            }
            prev= prev.next;
            start= start.next;
        }
        return true;
    }
	public static void main(String[] args) {

		var obj = new SolutionFriday0322();
		ListNode temp = new ListNode(1, new ListNode(2));
		ListNode temp1 = new ListNode(2, new ListNode(1));		
		temp.next = temp1;
		System.out.println(obj.isPalindrome(temp));
		System.out.println("---");
		
		temp = new ListNode(1, new ListNode(2));
		System.out.println(obj.isPalindrome(temp));
		System.out.println("---");
		
		//Custom Input
		temp = new ListNode(10, new ListNode(1));
		temp1 = new ListNode(13, new ListNode(6));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(9, new ListNode(5));

		System.out.println(obj.isPalindrome(temp));
		System.out.println("---");

		temp = new ListNode(0, new ListNode(1));
		temp1 = new ListNode(2, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(2, new ListNode(1));
		temp1.next.next.next.next = new ListNode(0);

		System.out.println(obj.isPalindrome(temp));
		System.out.println("---");

	}
}

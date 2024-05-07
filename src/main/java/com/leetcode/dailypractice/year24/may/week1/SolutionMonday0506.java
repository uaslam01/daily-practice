package com.leetcode.dailypractice.year24.may.week1;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/remove-nodes-from-linked-list/">
 * Problem-Link</a>
 * 
 * 
 * 2487. Remove Nodes From Linked List Medium Topics Companies Hint
 * 
 * 
 * You are given the head of a linked list. Remove every node which has a node
 * with a greater value anywhere to the right side of it. Return the head of the
 * modified linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="drawio.png" width="50%"/>
 * 
 * 
 * Input: head = [5,2,13,3,8] Output: [13,8] Explanation: The nodes that should
 * be removed are 5, 2 and 3. - Node 13 is to the right of node 5. - Node 13 is
 * to the right of node 2. - Node 8 is to the right of node 3.
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1,1,1,1] Output: [1,1,1,1] Explanation: Every node has value
 * 1, so no nodes are removed.
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the given list is in the range [1, 105]. 1 <=
 * Node.val <= 105
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 112.1K
 * Submissions 156.1K Acceptance Rate 71.8%
 **/

public class SolutionMonday0506 {
	// Mine Solution/Best Solution 1
	public ListNode removeNodes2(ListNode head) {

		ListNode temp = head;
		ListNode secList = null;
		ListNode secListHead = head;
		while (temp.next != null) {
			if (temp.next.val > temp.val) {
				if (secList == null) {
					secListHead = temp.next;
				} else {
					secList.next = temp.next;
				}
				secList = temp.next;

				// temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return secListHead;
	}

	
	//Mine Solution 2
	public ListNode removeNodes(ListNode head) {

		ListNode reverseListHead = reverseList(head);
		ListNode result = null;
		int maxVal = reverseListHead.val;
		ListNode temp = reverseListHead;
		while (temp != null) {
			if(temp.val>=maxVal) {
				if(result==null) {
					result = temp;
				} else {
					result.next = temp;
					result = result.next;
					maxVal = temp.val;
					
				}
			}
			temp = temp.next;
			result.next = null;
			
		}
		return reverseList(reverseListHead);
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode temp = head;
		ListNode reverseHead = null;
        if(temp == null)
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
	// Best Solution
	public ListNode removeNodes1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		curr = prev.next;
		prev.next = null;
		while (curr != null) {
			ListNode temp = curr.next;
			if (curr.val >= prev.val) {
				curr.next = prev;
				prev = curr;
			}
			curr = temp;
		}

		return prev;
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
		var obj = new SolutionMonday0506();
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		ListNode temp = new ListNode(5, new ListNode(2));
		ListNode temp1 = new ListNode(13, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(8);
		cons.accept(obj.removeNodes(temp));
		System.out.println("---");
		
		temp = new ListNode(1, new ListNode(1));
		temp1 = new ListNode(1, new ListNode(1));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(1);

		cons.accept(obj.removeNodes(temp));
		System.out.println("---");

		// Wrong output
		// [138,466,216,67,642,978,264,136,463,331,60,600,223,275,856,809,167,101,846,165,575,276,409,590,733,200,839,515,852,615,8,584,250,337,537,63,797,900,670,636,112,701,334,422,780,552,912,506,313,474,183,792,822,661,37,164,601,271,902,792,501,184,559,140,506,94,161,167,622,288,457,953,700,464,785,203,729,725,422,76,191,195,157,854,730,577,503,401,517,692,42,135,823,883,255,111,334,365,513,338,65,600,926,607,193,763,366,674,145,229,700,11,984,36,185,475,204,604,191,898,876,762,654,770,774,575,276,165,610,649,235,749,440,607,962,747,891,943,839,403,655,22,705,416,904,765,905,574,214,471,451,774,41,365,703,895,327,879,414,821,363,30,130,14,754,41,494,548,76,825,899,499,188,982,8,890,563,438,363,32,482,623,864,161,962,678,414,659,612,332,164,580,14,633,842,969,792,777,705,436,750,501,395,342,838,493,998,112,660,961,943,721,480,522,133,129,276,362,616,52,117,300,274,862,487,715,272,232,543,275,68,144,656,623,317,63,908,565,880,12,920,467,559,91,698]
		// Expected Output: [998,961,943,920,698]
	}
}

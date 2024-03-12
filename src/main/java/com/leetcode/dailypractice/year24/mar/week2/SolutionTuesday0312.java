package com.leetcode.dailypractice.year24.mar.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">Problem-Link</a>
 * 
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 * 
 * Medium Topics Companies Hint
 * 
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list. You may return any
 * such answer.
 * 
 * 
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * 
 * Input: head = [1,2,-3,3,1]
 * 
 * Output: [3,1]
 * 
 * Note: The answer [1,2,1] would also be accepted.
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,-3,4]
 * 
 * Output: [1,2,4]
 * 
 * 
 * Example 3:
 * 
 * Input: head = [1,2,3,-3,-2]
 * 
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The given linked list will contain between 1 and 1000 nodes. Each node in the
 * linked list has -1000 <= node.val <= 1000.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 85.5K
 * Submissions 178.7K Acceptance Rate 47.9%
 */
public class SolutionTuesday0312 {
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

	//Mine Solution / Only works for two numbers, when sum is equal to zero
	public ListNode removeZeroSumSublists12(ListNode head) {
		if (head == null)
			return head;
		head.next = removeZeroSumSublists12(head.next);
		if (head.next != null && head.val + head.next.val == 0) {
			return head.next.next;
		}
		return head;
	}
	
	//Best Solution 1
	public ListNode removeZeroSumSublists1(ListNode head) {
		int prefixSum = 0;
		Map<Integer, ListNode> map = new HashMap<>();

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		map.put(0, dummy);

		while (head != null) {
			prefixSum += head.val;
			if (map.containsKey(prefixSum)) {
				ListNode p = map.get(prefixSum);
				ListNode start = p;
				int pSum = prefixSum;

				while (start != head) {
					start = start.next;
					pSum += start.val;
					if (start != head) {
						map.remove(pSum);
					}
				}
				p.next = start.next;

			} else {
				map.put(prefixSum, head);
			}

			head = head.next;
		}
		return dummy.next;
	}
	
	//Best Solution 2
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)return head;
        ListNode prev = null;
        ListNode cur = head;
        int  running_sum=0;
        while(cur!=null)
        {
            running_sum += cur.val;
            if(running_sum==0)
            {
                if(prev == null)
                head = cur.next;
                else
                prev.next = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

	public static void main(String[] args) {
		Consumer<ListNode> cons = x -> {
			while (x != null) {
				System.out.print(x.val);
				x = x.next;
			}
		};
		var obj = new SolutionTuesday0312();

		ListNode temp = new ListNode(1, new ListNode(2));
		ListNode temp1 = new ListNode(-3, new ListNode(3));
		temp.next.next = temp1;
		temp1.next.next = new ListNode(1);
		cons.accept(obj.removeZeroSumSublists(temp));
		System.out.println("---");

		temp1 = new ListNode(3, new ListNode(-3));
		temp1.next.next = new ListNode(4);
		temp.next.next = temp1;
		cons.accept(obj.removeZeroSumSublists(temp));
		System.out.println("---");

		temp1.next.next = new ListNode(-2);
		temp.next.next = temp1;
		cons.accept(obj.removeZeroSumSublists(temp));
		System.out.println("---");

		// Wrong Output: [5,-3,-4,1,6,-2,-5]
		// Expected: [5,-2,-5]

	}
}
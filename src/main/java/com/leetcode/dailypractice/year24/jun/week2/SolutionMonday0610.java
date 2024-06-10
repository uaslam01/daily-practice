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
public class SolutionMonday0310 {
	// Mine Solution / Best Solution
	    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int i : heights) {
            arr[i]++;
        }
        int res = 0;
        int startInd = 1;
        for (int i = 0; i < heights.length; i++) {
            while (arr[startInd] == 0) {
                startInd++;
            }
            if (startInd != heights[i])
                res++;
            arr[startInd]--;
        }
        return res;
    }
	public static void main(String[] arg) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday0310();
		cons.accept(obj.hasCycle(temp));
		cons.accept(obj.hasCycle(new ListNode(1)));

	}

}

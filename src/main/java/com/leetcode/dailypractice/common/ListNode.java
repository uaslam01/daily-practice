package com.leetcode.dailypractice.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListNode {
	public int val;
	public ListNode next;
	public boolean isVisited;
	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
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
	
    public int getMaximumGold(int[][] grid) {
        List<ListNode> list = new ArrayList<>();
        Map<String, ListNode> map = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        for(int i=0;i<rows;i++) {
        	for(int j=0;j<cols;j++) {
        		if(grid[i][j]!=0) {
        			ListNode temp = null;
        			if(!map.containsKey(i+""+j)) {
            			temp = new ListNode(grid[i][j]);
            			map.put(i+""+j, temp);
        			}
        			if(map.containsKey((i-1)+""+j)) {
        				temp.next = map.get((i-1)+""+j);
        				temp = temp.next;
        			}
        			if(map.containsKey(i+""+(j-1))) {
        				temp.next = map.get(i+""+(j-1));
        				temp = temp.next;
        			}
        			if(i+1<rows && grid[i+1][j]>0) {
            			ListNode temp1 = new ListNode(grid[i+1][j]);
            			map.put((i+1)+""+j, temp1);
        				temp.next = temp1;
        				temp = temp.next;
        			}
        			if(j+1<cols && grid[i][j+1]>0) {
        				ListNode temp1 = new ListNode(grid[i][j+1]);
            			map.put((i)+""+j+1, temp1);
            			temp.next = temp1;
        				temp = temp.next;
        			}
        			list.add(temp);
        		}
        	}
        	for(ListNode temp: list) {
        		temp.isVisited = true;
        		int totalGold = 0;
        		while(temp!=null) {
        			totalGold+=getTotalGoldByDFS(temp);
        			temp = temp.next;
        		}
        		if(maxGold<totalGold)
        			maxGold = totalGold;
        		
        	}
        }
        return maxGold;
    }
    int getTotalGoldByDFS(ListNode temp) {
    	if(temp==null || temp.isVisited)
    		return 0;
    	return temp.val+getTotalGoldByDFS(temp.next);
    }

}

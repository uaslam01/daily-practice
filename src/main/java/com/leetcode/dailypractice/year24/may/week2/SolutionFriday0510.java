package com.leetcode.dailypractice.year24.may.week2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/k-th-smallest-prime-fraction/">
 * Problem-Link</a>
 * 
786. K-th Smallest Prime Fraction

Medium
Topics
Companies

You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.


Example 2:

Input: arr = [1,7], k = 1
Output: [1,7]
 

Constraints:

2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 104
arr[0] == 1
arr[i] is a prime number for i > 0.
All the numbers of arr are unique and sorted in strictly increasing order.
1 <= k <= arr.length * (arr.length - 1) / 2
 

Follow up: Can you solve the problem with better than O(n2) complexity?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
71K
Submissions
116.7K
Acceptance Rate
60.9%
 **/

public class SolutionFriday0510 {
	//Mine Solution /Best Solution 1
	private class Pair implements Comparable<Pair>{
		int i;
		int j;
		double fraction;
		
		Pair(int i, int j, double frac){
			this.i = i;
			this.j = j;
			this.fraction = frac;
					
		}

		@Override
		public int compareTo(Pair o) {
			return o.fraction<this.fraction?1:o.fraction>this.fraction?-1:0;
		}
		
	}
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    	int[] pair = new int[2];
    	PriorityQueue<Pair> pq = new PriorityQueue<>(k);

    	int len = arr.length-1;

    	int i=0;
    	int j=len-1;
    	int y = i+1;
    	int z = len;
    	
    	while(--k>0) {
    		if(arr[i]*1.0/arr[j]<arr[y]*1.0/arr[z]) {
    			j--;
    			pq.add(new Pair(i, j, arr[i]*1.0/arr[j]));
    		} else {
    			z--;
    			pq.add(new Pair(i, j, arr[i]*1.0/arr[z]));
    		}
    		
    	}
    	pair[0] = i;
    	pair[1] = j;
    	return pair;
    }  
    
    
	public static void main(String[] arg) {
		var obj = new SolutionFriday0510();
		IntConsumer cons = System.out::println;
		Consumer<int[]> arrConsumer = x -> Arrays.stream(x).forEach(cons);

		arrConsumer.accept(obj.kthSmallestPrimeFraction(new int[] { 1, 2, 3 }, 2));
		arrConsumer.accept(obj.kthSmallestPrimeFraction(new int[] { 1, 2, 3 }, 2));
		arrConsumer.accept(obj.kthSmallestPrimeFraction(new int[] { 1, 2, 3 }, 2));

	}
}

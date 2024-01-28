package com.leetcode.dailypractice.year24.jan.week4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
  * <pre>
 * <a href=
 * "https://leetcode.com/problems/k-inverse-pairs-array/">Problem-Link</a>
 * 
 * 629. K Inverse Pairs Array
 * 
 * Attempted Hard Topics Companies
 * 
 * 
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where
 * 0 <= i < j < nums.length and nums[i] > nums[j].
 * 
 * Given two integers n and k, return the number of different arrays consist of
 * numbers from 1 to n such that there are exactly k inverse pairs. Since the
 * answer can be huge, return it modulo 109 + 7.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, k = 0
 * 
 * Output: 1
 * 
 * Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has
 * exactly 0 inverse pairs.
 * 
 * 
 * Example 2:
 * 
 * Input: n = 3, k = 1
 * 
 * Output: 2
 * 
 * Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000 0 <= k <= 1000 Seen this question in a real interview before?
 * 1/4 Yes No Accepted 92.9K Submissions 195.6K Acceptance Rate 47.5%
 */
public class SolutionSaturday0127 {
	//Mine Solution
	static int totalPairs = 0;
	static int size;
	static int requiredPairs;
	static int initialCount=0;
    public int kInversePairs(int n, int k) {
    	 if(k==0)
             return 1;
         if(k>n)
             return 0;
	    initialCount = 0;
	    totalPairs =0;
        size = n;
        requiredPairs = k;
        Deque<Integer> stack = new ArrayDeque<>();
        dpSolutionToFindKPairs(n, stack);
    	return totalPairs;
    }
    public void dpSolutionToFindKPairs(int n, Deque<Integer> stack) {
    	if(n==0)
    		return;
    	int counter = initialCount;
    	for(int i=0; i<n;i++) {
        	counter = (counter)%size+1;
        	while(stack.contains(counter)) {
        		counter = (counter)%size+1;
        	}
    		stack.push(counter);
    		dpSolutionToFindKPairs(n-1, stack);
        	calculatePairs(stack.stream().collect(Collectors.toList()));
    		stack.pop();
    	}
    }
    void calculatePairs(List<Integer> list)
    {
    	int k = 0;
    	if(list.size()!=size)
    		return;
    	for(int i=0; i<list.size()-1;i++) {
    		for(int j=i+1; j<list.size();j++) {
        		if(list.get(i)>list.get(j)) {
        			k++;
        		}
        		if(k>requiredPairs)
        			return;
        			
        	}	
    	}
    	if(k==requiredPairs)
    		totalPairs++;
    }
    //Best Solution
    public int kInversePairs1(int n, int k) {
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x <= Math.min(j, i - 1); x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1000000007;
                    }
                }
            }
        }

        return dp[n][k];
    }
	public static void main(String[] args) {
		var obj = new SolutionSaturday0127();
		//Wrong Answer on my solution
		System.out.println(obj.kInversePairs(3, 3));
		System.out.println(obj.kInversePairs(3, 2));
		//Time Limit Exceeds
		long initTime = System.currentTimeMillis();
		System.out.println(obj.kInversePairs(10, 1));
		System.out.println((System.currentTimeMillis()-initTime));
		
		//Sample input
		System.out.println(obj.kInversePairs(3, 1));

		System.out.println(obj.kInversePairs(3, 0));
	}
}
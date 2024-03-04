package com.leetcode.dailypractice.year24.mar.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/bag-of-tokens/">Problem-Link</a>
 *
 * 948. Bag of Tokens
 * 
 * Medium Topics Companies
 * 
 * You start with an initial power of power, an initial score of 0, and a bag of
 * tokens given as an integer array tokens, where each tokens[i] donates the
 * value of tokeni.
 * 
 * Your goal is to maximize the total score by strategically playing these
 * tokens. In one move, you can play an unplayed token in one of the two ways
 * (but not both for the same token):
 * 
 * Face-up: If your current power is at least tokens[i], you may play tokeni,
 * losing tokens[i] power and gaining 1 score.
 * 
 * Face-down: If your current score is at least 1, you may play tokeni, gaining
 * tokens[i] power and losing 1 score.
 * 
 * Return the maximum possible score you can achieve after playing any number of
 * tokens.
 * 
 * 
 * Example 1:
 * 
 * Input: tokens = [100], power = 50
 * 
 * Output: 0
 * 
 * Explanation: Since your score is 0 initially, you cannot play the token
 * face-down. You also cannot play it face-up since your power (50) is less than
 * tokens[0] (100).
 * 
 * 
 * Example 2:
 * 
 * Input: tokens = [200,100], power = 150
 * 
 * Output: 1
 * 
 * Explanation: Play token1 (100) face-up, reducing your power to 50 and
 * increasing your score to 1.
 * 
 * There is no need to play token0, since you cannot play it face-up to add to
 * your score. The maximum score achievable is 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = [100,200,300,400], power = 200
 * 
 * Output: 2
 * 
 * 
 * Explanation: Play the tokens in this order to get a score of 2:
 * 
 * Play token0 (100) face-up, reducing power to 100 and increasing score to 1.
 * 
 * Play token3 (400) face-down, increasing power to 500 and reducing score to 0.
 * 
 * Play token1 (200) face-up, reducing power to 300 and increasing score to 1.
 * 
 * Play token2 (300) face-up, reducing power to 0 and increasing score to 2.
 * 
 * The maximum score achievable is 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= tokens.length <= 1000 0 <= tokens[i], power < 104
 * 
 * Seen this question in a real interview before? 1/4 Yes No
 * 
 * Accepted 148.3K Submissions 266.7K Acceptance Rate 55.6%
 */
public class SolutionMonday0304 {
	// Mine Solution
	public int bagOfTokensScore1(int[] tokens, int power) {
		List<Integer> list = new ArrayList<>();
		for (int token : tokens) {
			list.add(token);
		}
		Collections.sort(list);
		int score = 0;
		int startInd = 0;
		int endInd = tokens.length;
		boolean toContinue = true;
		while (toContinue) {
			if (startInd == endInd) {
				toContinue = false;
			} else {
				int val = list.get(startInd);
				if (val <= power) {
					score++;
					startInd++;
					power -= val;
				} else {
					if (score > 0 && startInd != endInd - 1) {
						power += list.get(--endInd);
						score--;
					} else {
						toContinue = false;
					}
				}
			}
		}
		return score;
	}

	// Best Solution
	public int bagOfTokensScore2(int[] tokens, int power) {
		int score = 0, last = tokens.length, ans = 0, i = 0;
		quicksort(tokens, 0, last - 1);
		while (i < last && (power >= tokens[i] || score > 0)) {
			if (power >= tokens[i]) {
				power -= tokens[i];
				score++;
				i++;
			} else {
				score--;
				power += tokens[--last];
			}
			ans = Math.max(score, ans);
		}
		return ans;
	}

	private void quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(arr, left, right);
			quicksort(arr, left, pivotIndex - 1);
			quicksort(arr, pivotIndex + 1, right);
		}
	}

	private int partition(int[] arr, int left, int right) {
		int pivotValue = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivotValue) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		return i + 1;
	}
	
	//Best Solution 2
	public int bagOfTokensScore(int[] tokens, int power) {


        Arrays.sort(tokens);
        int i=0;
        int k=tokens.length-1;
        int score=0;

      while (i <= k) {
          
            if (tokens[i] <= power) {
                power -= tokens[i];
                score++;
                i++;
            
            } else if (score > 0 && i != k) {
                power += tokens[k];
                score--;
                k--;
            } else {
                break;
            }
        }  
        return score;
    }

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday0304();
		cons.accept(obj.bagOfTokensScore(new int[] { 100 }, 50));
		cons.accept(obj.bagOfTokensScore(new int[] { 200, 100 }, 150));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 300, 400 }, 200));
		// Custom Input
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 300, 400 }, 200));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 200, 400 }, 200));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 200, 200 }, 200));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 300, 400 }, 50));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 200, 200 }, 200));
		cons.accept(obj.bagOfTokensScore(new int[] { 100, 200, 200, 200 }, 100));
	}
}

package com.leetcode.dailypractice.year24.mar.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.IntConsumer;

/**
 * *
 * 
 * <pre>
 * <a href= "https://leetcode.com/problems/task-scheduler/">Problem-Link</a>
 * 
 * 621. Task Scheduler
 * 
 * Medium Topics Companies
 * 
 * You are given an array of CPU tasks, each represented by letters A to Z, and
 * a cooling time, n. Each cycle or interval allows the completion of one task.
 * Tasks can be completed in any order, but there's a constraint: identical
 * tasks must be separated by at least n intervals due to cooling time.
 * 
 * ​Return the minimum number of intervals required to complete all tasks.
 * 
 * 
 * Example 1:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * 
 * Output: 8
 * 
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A ->
 * B.
 * 
 * After completing task A, you must wait two cycles before doing A again. The
 * same applies to task B. In the 3rd interval, neither A nor B can be done, so
 * you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
 * 
 * 
 * Example 2:
 * 
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * 
 * Output: 6
 * 
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * 
 * With a cooling interval of 1, you can repeat a task after just one other
 * task.
 * 
 * 
 * Example 3:
 * 
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * 
 * Output: 10
 * 
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle
 * -> idle -> A -> B.
 * 
 * There are only two types of tasks, A and B, which need to be separated by 3
 * intervals. This leads to idling twice between repetitions of these tasks.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= tasks.length <= 104 tasks[i] is an uppercase English letter. 0 <= n <=
 * 100
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 537.8K
 * Submissions 916.6K Acceptance Rate 58.7%
 */
public class SolutionTuesday0319 {

	// Mine Solution
	public int leastInterval(char[] tasks, int n) {
		List<Character> result = new ArrayList<>();
		Map<Character, Integer> charCountMap = new HashMap<>();
		for (char task : tasks) {
			if (charCountMap.containsKey(task)) {
				charCountMap.put(task, charCountMap.get(task) + 1);
			} else {
				charCountMap.put(task, 1);
			}
		}
		Queue<Character> queue = new ArrayDeque<>();
		for (int i = 0; i<tasks.length;i++) {
			char val = checkLastSotre(queue, n, tasks[i],  charCountMap);
			result.add(val);
			i = val=='#'?i-1:i;

		}
		return result.size();
	}

	char checkLastSotre(Queue<Character> queue, int n, char nextCh,  Map<Character, Integer> charCountMap) {
		char res ='#';
		if (!queue.contains(nextCh)) {
			res = nextCh;
		} else {
			for (char key : charCountMap.keySet()) {
				if (!queue.contains(key)) {
					res = key;
					break;
				}

			}			
		}
		if (queue.size() == n) {
			queue.remove();
		}
		queue.add(res);
		
		Integer val = charCountMap.get(res);
		if(val==null)
			return res;
		if (val==1) {
			charCountMap.remove(res);
		} else {
			charCountMap.put(res, val - 1);
		}
		
		return res;
	}
	
	//Best Solution
    public int leastInterval2(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idle = chunk * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(chunk, freq[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
	public static void main(String[] args) {
		IntConsumer cons = System.out::print;

		var obj = new SolutionTuesday0319();

		cons.accept(obj.leastInterval(new char[] { 'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E' }, 2));

		cons.accept(obj.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println();
		cons.accept(obj.leastInterval(new char[] { 'A', 'C', 'A', 'B', 'D', 'B' }, 1));
		System.out.println();
		cons.accept(obj.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3));
		System.out.println();

		// Custom Input
		//Getting 13 expecetd value 12
		cons.accept(obj.leastInterval(new char[] { 'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E' }, 2));

	}
}

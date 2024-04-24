package com.leetcode.dailypractice.year24.apr.week4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/open-the-lock/">Problem-Link</a>
 * 
 * 
 * 752. Open the Lock
 * 
 * Medium Topics Companies Hint
 * 
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4
 * wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * 
 * Example 1:
 * 
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * 
 * Explanation: A sequence of valid moves would be "0000" -> "1000" -> "1100" ->
 * "1200" -> "1201" -> "1202" -> "0202". Note that a sequence like "0000" ->
 * "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the wheels of
 * the lock become stuck after the display becomes the dead end "0102".
 * 
 * Example 2:
 * 
 * Input: deadends = ["8888"], target = "0009" Output: 1 Explanation: We can
 * turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * Example 3:
 * 
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888" Output: -1
 * 
 * Explanation: We cannot reach the target without getting stuck.
 * 
 * 
 * Constraints:
 * 
 * 1 <= deadends.length <= 500 deadends[i].length == 4 target.length == 4 target
 * will not be in the list deadends. target and deadends[i] consist of digits
 * only.
 * 
 * Seen this question in a real interview before? 1/5 Yes No Accepted 257.3K
 * Submissions 446.5K Acceptance Rate 57.6%
 */
public class SolutionMonday0422 {
	//Mine Solution
    public int openLock(String[] deadends, String target) {
    	int thousands = target.charAt(0)-'0';
    	int hundreds = target.charAt(1)-'0';
    	int tens = target.charAt(2)-'0';
    	int units = target.charAt(3)-'0';
    	
    	int counter = 0;
    	
    	boolean isOpenLock = false;
    	while(!isOpenLock) {
    		if(9-units<units) {
    			
    			counter+=1;
    		} else {
    			
    		}
    	}
        return 0;
    }
    
    public boolean isBlockedDigit(String number, int index, String[] deadends) {
    	for(var s: deadends) {
    	}
    	return false;
    }
    
    
    
    //Best Solution
    public int openLock1(String[] deadends, String target) {
        int[] pow10 = {1, 10, 100, 1000};
        int[] visit = new int[10000]; // 0: not visited, 1: visited through forward direction, -1: visited through backward direction, 2: deadends
        for(String dead: deadends) {
            visit[Integer.parseInt(dead)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), steps = 0, dir = 1;
        if(visit[src] == 2 || visit[dest] == 2) return -1;
        if(src == dest) return 0;
        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        visit[src] = 1;
        backward.add(dest);
        visit[dest] = -1;
        while(!forward.isEmpty() && !backward.isEmpty()) {
            if(forward.size() > backward.size()) {
                Queue<Integer> tmp = forward; forward = backward; backward = tmp;
                dir = -dir;
            }
            steps++;
            int size = forward.size();
            while(size-- > 0) {
                int cur = forward.poll();
                for(int p: pow10) {
                    int d = (cur / p) % 10;
                    for(int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = cur + (z - d) * p;
                        if(visit[next] == -dir) return steps;
                        if(visit[next] == 0) {
                            forward.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

package com.leetcode.dailypractice.year24.feb.week3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-the-town-judge/">Problem-Link</a>
 *
 * 997. Find the Town Judge
 * 
 * Easy Topics Companies
 * 
 * 
 * In a town, there are n people labeled from 1 to n. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * The town judge trusts nobody.
 * 
 * Everybody (except for the town judge) trusts the town judge.
 * 
 * There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given an array trust where trust[i] = [ai, bi] representing that the
 * person labeled ai trusts the person labeled bi. If a trust relationship does
 * not exist in trust array, then such a trust relationship does not exist.
 * 
 * Return the label of the town judge if the town judge exists and can be
 * identified, or return -1 otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2, trust = [[1,2]]
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: n = 3, trust = [[1,3],[2,3]]
 * 
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * 
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000 0 <= trust.length <= 104 trust[i].length == 2 All the pairs of
 * trust are unique. ai != bi 1 <= ai, bi <= n
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 496.6K
 * Submissions 1M Acceptance Rate 49.4%
 */
public class SolutionThursday0222 {
	//Mine Solution
    public int findJudge1(int n, int[][] trust) {
        boolean[] trustees = new boolean[n];
        for(int i=0;i<trust.length;i++) {
        	trustees[trust[i][0]-1]=true;
        }
        boolean isJudgeExist = false;
        int judgeIndex = -1;
        for(int i=0; i<n;i++) {
        	if(trustees[i]==false) {
        		isJudgeExist = true;
        		judgeIndex = i+1;
        	}
        }
        if(isJudgeExist==false)
        	return -1;
        else {
        	Set<Integer> set = new HashSet<>();
            for(int i=0;i<trust.length;i++) {
            	if(trust[i][1]==judgeIndex) {
            		set.add(i);
            	}
            }
        	return set.size()==n-1?judgeIndex:-1;	
        }  		
    }
    //Best Solution
    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int indegree[] = new int[n + 1];
        for(int i = 0; i < m; i++){
            indegree[trust[i][1]]++;
        }

        int answer = -1;

        for(int i = 1; i <= n; i++){
            if(indegree[i] == n - 1){
                answer = i;
            }
        }

        for(int i = 0; i < m; i++){
            if(trust[i][0] == answer){
                return -1;
            }
        }

        return answer;
        
    }
    
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionThursday0222();
		cons.accept(obj.findJudge(3, new int[][] {{1,3},{1,3}}));

		cons.accept(obj.findJudge(2, new int[][] {{1,2}}));
		cons.accept(obj.findJudge(3, new int[][] {{1,3},{2,3}}));
		cons.accept(obj.findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));
		


	}
}

package com.leetcode.dailypractice.year24.feb.week1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/first-unique-character-in-a-string/">Problem-Link</a>
 * 
 * 
 * 387. First Unique Character in a String
 * 
 * Easy Topics Companies
 * 
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode"
 * 
 * Output: 0
 * 
 * 
 * Example 2:
 * 
 * Input: s = "loveleetcode"
 * 
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "aabb"
 * 
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of only lowercase English letters.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 1.6M
 * Submissions 2.6M Acceptance Rate 61.5%
 */
public class SolutionMonday0205 {
	//Mine Solution
    public int firstUniqChar(String s) {
    	Set<Character> repeatedChars = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
        	char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.remove(ch);
                repeatedChars.add(ch);
            } else if(!repeatedChars.contains(ch)) {
                map.put(ch, i);
            }
        }
        return map.isEmpty()?-1:map.entrySet().iterator().next().getValue();
    }
    
	public static void main(String[] args) {
		var obj = new SolutionMonday0205();
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println("----");

		System.out.println(obj.firstUniqChar("loveleetcode"));
		System.out.println("----");
		
		System.out.println(obj.firstUniqChar("aabb"));
		System.out.println("----");
		
		//Got wrong answer on aadadaad, updated the code
		System.out.println(obj.firstUniqChar("aadadaad"));
		System.out.println("----");
		

	}
}
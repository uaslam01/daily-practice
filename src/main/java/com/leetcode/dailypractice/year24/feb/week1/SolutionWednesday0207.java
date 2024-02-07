package com.leetcode.dailypractice.year24.feb.week1;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/sort-characters-by-frequency/">Problem-Link</a>
 * 
 * 451. Sort Characters By Frequency
 * 
 * Medium Topics Companies
 * 
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * 
 * Return the sorted string. If there are multiple answers, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: s = "cccaaa"
 * 
 * Output: "aaaccc"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and
 * "aaaccc" are valid answers.
 * 
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * Example 3:
 * 
 * Input: s = "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * 
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 105 s consists of uppercase and lowercase English
 * letters and digits.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 647.5K
 * Submissions 902.8K Acceptance Rate 71.7%
 */
public class SolutionWednesday0207 {
	// Mine Solution
	public String frequencySort1(String s) {
		int[] lowerCaseArr = new int[26];
		int[] upperCaseArr = new int[26];
		int[] digits = new int[10];

		for (var ch : s.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				lowerCaseArr[ch - 'a']++;
			} else if (ch >= 'A' && ch <= 'Z') {
				upperCaseArr[ch - 'A']++;
			} else {
				digits[ch - '0']++;
			}
		}
		Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

		for (int i = 0; i < 26; i++) {
			if (lowerCaseArr[i] != 0) {
				char ch = (char) ('a' + i);
				if (map.containsKey(lowerCaseArr[i])) {
					map.put(lowerCaseArr[i], map.get(lowerCaseArr[i]) + "" + ch);
				} else
					map.put(lowerCaseArr[i], "" + ch);

			}
			if (upperCaseArr[i] != 0) {
				char ch = (char) ('A' + i);
				if (map.containsKey(upperCaseArr[i])) {
					map.put(upperCaseArr[i], map.get(upperCaseArr[i]) + "" + ch);
				} else
					map.put(upperCaseArr[i], "" + ch);
			}

		}
		for (int i = 0; i < 10; i++) {
			if (digits[i] != 0) {
				char ch = (char) ('0' + i);
				if (map.containsKey(digits[i])) {
					map.put(digits[i], map.get(digits[i]) + "" + ch);
				} else
					map.put(digits[i], "" + ch);
			}
		}
		StringBuilder answer = new StringBuilder();
		for (var entry : map.entrySet()) {
			int key = entry.getKey();
			String val = entry.getValue();
			for (int i = 0; i < val.length(); i++) {
				answer.append((val.charAt(i) + "").repeat(key));
			}
		}

		return answer.toString();
	}
	
	//Best Solution
    public String frequencySort(String s) {
        char[] str=s.toCharArray();
         int[] freq=new int[128];
         // for(char ch:s) freq[ch]++;
         for(int i=0;i<str.length;i++) freq[str[i]]++;
         for(int i=0;i<str.length;){
             char cmax=',';
             for(int j=0;j<128;j++){
                 if(freq[j]>freq[cmax]) cmax=(char)j;
             }
             while(freq[cmax]!=0){
                 str[i++]=cmax;
                 freq[cmax]--;
             }
         }
         return new String(str);
     }

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionWednesday0207();
		//Wrong Answer
		cons.accept(obj.frequencySort("AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZaabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz0011223344556677889"));

		cons.accept(obj.frequencySort("tree"));
		cons.accept(obj.frequencySort("cccaaa"));
		cons.accept(obj.frequencySort("Aabb"));
		

	}
}

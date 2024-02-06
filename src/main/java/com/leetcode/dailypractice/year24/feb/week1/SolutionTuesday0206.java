package com.leetcode.dailypractice.year24.feb.week1;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/group-anagrams/">Problem-Link</a>
 * 
 * 49. Group Anagrams
 * 
 * Medium Topics Companies
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * 
 * Input: strs = [""]
 * 
 * Output: [[""]]
 * 
 * Example 3:
 * 
 * Input: strs = ["a"]
 * 
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lowercase English letters.
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 2.6M
 * Submissions 3.8M Acceptance Rate 67.9%
 */
public class SolutionTuesday0206 {
	// Mine Solution
	public List<List<String>> groupAnagrams1(String[] strs) {
		int[][] alphabetsArr = new int[strs.length][26];
		for (int i = 0; i < strs.length; i++) {
			for (var ch : strs[i].toCharArray()) {
				alphabetsArr[i][ch - 'a']++;
			}
		}
		List<List<String>> res = new ArrayList<>();
		
		for (int i = 0; i < strs.length; i++) {
			List<String> list = new ArrayList<>();
			if(strs[i]==null)
				continue;
			
			list.add(strs[i]);
			
			for (int j = i+1; j < strs.length; j++) {
				if (strs[j]!=null && strs[i].length() == strs[j].length() && isEqualFreq(alphabetsArr[i], alphabetsArr[j])) {
					list.add(strs[j]);
					strs[j]= null;
				}
			}
			strs[i]=null;
			res.add(list);
		}
		return res;
	}

	private boolean isEqualFreq(int[] arr1, int[] arr2) {
		for (int i = 0; i < 26; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	//Best Solution
    //TC: O(N (K + 26)) K: longest length of a word
    //SC: O(N (K + 26))
    public String getSignature(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
        }

        result.addAll(groups.values());

        return result;
    }
    
    private List<List<String>> res;

    public List<List<String>> groupAnagrams(String[] strs) {        
        return new AbstractList<List<String>>() {
            public List<String> get(int index) {
                if (res == null) init();
                return res.get(index);
            }
            
            public int size() {
                if (res == null) init();
                return res.size();
            }
            
            private void init() {
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                    int[] count = new int[26];
                    for (char c : s.toCharArray()) {
                        count[c - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (count[i] != 0) {
                            sb.append('a' + i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
                    res = new ArrayList<>(map.values());
                }
            }
        };
    }
    
	public static void main(String[] args) {
		var obj = new SolutionTuesday0206();
		Consumer<List<String>> consumer = x -> x.forEach(System.out::println);

		obj.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }).forEach(consumer);
		System.out.println("----");

		obj.groupAnagrams(new String[] { "a" }).forEach(consumer);
		System.out.println("----");

		obj.groupAnagrams(new String[] { "" }).forEach(consumer);
		System.out.println("----");

	}
}

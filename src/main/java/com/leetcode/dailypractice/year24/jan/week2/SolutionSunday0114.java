package com.leetcode.dailypractice.year24.jan.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/determine-if-two-strings-are-close/">Problem-Link</a>
 * 
 * 1657. Determine if Two Strings Are Close Medium Topics Companies Hint 
 * 
 * Two strings are considered close if you can attain one from the other using the
 * following operations:
 * 
 * Operation 1: Swap any two existing characters. For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into
 * another existing character, and do the same with the other character. For
 * example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * 
 * Given two strings, word1 and word2, return true if word1 and word2 are close,
 * and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "abc", word2 = "bca" Output: true Explanation:
 * 
 * You can attain word2 from word1 in 2 operations. Apply Operation 1: "abc" ->
 * "acb" Apply Operation 1: "acb" -> "bca" 
 * 
 * Example 2:
 * 
 * Input: word1 = "a", word2 = "aa" Output: false Explanation:
 * 
 * It is impossible to attain word2 from word1, or vice versa, in any number of
 * operations. 
 * 
 * Example 3:
 * 
 * Input: word1 = "cabbba", word2 = "abbccc" Output: true Explanation:
 * 
 * You can attain word2 from word1 in 3 operations. Apply Operation 1: "cabbba"
 * -> "caabbb" Apply Operation 2: "caabbb" -> "baaccc" Apply Operation 2:
 * "baaccc" -> "abbccc"
 * 
 * 
 * Constraints:
 * 
 * 1 <= word1.length, word2.length <= 105 word1 and word2 contain only lowercase
 * English letters. Seen this question in a real interview before? 1/4 Yes No
 * Accepted 241.8K Submissions 441.4K Acceptance Rate 54.8%
 **/
public class SolutionSunday0114 {
	//Mine Solution(Best Solution)
    public boolean closeStrings1(String word1, String word2) {
    	int[] charCountWord1 = new int[26];
    	int[] charCountWord2 = new int[26];

    	for(char ch: word1.toCharArray()) {
    		charCountWord1[ch-'a']++;
    	}
    	for(char ch: word2.toCharArray()) {
    		charCountWord2[ch-'a']++;
    	}
    	for(int i = 0; i < 26; i++) {
    		if(charCountWord1[i]!=0&&charCountWord2[i]==0)
    			return false;
    		if(charCountWord2[i]!=0&&charCountWord1[i]==0)
    			return false;

    	}    	
    	Arrays.sort(charCountWord1);
    	Arrays.sort(charCountWord2);
        return Arrays.equals(charCountWord1, charCountWord2);
    }
    /**
    Other Solution
    Approach
    1. Create frequency maps for both words.
    2. Check if the character sets of both words are identical.
    3. Compare the frequency groups of both words.
    Complexity
    Time complexity: O(n + m + u log u), if the character set is fixed (like 26 letters), the O(u log u) term can be considered O(1), so ending in O(n + m). N, M are the length of input strings, U - unique characters.
    Space complexity: O(u)O(u)O(u), if u = 26 -> O(1)
    */
    public boolean closeStrings(String word1, String word2) {

        var freqMapOfWord1 = getCharFrequencyMap(word1);
        var freqMapOfWord2 = getCharFrequencyMap(word2);

        return areCharSetsIdentical(freqMapOfWord1.keySet(), freqMapOfWord2.keySet())
               && areFrequencyGroupsEquals(freqMapOfWord1, freqMapOfWord2);
    }

    private <K, V extends Comparable<? super V>> boolean areFrequencyGroupsEquals(Map<K, V> freqMapOne, Map<K, V> freqMapTwo) {

        if (freqMapOne.size() != freqMapTwo.size()) return false;

        List<V> list1 = new ArrayList<>(freqMapOne.values());
        List<V> list2 = new ArrayList<>(freqMapTwo.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

    private boolean areCharSetsIdentical(Set<Character> set1, Set<Character> set2) {
        return set1.equals(set2);
    }

    private Map<Character, Integer> getCharFrequencyMap(String s) {

        Map<Character, Integer> resultMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            resultMap.merge(ch, 1, Integer::sum);
        }

        return resultMap;
    }

    public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionSunday0114();
		cons.accept(obj.closeStrings("abc", "bca"));
		cons.accept(obj.closeStrings("a", "aa"));
		cons.accept(obj.closeStrings("cabbba", "abbccc"));
		cons.accept(obj.closeStrings("uau", "ssx"));
		
    }
}

package com.leetcode.dailypractice.year23.dec.week1;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
1160. Find Words That Can Be Formed by Characters
Easy
1.9K
169
Companies
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.
Accepted
213.9K
Submissions
304K
Acceptance Rate
70.4%
 */
public class SolutionFriday1202 {
	//Mine
       public int countCharacters1(String[] words, String chars) {
        
    }
    //Best Solution
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> ch = new HashMap<>();

        for (char c : chars.toCharArray()) {
            ch.put(c, 1 + ch.getOrDefault(c, 0));
        }

        int res = 0;
        for (String word : words) {
            Map<Character, Integer> copy = new HashMap<>(ch);

            for (char c : word.toCharArray()) {
                if (copy.containsKey(c) && copy.get(c) != 0) {
                    copy.put(c, copy.get(c) - 1);
                } else {
                    res -= word.length();
                    break;
                }
            }

            res += word.length();
        }

        return res;        
    }

	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionFriday1202();
		cons.accept(obj.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
        cons.accept(obj.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
	}
}

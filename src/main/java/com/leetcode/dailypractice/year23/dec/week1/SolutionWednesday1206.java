package com.leetcode.dailypractice.year23.dec.week1;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 * 1662. Check If Two String Arrays are Equivalent Easy 2.6K 188 Companies Given
 * two string arrays word1 and word2, return true if the two arrays represent
 * the same string, and false otherwise.
 * 
 * A string is represented by an array if the array elements concatenated in
 * order forms the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"] Output: true Explanation:
 * word1 represents string "ab" + "c" -> "abc" word2 represents string "a" +
 * "bc" -> "abc" The strings are the same, so return true. Example 2:
 * 
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"] Output: false Example 3:
 * 
 * Input: word1 = ["abc", "d", "defg"], word2 = ["abcddefg"] Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= word1.length, word2.length <= 103 1 <= word1[i].length, word2[i].length
 * <= 103 1 <= sum(word1[i].length), sum(word2[i].length) <= 103 word1[i] and
 * word2[i] consist of lowercase letters. Accepted 370.7K Submissions 438K
 * Acceptance Rate 84.6%
 */
public class SolutionFriday1201 {
	//Mine
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        Arrays.stream(word1).forEach(x->s1.append(x));
        Arrays.stream(word2).forEach(x->s2.append(x));
        return s1.toString().equals(s2.toString());
    }
    //Best Solution
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int pointer1 = 0;  // Pointer for word1
        int pointer2 = 0;  // Pointer for word2        
        int idx1 = 0;      // Index for the current word in word1
        int idx2 = 0;      // Index for the current word in word2

        while (pointer1 < word1.length && pointer2 < word2.length) {
            // Get the current characters from both words
            char char1 = word1[pointer1].charAt(idx1);
            char char2 = word2[pointer2].charAt(idx2);

            // Compare characters
            if (char1 != char2) {
                return false;
            }

            // Move to the next character in the current word
            idx1++;
            idx2++;

            // Move to the next word if the end of the current word is reached
            if (idx1 == word1[pointer1].length()) {
                idx1 = 0;  // Move to the next word in word1
                pointer1++;
            }

            if (idx2 == word2[pointer2].length()) {
                idx2 = 0;  // Move to the next word in word2
                pointer2++;
            }
        }

        // Check if both pointers have reached the end of their respective arrays
        return pointer1 == word1.length && pointer2 == word2.length;        
    }

	public static void main(String[] args) {
		Integer num = new Integer(3);
		String str = num.toString();
		System.out.println(Integer.valueOf(str));
		Integer num2 = Integer.valueOf(str);
		System.out.println(num2);
		Consumer cons = System.out::println;
		var obj = new SolutionFriday1201();
		cons.accept(obj.arrayStringsAreEqual(new String[] {"a","bc"}, new String[] {"abc"}));
		cons.accept(obj.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab", "c"}));
		cons.accept(obj.arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));

	}
}

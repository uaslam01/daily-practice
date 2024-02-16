package com.leetcode.dailypractice.year24.feb.week2;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/find-first-palindromic-string-in-the-array/">Problem-Link</a>
 *
 * 2108. Find First Palindromic String in the Array
 * 
 * 
 * Easy Topics Companies Hint
 * 
 * 
 * Given an array of strings words, return the first palindromic string in the
 * array. If there is no such string, return an empty string "".
 * 
 * A string is palindromic if it reads the same forward and backward.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["abc","car","ada","racecar","cool"]
 * 
 * Output: "ada"
 * 
 * Explanation: The first string that is palindromic is "ada".
 * 
 * Note that "racecar" is also palindromic, but it is not the first.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["notapalindrome","racecar"]
 * 
 * Output: "racecar"
 * 
 * Explanation: The first and only string that is palindromic is "racecar".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["def","ghi"]
 * 
 * Output: ""
 * 
 * Explanation: There are no palindromic strings, so the empty string is
 * returned.
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] consists only
 * of lowercase English letters.
 * 
 * Seen this question in a real interview before?
 * 
 * 1/4 Yes No Accepted 203.7K Submissions 244.5K Acceptance Rate 83.3%
 */
public class SolutionTuesday0213 {
	//Mine Solution
	public String firstPalindrome(String[] words) {
		for(String word: words) {
			int i=0;
			int j = word.length()-1;
			boolean isPalindrom = true;
			while(i<=j&&isPalindrom) {
				if(word.charAt(i)!=word.charAt(j)) {
					isPalindrom = false;
				}
				i++;
				j--;
			}
			if(isPalindrom) {
				return word;
			}
		}
		return "";
	}
	
	//Best Solution
	 public String firstPalindrome1(String[] words) {
	        for(int str = 0; str < words.length; str++){
	            if (isPalindrome(words[str])){
	                return words[str];
	            }
	        }
	        return "";
	    }
	    public boolean isPalindrome(String str){
	        if(str== null || str.length() == 0){
	            return false;
	        }
	        for(int i = 0; i < str.length()/2; i++){
	            char start = str.charAt(i);
	            char end = str.charAt(str.length() - 1 - i);

	            if(start != end){
	                return false;
	            }
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionTuesday0213();
		cons.accept(obj.firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
		cons.accept(obj.firstPalindrome(new String[] {"notapalindrome","racecar"}));
		cons.accept(obj.firstPalindrome(new String[] {"def","ghi"}));

		
	}
}

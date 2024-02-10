package com.leetcode.dailypractice.year24.feb.week2;

import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/palindromic-substrings/">Problem-Link</a>
 * 
 * 647. Palindromic Substrings
 * 
 * 
 * Medium Topics Companies Hint
 * 
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * 
 * Output: 3
 * 
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * Input: s = "aaa"
 * 
 * Output: 6
 * 
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consists of lowercase English letters.
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 744.5K
 * Submissions 1.1M Acceptance Rate 69.6%
 */
public class SolutionSaturday0210 {
    int count1 = 0;
    //Best Solution
    boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                count1++;
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                    if (count1 == 2) {
                        count1 = 0;
                        break;
                    }
                }
            }
        }
        return count;
    }
    //Best Solution 2
    int start=0,length=0,maxLength=0,count=0;
    public int countSubstrings1(String s) {
         length =s.length();

        for(int i=0;i<length;i++){
            i = countAndReturnNextIndex(s,i);
            // count++;
        }   
        return count;
    }
    public int countAndReturnNextIndex(String s,int k){
        
        int left = k-1,right=k;
        while(right<length -1 && s.charAt(right) == s.charAt(right+1)) right++;
        int countOfSameChar = right-left;
        if(countOfSameChar >=1){
            //5 =5 + 4 +3 + 2 +1
            //4 = 4 +3 + 2 +1
            count+= (countOfSameChar*(countOfSameChar+1))/2 ;
            // System.out.println(left+" "+right+" "+length);
            // System.out.println(countOfSameChar);
        }
        int nextIndex = right++;
        while(left>=0 && right<length && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return nextIndex;

    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionSaturday0210();
		//Wrong Answer
		cons.accept(obj.countSubstrings("abc"));

		cons.accept(obj.countSubstrings("aaa"));
		

	}
}

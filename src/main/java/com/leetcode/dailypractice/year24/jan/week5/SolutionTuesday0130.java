package com.leetcode.dailypractice.year24.jan.week5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/evaluate-reverse-polish-notation/">Problem-Link</a>
 * 
 * 
 * 150. Evaluate Reverse Polish Notation
 * 
 * 
 * Medium Topics Companies
 * 
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * 
 * 
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * 
 * Note that:
 * 
 * The valid operators are '+', '-', '*', and '/'.
 * 
 * Each operand may be an integer or another expression. The division between
 * two integers always truncates toward zero. There will not be any division by
 * zero. The input represents a valid arithmetic expression in a reverse polish
 * notation. The answer and all the intermediate calculations can be represented
 * in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * 
 * Output: 9
 * 
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * 
 * Output: 6
 * 
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 
 * Output: 22
 * 
 * 
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 / (12 *
 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0 +
 * 17) + 5 = 17 + 5 = 22
 * 
 * 
 * Constraints:
 * 
 * 1 <= tokens.length <= 104 tokens[i] is either an operator: "+", "-", "*", or
 * "/", or an integer in the range [-200, 200].
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 917.8K
 * Submissions 1.8M Acceptance Rate 50.0%
 */
public class SolutionTuesday0130 {
	// Mine/Best Solution
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (var token : tokens) {
			if (isArithmaticSymbol(token)) {
				int n2 = stack.pop();
				int n1 = stack.pop();
				stack.push(performOperation(n1, n2, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}
    long resolves(long a, long b, char operator) {
        if (operator == '+') return a + b;
        else if (operator == '-') return a - b;
        else if (operator == '*') return a * b;
        return a / b;
    }

    //Best Solution Other
    public int evalRPN1(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                long integer2 = stack.pop();
                long integer1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(integer1, integer2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
	int performOperation(int n1, int n2, String operation) {
		switch (operation) {
		case "+":
			return n1 + n2;
		case "-":
			return n1 - n2;
		case "*":
			return n1 * n2;
		case "/":
			return n1 / n2;
		default:
			return 0;
		}
	}

	boolean isArithmaticSymbol(String ch) {
		return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
	}

	public static void main(String[] args) {
		var obj = new SolutionTuesday0130();
		System.out.println(obj.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(obj.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(obj.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));

	}
}

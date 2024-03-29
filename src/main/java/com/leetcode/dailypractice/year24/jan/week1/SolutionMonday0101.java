package com.leetcode.dailypractice.year24.jan.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/build-an-array-with-stack-operations/">Problem-Link</a>
 *
 * Build an Array With Stack Operations Medium 618 280 Companies You are given an integer
 * array target and an integer n.
 * 
 * You have an empty stack with the two following operations:
 * 
 * "Push": pushes an integer to the top of the stack. "Pop": removes the integer
 * on the top of the stack. You also have a stream of the integers in the range
 * [1, n].
 * 
 * Use the two stack operations to make the numbers in the stack (from the
 * bottom to the top) equal to target. You should follow the following rules:
 * 
 * If the stream of the integers is not empty, pick the next integer from the
 * stream and push it to the top of the stack. If the stack is not empty, pop
 * the integer at the top of the stack. If, at any moment, the elements in the
 * stack (from the bottom to the top) are equal to target, do not read new
 * integers from the stream and do not do more operations on the stack. Return
 * the stack operations needed to build target following the mentioned rules. If
 * there are multiple valid answers, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = [1,3], n = 3 Output: ["Push","Push","Pop","Push"]
 * 
 * Explanation: Initially the stack s is empty. The last element is the top of
 * the stack. Read 1 from the stream and push it to the stack. s = [1]. Read 2
 * from the stream and push it to the stack. s = [1,2]. Pop the integer on the
 * top of the stack. s = [1]. Read 3 from the stream and push it to the stack. s
 * = [1,3]. Example 2:
 * 
 * Input: target = [1,2,3], n = 3 Output: ["Push","Push","Push"] 
 * 
 * Explanation: Initially the stack s is empty. The last element is the top of the stack.
 * Read 1 from the stream and push it to the stack. s = [1]. Read 2 from the
 * stream and push it to the stack. s = [1,2]. Read 3 from the stream and push
 * it to the stack. s = [1,2,3]. Example 3:
 * 
 * Input: target = [1,2], n = 4 Output: ["Push","Push"] 
 * 
 * Explanation: Initially the stack s is empty. The last element is the top of the stack. Read 1 from
 * the stream and push it to the stack. s = [1]. Read 2 from the stream and push
 * it to the stack. s = [1,2]. Since the stack (from the bottom to the top) is
 * equal to target, we stop the stack operations. The answers that read integer
 * 3 from the stream are not accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= target.length <= 100 1 <= n <= 100 1 <= target[i] <= n target is
 * strictly increasing.
 */

public class SolutionMonday0101{
	// First Solution Mine
	public List<String> buildArray1(int[] target, int n) {
		List<String> list = new ArrayList<>();
		Stack<Integer> numStack = new Stack<>();
		int targetCounter = 0;
		for (int i = 0; i < n && targetCounter != target.length; i++) {
			numStack.push(i + 1);
			list.add("Push");
			if (numStack.peek() == target[targetCounter]) {
				targetCounter++;
			} else {
				numStack.pop();
				list.add("Pop");
			}

		}
		return list;
	}

	// Best Solution Mine
	public List<String> buildArray(int[] target, int n) {
		List<String> list = new LinkedList<>();
		int temp;
		int targetCounter = 0;
		for (int i = 0; i < n && targetCounter != target.length; i++) {
			temp = (i + 1);
			list.add("Push");
			if (temp == target[targetCounter]) {
				targetCounter++;
			} else {
				list.add("Pop");
			}

		}
		return list;
	}

	// Best Solution Online
	public static List<String> buildArray2(int[] target, int n) {
		List<String> result = new ArrayList<>();
		int current = 1; // The current number to be pushed.

		for (int i = 0; i < target.length; i++) {
			while (current < target[i]) {
				// While the current number is less than the target number,
				// push the current number and generate the "Push" operation.
				result.add("Push");
				result.add("Pop"); // After pushing, immediately pop.
				current++;
			}

			// The current number matches the target number, so push it.
			result.add("Push");

			current++; // Move to the next number to be pushed.
		}

		return result;
	}
	//Best Solution2
	public List<String> buildArray3(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetIndex = 0; // Pointer for target array
        int currentNumber = 1; // Pointer for numbers 1 to n

        while (targetIndex < target.length) {
            if (target[targetIndex] == currentNumber) {
                // If the current number in the target array matches the current number 1 to n
                // Push "Push" operation and move both pointers
                operations.add("Push");
                targetIndex++;
            } else {
                // If the numbers don't match, push "Push" followed by "Pop" operation
                // and only move the current number pointer
                operations.add("Push");
                operations.add("Pop");
            }
            currentNumber++;
        }

        return operations;
    }
	public static void main(String[] args) {

		(new SolutionMonday0101().buildArray(new int[] { 1, 3 }, 3)).forEach(System.out::print);
		System.out.println("");
		(new SolutionMonday0101().buildArray(new int[] { 1, 2, 3 }, 3)).forEach(System.out::print);
		System.out.println("");
		(new SolutionMonday0101().buildArray(new int[] { 1, 2 }, 4)).forEach(System.out::print);

	}
}
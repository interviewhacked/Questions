
/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


 */

import java.util.Stack;

class CIndex {
	char c;
	int index;

	CIndex(char c, int index) {
		this.c = c;
		this.index = index;
	}
}

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {

		Stack<CIndex> stack = new Stack<>();
		boolean isValid[] = new boolean[s.length()];
		int max = 0;

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(new CIndex(c, i));
				continue;
			}
			if (!stack.isEmpty()) {
				isValid[stack.pop().index] = true;
				isValid[i] = true;
			}

		}
		int current = 0;
		for (boolean b : isValid) {
			if (b) {
				++current;
			} else {
				if (current > max) {
					max = current;
				}
				current = 0;
			}
		}
		return Math.max(max, current);
	}
}

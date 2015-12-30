import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

	int compute(final String input) {
		Scanner scan = new Scanner(System.in);
	    scan.nextLine();
		if (input == null || input.trim().length() < 1) {
			return 0;
		}
		String els[] = input.split(" ");
		Stack<Integer> aStack = new Stack<>();
		for (String el : els) {
			if (isOperator(el.trim())) {
				int op2 = aStack.pop();
				int op1 = aStack.pop();
				aStack.push(execute(el, op1, op2));
			} else {
				aStack.push(Integer.parseInt(el.trim()));
			}
		}
		return aStack.pop();
	}

	boolean isOperator(String el) {
		char c = el.trim().charAt(0);
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	int execute(String operator, int op1, int op2) {
		char c = operator.trim().charAt(0);
		switch (c) {
		case '+':
			return op1 + op2;

		case '-':
			return op1 - op2;

		case '*':
			return op1 * op2;

		case '/':
			return op1 / op2;

		}
		throw new RuntimeException("unknown operator");
	}
}

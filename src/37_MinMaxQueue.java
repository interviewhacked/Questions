import java.util.Stack;

public class MinMaxQueue<T extends Comparable<T>> {

	private class StackElement<S> {
		S el;
		S max;
		S min;

		StackElement(S el, S max, S min) {
			this.el = el;
			this.max = max;
			this.min = min;
		}
	}

	private Stack<StackElement<T>> first;
	private Stack<StackElement<T>> second;

	public MinMaxQueue() {
		first = new Stack<>();
		second = new Stack<>();
	}

	public void enqueue(T el) {
		push(first, el);
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Queue");
		}
		if (!second.isEmpty()) {
			return second.pop().el;
		}
		while (!first.isEmpty()) {
			push(second, first.pop().el);
		}
		return second.pop().el;
	}

	private void push(Stack<StackElement<T>> stack, T el) {
		if (stack.isEmpty()) {
			stack.push((new StackElement<T>(el, el, el)));
			return;
		}
		StackElement<T> top = stack.peek();
		T newMax = top.max;
		T newMin = top.min;
		if (top.max.compareTo(el) < 0) {
			newMax = el;
		}
		if (top.min.compareTo(el) > 0) {
			newMin = el;
		}
		stack.push((new StackElement<T>(el, newMax, newMin)));
	}

	private boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	public T getMin() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Queue");
		}
		if (first.isEmpty()) {
			return second.peek().min;
		}
		if (second.isEmpty()) {
			return first.peek().min;
		}
		return first.peek().min.compareTo(second.peek().min) > 0 ? second.peek().min : first.peek().min;
	}

	public T getMax() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Queue");
		}
		if (first.isEmpty()) {
			return second.peek().max;
		}
		if (second.isEmpty()) {
			return first.peek().max;
		}
		return first.peek().max.compareTo(second.peek().max) < 0 ? second.peek().max : first.peek().max;
	}
}

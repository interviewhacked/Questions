import java.util.Stack;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7 Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * @author joshi18
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length <= 1) {
			return nums;
		}
		int result[] = new int[nums.length - k + 1];
		MinMaxQueueUtil<Integer> queue = new MinMaxQueueUtil<>();
		for (int i = 0; i < k; ++i) {
			queue.enqueue(nums[i]);
		}
		result[0] = queue.getMax();
		for (int i = k, j = 1; i < nums.length; ++i, ++j) {
			queue.dequeue();
			queue.enqueue(nums[i]);
			result[j] = queue.getMax();
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum o = new SlidingWindowMaximum();
		o.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
	}
}

class MinMaxQueueUtil<T extends Comparable<T>> {

	class StackElement<S> {
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

	public MinMaxQueueUtil() {
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
		return first.peek().min.compareTo(second.peek().min) > 0 ? second
				.peek().min : first.peek().min;
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
		return first.peek().max.compareTo(second.peek().max) < 0 ? second
				.peek().max : first.peek().max;
	}
}

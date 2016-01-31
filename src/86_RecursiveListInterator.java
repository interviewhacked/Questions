/**
 * Write an iterator for a list whose each element can either be an integer or another list.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface ListElement {

}

class IntegerEl implements ListElement {
	private int val;

	IntegerEl(int v) {
		this.val = v;
	}

	public int getValue() {
		return val;
	}
}

class CustomList implements ListElement {
	List<ListElement> data;

	CustomList() {
		data = new ArrayList<>();
	}

	void add(int el) {
		data.add(new IntegerEl(el));
	}

	void add(ListElement el) {
		data.add(el);
		System.out.println("count " + data.size());
	}

	public CustomList(List<Integer> iL) {
		data = new ArrayList<>();
		for (int i : iL) {
			data.add(new IntegerEl(i));
		}
	}

	public CustomList(int[] iL) {
		data = new ArrayList<>();
		for (int i : iL) {
			data.add(new IntegerEl(i));
		}
	}

	public CustomList(int el) {
		data = new ArrayList<>();
		data.add(new IntegerEl(el));
	}

	public CustomList(ListElement el) {
		data = new ArrayList<>();
		data.add(el);
	}
}

public class CustomListIerator {

	private int currentEl;
	private boolean isAvaialable = false;
	Stack<Iterator<ListElement>> stack = new Stack<>();

	public CustomListIerator(CustomList l) {
		stack.push(l.data.iterator());
	}

	public int next() {
		nextHelper();
		if (isAvaialable) {
			isAvaialable = false;
			return currentEl;
		}
		throw new RuntimeException("no more elements");
	}

	public boolean hasNext() {
		if (isAvaialable) {
			return true;
		}
		nextHelper();
		return isAvaialable;
	}

	private void nextHelper() {
		if (isAvaialable) {
			return;
		}
		if (stack.isEmpty()) {
			return;
		}

		do {
			Iterator<ListElement> currentIterator = stack.pop();
			if (!currentIterator.hasNext()) {
				continue;
			}
			ListElement cur = currentIterator.next();
			if (cur instanceof IntegerEl) {
				currentEl = ((IntegerEl) cur).getValue();
				isAvaialable = true;
				stack.push(currentIterator);
				return;
			}
			stack.push(currentIterator);
			stack.push(((CustomList) cur).data.iterator());
		} while (!stack.isEmpty());

	}

	public static void main(String[] args) {

		CustomList one = new CustomList(1);
		CustomList two = new CustomList(new CustomList(new CustomList(
				new int[] { 2 })));
		CustomList three = new CustomList(new CustomList(new CustomList(
				new int[] { 1, 2, 3 })));
		CustomList four = new CustomList(1);
		four.add(new CustomList(2));
		four.add(new CustomList(3));
		four.add(new CustomList(4));
		four.add(new CustomList(5));
		CustomList five = new CustomList(1);
		five.add(new CustomList(new int[] { 1, 2 }));
		five.add(two);
		five.add(three);
		five.add(one);
		CustomListIerator it = new CustomListIerator(one);
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		it = new CustomListIerator(two);
		System.out.println();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		it = new CustomListIerator(three);
		System.out.println();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		it = new CustomListIerator(four);
		System.out.println();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		it = new CustomListIerator(five);
		System.out.println();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}

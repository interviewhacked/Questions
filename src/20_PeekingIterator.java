import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * 
 * Call next() gets you 1, the first element in the list.
 * 
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * 
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 * 
 * @author joshi18
 *
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	Integer current;
	boolean hasCurrent;
	Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (hasCurrent) {
			return current;
		}
		nextHelper();
		return hasCurrent ? current : null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (hasCurrent) {
			hasCurrent = false;
			return current;
		} else {
			nextHelper();
		}
		if (hasCurrent) {
			hasCurrent = false;
			return current;
		}
		return null;
	}

	private void nextHelper() {
		if (iterator.hasNext()) {
			current = iterator.next();
			hasCurrent = true;
		} else {
			hasCurrent = false;
		}
	}

	@Override
	public boolean hasNext() {
		if (hasCurrent) {
			return true;
		}
		return iterator.hasNext();
	}
}
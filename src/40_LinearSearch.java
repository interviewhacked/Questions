package com.mapr;

interface ComparisonFunction {
	SearchResultType compare(int el1, int el2);
}

/**
 * Each search type enum encapsulates a function which does the corresponding
 * comparison for that particular search type given two elements.
 * 
 * returnFirst tells if we should return the first match or the last.
 * @author joshi18
 *
 */
enum SearchType {
	LessThan(new ComparisonFunction() {
		public SearchResultType compare(int el1, int el2) {
			return el1 < el2 ? SearchResultType.FoundLess
					: SearchResultType.NotFound;
		}

	}, false), LessThanEquals(new ComparisonFunction() {
		public SearchResultType compare(int el1, int el2) {
			return el1 <= el2 ? (el1 == el2 ? SearchResultType.FoundExact
					: SearchResultType.FoundLess) : SearchResultType.NotFound;
		}
	}, false), Equals(new ComparisonFunction() {
		public SearchResultType compare(int el1, int el2) {
			return el1 == el2 ? SearchResultType.FoundExact
					: SearchResultType.NotFound;
		}
	}, true), GreaterThanEquals(new ComparisonFunction() {
		public SearchResultType compare(int el1, int el2) {
			return el1 >= el2 ? (el1 == el2 ? SearchResultType.FoundExact
					: SearchResultType.FoundGreater)
					: SearchResultType.NotFound;
		}
	}, true), GreaterThan(new ComparisonFunction() {
		public SearchResultType compare(int el1, int el2) {
			return el1 > el2 ? SearchResultType.FoundGreater
					: SearchResultType.NotFound;
		}
	}, true);
	private final ComparisonFunction func;
	private final boolean returnFirst;

	private SearchType(final ComparisonFunction _func,
			final boolean _returnFirst) {
		func = _func;
		returnFirst = _returnFirst;
	}

	public boolean isReturnFirst() {
		return returnFirst;
	}

	public SearchResultType compare(int el, int key) {
		return this.func.compare(el, key);
	}

}

enum SearchResultType {
	NotFound, FoundExact, FoundGreater, FoundLess
}

class SearchResult {
	final SearchResultType resultType;
	final int index;

	public SearchResult(final SearchResultType _resultType, final int _index) {
		resultType = _resultType;
		index = _index;
	}
}

public class LinearSearch {

	/*-
	 * 
	 * items    	: An array of sorted ints, with no duplicates
	 * isAscending	: true if the array is sorted in ascending order
	 * key      	: the key to search for
	 * type     	: the type of match to find
	 * @return		: An object of SearchResult
	 * 
	 * It simply calls searchHelper with appropriate values 'startIndex', 'endIndex' and
	 * 'step'. If isAscending is true we move from 0 to items.length-1 otherwise we move
	 * from items.length-1 to 0. 
	 */
	public SearchResult search(int[] items, final boolean isAscending,
			final int key, final SearchType type) {

		return isAscending ? searchHelper(items, key, type, 0, items.length, 1)
				: searchHelper(items, key, type, items.length - 1, -1, -1);
	}

	/**
	 * Helper function for search function.
	 * 
	 * @param items
	 *            array to be searched
	 * @param key
	 *            The number we are looking for
	 * @param type
	 *            One of the SearchType
	 * @param start
	 *            Start index in the array 'items'
	 * @param end
	 *            End index in the array 'items'
	 * @param step
	 *            The amount by which 'start' is incremented to traverse the
	 *            'items' array until 'start' eauals 'end'.
	 * 
	 * @return An object of SearchResult type
	 */

	/*-
	 * Traverse the array maintaining last matching index.
	 * When we found a match one of three things happen:
	 * 1. el == key: Return the result
	 * 2. el > key: Return the result
	 * 3. el < key: Continue 
	 * 
	 * After the loop finishes return the last matching result.
	 */
	public SearchResult searchHelper(int[] items, final int key,
			final SearchType type, final int startIndex, final int endIndex,
			final int step) {
		int lastMatchingIndex = -1;
		SearchResultType lastMatchingResult = SearchResultType.NotFound;

		for (int i = startIndex; i != endIndex; i = i + step) {
			SearchResultType currentResult = type.compare(items[i], key);

			if (currentResult != SearchResultType.NotFound) {
				lastMatchingIndex = i;
				lastMatchingResult = currentResult;
			}
			if (currentResult == SearchResultType.FoundExact) {
				return new SearchResult(currentResult, lastMatchingIndex);
			}
			if (currentResult != SearchResultType.NotFound
					&& type.isReturnFirst()) {
				return new SearchResult(currentResult, lastMatchingIndex);
			}
		}
		return new SearchResult(lastMatchingResult, lastMatchingIndex);
	}
}

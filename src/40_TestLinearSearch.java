package com.mapr;

/*-
 * Test cases for mpar.LinearSearch
 * 
 * Functional Testing
 * The general approach for functional testing is to have a sorted array of varying length(1, 2,...,n)
 * with element present at different indices(0,n-1, i) passed as key. Also some elements which are not in
 * the array passed as keys. With both ascending and descending array elements. 
 * One approach for generating automated test cases can be this:
 * 
 * 1. Generate a random number n >0
 * 2. Generate n unique random numbers using HashSet to avoid duplicates
 * 3. Generate a random index >=0 and <=n-1 and test for equals
 * 4. Generate a random index >0 and <n-1 and set elements greater and less than the index and use it as key 
 *    for LessThan, GreaterThan, LessThanEquals and GreaterThanEquals.
 * 5. Now reverse sort the array and pass isAscending true
 * 6. Repeat it for n times.
 * 
 * 
 * Other kinds of testing can be:
 * 1. Integration testing: Test it with other parts of the system to ensure 
 *    a. precondition are being met
 * 	  b. postcondition are being met
 *    
 * 2. Performance testing: To ensure this function is finishing fast enough even with large arrays we can insert
 * 	 trace statements or use an open source tool to measure how much time is being spent.
 * 	 e.g. Does using large arrays where array length is close to Integer.MAX_INT cause this to fail?
 * 
 * 3. Code coverage/Branch coverage : We can have more confidence in testing if we can be sure that the test cases
 *    have executed all/most of the statements and conditions 
 * 
 * @author joshi18
 *
 */
public class TestLinearSearch {

	LinearSearch linearSearch = new LinearSearch();

	public static void main(String args[]) {
		TestLinearSearch test = new TestLinearSearch();
		test.testEqualsAscending();
		test.testEqualsDescending();
		test.testLessThanAscending();
		test.testLessThanDescending();
		test.testGreaterThan();
		test.testGreaterThanEquals();
		test.testLessThanEquals();
	}

	public void testEqualsAscending() {
		int[] array = new int[] { 0, 20, 43, 57, 89, 109 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, true, 0,
				SearchType.Equals);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens at the last index in the array
		result = linearSearch.search(array, true, 109, SearchType.Equals);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 43, SearchType.Equals);
		assert (result.index == 2);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 20, SearchType.Equals);
		assert (result.index == 1);
		assert (result.resultType == SearchResultType.FoundExact);

		// No match
		result = linearSearch.search(array, true, 37, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, 110, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, -1, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	public void testEqualsDescending() {
		int[] array = new int[] { 109, 89, 57, 43, 20, 0 };

		// Match happens at the last index in the array
		SearchResult result = linearSearch.search(array, false, 0,
				SearchType.Equals);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens at the first index in the array
		result = linearSearch.search(array, false, 109, SearchType.Equals);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens somewhere in the array
		result = linearSearch.search(array, false, 43, SearchType.Equals);
		assert (result.index == 3);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens somewhere in the array
		result = linearSearch.search(array, false, 20, SearchType.Equals);
		assert (result.index == 4);
		assert (result.resultType == SearchResultType.FoundExact);

		// No match
		result = linearSearch.search(array, false, 37, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, false, 110, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, false, -1, SearchType.Equals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	public void testLessThanAscending() {
		int[] array = new int[] { -2 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, true, -1,
				SearchType.LessThan);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundLess);

		array = new int[] { -20, 0, 30, 79 };

		// Match happens at the last index in the array
		result = linearSearch.search(array, true, 109, SearchType.LessThan);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundLess);

		array = new int[] { -20, 0, 30, 79, 308, 45678, 100000 };
		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 99999, SearchType.LessThan);
		assert (result.index == 5);
		assert (result.resultType == SearchResultType.FoundLess);

		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 20, SearchType.LessThan);
		assert (result.index == 1);
		assert (result.resultType == SearchResultType.FoundLess);

		// No match
		result = linearSearch.search(array, true, -21, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, -2000, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, -89000, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	public void testLessThanDescending() {
		int[] array = new int[] { -2 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, false, -1,
				SearchType.LessThan);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundLess);

		array = new int[] { 79, 30, 0, -20 };

		// Match happens at the first index in the array
		result = linearSearch.search(array, false, 109, SearchType.LessThan);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundLess);

		array = new int[] { 100000, 45768, 308, 79, 30, 0, -20 };
		// Match happens somewhere in the array
		result = linearSearch.search(array, false, 99999, SearchType.LessThan);
		assert (result.index == 1);
		assert (result.resultType == SearchResultType.FoundLess);

		// Match happens somewhere in the array
		result = linearSearch.search(array, false, 20, SearchType.LessThan);
		assert (result.index == 5);
		assert (result.resultType == SearchResultType.FoundLess);

		// No match
		result = linearSearch.search(array, false, -21, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, false, -2000, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, false, -89000, SearchType.LessThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	// similar for descending
	public void testGreaterThan() {
		int[] array = new int[] { -1 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, true, -2,
				SearchType.GreaterThan);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundGreater);

		array = new int[] { -20, 0, 30, 79 };

		// Match happens at the last index in the array
		result = linearSearch.search(array, true, 30, SearchType.GreaterThan);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundGreater);

		array = new int[] { -20, 0, 30, 79, 308, 45678, 100000 };
		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 90, SearchType.GreaterThan);
		assert (result.index == 4);
		assert (result.resultType == SearchResultType.FoundGreater);

		// Match happens somewhere in the array
		result = linearSearch
				.search(array, true, 45678, SearchType.GreaterThan);
		assert (result.index == 6);
		assert (result.resultType == SearchResultType.FoundGreater);

		// No match
		result = linearSearch.search(array, true, 100000,
				SearchType.GreaterThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, 999999,
				SearchType.GreaterThan);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	// similar for descending
	public void testGreaterThanEquals() {
		int[] array = new int[] { -2 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, true, -2,
				SearchType.GreaterThanEquals);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundExact);

		array = new int[] { -20, 0, 30, 79 };

		// Match happens at the last index in the array
		result = linearSearch.search(array, true, 79,
				SearchType.GreaterThanEquals);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundExact);

		array = new int[] { -20, 0, 30, 79, 308, 45678, 100000 };
		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 90,
				SearchType.GreaterThanEquals);
		assert (result.index == 4);
		assert (result.resultType == SearchResultType.FoundGreater);

		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 45678,
				SearchType.GreaterThanEquals);
		assert (result.index == 5);
		assert (result.resultType == SearchResultType.FoundExact);

		result = linearSearch.search(array, true, 100000,
				SearchType.GreaterThanEquals);
		assert (result.index == 6);
		assert (result.resultType == SearchResultType.FoundExact);

		// No match
		result = linearSearch.search(array, true, 999999,
				SearchType.GreaterThanEquals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

	}

	// similar for descending
	public void testLessThanEquals() {
		int[] array = new int[] { 0 };

		// Match happens at the first index in the array
		SearchResult result = linearSearch.search(array, true, 1,
				SearchType.LessThanEquals);
		assert (result.index == 0);
		assert (result.resultType == SearchResultType.FoundLess);

		array = new int[] { -20, 0, 30, 79 };

		// Match happens at the last index in the array
		result = linearSearch
				.search(array, true, 79, SearchType.LessThanEquals);
		assert (result.index == array.length - 1);
		assert (result.resultType == SearchResultType.FoundExact);

		array = new int[] { -20, 0, 30, 79, 308, 45678, 100000 };
		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 308,
				SearchType.LessThanEquals);
		assert (result.index == 4);
		assert (result.resultType == SearchResultType.FoundExact);

		// Match happens somewhere in the array
		result = linearSearch.search(array, true, 0, SearchType.LessThanEquals);
		assert (result.index == 1);
		assert (result.resultType == SearchResultType.FoundExact);

		// No match
		result = linearSearch.search(array, true, -21,
				SearchType.LessThanEquals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, -2000,
				SearchType.LessThanEquals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);

		result = linearSearch.search(array, true, -89000,
				SearchType.LessThanEquals);
		assert (result.index == -1);
		assert (result.resultType == SearchResultType.NotFound);
	}

}

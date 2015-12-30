/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */


/**
 * First we will ignore values that are negative or zero. Now, try to assign
 * value i to index i-1 and ignore values which are greater than length of the
 * array. Now we can traverse the array to find first instance where A[i]!=i+1
 * and if we don't find any such occurrence return A.length+1
 * 
 * @author joshi18
 *
 */

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; ++i) {
			int value = A[i];
			if (value < 1) {
				// We don't care about 0 or negative values
				continue;
			}
			int correctIndex = value - 1;
			if (correctIndex > A.length - 1) {
				continue;
			}
			if (correctIndex == i) {
				continue;
			}
			while (true) {
				int newValue = A[correctIndex];
				if (newValue == value) {
					break;
				}
				A[correctIndex] = value;
				value = newValue;
				correctIndex = value - 1;
				if (correctIndex > A.length - 1 || correctIndex < 0) {
					break;
				}
			}
		}
		for (int i = 0; i < A.length; ++i) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive o = new FirstMissingPositive();
		assert (2 == o.firstMissingPositive(new int[] { 1, 3 }));
		assert (2 == o.firstMissingPositive(new int[] { 1, 1 }));
		assert (2 == o.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		assert (1 == o.firstMissingPositive(new int[] { 3, 4, -1 }));
		assert (3 == o.firstMissingPositive(new int[] { 1, 2, 0 }));
		assert (3 == o.firstMissingPositive(new int[] { 2, 1 }));
	}
}

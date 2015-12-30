import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i]
 * 
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1). To the right of 2
 * there is only 1 smaller element (1). To the right of 6 there is 1 smaller
 * element (1). To the right of 1 there is 0 smaller element. Return the array
 * [2, 1, 1, 0].
 * 
 * @author joshi18
 *
 */

/*-
 * Approach is similar to counting inversion problem.
 * 
 * If there are two sorted sub-array for which we know the count we
 * can find the count of merged sub-array as follows:
 * A B C 				D E
 * if(C>E) then its greater than D too so count(C) += 2; Now move the index to B
 * if(C<E) then E is greater than A,B too so now move the index to D. 
 * @author joshi18
 *
 */
/**
 * Another approach can be using balanced bst and inserting array elements from
 * right to left.
 * 
 * @author joshi18
 *
 */
public class CountSmallerNumbersToRight {
	/**
	 * Stores a single element from the array with its original index in the
	 * array and number of elements less than it to its right.
	 * 
	 * @author joshi18
	 *
	 */
	class ElInfo {
		int el;
		int count;
		int index;

		ElInfo(int el) {
			this.el = el;
			this.count = 0;
		}
	}

	ElInfo[] elNCount;

	public List<Integer> countSmaller(int[] nums) {
		Integer[] result = new Integer[nums.length];
		elNCount = new ElInfo[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			elNCount[i] = new ElInfo(nums[i]);
			elNCount[i].index = i;
		}
		helper(elNCount, 0, nums.length - 1);
		for (int i = 0; i < elNCount.length; ++i) {
			result[elNCount[i].index] = elNCount[i].count;
		}
		return Arrays.asList(result);
	}

	void helper(ElInfo[] nums, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		helper(nums, low, mid);
		helper(nums, mid + 1, high);
		merge(nums, low, mid, mid + 1, high);
	}

	void merge(ElInfo[] nums, int l1, int h1, int l2, int h2) {
		int i = h1, j = h2;
		ElInfo[] merged = new ElInfo[h1 - l1 + 1 + h2 - l2 + 1];
		int k = merged.length - 1;
		while (i >= l1 && j >= l2) {
			if (nums[i].el > nums[j].el) {
				elNCount[i].count += j - l2 + 1;
				merged[k--] = nums[i--];
			} else {
				merged[k--] = nums[j--];
			}
		}
		while (i >= l1) {
			merged[k--] = nums[i--];
		}
		while (j >= l2) {
			merged[k--] = nums[j--];
		}
		for (int index = 0; index < merged.length; ++index) {
			nums[l1 + index] = merged[index];
		}
	}

	public static void main(String[] args) {
		CountSmallerNumbersToRight o = new CountSmallerNumbersToRight();
		System.out.println(o.countSmaller(new int[] { 2, 1 }));
		System.out.println(o.countSmaller(new int[] { 2, 5, 1, 6 }));
		System.out.println(o.countSmaller(new int[] { 5, 2, 6, 1 }));

		System.out.println(o.countSmaller(new int[] { 26, 78, 27, 100, 33, 67,
				90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32,
				78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36,
				100, 41 }));
	}
}

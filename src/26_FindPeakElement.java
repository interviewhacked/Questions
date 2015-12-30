/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * 
 * @author pkjoshi
 *
 */

/**
 * There must be one such element.
 * @author pkjoshi
 *
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (low == high) {
				return low;
			}
			int median = low + (high - low) / 2;
			if (median == low) {
				if (nums[median] > nums[median + 1]) {
					return median;
				}
				low = median + 1;
				continue;
			}
			if (median == high) {
				if (nums[median] > nums[median - 1]) {
					return median;
				}
				high = median - 1;
				continue;
			}
			if (nums[median] > nums[median - 1] && nums[median] > nums[median + 1]) {
				return median;
			}
			if (nums[median] < nums[median - 1]) {
				high = median - 1;
				continue;
			}
			if (nums[median] < nums[median + 1]) {
				low = median + 1;
				continue;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindPeakElement o = new FindPeakElement();
		System.out.println(o.findPeakElement(new int[] { 1, 2 }));
		System.out.println(o.findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(o.findPeakElement(new int[] { 1, 2, 3, 4 }));
		System.out.println(o.findPeakElement(new int[] { 4, 2, 3, 4, 5, 4 }));
	}
}

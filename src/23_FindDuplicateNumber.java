import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n^2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * @author joshi18
 *
 */
public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
		return findHelper(nums, 1, nums.length - 1);
	}

	int findHelper(int[] nums, int low, int high) {
		boolean isSeen = false;
		int median = (low + high) / 2;
		int highCount = 0, lowCount = 0;
		for (int el : nums) {
			if (el == median) {
				if (isSeen) {
					return median;
				}
				isSeen = true;
			}
			if (el > median && el <= high) {
				++highCount;
			} else if (el < median && el >= low) {
				++lowCount;
			}
		}
		if (highCount > lowCount) {
			return findHelper(nums, median + 1, high);
		}
		return findHelper(nums, low, median - 1);
	}

	public static void main(String[] args) {
		System.out.println(new FindDuplicateNumber().findDuplicate(new int[] {
				4, 3, 1, 4, 2 }));
	}
}

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 */
/*-
 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 */
/**
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author joshi18
 *
 */

/**
 * Sort the array put the larger elements at odd indices and smaller elements at
 * even indices.
 * 
 * @author joshi18
 *
 */
public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for (int low = 1, high = nums.length - 1; low < high; low += 2, --high) {
			int c = nums[low];
			nums[low] = nums[high];
			nums[high] = c;
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		WiggleSortII o = new WiggleSortII();
		o.wiggleSort(new int[] { 5, 4, 5, 6 });
		o.wiggleSort(new int[] { 1, 5, 1, 1, 6, 4 });
		o.wiggleSort(new int[] { 1, 3, 2, 2, 3, 1 });
	}
}

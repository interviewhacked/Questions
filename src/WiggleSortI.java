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
public class WiggleSortI {
	public void wiggleSort(int[] nums) {
		for (int i = 0; i <= nums.length - 3; i += 2) {
			int max = Math.max(nums[i], Math.max(nums[i + 1], nums[i + 2]));
			if (nums[i + 1] == max) {
				continue;
			}
			if (nums[i] == max) {
				int c = nums[i + 1];
				nums[i + 1] = nums[i];
				nums[i] = c;
			}
			if (nums[i + 2] == max) {
				int c = nums[i + 1];
				nums[i + 1] = nums[i + 2];
				nums[i + 2] = c;
			}
		}
	}
	public static void main(String []args){
		
	}
}

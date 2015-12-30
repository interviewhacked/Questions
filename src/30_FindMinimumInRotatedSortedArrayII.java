/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * @author pkjoshi
 *
 */
public class FindMinimumInRotatedSortedArrayII {
	int min = Integer.MAX_VALUE;

	public int findMin(int[] nums) {
		min = Integer.MAX_VALUE;
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (low == high) {
				if (nums[low] < min) {
					return nums[low];
				}
			}
			if (high - low < 2) {
				return Math.min(min, nums[low] > nums[high] ? nums[high] : nums[low]);
			}
			int mid = low + (high - low) / 2;
			// all the elements are right to mid
			if (mid - 1 < low) {
				if (nums[mid] <= nums[mid + 1]) {
					return nums[mid];
				} else {
					return nums[mid + 1];
				}
			}
			// all the elements are left to mid
			if (mid + 1 > high) {
				if (nums[mid] <= nums[low]) {
					return nums[mid];
				} else {
					return nums[low];
				}
			}
			// We found the first element which has a bigger element to its left
			// which
			// is the answer
			if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			//Left half is sorted so min can be in either half.
			if (nums[low] <= nums[mid - 1]) {
				if (nums[low] < min) {
					min = nums[low];
				}
				low = mid + 1;
				continue;
			} else {//right half is sorted so min can be in either half.
				if (nums[mid + 1] <= nums[high]) {
					if (nums[mid + 1] < min) {
						min = nums[mid + 1];
					}
					high = mid - 1;
					continue;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII o = new FindMinimumInRotatedSortedArrayII();
		System.out.println(o.findMin(new int[] { 4, 4, 5, 6, 6, 7, 7, 0, 0, 1, 2, 2, 2 }));
		System.out.println(o.findMin(new int[] { 4 }));
		System.out.println(o.findMin(new int[] { 4, 4 }));
		System.out.println(o.findMin(new int[] { 4, 4, 4, 4 }));
		System.out.println(o.findMin(new int[] { 3, 1 }));
		System.out.println(o.findMin(new int[] { 3, 1, 3 }));

	}
}
The above would not work in the case 
1,1,1,1,1,1,1,3,1,1

The following the right sol.
public int findMin(int[] nums) {
	min = Integer.MAX_VALUE;
	int low = 0, high = nums.length - 1;
	while (low < high) {
		int mid =(low+high)/2;
		if(nums[mid]<nums[high]){
			high = mid;
		}else if(nums[mid]>nums[high]){
			low = mid+1;
		}else{
			--high;
		}
	}

	return nums[low];
}

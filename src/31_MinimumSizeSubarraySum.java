/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * @author pkjoshi
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int beginIndex = 0;
		int min = Integer.MAX_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; ++i) {
			curSum += nums[i];
			if (curSum >= s) {
				while (curSum > s) {
					curSum -= nums[beginIndex];
					++beginIndex;
				}
				if (curSum == s) {
					if (i - beginIndex < min) {
						min = i - beginIndex;
					}
				} else {
					--beginIndex;
					curSum += nums[beginIndex];
					if (i - beginIndex < min) {
						min = i - beginIndex;
					}
				}
				curSum -= nums[beginIndex];
				++beginIndex;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min + 1;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum o = new MinimumSizeSubarraySum();
		System.out.println(o.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(o.minSubArrayLen(5, new int[] { 2,3,1,1,1,1,1 }));
	}
}

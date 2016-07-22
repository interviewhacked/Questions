/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
 */

/**
 * Maintain two indices 1. Minimum element seen so far and 2. second minimum element
 * If we find an element greater than the second minimum we return true.
 * If we find an element less than second minimum we update the second minimum
 * same for the minimum.
 */
package IncreasingTripletSubsequence;

public class Solution {
	public boolean increasingTriplet(int[] nums) {
		int middle = -1, min = -1, max = -1;
		for (int i = 0; i < nums.length; ++i) {
			if (min == -1) {
				min = i;
				continue;
			}
			if (nums[i] < nums[min]) {
				min = i;
				continue;
			}
			if (nums[i] > nums[min]) {
				if (middle == -1) {
					middle = i;
				} else {
					if (nums[middle] < nums[i]) {
						return true;
					}
					if (nums[middle] > nums[i]) {
						middle = i;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		assert (true == sol.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		assert (false == sol.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		assert (false == sol.increasingTriplet(new int[] { 5, 4, 3, 1, 2 }));
		assert (true == sol.increasingTriplet(new int[] { 5, 4, 3, 1, 2, 5 }));
	}
}

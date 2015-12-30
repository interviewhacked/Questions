
/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author joshi18
 *
 */
public class JumpGameII {
	// Naive approach O(n^2)
	public int jump1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int maxJumpPos = nums[0];
		int[] jumpsRequired = new int[nums.length];
		jumpsRequired[0] = 0;
		for (int i = 1; i < nums.length; ++i) {
			if (i <= maxJumpPos) {
				jumpsRequired[i] = 1;
			}
		}
		if (maxJumpPos >= nums.length - 1) {
			return 1;
		}
		for (int i = 0; i < nums.length; ++i) {
			int curValue = nums[i];
			boolean isUpdated = false;
			int parentJumps = -1;
			int newMaxJumpPos = -1;
			for (int j = i + curValue; j > i; --j) {
				if (j >= nums.length - 1) {
					return jumpsRequired[maxJumpPos] + 1;
				}
				if (nums[j] + j > maxJumpPos) {
					parentJumps = jumpsRequired[j];
					newMaxJumpPos = nums[j] + j;
					isUpdated = true;
				}
			}
			if (isUpdated) {
				for (int k = maxJumpPos + 1; k < jumpsRequired.length
						&& k <= newMaxJumpPos; ++k) {
					jumpsRequired[k] = parentJumps + 1;
				}
				maxJumpPos = newMaxJumpPos;
			}
			if (maxJumpPos >= nums.length - 1) {
				return jumpsRequired[jumpsRequired.length - 1];
			}
		}
		return jumpsRequired[jumpsRequired.length - 1];
	}

	/**
	 * For each index computer how much far your can go, that is stored in
	 * farthest. If current index becomes greater than farthest it means you
	 * have to take a jump and update farthest. O(N)
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int jumpsSoFar = 1;
		int farthest = nums[0];
		int newFarthest = farthest;
		if (farthest >= nums.length - 1) {
			return jumpsSoFar;
		}
		for (int i = 0; i < nums.length; ++i) {
			if (i > farthest) {
				++jumpsSoFar;
				if (newFarthest >= i) {
					farthest = newFarthest;
				} else {
					// Can't reach here.
					return Integer.MAX_VALUE;
				}
			}
			if (i + nums[i] > farthest) {
				newFarthest = Math.max(newFarthest, i + nums[i]);
			}
			if (farthest >= nums.length - 1) {
				return jumpsSoFar;
			}
		}
		return jumpsSoFar;
	}

	public static void main(String[] args) {
		JumpGameII o = new JumpGameII();
		assert (1 == o.jump(new int[] { 2, 1 }));
		assert (2 == o.jump(new int[] { 2, 3, 1, 1, 4 }));
		assert (2 == o.jump(new int[] { 1, 2, 3 }));
		assert (3 == o.jump(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }));
		assert (3 == o.jump(new int[] { 2, 1, 1, 1, 1 }));
		assert (2 == o.jump(new int[] { 2, 3, 0, 1, 4 }));
		assert (3 == o.jump(new int[] { 5, 4, 0, 1, 3, 6, 8, 0, 9, 4, 9, 1, 8,
				7, 4, 8 }));
		assert (3 == o.jump(new int[] { 3, 1, 9, 0, 4, 4, 8, 4, 7, 0, 8, 4, 3,
				1, 2 }));
		assert (4 == o.jump(new int[] { 1, 1, 1, 1, 1 }));
	}
}

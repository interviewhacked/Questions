/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author pkjoshi
 *
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int prev = nums[0];

		if (nums.length < 2) {
			return prev;
		}
		int cur = 0;
		if (prev > nums[1]) {
			cur = prev;
		} else {
			cur = nums[1];
		}
		for (int i = 2; i < nums.length; ++i) {
			int next = prev + nums[i];
			if (next > cur) {
				prev = cur;
				cur = next;
			} else {
				prev = cur;
			}
		}
		return cur;

	}

	public static void main(String[] args) {
		HouseRobber o = new HouseRobber();
		o.rob(new int[] { 2, 1, 1, 2 });
	}
}

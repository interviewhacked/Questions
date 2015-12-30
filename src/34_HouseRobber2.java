/**
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * @author pkjoshi
 *
 */
public class HouseRobber2 {

	public int rob(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int [] withoutFirst = new int[nums.length-1];
        int [] withoutLast = new int[nums.length-1];
        for(int i=1;i<nums.length;++i){
            withoutFirst[i-1]=nums[i];
        }
        for(int i=0;i<nums.length-1;++i){
            withoutLast[i] = nums[i];
        }
        int max= robHelper(withoutFirst);
        int two = robHelper(withoutLast);
        return max>two?max:two;
    }
	public int robHelper(int[] nums) {
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
}

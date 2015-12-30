/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * @author pkjoshi
 *
 */
public class BestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int forward[] = new int[prices.length];
		int reverse[] = new int[prices.length];
		int min = prices[0], max = prices[0];
		forward[0] = 0;
		for (int i = 1; i < prices.length; ++i) {
			if (max < prices[i]) {
				max = prices[i];
				forward[i] = max - min;
			}
			if (min > prices[i]) {
				min = max = prices[i];
			}
		}
		min = max = prices[prices.length - 1];
		// just maintain the maximum profit so far in reverse[]
		int maxProfit = 0;
		for (int i = prices.length - 2; i >= 0; --i) {
			if (min > prices[i]) {
				min = prices[i];
				reverse[i] = Math.max(max - min, maxProfit);
				maxProfit = Math.max(reverse[i], maxProfit);
			}
			if (max < prices[i]) {
				min = max = prices[i];
			}
			reverse[i] = maxProfit;
		}
		max = 0;
		for (int i = 0; i < prices.length - 1; ++i) {
			int cur = forward[i] + reverse[i + 1];
			if (cur > max) {
				max = cur;
			}
		}

		max = max > forward[prices.length - 1] ? max : forward[prices.length - 1];
		max = max > reverse[0] ? max : reverse[0];
		return max;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 o = new BestTimeToBuyAndSellStock3();
		o.maxProfit(new int[] { 2, 1, 2, 1, 0, 0, 1 });
	}
}

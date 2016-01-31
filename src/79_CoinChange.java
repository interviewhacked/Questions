import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author pkjoshi
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int result[] = new int[amount + 1];
		boolean isValid[] = new boolean[amount + 1];
		isValid[0] = true;
		result[0] = 0;
		for (int i = 1; i <= amount; ++i) {
			for (int j = 0; j < coins.length; ++j) {
				if (i < coins[j]) {

					continue;
				}
				int option1 = isValid[i] ? result[i] : Integer.MAX_VALUE;
				int option2 = isValid[i - coins[j]] ? result[i - coins[j]] + 1 : Integer.MAX_VALUE;
				int minVal = Math.min(option1, option2);
				if (minVal != Integer.MAX_VALUE) {
					result[i] = minVal;
					isValid[i] = true;
				}
			}
		}
		if (isValid[amount]) {
			return result[amount];
		}
		return -1;
	}

}

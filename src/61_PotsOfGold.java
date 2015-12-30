/**
 * Pots of gold game: Two players A & B. There are pots of gold arranged in a
 * line, each containing some gold coins (the players can see how many coins are
 * there in each gold pot - perfect information). They get alternating turns in
 * which the player can pick a pot from one of the ends of the line. The winner
 * is the player which has a higher number of coins at the end. The objective is
 * to "maximize" the number of coins collected by A, assuming B also plays
 * optimally. A starts the game.
 * 
 * The idea is to find an optimal strategy that makes A win knowing that B is
 * playing optimally as well. How would you do that?
 * 
 * @author joshi18
 *
 */

/*-
 * function max_coin( int *coin, int start, int end ):
 if start > end:
 return 0

 int a = coin[start] + min( max_coin( coin, start+2,end ), max_coin( coin, start+1,end-1 ) )
 int b = coin[end] + min( max_coin( coin, start+1,end-1 ), max_coin( coin, start,end-2 ) )

 return max(a,b)
 * @author joshi18
 *
 */

public class PotsOfGold {

	static int maxCoin(int[] coins) {
		int table[][] = new int[coins.length][coins.length];
		for (int k = 0; k < coins.length; ++k) {
			for (int row = 0, col = k; row < coins.length && col < coins.length; ++row, ++col) {
				if (row == col) {
					table[row][col] = coins[row];
					continue;
				}
				if (Math.abs(row - col) == 1) {
					table[row][col] = Math.max(coins[row], coins[col]);
					continue;
				}
				int a = coins[row]
						+ Math.min(get(row + 2,col,table), get(row + 1,col-1,table));
				int b = coins[col]
						+ Math.min(get(row ,col-2,table), get(row-1,col-1,table));
				table[row][col] = Math.max(a, b);
				// }
			}
		}
		return table[0][coins.length - 1];
	}

	static int get(int row, int col, int[][] table) {
		if (row < 0 || row > table.length || col < 0 || col > table[0].length) {
			return Integer.MAX_VALUE;
		}
		return table[row][col];
	}

	public static void main(String[] args) {
		PotsOfGold.maxCoin(new int[] { 1, 3, 4, 6 });
	}
}

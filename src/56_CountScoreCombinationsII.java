/**
 * Suppose that the final score is given in the form(s,s').i.e., Team1 scored s
 * points and Team 2 scored s' points. How would you compute the number of
 * distinct sequences which result in this score?
 * 
 * @author joshi18
 *
 */

/**
 * C(s,s') = C(s-w[i]) +C(s') + C(s) + C(s'-w[i])
 * 
 * @author joshi18
 *
 */
public class CountScoreCombinatiionsII {

	int countSequences(int team1, int team2, int[] w) {
		int count[][] = new int[team1 + 1][team2 + 1];
		// Initialize 0th row and column with 1.
		for (int row = 1; row <= team1; ++row) {
			for (int col = 1; col <= team2; ++col) {
				for (int i = 0; i < w.length; ++i) {
					count[row][col] += count[row - w[i]][col]
							+ count[row][col - w[i]];
				}
			}
		}
		return count[team1][team2];
	}
}

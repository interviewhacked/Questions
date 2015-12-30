import java.util.Arrays;

/**
 * You have an aggregate score s and W which specifies the points that can
 * be scored in an individual play. How would you find the number of
 * combinations of plays that result in an aggregate score of S? How would
 * you compute the number of distinct sequences of individual plays that
 * result in a score of s?
 * 
 * e.g. W=[2,3,7] , four combination of plays yield a score of 12. 2*6 2*3 +
 * 3*2 2*1 + 3*1 + 7*1 3*4
 */

/**
 * C(s) = C(s-W1) + c(s-W2) ... +c(s-Wi) where C(0) = 1; and C(<0) = 0;
 * 
 * @param s
 * @param W
 * @return
 */
public class CountScoreCombinations {
	int countCombination(int s, int[] W) {
		Arrays.sort(W);
		int table[] = new int[s + 1];
		table[0] = 1;
		for (int aScore : W) {
			for (int i = aScore; i <= s; ++i) {
				table[i] += table[i - aScore];
			}
		}
		return table[s];
	}

	int countPermutation(int s, int[] W) {
		Arrays.sort(W);
		int table[] = new int[s + 1];
		table[0] = 1;
		for (int i = 0; i <= s; ++i) {
			for (int aScore : W) {
				if (i >= aScore) {
					table[i] += table[i - aScore];
				}
			}
		}
		return table[s];
	}

}

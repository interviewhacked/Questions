/**
 * Bitwise AND of Numbers Range
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author joshi18
 *
 */


/**
 * If two number differ by 1 there left most bit switches from 1 to 0 or 0 to 1.
 * If they differ by 2 their second LSB switches from 1 to 0 or 0 to 1.
 * So, if the difference is 2^i,i leftmost bits in their AND would be zero.
 * so answer would be m & n & (2^i)
 * @author joshi18
 *
 */
public class BitwiseAndOfNumberRange {
	public int rangeBitwiseAnd(int m, int n) {
		int diff = n - m;
		int i = 0;
		if (diff == 0) {
			return m;
		}
		if (diff == 1) {
			return m & n;
		}
		while (diff > 1) {
			++i;
			diff >>= 1;
		}
		int val = 1;
		for (; i > 0; --i) {
			val <<= 1;
			val |= 1;
		}
		return m & n & ~val;
	}
}

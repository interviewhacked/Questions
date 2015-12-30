/**
 * Given two integers and two bit positions. Set the bits of the first
 * integer between those two bit positions to be that of the second integer.
 */

int replace_bits(int a, int b, int x, int y) {
	/**
	 * Build a mask with bits set from positions x to y. To do that build a
	 * number with (y-x) bits set and shift it by x
	 */
	int mask = ((1 << (y - x + 1)) - 1) << x;
	// Clear a and replace with that of b
	return ((a & ~mask) | (b & mask));
}

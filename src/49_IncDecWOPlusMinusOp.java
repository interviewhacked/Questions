/**
 * Write a program that takes an unsigned integer and adds 1 to it without
 * using the plus or minus signs.
 */

static int increment(int n) {
	int bit = 1;
	while ((n & bit) != 0) {
		n ^= bit;
		bit <<= 1;
	}
	return n ^ bit;
}

static int decrement(int n) {
	int bit = 1;
	while ((n & bit) != 1) {
		n |= bit;
		bit <<= 1;
	}
	return n ^ bit;
}

// In the same way write decrement(int n)

public static void main(String[] args) {
	assert (increment(5) == 6);
	assert (decrement(9) == 8);
	assert (decrement(567) == 566);
}

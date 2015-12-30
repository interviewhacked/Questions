/**
 * Given an int, write code to return the number of bits that are 1 in O(m)
 * time, where m is the number of bits that are 1.
 */

int numbits(unsigned int n) {
	int i;
	for (i = 0; n > 0; i++)
		n &= (n - 1);
	return i;
}

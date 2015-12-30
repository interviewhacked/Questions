/**
	 * What is the minimum number instructions required to swap Odd and even
	 * bits in an uinteger Eg 10101010 should become 01010101s
	 */
	
	
	
	
	/*-
	 * 
	 * 
	 * 
	 * well ths soultion will be like 
		1) let the number be A = 10101111
		2) A1 = A & 10101010 = 10101010
		3) A2 = A & 01010101 = 00000101
		4) A1 = A1 >> 1 = 01010101
		5) A2 = A2 << 1 = 00001010
		6) Answer = A1 | A2 = 01011111
	 */

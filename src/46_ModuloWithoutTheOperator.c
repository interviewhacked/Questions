/**
	 * Given y bytes and you can transfer only x bytes at once. Write a
	 * mathematical expression having only + - / * which gives the number of
	 * iterations to copy y bytes.
	 */
	
	
	/*-
	 * The formula rewritten to use only + - / *  
		(y + (x-1)) / x 

		In order to prove correctness you need to check two case sets: 
		1. y % x == 0 => addition of x-1 doesn't affect the result, so it is y/x (which is ok) 
		2. y % x > 0 => addition of x-1 increments result with 1 (which is ok because we need another copy for the remaining y % x bytes)
	 */

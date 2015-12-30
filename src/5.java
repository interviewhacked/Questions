/**
	 * You have 'n' number of balls and 'r' number of boxes. Find the
	 * probability that that first 'r1' boxes contains k balls.
	 **/

	
	


	/**
	 * C(n, k) (r1/r)k([r-r1]/r)n-k
	 * 
	 * The probability that a given ball is put in the first r1 boxes is r1/r;
	 * so the probability that k given balls are put in the first r1 boxes is
	 * (r1/r)k The other factor is the same reasoning for putting the rest of
	 * the balls in the rest of the boxes.
	 **/

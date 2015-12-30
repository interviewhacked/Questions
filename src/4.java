/**
	 * Cracking Eggs (or Asymmetric Cost Binary Search) You have a 100 story
	 * building and an egg. This is an especially strong egg. There is some
	 * floor below which the egg will not break if dropped. What is the worst
	 * case upper bound on the number of drops you must make to determine this
	 * floor?
	 **/

	/**
	 * Ideally we would like a binary search-like algorithm to determine the
	 * floor. However, the complication is that if we try a floor too high, then
	 * our egg breaks and we are stuck. So we must make sure our guess is always
	 * below the actual answer. So we are forced to start from the first floor
	 * and work our way up. This means the worst case would be when the floor is
	 * 100 or 99, which requires 99 drops. Variant 2: You are now given 2
	 * identical eggs (i.e. eggs with the same threshold floor). What is the
	 * worst case upper bound on the number of drops in this instance? Answer:
	 * 14 The advantage of having 2 eggs is that we are now allowed to guess
	 * higher than the actual floor one time and still be ok. Suppose our upper
	 * bound is k. For our first drop we could try a floor as high as floor k.
	 * If the egg doesn’t break, we keep moving up. However, if the egg breaks
	 * we can try all the floors below floor k and still determine the floor
	 * within k drops. After dropping an egg on floor k, we have k-1 remaining
	 * drops, and so the same logic applies. We can now move up to floor k +
	 * (k-1). So eventually we move up as high as K+(k-1)+(k-2).....+1 The
	 * smallest value of k such that this value will be >=99 is 14.
	 * 
	 * 
	 * Given B eggs with D dropping allowed at max. The maximum height of
	 * building for which the egg dropping result of each storey can be
	 * determined is F(B,D). Recurrence relation is
	 * 
	 * F(B,D) = F(B-1,D-1) + F(B,D-1) + 1
	 * 
	 * F(B,0) = 0 F(1,D) = D F(2,D) = D(D+1)/2.
	 **/

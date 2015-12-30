/**
	 * Suppose that you want to output 0 with probability 1/2 and 1 with
	 * probability 1/2. You have a function BIASED-RANDOM that outputs 1 with
	 * probability p and 0 with probability 1-p where 0<p<1.Write a function
	 * UNBIASED-RANDOM that uses BIASED -RANDOM and outputs 1 and 0 with equal
	 * probability.
	 * 
	 * 
	 * 
	 * 
	 */




	while(true)
	{	
		x = BIASED-RANDOM();
		y = BIASED-RANDOM();
		if x != y
			 return x;
	}
	/**
	 * To see that UNBIASED-RANDOM returns 0 and 1 each with probability 1/2,
	 * observe that the probability that a given iteration returns 0 is Pr {x =
	 * 0 and y = 1} = (1 − p)p , and the probability that a given iteration
	 * returns 1 is Pr {x = 1 and y = 0} = p(1 − p) . (We rely on the bits
	 * returned by BIASED-RANDOM being independent.) Thus, the probability that
	 * a given iteration returns 0 equals the probability that it returns 1.
	 * Since there is no other way for UNBIASED-RANDOM to return a value, it
	 * returns 0 and 1 each with probability 1/2.
	 */

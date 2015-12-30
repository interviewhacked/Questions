	/**
	 * Our boss has n supposedly identical VLSI chips that are potentially
	 * capable of testing each other. His test jig accommodates two chips at a
	 * time. The result is either that they are the same, that is “both are good
	 * or both are bad” or that they are different, that is “at least one is
	 * bad.” The professor hires us to design an algorithm to distinguish good
	 * chips from bad ones assuming more than half of the chips are good.
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * Maintain two set S and C.Initialize S with all the available chips and C
	 * empty.
	 */
	while(true)
	{
		if(C.isEmpty())
			//take one chip from S and add it to C.
		else
			if(S.empty())
				//the chips that are in set C are good
				break;
			else
				/**
				take one chip from S and compare it
				to one chip from C.
				if Both are same add the chip to set
				C else throw both of them away.
				*/
	}
	/**
	 * As we are removing equal number of good and bad chips whatever will
	 * remain should be good ones.
	 * 
	 */

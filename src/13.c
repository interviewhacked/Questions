/**
	 * Write a macro to give offset of particular field in structure.
*	 e.g. struct  abc {
			 int a,
			 int b,
			 char c
			}; 
	 *Write a macro like offset(abc , c) to find
	 * offset of c from top
	*/



	 #define offset(abc, c) (&(abc.c) - &abc)

/**
	Consider a singly-linked list where each node has a "next" pointer. You have a
	pointer to the first node. You do not know the length of the list. The list has
	a cycle, meaning the "next" pointer of the last node points back to some node
	earlier in the list. 
**/


Sol.

/**
  It is possible to find the cycle by advancing two pointers in a loop - the first 
  pointer at 1 node per iteration and the second
  pointer at 2 nodes per iteration. When these pointers are equal, you know you
  have found the cycle. Given the above, how do you find the position at which the
  cycle begins, i.e. the index of the node to which the last node points back?
**/


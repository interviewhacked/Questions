/**
	 * You are given a threaded binary tree where each node of a tree points to
	 * some node to the right of it in in-order traversal. Given such tree,
	 * check whether each thread pointer of the node in a tree satisfies this
	 * condition( i.e check whether if thread pointer is pointing to node that
	 * is on the right side in in-order traversal). If not make that pointer
	 * NULL else leave it.
	 * 
	 * Each node has only three pointers pointing to left, right nodes and other
	 * the thread pointer. Space and Time constraint has to be considered while
	 * designing it. (in this case "threaded" means simply that the next pointer
	 * points to some node to it's right. So you can't reuse the right pointer,
	 * you need a third one; you can have a distinct left, right and next
	 * pointer at one node. )
	 **/

	/**
	 * In the inorder traversal we keep marking the node "visited" when we visit
	 * it and at each node we check if the thread points to an already visited
	 * node. If yes, make it point to NULL, else continue.
	 **/



	void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			// at node r
			root.visited = true;
			if (root.p_thread.visted) { // already visited => pointing to left
				root.p_thread = null;
			}

			inorder(root.right);
		}
	}

	/**
	 * If p_thread points to the
	 * node itself (a self loop) then it is not actually satisfying the
	 * condition : the thread pointer points to some node occurring to the right
	 * in in-order traversal.
	 **/

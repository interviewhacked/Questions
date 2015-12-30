	/**
	 * An n-ary tree is represented in a matrix form such that A[i,j] = 1 if j
	 * is the ancestor of i. Otherwise A[i,j] = 0. Given this construct the
	 * tree.
	 * 
	 * 
	 * 
	 */

	/**
	 * First we need to count ancestors for each of the nodes. So, we add a new
	 * column in the table, which will tell us the number of ancestor count for
	 * each node. The node with 0 ancestor count becomes the root node and we
	 * decrease count for every node which has root node as the ancestor. Now
	 * all the nodes with 0 ancestor count become the children of the root node.
	 * We repeat the same for the children and continue until there no more
	 * non-zero ancestor counts. It works because except root every node has
	 * only one parent.
	 * 
	 * 
	 * Now, do the reverse. Given the tree build the matrix.
	 */

	List<Node> ancestor = new ArrayList<>();

	void dfs(Node root) {
		ancestor.add(root);
		for (Node child : root.getChildren) {
			for (Node aNode : ancestor) {
				setAncestor(aNode, child);
				dfs(child);
			}
		}
		ancestor.remove(); // remove the last element in the list
	}
	/*
	 * Another interesting approach to answer query such as isAncestor(nodeA,
	 * nodeB) is to assign preOrder and postOrder sequence numbers to nodes in
	 * the tree. Now, isAncestor(nodeA, nodeB) is true iff preOrder sequence
	 * number for nodeA is less than the same for nodeB and postOrder sequence
	 * number is greater. 
	 */
}

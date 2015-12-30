/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 **/
/*-For example,
 Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author pkjoshi
 *
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode curParent = root;
		while (true) {
			TreeLinkNode prev = null;
			TreeLinkNode nextParent = null;
			while (curParent != null) {
				if (curParent.left != null) {
					if (prev != null) {
						prev.next = curParent.left;
					}
					prev = curParent.left;
					if (nextParent == null) {
						nextParent = curParent.left;
					}
				}
				if (curParent.right != null) {
					if (prev != null) {
						prev.next = curParent.right;
					}
					prev = curParent.right;
					if (nextParent == null) {
						nextParent = curParent.right;
					}
				}
				curParent = curParent.next;
			}
			if (nextParent == null) {
				break;
			}
			curParent = nextParent;
		}
	}
}

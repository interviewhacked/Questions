/**
 * Given a Binary Search tree of integers, you need to return the number of
 * nodes having values between two given integers. You can assume that you
 * already have some extra information at each node (number of children in left
 * and right subtrees).
 * 
 * @author joshi18
 *
 */

class TreeNode {
	int el;
	TreeNode left;
	TreeNode right;
	int leftChildCount;
}

public class BSTNodeCount {

	int rangeCount(int lowerLimit, int upperLimit, TreeNode root) {
		int a1 = lessNodeCount(lowerLimit, root);
		int a2 = lessNodeCount(upperLimit, root);
		return a2 - a1;
	}

	int lessNodeCount(int lowerLimit, TreeNode root) {
		int lessCount = 0;
		while (true) {
			if (root == null) {
				return lessCount;
			}
			if (root.el == lowerLimit) {
				lessCount += root.leftChildCount;
				return lessCount;
			}
			if (root.el > lowerLimit) {
				root = root.left;
				continue;
			}
			if (root.el < lowerLimit) {
				lessCount += 1; // for the current node
				lessCount += root.leftChildCount;
				root = root.right;
				continue;
			}
		}
	}

}

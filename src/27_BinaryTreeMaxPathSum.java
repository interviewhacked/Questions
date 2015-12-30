/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3 Return 6.
 * 
 * @author pkjoshi
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeMaxPathSum {
	int globalMax = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return globalMax;
	}

	int helper(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		int result = root.val;
		if (left > 0) {
			result += left;
		}
		if (right > 0) {
			result += right;
		}
		globalMax = max(result, left, right, globalMax);
		int childMax = max(left, right);
		if (childMax > 0) {
			return root.val + childMax;
		}
		return root.val;
	}

	int max(int... a) {
		int max = Integer.MIN_VALUE;
		for (int el : a) {
			if (el > max) {
				max = el;
			}
		}
		return max;
	}
}

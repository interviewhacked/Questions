package Questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 */

/*-
 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * @author joshi18
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

class Codec {

	private static final String SEPARATOR = ",";
	private static final TreeNode SENTINEL = new TreeNode(0);
	private static final String NULL_MARKER = "#";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current == SENTINEL) {
				sb.append(NULL_MARKER);
				sb.append(SEPARATOR);
				continue;
			}
			sb.append(current.val);
			sb.append(SEPARATOR);
			if (current.left != null) {
				queue.add(current.left);
			} else {
				queue.add(SENTINEL);
			}
			if (current.right != null) {
				queue.add(current.right);
			} else {
				queue.add(SENTINEL);
			}
		}
		return sb.toString().substring(0, sb.length()-1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}
		String values[] = data.split(SEPARATOR + "");
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode parent = queue.poll();
			if (!values[i].equals(NULL_MARKER + "")) {
				parent.left = new TreeNode(Integer.parseInt(values[i]));
				queue.add(parent.left);
			}
			++i;
			if (!values[i].equals(NULL_MARKER + "")) {
				parent.right = new TreeNode(Integer.parseInt(values[i]));
				queue.add(parent.right);
			}
			++i;
		}
		return root;
	}
}

public class SerializeDesrializeBinaryTree {

}

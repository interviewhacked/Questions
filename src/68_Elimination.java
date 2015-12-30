/**
 * A group of N children decide to play a game. They form a circle and count off, starting at 1. 
 * The first child says "one", the second says "two", and so on. When the M-th child is reached, 
 * that child is eliminated and must leave the circle. The next child then starts over with "one".
 *  This continues until there are only M-1 children left in the circle. Those children are declared the winners. 
We imagine that the children are assigned the cardinal numbers 1, 2, ... N. The goal of the problem 
is to print the M-1 winning children, given N and M. 
Example 1 As an example, imagine that N is 5 and M is 2. 
Children 1, 2, 3, 4, and 5 form a circle. First child 2 is eliminated, then child 4. 
At this point only children 1, 3, and 5 remain. Child 5 is skipped, and the counting 
continues around the circle. Child 1 is eliminated, followed by 5. This leaves child 3 as the winner. 
Example 2 As a second example, imagine that N is 5 and M is 3. In order, children 3, 1, and 5 are
 eliminated, leaving children 2 and 4 as the winners. 
Input Format The input for the problem consists of two lines. The first is N, the total number of 
children. The second is M, number of children skipped in each turn. Thus, 

 */

import java.util.Arrays;

class Node {
	int el;
	Node next;

	Node(int el) {
		this.el = el;
	}
}

public class Elimination {

	void compute(int n, int m) {
		Node head = createList(n);
		int length = n;
		int i = 1;
		Node prev = null;
		Node cur = head;
		if (m <= 1) {
			return;
		}
		while (length >= m) {
			if (i % m == 0) {
				if (prev == null) {
					cur = null;
					length = 0;
					break;
				}
				prev.next = cur.next;
				cur = cur.next;
				--length;
				++i;
			} else {
				++i;
				prev = cur;
				cur = cur.next;
			}
		}
		int arr[] = new int[length];
		i = 0;
		while (length > 0) {
			// System.out.println(cur.el);
			arr[i++] = cur.el;
			cur = cur.next;
			--length;
		}
		Arrays.sort(arr);
		for (int el : arr) {
			System.out.println(el);
		}
	}

	Node createList(int length) {
		Node head = new Node(1);
		Node prev = head;
		for (int i = 2; i <= length; ++i) {
			Node cur = new Node(i);
			prev.next = cur;
			prev = cur;
		}
		prev.next = head;
		return head;
	}

}

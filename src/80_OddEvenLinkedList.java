/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
 * 
 * Note: The relative order inside both the even and odd groups should remain as
 * it was in the input. The first node is considered odd, the second node even
 * and so on ...
 * 
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	ListNode(int x, ListNode next) {
		val = x;
		this.next = next;
	}
}

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode evenPrev = null;
		ListNode oddPrev = null;
		ListNode current = head;
		ListNode oddHead = null;
		boolean isEven = true;
		while (current != null) {
			if (isEven) {
				if (evenPrev != null) {
					evenPrev.next = current;
				}
				evenPrev = current;
				isEven = false;
			} else {
				if (oddPrev != null) {
					oddPrev.next = current;
				} else {
					oddHead = current;
				}
				oddPrev = current;
				isEven = true;
			}
			ListNode next = current.next;
			current.next = null;
			current = next;
		}
		evenPrev.next = oddHead;

		return head;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8))))))));
		OddEvenLinkedList o = new OddEvenLinkedList();
		o.print(o.oddEvenList(node));
	}

	void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}

import java.io.*;
import java.util.*;

public class Main {

	public static class Node {
		int data;
		Node next;
	}

	static class LinkedList {
		Node head;
		Node tail;
		int size;

		void addLast(int val) {
			if (size == 0) {
				Node temp = new Node();
				temp.data = val;
				temp.next = null;
				head = tail = temp;
			} else {
				Node temp = new Node();
				temp.data = val;
				temp.next = null;
				tail.next = temp;
				tail = temp;
			}
			size++;
		}

		public int size() {
			return size;
		}

		public Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			return head.data;
		}

		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			return tail.data;
		}

		public int getAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid Index");
				return -1;
			}
			return getNodeAt(idx).data;
		}

		private void reverseprHelper(Node node) {
			if (node == null || node.next == null) {
				head = node;
				return;
			}

			reverseprHelper(node.next);
			node.next.next = node;
			node.next = null;
		}

		public void reversepr() {
			reverseprHelper(head);
			Node temp = head;
			head = tail;
			tail = temp;
		}

		void display() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.display();
		System.out.println("Size: " + list.size());
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		System.out.println("At Index 3: " + list.getAt(3));

		list.reversepr();
		System.out.print("After Reverse: ");
		list.display();
	}
}
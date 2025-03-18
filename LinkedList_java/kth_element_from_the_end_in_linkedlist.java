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

		public int kthfromlast(int k) {
			Node s = head;
			Node f = head;

			for (int i = 0; i < k; i++) {
				if (f == null) {
					System.out.println("Index out of bounds");
					return -1;
				}
				f = f.next;
			}
			while (f != null) {
				s = s.next;
				f = f.next;
			}
			return s.data;
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
		list.addLast(60);

		list.display();

		int a = list.kthfromlast(2);
		System.out.println(a);

		int b = list.kthfromlast(3);
		System.out.println(b);
	}
}
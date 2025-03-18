
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

		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return head.data;
			}
		}

		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return tail.data;
			}
		}

		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			} else {
				Node temp = head ;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
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
		int s = list.size();
		System.out.println(s);
        s = list.getFirst();
        System.out.println(s);
        s = list.getLast();
        System.out.println(s);
        s = list.getAt(3);
        System.out.println(s);
		list.display();
	}
}
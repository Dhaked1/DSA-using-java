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
		list.display();
	}
}
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
		public int size()
		{
			return size;
		}
		public void removeFirst()
		{
			if(size == 0)
			{
				System.out.println("List is empty");
				
			}
			else if(size==1)
			{
				head = tail = null;
				size = 0;
			}
			else
			{
				head = head.next;
				size--;
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
		list.display();
		int s = list.size();
		System.out.println(s);
		list.removeFirst();
		list.display();
	}
}
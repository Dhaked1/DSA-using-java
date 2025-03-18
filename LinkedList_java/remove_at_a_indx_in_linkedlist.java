
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
     public void removeFirst()
     {
     	if(size == 0)
     	{
     		System.out.println("List is empty");
  
     	}
     	else if(size == 1)
     	{
     		head = tail = null;
     		size =0;
     	}
     	else
     	{
     		head = head.next;
     		size--;
     	}
     }
     
     public void removeLast()
     {
     	if(size==0)
     	{
     		System.out.println("List is empty");
     	}
     	else if(size ==1)
     	{
     		head = tail = null;
     		size = 0;
    
     	}
     	else
     	{
     		Node temp  = head;
     		for (int i=0;i<size-2;i++)
     		{
     			temp = temp.next;
     		}
     		tail = temp;
     		temp.next = null;
     		size--;
     	}
     }
     
     public void removeAt(int idx)
     {
     	if(idx<0 || idx>= size)
     	{
     		System.out.println("Invalid argument");
     	}
     	else if(idx==0)
     	{
     		removeFirst();
     	}
     	else if(idx == size-1)
     	{
     		removeLast();
     	}
     	else
     	{
     		Node temp = head;
     		for(int i =0;i<idx-1;i++)
     		{
     			temp = temp.next;
     		}
     		temp.next = temp.next.next;
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
		list.addLast(40);
		list.addLast(50);
		list.display();
		int s = list.size();
		System.out.println(s);
       list.removeAt(5);
    
		list.display();
		list.removeAt(3);
		list.display();
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static class CustomQueue {
		int[] data;
		int front;
		int size;

		public CustomQueue(int cap) {
			data = new int[cap];
			front = 0;
			size = 0;
		}

		int size() {
			return size;
		}

		void add(int val) {
			if (size == data.length) {
				int[] ndata = new int[2 * data.length];
				for (int i = 0; i < size; i++) {
					int idx = (front + i) % data.length;
					ndata[i] = data[idx];
				}
				data = ndata;
				front = 0;
				int idx = (front + size) % data.length;
				data[idx] = val;
				size++;
			} else {
				int idx = (front + size) % data.length;
				data[idx] = val;
				size++;
			}
		}
		int peek() {
			if (size == 0) {
				System.out.println("Queue underflow");
				return -1;
			} else {
				return data[front];
			}
		}

		int remove() {
			if (size == 0) {
				System.out.println("Queue underflow");
				return -1;
			} else {
				int val = data[front];
				front = (front + 1) % data.length;
				size--;
				return val;
			}
		}
	}

	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue(5);

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		

		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		queue.add(60);
		System.out.println(queue.remove());
		queue.add(70);
		queue.add(80);

		while (queue.size() > 0) {
			System.out.println(queue.remove());
		}

		System.out.println(queue.remove());
	}
}